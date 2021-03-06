# Test plan/strategy

Show test passion！During the interview, show user/product experts

Test plan (Timeline! Leadership!) and test strategy(All parts and frameworks, test types), test environment.
 creating a test roadmap that parallels the product’s development cycle and addresses any testing gaps.

regression testing, feature testing, stress
testing, performance testing, environments,

-Always try to connect interview scenarios and answers to examples from personal experience (school projects, professional experience, blogs/ publications)  

### Test challenge

Situation

Last year, I was asked to develop test automation solution for our UI component bat cave

Draw out our architecture, Cave, JMD, Perforce SCM, previously it's all manually testing, painful and not scalable.

 This application is using a JS MVC framework called ExtJs, 

the DOM issue

Action:

Doing research

Fixed the unit testing , RESTful to verify the REST calls, 

Jasmine is a behavior-driven development framework for testing JavaScript code. Jasmine<甲司漫>

Unit BDD testing instead of DOM testing

Jasmine can be integrated easily to test ExtJS applications behavior because the controller/store/model of ExtJS are functional pieces of code with minimal reference to the UI. The controller in the ExtJS binds to the different UI events like click, selection etc. and delegates it to the respective event Handlers defined as function in the controller. We can leverage the Jasmine framework to test these event delegates without actually generating the events from the UI.

It does not require a DOM

#### Suite

A Jasmine suite is a group of test cases that can be used to test a specific behavior of the JavaScript code (a JavaScript object or function). This begins with a call to the Jasmine global function `describe`with two parameters – first parameter represents the title of the test suite and second parameter represents a function that implements the test suite.



```java
describe ("ExtJS Question App Test Suite", function () {
var mainPanel = null;
var questionStore = null;
var questionStore = null;
var storeLength = -1;
var controller = null;
  /* Setup method to be called before each Test case.*/
  beforeEach (function () {
        // Initializing the mainPanel.
       mainPanel = Ext.create ('QAApp.view.MainPanel');
       questionStore = Ext.StoreManager.lookup ('QuestionStore');
       controller = Ext.create ('QAApp.controller.QuestionController');
       storeLength = questionStore.data.items.length;
  }); // before each

  /* Test if View is created Successfully.*/
  it ('Main View is loaded', function () {
        expect (mainPanel != null).toBeTruthy ();
  });

 /* Test if store is loaded successfully.*/ 
  it ('Store shouldn’t be null', function () {
        expect (questionStore != null).toBeTruthy();
   });

  /* Test controller is initialized successfully.*/ 
  it ('Controller shouldn’t be null', function () {
        expect (controller != null).toBeTruthy();
   });

/* Test if Grid in MainPanel is loaded successfully.*/   
  it ('Grid should be loaded', function () {
        expect (Ext.getCmp ("questionGrid") != null).toBeTruthy ();
  });

 /* Test if Grid in MainPanel is loaded successfully.*/   
  it ('Store has items', function () {
  
       expect (questionStore.data.items.length).toBe (storeLength);
  });

 /* Test if new item is added to store.*/   
 it ('New item should be added to store', function () {
        var record = Ext.create ("QAApp.model.Question");
        record.id = 1;
        record.question = 'Questions 3';
        questionStore.add (record);
        expect (questionStore.data.items.length).toBe (storeLength + 1);
        questionStore.removeAt (storeLength);
 });

/* Item should be removed from store via controller.*/   
 it ('Item should be removed from store', function () {
        var record = Ext.create ("QAApp.model.Question");
        record.id = 1;
        record.question = 'Questions 3';
        questionStore.add (record);

        /* Removing item from controller API.*/   
        controller.deleteQuestionFromStore(record);
        questionStore.removeAt (storeLength);
        expect (questionStore.data.items.length).toBe (storeLength);
 });

});
```

```java
   import static com.jayway.restassured.RestAssured.given;

    import org.junit.Test;

    public class HelloWorldRestAssured {

     @Test
     public void makeSureThatGoogleIsUp() {
         given().when().get("http://www.google.com").then().statusCode(200);
     }

    }
```

Results:

The test automation is setup and running in our CI system now.

### Bug challenge

Most interesting bug you found

最近发现的

p4svc的performance bug

还是draw diagram

