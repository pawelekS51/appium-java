package app.activity;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import preconditions.RedirectionObjectPattern;

import java.io.File;

public class Redirection extends RedirectionObjectPattern {

    private ExtentTest redirectionTest;
    private ExtentReports report;
    private ExtentLoggerReporter reporter;

    @BeforeClass
    private void initializeReport() {
        File path = new File("reports\\redirection");
        reporter = new ExtentLoggerReporter(path);
        report = new ExtentReports();
        report.attachReporter(reporter);
        redirectionTest = report.createTest("Test przekierowan", "Test polega na XYZ");
    }

    @Test
    private void redirectionTest() {
        startActivity();
        returnGoButton().click();
        returnTextBefore().sendKeys("test");
        returnApplyBtn().click();
        String test = returnTextAfter().getAttribute("text");
        if (test != null) {
            Assert.assertEquals(test, "test");
            redirectionTest.log(Status.PASS, "OK");
            returnClearBtn().click();
        } else {
            redirectionTest.log(Status.FAIL, "No OK");
        }
    }

    @AfterClass
    private void closeReport() {
        report.flush();
    }
}
