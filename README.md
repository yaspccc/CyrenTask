# lpAutomationReport

  Generate Reports Using Extent Library,
  comes with a rich set of features.

  - Ability to generate dynamic HTML logs.
  - Represents test case status with the help of PIE Charts.
  - Generates step-by-step test case summary.
  - Ability to filter reports based on test status.
  - It maintains execution history.
  - It captures details like OS, Memory, Java version and so on.
  - You can attach error screenshots within the report.

# Usage

   - Add dependency to your pox.xml

     ```java
        <dependency>
        <groupId>com.liveperson.lpAutomationReport</groupId>
        <artifactId>lpAutomationReport</artifactId>
        <version>1.0</version>
        </dependency>
    ```

   - Initialize the report and the test flow in your @BeforeClass as below :

     ```java
        mobileReport = new AutoReport();
        mobileReportTest = new AutoTest("testName","testDEscription");
        mobileReportTest = mobileReport.startTest(mobileReportTest);
     ```

   - Add steps info/error/pass/fail/skip as below :

     ```java
        mobileReportTest.logSucsses("testStepName")
        mobileReportTest.logFailed("testStepName")
        mobileReportTest.logSkipped("testStepName")
        mobileReportTest.logInfo("testStepName")
        mobileReportTest.logError("testStepName")
     ```

     ** need to override [TestWatcher] class that has [failed] & [succeeded] methods


   - And finally end your test flow in the @AfterClass as below :

     ```java
        mobileReport.endTest(mobileReportTest);
     ```
