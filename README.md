**appium:**

Appium server should be launched automatically by this script.

**Prerequisites:**

    Selenium remote-driver 3.141.59
    Selenium server 3.141.59
    ExtentReports 4.1.3
    Appium java-client 7.3.0
    TestNG 7.1.0
    Slf4j-log4j 1.7.30

    node.js installed

**Instructions:**

1. npm install appium -g
2. Modify 'DEVICE_NAME' in /src/com.test/BaseTest.java to your emulator or device name (from adb).

**Running tests:**

You can run test directly from IDE by testSuite.xml

Test could be runned both on emulators and regular devices.

**Notes:**

You can view test reports in project tree - /reports/*casename*

Project was built and runned under IntelliJ Community 2019.3.3

**Troubleshooting:**

In case you encounter any problems, please check that all of required libraries are properly attached to project and appium is installed.
Test app is not using hardcoded path so it shouldn't cause problems.
