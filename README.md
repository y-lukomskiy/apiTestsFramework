# A basic framework to run API tests with RestAssured

Table of contents
=================
<!--ts-->
* [Tests requirements](#test-requirements)
* [To run tests from IDE](#to-run-tests-from-ide)
* [To run tests from Maven](#to-run-tests-from-maven)
<!--te-->
 
## Test requirements
1. Java 8 should be pre-installed. Please check such points:
    * Java 8 is installed
    * JAVA_HOME is added as a system variable ([Instruction](https://docs.oracle.com/cd/E19182-01/821-0917/inst_jdk_javahome_t/index.html))
2. Intellij idea is installed ([Download](https://www.jetbrains.com/ru-ru/idea/))
3. Maven is installed to the system and bin folder is added to Path ([Instruction](https://maven.apache.org/install.html))
    
## To run tests from IDE
1. Clone the project from GitHub
2. Import the project in IDEA and download Maven dependencies
3. To execute the tests, fill launch configuration in one of the ways above:
    * With "Build project" configuration:
        * Click the "Add Configuration" button and add new TestNG configuration(via "+" button)
        * Fill such fields: 
            * ``Name - any`` 
            * ``Test kind - Suite`` 
            * ``Class - fill path to /Path_To_Project_In_Your_OS/src/test/resources/testNG.xml``
        * Save launch configuration and click the "Play" button near created configuration.
    
    * With direct testNG.xml file execution:
        * navigate to the /src/test/resources/testNG.xml
        * click right button on the testNG.xml file and click the "Run..." button
4. To get an Allure report - execute one by one ``allure:report`` and ``allure:serve`` commands in the maven/plugins/allure section 
5. (Optionally) You can specify a browser and platform in the testNG file. To do this, please set ``parallel="methods"`` in testNG.xml 
  
 ## To run tests from Maven
1. Clone the project from GitHub
2. Open the command line and navigate to the project's folder with the ``cd`` command
3. To execute tests with the Maven enter ``mvn clean test``    
