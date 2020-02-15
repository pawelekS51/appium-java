package preconditions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest extends DriverSetup {


    @BeforeSuite
    private void globalSetup() {
        setUp();
    }

    @AfterSuite
    private void globalTearDown() {
        tearDown();
    }
}