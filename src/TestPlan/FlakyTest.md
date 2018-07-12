# Flaky Tests (And How To Avoid Them)



**Flaky tests**. You may not have heard that term, but you have probably experienced the pain. A “flaky” test is one that has a non-deterministic outcome: it can pass sometimes and fail others, for the same code, running the same test.

Flaky tests (sometimes also called “Flappers”) can be extremely painful to debug, because they’re hard to reproduce. Moreover, they are a big waste of developer time; their failure does not necessarily indicate a bug, but they still require attention. In settings where regression tests are executed before each commit, flaky tests will slow down the entire pipeline of code, because they appear to be connected with commits that are actually completely unrelated.

So, how can you be a good citizen and not write flaky tests?

During my Master’s program, I worked on a project to uncover common causes of flaky tests. My colleagues and I downloaded the entire svn log from the Apache svn repository. We then grepped through the log for keywords “flak” and “intermit” to catch variations of the words flaky and intermittent. In the process, we found 1129 commit messages that included phrases like “fixing flaky test” or “fixing intermittently failing test”.

We spent the next few months meticulously going through those log messages and their corresponding commits to see whether they were in fact fixing a flaky test; and if so, how. We found three top causes for flaky tests.

### Async wait (45%)

Developers often write tests that need to wait for something else to complete. Many flaky tests we came across were using sleep statements to do the waiting. The problem with sleep statements, however, is that they are imprecise. If a tests sleeps for 30 seconds, it may pass *most* of the time (if the processing takes less than 30s most of the time) but in other environments or under different circumstances, it may take longer and the test will fail.

The majority of such flaky tests we encountered were fixed by replacing the sleep statements with waitFor statements. With the latter, the test waits for a certain condition to become true (by periodically checking it, for example) up until a certain timeout value.

Of course, you’re probably now thinking that these tests could still fail nondeterministically when the processing takes longer than the timeout value, and you are correct. However, the flaky behavior can be greatly reduced, because the timeout value can be set to a *much* higher value than the sleep value, since the time price is not always paid. Suppose that you have a test which sleeps for 30 seconds before evaluating an assertion. That test always waits 30 seconds, no matter how long the processing *actually* takes; even if the condition becomes true after 10 seconds, the test would still wait 30 seconds. When the test uses a waitFor statement instead, it only waits as long as necessary. If the condition becomes true after 10 seconds, the test will finish after 10 seconds even if the timeout is 30 seconds.

Developers tend to use these high values for sleep statements to be cautious and avoid flaky tests; but in doing so, they are also unnecessarily increasing the test execution time.

So, next time you’re writing a test that needs to wait for something, don’t use sleep!

### Concurrency (20%)

Async wait is actually just one specific example of a broader category: problems with **concurrency**. (It just happens to be the most common type, which is why we called it out first as a separate category.) The broader category includes tests that are flaky because of other kinds of concurrency issues: data races, atomicity violations, or deadlocks.

These tests are usually flaky because the developer made an incorrect assumption about the ordering of operations being performed by different threads. There are plenty of cases where multiple code behaviors are correct — nondeterminism in the test execution isn’t necessarily an issue on its own. However, when the test only accepts a subset of those behaviors, then it will be flaky (i.e., its outcome will be nondeterministic).

These types of flaky tests are usually fixed by adding a synchronization block, or by changing the test to accept a wider range of behaviors. So, if you’re writing a test that deals with concurrent code, carefully think about whether some of the statements need to be synchronized. Also, if your test deliberately assumes a certain thread ordering, make sure to enforce it! There are tools out there that can help you do that, such as [IMUnit](http://mir.cs.illinois.edu/imunit/). The tool can also be used to explicitly test different thread schedules.

### Test Order Dependency (12%)

The final category of flaky tests we looked at in detail are those that would pass or fail depending on which tests were executed before them. A good test should be isolated, and should set up the state it depends on explicitly. (It should also clean up after itself.) However, in practice, many tests make implicit assumptions about the shared state (memory, database, files, etc.) without doing anything to enforce those assumptions.

There are two ways in which this kind of flaky tests can manifest themselves. A test (t1) can either depend on another test (t2) *not* to execute before it (because t2 changes the state that t1 expects); or, conversely, t1 can depend on another test (t3) to *have to* execute before it (because t3 sets up the state to whatever t1 expects). In this case, if that order isn’t maintained — that is, if t2 runs before t1, or if t3 runs after t1 — then t1 will fail.

As an example, we found several tests that started failing after projects moved from Java 6 to Java 7, because that upgrade affected the order of JUnit tests (because of a change in the reflection library).

A good test should be OK to run independently, or in any order with any other test. It should be properly isolated and should set up the state it expects (bonus points if it also cleans up after itself :-)). Whenever you write a test, you should make sure that it can run reliably on its own. You should also carefully review all the assumptions that the test is making. If the test needs a static variable to have its default value, then explicitly set it to that value. Do not assume that no other test will change the default value.

Besides the top three categories of flaky tests, we also discovered a few other causes including:

- **Resource leak**: Tests can be flaky if the application or tests do not properly acquire and release resources (such as memory or database connections). To avoid such issues, consider using resource pools and make sure that resources are returned to the pool when they are no longer needed.
- **Network**: Tests can be flaky because of dependency on network (e.g., remote services). The best fix for these is to mock the remote services.
- **Time**: Tests can be flaky if they depend on system time. System time is highly platform-dependent. If you expect your test to run on other machines, do not use system time.
- **I/O**: Tests can be flaky because of I/O operations (besides network). One example we encountered was a test that would fail whenever the file it was trying to read had not been properly closed. Make sure all your tests properly close all resources and use appropriate synchronization for shared resources.
- **Randomness**: Tests can be flaky if they use random number generators without accounting for the full range of possible results. If your test uses a random number generator, consider controlling for the seed and carefully consider all the possible values that can be returned.
- **Floating point operations**: We came across tests that were flaky because of floating point operations. Floating point operations are by nature imprecise and require careful attention to avoid underflows, overflows, or issues with non-associative addition.
- **Unordered collections**: Tests can be flaky when they make assumptions about the order of elements in an unordered collection. If your test is working with a set or a JSON object, don’t make any assumptions about the order, simply check for existence of elements in the collection.

You can read more about our work in the published [paper](http://mir.cs.illinois.edu/lamyaa/publications/fse14.pdf). The main take-away is: writing a good test requires careful consideration. A good test should be as deterministic as possible and its failure should always indicate a real regression. A good test should not make more assumptions that it needs to and should enforce any assumptions it does make.