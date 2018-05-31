# Test plan/strategy

Please think about this from all the angels and several google applications, like Gmail, GoogleMap, 



Show test passion！During the interview, show user/product experts

Test plan (Timeline! Leadership!) and test strategy(All parts and frameworks, test types), test environment.
 creating a test roadmap that parallels the product’s development cycle and addresses any testing gaps.

regression testing, feature testing, stress
testing, performance testing, environments,

-Always try to connect interview scenarios and answers to examples from personal experience (school projects, professional experience, blogs/ publications)  



### How to test gmail?

How does user use it?

Draw out the system design diagram

CDN DNS



Android:

integrating test frameworks such as [Mockito](https://github.com/mockito/mockito) to test Android API calls in your local unit tests, and [Espresso](https://developer.android.com/topic/libraries/testing-support-library/index.html#Espresso) or [UI Automator](https://developer.android.com/topic/libraries/testing-support-library/index.html#UIAutomator) to exercise user interaction in your instrumented tests. You can generate Espresso tests automatically using[Espresso Test Recorder](https://developer.android.com/studio/test/espresso-test-recorder.html). 



iOS:

EarlGrey

With the EarlGrey framework, you have access to enhanced synchronization features. EarlGrey automatically synchronizes with the UI, network requests, and various queues; but still allows you to manually implement customized timings, if needed.

EarlGrey’s synchronization features help to ensure that the UI is in a steady state before actions are performed. This greatly increases test stability and makes tests highly repeatable.

EarlGrey works in conjunction with the XCTest framework and integrates with Xcode’s Test Navigator so you can run tests directly from Xcode or the command line (using xcodebuild).



Web, Mocha, for both unit, Selenium Web Driver for system end - to- end

Load balance

Servers, message queue (JUnit test, Integeration test, REST assured (API)test

Databases, cache, nosql (Test DB consisting DB trigger) ( database functions, triggers, views, [SQL](https://en.wikipedia.org/wiki/SQL) queries )

logging, metrics, monitoring,automation (Reliability testing/ High availability testing)

<Performance, load, stress test> Gatling 

Use Chaos Monkey, get random tests



### Test Plan the timeline for them (how to execute them)

Develop the unit tests during the developing phase

Mockout the backend.

TDD: Write the system test for  (Run them after development done):

Cover main User workflow, random testing

Monkey tests

DB testing

Load testing, above all run in test environment, make it stable

-------------------------------------

Reliability testing



### Interview sample:

I applied via an internal referral by a Google employee. Google was very patient with scheduling the first technical phone screen according to my needs. The phone screen involved a simple coding question (leetcode easy level). I was able to move on the next (and in my case final) round of onsite interviews.

##### I was asked coding questions in 4 of the 5 interviews. The other interview focused on my experiences with test strategy development and I was asked to design a mock test strategy for a real product / service.

In terms of difficulty I would say 1 of the 4 coding questions was a medium - hard. 1 was a medium and 2 were easy. I say this based on having reviewed / solved several dozen leetcode problems of all levels.
I enjoyed the conversations with all the interviewers. All of them were very friendly and polite. I also found them to be helpful and patient. Interviews can get stressful, so my advise would be to take measured breaks even if you do not need a bathroom break - take one to regroup and reset your mind. Sometimes you make mistakes are some processing is still happening from previous interview questions as you have just begun tackling a new one. Make sure you start afresh with a clean slate. It sounds like common sense, but you really need make a routine of it as it helps in the transitions between questions.
Oh, also if you are available to do a coaching session the Google offers candidates before your final interviews - do one - I found it helpful.