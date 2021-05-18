
Cucumber BDD Framwork implementation for Cafe TownSend Application:

This Project is developed with BDD approach using Cucumber framework to automate the API published in https://jsonplaceholder.typicode.com/


Automation Approach:

The project is developed using Java and RestAssured. Cucumber is used as the testing framework.

The Testrunner file is created and this facilitates running the test scenario. Multiple test runner files can be created or tags can be used so that it will be useful while integrating with any CI/CD tools. 

Pre-requisites For Windows OS 
Step 1:Install JDK and set Java home
Step 2: Install Maven 3.0.3+
Step 3: Ensure maven binaries are on your PATH (ie. you can run mvn from anywhere)

Running Tests on Windows OS:

Clone/Download the project from this repository. Navigate to the project folder using terminal.

To execute the complete test suite, run the following command mvn verify. Once the test run is completed, you can find the test report under /target/cucumber-html-reports folder as a html file. All the logs are available in log.txt file.

This project is integrated with circle ci. config.yml for this is available in the repository.
