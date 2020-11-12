# How to get Selenium / ChromeDriver to work on your Mac  
  
  
### 1. Update ChromeDriver, and make sure Mac OS X will allow it to run:
  - ChromeDriver is a stand-alone executable file located at: `~/dev-tools/chromedriver/chromedriver`
  - Look up your currently installed version of Chrome (go to the Chrome menu and select the first option, About Google Chrome)
  - Navigate to [ChromeDriver Downloads page](https://chromedriver.chromium.org/downloads)
  - Download the version of ChromeDriver that corresponds to the version of Chrome you have
  - Unzip the file you downloaded, which should produce your `chromedriver` executable.  
  - Put your `chromedriver` executable it in your `~/dev-tools/chromedriver/` folder, overwriting the old one if necessary
  - Double-click on the `chromedriver` executable to launch it. Mac OS X may pop-up a window saying that it won't open an untrusted application. If so:
    - Open System Preferences and click Security & Privacy. Click the Open Anyway button, then when a new pop-up appears, click Open. 
  - ChromeDriver should now be able to run
  
  
### 2. Import this Maven project into Eclipse (the `pom.xml` is here in the root directory)  
  
  
### 3. Launch the Server application by right-clicking on `src/main/java/Application.java` and selecting Run As > Java Application  
  
  
### 4. Before running any tests, set your project to JUnit 4:
  - Right-click on your test file, go to Run As > Run Configurations...
  - There is a drop-down menu next to "Test runner:"
  - Select JUnit 4
  - Click Apply, and then click Run

  
### 5. Have fun writing your Selenium tests!  
  