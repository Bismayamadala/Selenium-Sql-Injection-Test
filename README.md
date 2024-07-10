# Selenium-Sql-Injection-Test

## Description

This Java program uses Selenium WebDriver to interact with the OWASP Juice Shop login form and attempts a controlled SQL injection attack. It performs the following steps:
1. Launches a web browser and navigates to the OWASP Juice Shop login page.
2. Locates the username and password input fields.
3. Enters a crafted SQL injection payload into the username field and a valid password into the password field.
4. Submits the login form.
5. Analyzes the browser response for signs of an error message indicating a failed SQL injection attempt.

## Prerequisites

- Java JDK
- Maven
- ChromeDriver (or the WebDriver for your preferred browser)

## Setup

1. Install Java JDK and Maven.
2. Download and install ChromeDriver (or the appropriate WebDriver for your browser).
3. Update the `chromedriver` path in the Java program to match your local setup.

## Running the Program

1. Clone the repository.
2. Navigate to the project directory.
3. Add Selenium dependencies in the `pom.xml` file.
4. Compile and run the Java program using Maven.

## Exception Handling

The program includes basic exception handling to catch and print stack traces for any errors that occur during execution.

## Notes

- Ensure you use the correct locator strategies (e.g., `By.id`, `By.name`) for elements on the login form.
- The SQL injection payload used in this example is a simple attempt to bypass login authentication. The actual response may vary depending on the security measures in place on the target application.
