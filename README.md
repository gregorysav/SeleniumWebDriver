# SeleniumWebDriver

## General info
This project is simple Selenium project written in Java. Selenium WebDriver is used to automate test scenarios.

## Technologies
In my Project I am using:
* selenium-java version: 3.4.0
* testng version: 6.14.2
* maven-compiler-plugin version: 3.6.1
* allure-commandline : 2.13.0

## Getting started
To generate that project on your local machine you need to clone the repo and then import it on your IDE.
After importing you should open it as a Maven project.

### Matter of IDE
[Intellij](https://www.jetbrains.com/help/idea/maven-support.html)
[Eclipse](https://vaadin.com/learn/tutorials/import-maven-project-eclipse)

## Run Test Suites
Before running the tests you should reimport Maven and also build the project.
After doing this both .idea and target folders must be created.

## Create Allure reports
1. Download and install Allure binary
   * Download the latest version as zip archive from [Allure binary](https://github.com/allure-framework/allure2/releases)
   * Unpack the archive to allure-commandline file
   * Navigate to bin folder
   * Add allure to system PATH
2. Execute `<allure --version>` in console to make sure that allure is now available
3. Run Test Suites from testng.xml file
4. Execute `<allure serve /home/path/to/project/allure-results>` in console to serve the html file on the browser
