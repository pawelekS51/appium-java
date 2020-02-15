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

    ExtentTest searchInvokeTest, searchInvokeTestNegative;
    ExtentReports report;
    ExtentLoggerReporter reporter;

    @BeforeClass
    private void initializeReport() {
        File path = new File("reports\\search");
        reporter = new ExtentLoggerReporter(path);
        report = new ExtentReports();
        report.attachReporter(reporter);
        searchInvokeTest = report.createTest("Test wywołania wyszukiwania", "Test polega na XYZ");
        searchInvokeTestNegative = report.createTest("Test wywołania wyszukiwania - negatywny", "Test polega na XYZ");
    }

    @Test
    private void searchInvokeTest() {
        startActivity();
        returnSearchInput().sendKeys("test");
        startSearchBtn().click();
        String test = androidInput().getText();
        if (test != null) {
            Assert.assertEquals(test, "test");
            logger.info("Search text as expected.");
            searchInvokeTest.log(Status.PASS, "OK");
        } else {
            logger.info("Search text not as expected.");
            searchInvokeTest.log(Status.FAIL, "Not OK");
        }
    }

    @Test
    private void searchInvokeTestNegative() {
        startActivity();
        startSearchBtn().click();
        String test = androidInput().getText();
        if (test.isEmpty()) {
            logger.info("Search text is empty.");
            searchInvokeTestNegative.log(Status.FAIL, "OK");
        } else {
            Assert.assertNotNull(test);
            logger.info("Search text is not empty.");
            searchInvokeTestNegative.log(Status.PASS, "Not OK");
        }
    }

    @AfterClass
    private void closeReport() {
        logger.info("Search test completed.");
        report.flush();
    }
}