Retry police， cold cache

the command doesn't finish

Hystrix closed the API

Found it in our test environment, not responding, check the P4SVC log, find the issue

Added performance test suite to it.  

### Questions for this round

May I ask which team are you working with? The major project you are working on ?

What do you think are the most important qualities to be a excellent test engineer ?

### Junit

```java
import junit.framework.Assert;
 
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class TournamentTest {
  Tournament tournament;
 
  @Before
  public void init() throws Exception {
    System.out.println("Setting up ...");
    tournament = new Tournament(100, 60);
  }
 
  @After
  public void destroy() throws Exception {
    System.out.println("Tearing down ...");
    tournament = null;
  }
 
  @Test
  public void testGetBestTeam() {
    这边写几个test cases input
    后面来assert
    Assert.assertNotNull(tournament);
 
    Team team = tournament.getBestTeam();
    Assert.assertNotNull(team);
    Assert.assertEquals(team.getName(), "Test1");
  }
}
```



### How to test Gmail/ Map / Camera/ Self Drive car/ Chromebook?

Testing is an art:

Princple:

Big picture (come up/ ask for multiple pieces)

integration with other things

Structred manner(do test cases for each part) (Camera, taking photos, image management, settings, all the angles)



1. Ask a lots of questions! Come up /ask for features and test cases, 
   1. Who will be the user? How would user use it? Come up features and Test Cases( new feature and apps) to be tested design, ask for example workflow, remember, it's not decided by you, work with your interviewers
   2. What's the boundary? how many users?
2. Draw out the system design diagram, with confirm, communication!
3. Test each parts (automation)
4. Test plan schedule (breifly mention)
5. General testing, then ask for fraigle part~ (Optional)

CDN DNS

### Approarch

#### Android:

Expresso咖啡

