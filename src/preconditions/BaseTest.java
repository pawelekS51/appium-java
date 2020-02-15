package preconditions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest extends DriverSetup {

    @BeforeSuite
    public void globalSetup() {
        serviceStart();
        setUp();
    }

    @AfterSuite
    public void globalTearDown() {
        tearDown();
        serviceStop();
    }
}