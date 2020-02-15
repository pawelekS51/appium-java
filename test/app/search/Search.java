package app.search;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentLoggerReporter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import preconditions.SearchObjectPattern;

import java.io.File;

public class Search extends SearchObjectPattern {

    ExtentTest alertDialogsTest;
    ExtentReports report;
    ExtentLoggerReporter reporter;

    @BeforeClass
    private void initializeReport() {
        File path = new File("reports\\search");
        reporter = new ExtentLoggerReporter(path);
        report = new ExtentReports();
        report.attachReporter(reporter);
        alertDialogsTest = report.createTest("Test dialogu", "Test polega na XYZ");
    }

    @Test
    private void alertDialogsTest() {
        startActivity();
        returnSearchInput().sendKeys("Paweł Śliwa");
        startSearchBtn().click();
        String test = androidInput().getText();
        if (test != null) {
            Assert.assertEquals(test, "Paweł Śliwa");
            logger.info("Search text as expected.");
            alertDialogsTest.log(Status.PASS, "OK");
        } else {
            logger.info("Search text not as expected.");
            alertDialogsTest.log(Status.PASS, "No OK");
        }
    }

    @AfterClass
    private void closeReport() {
        logger.info("Redirection test completed.");
        report.flush();
    }
}