integrating test frameworks such as [Mockito](https://github.com/mockito/mockito) to test Android API calls in your local unit tests, and [Espresso](https://developer.android.com/topic/libraries/testing-support-library/index.html#Espresso) or [UI Automator](https://developer.android.com/topic/libraries/testing-support-library/index.html#UIAutomator) to exercise user interaction in your instrumented tests. You can generate Espresso tests automatically using[Espresso Test Recorder](https://developer.android.com/studio/test/espresso-test-recorder.html). 

#### iOS:

EarlGrey 伯爵咖啡

With the EarlGrey framework, you have access to enhanced synchronization features. EarlGrey automatically synchronizes with the UI, network requests, and various queues; but still allows you to manually implement customized timings, if needed.

EarlGrey’s synchronization features help to ensure that the UI is in a steady state before actions are performed. This greatly increases test stability and makes tests highly repeatable.

EarlGrey works in conjunction with the XCTest framework and integrates with Xcode’s Test Navigator so you can run tests directly from Xcode or the command line (using xcodebuild).

#### Front-end and back-end

Web, Mocha, for both unit, Selenium Web Driver for system end - to- end

#### Load balance testing

use tools to test response of all the servers, check if they can return the results

Servers, message queue (JUnit test, Integeration test, REST assured (API)test

#### Database testing

Write scripts, test results, cache, nosql (Test DB consisting DB trigger) ( database functions, triggers, views, [SQL](https://en.wikipedia.org/wiki/SQL) queries )

#### Reliability testing

logging, metrics, monitoring,automation (Reliability testing/ High availability testing)

#### Performance testing

<Performance, load, stress test(something went down)> Gatling 

#### Stress testing

Use Chaos Monkey, get random tests



### Test Plan Scedule (who and when to execute them)

Develop the unit tests during the developing phase

```java
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class TestJunit1 {

   String message = "Robert";	
   MessageUtil messageUtil = new MessageUtil(message);
   
   @Test
   public void testPrintMessage() {	
      System.out.println("Inside testPrintMessage()");    
      assertEquals(message, messageUtil.printMessage());     
   }
}

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
   TestJunit1.class ,TestJunit2.class
})

public class JunitTestSuite {
}
```

Mockout the backend.

```javascript
var assert = require('assert');
describe('Array', function() {
  describe('#indexOf()', function() {
    it('should return -1 when the value is not present', function() {
      assert.equal([1,2,3].indexOf(4), -1);
    });
  });
});
```



```java
package com.example.android.testing.espresso.BasicSample;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
...

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
        onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged))
                .check(matches(withText(mStringToBetyped)));
    }
}
```

TDD: Write the system test for  (Run them after development done):

Cover main User workflow, random testing

Monkey tests

DB testing

Load testing, Performance testing 



#### Test environment, autotest, use docker, CI/CD tech

-------------------------------------

Reliability testing



### Interview sample:

I applied via an internal referral by a Google employee. Google was very patient with scheduling the first technical phone screen according to my needs. The phone screen involved a simple coding question (leetcode easy level). I was able to move on the next (and in my case final) round of onsite interviews.

##### I was asked coding questions in 4 of the 5 interviews. The other interview focused on my experiences with test strategy development and I was asked to design a mock test strategy for a real product / service.

In terms of difficulty I would say 1 of the 4 coding questions was a medium - hard. 1 was a medium and 2 were easy. I say this based on having reviewed / solved several dozen leetcode problems of all levels.
I enjoyed the conversations with all the interviewers. All of them were very friendly and polite. I also found them to be helpful and patient. Interviews can get stressful, so my advise would be to take measured breaks even if you do not need a bathroom break - take one to regroup and reset your mind. Sometimes you make mistakes are some processing is still happening from previous interview questions as you have just begun tackling a new one. Make sure you start afresh with a clean slate. It sounds like common sense, but you really need make a routine of it as it helps in the transitions between questions.
Oh, also if you are available to do a coaching session the Google offers candidates before your final interviews - do one - I found it helpful.



写test case 写test plan 然后写一些伪代码

简历上面的项目怎么测？Perl, REST assured, JS framework, Expresso  Junit for intern, Mocha

most interesting bug you found？Found a design, the fixed can not be merge back, but the qualification job cannot go, try to give real story

Given a scenaio, just freestyle troubleshooting



### Test factors

For designing Test Cases the following factors are considered:

1. Correctness
2. Negative
3. User Interface
4. Usability
5. Performance
6. Security
7. Integration
8. Reliability
9. Compatibility

**Correctness :** Correctness is the minimum requirement of software, the essential purpose of testing. The tester may or may not know the inside details of the software module under test e.g. control flow, data flow etc.

**Negative :** In this factor we can check what the product it is not supposed to do.
**User Interface :** In UI testing we check the user interfaces. For example in a web page we may check for a button. In this we check for button size and shape. We can also check the navigation links.
**Usability :** Usability testing measures the suitability of the software for its users, and is directed at measuring the following factors with which specified users can achieve specified goals in particular environments.

1. **Effectiveness :** The capability of the software product to enable users to achieve specified goals with the accuracy and completeness in a specified context of use.
2. **Efficiency :** The capability of the product to enable users to expend appropriate amounts of resources in relation to the effectiveness achieved in a specified context of use.

**Performance :** In software engineering, performance testing is testing that is performed from one perspective to determine how fast some aspect of a system performs under a particular workload.
Performance testing can serve various purposes. It can demonstrate that the system needs performance criteria.

1. **Load Testing:** This is the simplest form of performance testing. A load test is usually conducted to understand the behavior of the application under a specific expected load.
2. **Stress Testing:** Stress testing focuses on the ability of a system to handle loads beyond maximum capacity. System performance should degrade slowly and predictably without failure as stress levels are increased.
3. **Volume Testing:** Volume testing belongs to the group of non-functional values tests. Volume testing refers to testing a software application for a certain data volume. This volume can in generic terms be the database size or it could also be the size of an interface file that is the subject of volume testing.

**Security :** Process to determine that an Information System protects data and maintains functionality as intended. The basic security concepts that need to be covered by security testing are the following:

1. **Confidentiality :** A security measure which protects against the disclosure of information to parties other than the intended recipient that is by no means the only way of ensuring
2. **Integrity:** A measure intended to allow the receiver to determine that the information which it receives has not been altered in transit other than by the originator of the information.
3. **Authentication:** A measure designed to establish the validity of a transmission, message or originator. Allows a receiver to have confidence that the information it receives originated from a specific known source.
4. **Authorization:** The process of determining that a requester is allowed to receive a service/perform an operation.

**Integration :** Integration testing is a logical extension of unit testing. In its simplest form, two units that have already been tested are combined into a component and the interface between them is tested.

**Reliability :** Reliability testing is to monitor a statistical measure of software maturity over time and compare this to a desired reliability goal.

**Compatibility :** Compatibility testing of a part of software's non-functional tests. This testing is conducted on the application to evaluate the application's compatibility with the computing environment. Browser compatibility testing can be more appropriately referred to as user experience testing. This requires that the web applications are tested on various web browsers to ensure the following:



## Q&A

1. **Question 1. What Is A Test Plan?**

   **Answer :**

   A Test Plan is a document describing the scope, approach, resources, and schedule of intended testing activities. It identifies test items, the features to be tested, the testing tasks and who will do each task (roles and responsibilities) and any risks and its solutions.

2. **Question 2. What Does Test Plan Include?**

   **Answer :** Objective, scope, approach, focus

   **Components of the test plan document include:**

   - Test Plan id
   - Introduction
   - Test items
   - Features to be tested
   - Features not to be tested
   - Test techniques
   - Testing tasks
   - Suspension criteria
   - Features pass or fail criteria
   - Test environment (Entry criteria, Exit criteria)
   - Test deliverables
   - Staff and training needs
   - Responsibilities
   - Schedule
   - Approvals
   - Risks and Contingencies

   This is a standard approach to prepare test plan and test strategy documents, but things can vary company-to-company.

3. **Question 3. What Are The Levels Of Test Plan?**

   **Answer :**

   **The Level of Test Plan defines what the test plan is being created for e.g. subsections of testing:**

   - Integration
   - Unit
   - Acceptance
   - A Test Plan document will follow the same structure for each level of test plan. The only difference being the content and detail.
   - Hierarchy of Test Plans will exist.

4. **Question 4. What Is Test Strategy?**

   **Answer :**

   A Test Strategy document is a high level document and normally developed by project manager. This document defines “Software Testing Approach” to achieve testing objectives. The Test Strategy is normally derived from the Business Requirement Specification document.

5. **Question 5. What Does The Test Strategy Include?**

   **Answer :**

   The test strategy includes introduction, resource, scope and schedule for test activities, test tools, test priorities, test planning and the types of test that has to be performed.

6. **Question 6. What Is Test Case?**

   **Answer :**

   A test case is a documentation which specifies input values, expected output and the preconditions for executing the test.

7. **Question 7. What Are The Different Test Plan Types?**

   **Answer :**

   **The different test plan types are**

   - Master Test Plan

     A single high-level test plan for a project/product that unifies all other test plans.

   - Testing Level Specific Test Plans

     - Unit Test Plan
     - Integration Test Plan
     - System Test Plan
     - Acceptance Test Plan

   - Testing Type Specific Test Plans

     Plans for major types of testing like Performance Test Plan and Security Test Plan.

8. **Question 8. What Is Master Test Plan?**

   **Answer :**

   A single high-level test plan for a project/product that unifies all other test plans.

9. **Question 9. What Are Testing Level Specific Test Plans?**

   **Answer :**

   **Plans for each level of testing like**

   - Unit Test Plan
   - Integration Test Plan
   - System Test Plan
   - Acceptance Test Plan

10. **Question 10 What Re The Guide Lines For A Test Plan?**

    **Answer :**

    - Make the plan concise. Avoid redundancy. If you think you do not need a section that has been mentioned in the template above, go ahead and delete that section in your test plan.
    - Be specific. For example, when you specify an operating system as a property of a test environment, mention the OS Edition/Version as well, not just the OS Name.
    - Make use of lists and tables wherever possible. Avoid lengthy paragraphs.
    - Have the test plan reviewed a number of times prior to base lining it or sending it for approval. The quality of your test plan speaks volumes about the quality of the testing you or your team is going to perform.
    - Update the plan as and when necessary. An outdated and unused document stinks and is worse than not having the document in the first place.

11. **Question 11 Difference between load and stress testing.**

12. The primary purpose of load and stress testing is to test system’s performance, behaviour and response under different varied load. However, stress testing is an extreme or brutal form of load testing where a system under increasing load is subjected to certain unfavourable conditions like cut down in resources, short or limited time period for execution of task and various such things.
