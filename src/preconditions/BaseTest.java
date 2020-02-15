package preconditions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest extends DriverSetup {

    @BeforeSuite
    protected void globalSetup() {
        serviceStart();
        setUp();
    }

    @AfterSuite
    protected void globalTearDown() {
        tearDown();
        serviceStop();
    }
}