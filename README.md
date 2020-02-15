**Prerequisites:**

Import from maven.

1. Selenium remote-driver 3.141.59
2. Selenium server 3.141.59
3. ExtentReports 4.1.3
4. Appium java-client 7.3.0
5. TestNG 7.1.0
6. Slf4j-log4j 1.7.12

**appium:**

Appium server should be launched automatically by this script.

**Instructions:**

1. npm install appium -g
2. Modify 'DEVICE_NAME' in /src/com.test/BaseTest.java to your emulator or device name (from adb).

**Running tests:**

You can run test directly from IDE by testSuite.xml

**Notes:**

You can view test reports in project tree - /reports/*casename*

Project was built and runned under IntelliJ Community 2019.3.3
