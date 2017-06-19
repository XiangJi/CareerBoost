Testing

 

Manual testing vs. automated testing

Blackbox testing 和 white box testing

黑箱 integration testing， 里面不太知道

White box 可以unit testing function

Users

Case

Bound of use

Failure condition

Test cases and how would you perform

Normal case

Extremes case like null

Special or strange case

Manual and automatic

功能，性能，压力

 

Exception: 异常理解[http://www.cnblogs.com/chenssy/p/3453039.html](http://www.cnblogs.com/chenssy/p/3453039.html)

[http://www.runoob.com/java/java-exceptions.html](http://www.runoob.com/java/java-exceptions.html)

 

Edge case, corner case

Junit

[http://www.tutorialspoint.com/junit/junit_interview_questions.htm](http://www.tutorialspoint.com/junit/junit_interview_questions.htm)

Why not just use System.out.println()for testing?

Debugging the code using system.out.println() will lead to manualscanning of the whole output every time the program is run to ensure the codeis doing the expected operations. Moreover, in the long run, it takes lessertime to code JUnit methods and test them on class files.

 

Why does JUnit only report the firstfailure in a single test?

Reporting multiple failures in a single test is generally a signthat the test does too much and it is too big a unit test. JUnit is designed towork best with a number of small tests. It executes each test within a separateinstance of the test class. It reports failure on each test.

How do I test things that must berun in a J2EE container (e.g. servlets, EJBs)?

Refactoring J2EE components to delegate functionality to otherobjects that don't have to be run in a J2EE container will improve the designand testability of the software. Cactus is an open source JUnit extension thatcan be used for unit testing server-side java code.

Cactus is retired.

What are the core features of JUnit?

JUnit test framework provides following important features −

- Fixtures
- Test     suites
- Test     runners
- JUnit     classes



Name the tools with which JUnit canbe easily integrated.

JUnit Framework can beeasily integrated with either of the followings −

- Eclipse
- Ant
- Maven

What are the core features of JUnit?

JUnit test frameworkprovides following important features −

- Fixtures
- Test suites
- Test runners
- JUnit classes

What is a fixture?

Fixture is a fixed stateof a set of objects used as a baseline for running tests. The purpose of a testfixture is to ensure that there is a well known and fixed environment in whichtests are run so that results are repeatable. It includes following methods −

·     setUp() method whichruns before every test invocation.

·     tearDown() method whichruns after every test method.

What is a test suite?

Test suite means bundlea few unit test cases and run it together. In JUnit, both @RunWith and @Suiteannotation are used to run the suite test.

What is a test runner?

Test runner is used forexecuting the test cases.

What are JUnit classes? List some ofthem.

JUnit classes areimportant classes which are used in writing and testing JUnits. Some of theimportant classes are−

·     **Assert** − It contains a set of assert methods.

·     **TestCase** − It contains a test case defines thefixture to run multiple tests.

·     **TestResult** − It contains methods to collect theresults of executing a test case.

·     **TestSuite** − It is a Composite of Tests.

**Explain how you can write asimple JUnit test case?**

·       Determine a subclass of TestCase

·       To initialize object(s) under test, override the setup() method

·       To release object(s) under test override the teardown() method

 

测试三步曲，

\1. Define the test cases, null/ normal/edge corner, strange input like different para type

\2. Define the results

\3. assertEquals 

**void
assertEquals(boolean expected, boolean actual)** 
检查两个变量或者等式是否平衡

 

 

```java
import org.junit.Test;

import staticorg.junit.Assert.*;

public class TestJunit1 {

   @Test

   public void testAdd() {

      //test data

      int num= 5;

      String temp= null;

      String str= "Junit is workingfine";

 

      //check for equality

      assertEquals("Junit is workingfine", str);

 

      //check for false condition

      assertFalse(num > 6);

 

      //check for not null value

      assertNotNull(str);

   }

}

```



 

 Test is always part of the code, 

 Write a spec

Engineering productivity

collect effort

automated testing

Continuous collaboration throughout the entire SDLC

Functional testing, user scenario testing

product and user focused, domain experts

read product code and write test code

test planning, strategy, risk and test design





 