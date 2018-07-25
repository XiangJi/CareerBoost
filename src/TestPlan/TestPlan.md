# Test plan/strategy

Please think about this from all the angels and several google applications, like Gmail, GoogleMap, 



Show test passion！During the interview, show user/product experts

Test plan (Timeline! Leadership!) and test strategy(All parts and frameworks, test types), test environment.
 creating a test roadmap that parallels the product’s development cycle and addresses any testing gaps.

regression testing, feature testing, stress
testing, performance testing, environments,

-Always try to connect interview scenarios and answers to examples from personal experience (school projects, professional experience, blogs/ publications)  



### How to test Gmail?

Testing is an art

How does user use it?

### Draw out the system design diagram, with confirm, communication!

General testing, then ask for fraigle part~

CDN DNS



### Example 

1. Test Case( new feature and apps) to be tested design, ask for example workflow

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

Mockout the backend.

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



How to test a camera system, ask for the details, how is the white-box looks like?

How would you test google map, gmail, google self driving car, camera?

写test case 写test plan 然后写一些伪代码

简历上面的项目怎么测？

most interesting bug you found？



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