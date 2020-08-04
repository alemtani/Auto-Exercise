# Automation Exercise
Used Appium server to run automation tests of mobile applications.

## Download and Run
Download the zip file and extract to a location of your choice.

Open up the Eclipse IDE or whatever environment you are using and import via the following instructions (for Eclipse).
1. File > Import..
2. Select "Existing Projects into Workspace" and "Next >"
3. Under "Select root directory:", navigate to the path of the extracted file and click "OK" and "Finish"
4. Click "Finish" to finalize import

You will find four classes under the "tests" package in the "src/test/java" folder. Make sure to run each test under the "AppTest" and "BrowserTest" classes, as indicated by a decorator "@Test", as JUnit Tests.

## Walkthrough
This is where the learning experience truly lay. This will be the challenge, but it is possible with consultation of online tutorials and analogous thinking.

### Create a Maven Project
1. File > New > Other..
2. Select Maven > Maven Project
3. Follow the prompt until it asks you for the group and artifact IDs. Just choose informative package names.
4. Click "Finish"

### Import Dependencies
These dependencies will allow you to import the packages and modules you need to run your Appium and JUnit tests. How to do it:
1. Naviage to your "pom.xml" file and get the source code.
2. Add the "<dependencies>" tag inside the project, which will autocomplete the terminator. This is where you will import your dependencies.
3. On your browser, go to https://mvnrepository.com/ and import the latest stable versions of these libraries:\
    a. Selenium Java (org.seleniumhq.selenium >> selenium-java)\
    b. Java Client (io.appium >> java-client)\
    c. JUnit (junit >> junit)\
    d. JUnit Jupiter API (org.junit.jupiter >> junit-jupiter-api)
4. Build the project by saving (Ctrl + S).
5. Go to Project > Clean.. and click "OK" to compile libraries.

### Create Classes and Functions
Browser tests and application tests require different capabilities. It is also generally good practice to separate the driver setup/teardown with the actual tests. Thus, you will make four classes in total.
1. Under "src/test/java", create a new package. It may be better to create two, one for each type of test, for better organization. Name the package(s) something informative (eg. "tests").
2. You must create two base classes, one for the browser application on Chrome and one for the iHeartRadio app.\
    a. Two properties to define: AndroidDriver<AndroidElement> driver = null; AND DesiredCapabilities dc = new DesiredCapabilities()";\
    b. You must setUp() and tearDown() the driver before running the scripts. Make sure to add the @Before and @After annotations above, respectively.
3. You will have two classes to store the test cases.
    a. These should extend the base classes to access the driver.
    b. For each test, make sure to add the @Test annotation so that it can be run as a JUnit test.

### Add Desired Capabilities
For each base class, there will be four capabilities you must define:
- platformName : The platform you device is running on (eg. "Android", "iOS")
- platformVersion : The version of your platform; will be a text value (eg. "9.0")
- deviceName : The name of your device. Here's how to access it on your device (for Android):
    1. Go to Settings
    2. Go to System
    3. For "About emulated device" it should give you the name to pass in. If you are using the emulator, it will likely be "AOSP on IA Emulator".
- udid : The unique identifier to access your device. How to find it:
    1. On your emulator, assuming you are under Settings > System, go to About emulated device > Build number
    2. Click on "Build number" seven times until you get the notification that you are a developer.
    3. Go back to System and then to "Developer options". Enable USB debugging.
    4. Now, if you are using a macOS or Linux, you should be able to type the command "adb devices" on the terminal and find the connected device. For the emulator, expect "emulator-5554".

For running the browser tests, you must add the "browserName" property to a browser of your choice (eg. "Chrome", "Safari").

For running the test for iHeartRadio, you must define the "appPackage" and "appActivity" capabilities:
1. Make sure your device is connected and on. On the terminal, run "adb logcat"
2. You will see scripts flying on the terminal. Don't worry, just open the iHeartRadio app on your device.
3. As soon as the application opens, exit the logcat via Ctrl + C.
4. Copy the terminal scripts onto a document of your choice (eg. Notepad, Word).
5. Ctrl + F for "for activity". If you see something related to the iHeartRadio app (use common sense), that is where to extract info.
6. The "appPackage" is the script before the "/", while the "appActivity" is the script after. You should get this:\
    a. appPackage : "com.clearchannel.iheartradio.controller"\
    b. appActivity : ".activities.NavDrawerActivity"

You can now define the driver with the desired capabilities, passing in the URL of the Appium server (new URL("http://127.0.0.1:4723/wd/hub") for the default port) and the desired capabilities variable (dc).
