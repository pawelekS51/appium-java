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

    private ExtentTest redirectionTest, redirectionTestNegative;
    private ExtentReports report;
    private ExtentLoggerReporter reporter;

    @BeforeClass
    private void initializeReport() {
        File path = new File("reports\\redirection");
        reporter = new ExtentLoggerReporter(path);
        report = new ExtentReports();
        report.attachReporter(reporter);
        redirectionTest = report.createTest("Test przekierowan", "Test polega na XYZ");
        redirectionTestNegative = report.createTest("Test przekierowan - negatywny", "Test polega na XYZ");
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
            logger.info("Text attribute as expected.");
            redirectionTest.log(Status.PASS, "OK");
        } else {
            logger.info("Text attribute not as expected.");
            redirectionTest.log(Status.FAIL, "Not OK");
        }
        returnClearBtn().click();
    }

    @Test
    private void redirectionTestNegative() {
        startActivity();
        returnGoButton().click();
        returnApplyBtn().click();
        String test = returnTextAfter().getAttribute("text");
        if (test.isEmpty()) {
            logger.info("Text attribute is empty.");
            redirectionTestNegative.log(Status.FAIL, "OK");
        } else {
            Assert.assertNotNull(test);
            logger.info("Text attribute is not empty.");
            redirectionTestNegative.log(Status.PASS, "Not OK");
        }
        returnClearBtn().click();
    }

    @AfterClass
    private void closeReport() {
        logger.info("Redirection test completed.");
        report.flush();
    }
}