package utils;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter {
    public static void main(String[] args) {
        //Step 1 - Creating a physical file
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("/Users/praga/sde/simpleuiframe/reports/report.html");

        //Step 2 - Creating report
        ExtentReports report = new ExtentReports();

        //Step 3 - Attaching the physical file and report
        report.attachReporter(reporter);

        //step 4 - Add test case and update metadata
        ExtentTest testcase1 = report.createTest("testcase1", "login");
        testcase1.assignAuthor("Praga");
        testcase1.assignCategory("Smoke");

        //step 5.1 - make pass or fail of each teststep for testcase1
        testcase1.pass("step1");
        testcase1.pass("step2");
        testcase1.fail("step3");

        ExtentTest testcase2 = report.createTest("testcase2", "login");
        testcase2.assignAuthor("Eshwar");
        testcase2.assignCategory("Sanity");

        //step 5.2 - make pass or fail of each teststep for testcase2
        testcase2.pass("step1");
        testcase2.pass("step2");
        testcase2.pass("step3");

        //step 6 - this step saves the file until now and it will be done only once so , we can keep this in @AfterSuite of TestNG
        report.flush();
    }
}
