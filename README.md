
# Selenium-Test-Template

[![Java Version](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![Selenium Version](https://img.shields.io/badge/Selenium-4.12.1-purple)](https://www.selenium.dev/downloads/)
[![TestNG Version](https://img.shields.io/badge/TestNG-7.8.0-orange)](https://testng.org/doc/)

Selenium-Test-Template is a template project designed to accelerate web automation testing using Selenium and TestNG. This repository provides a structured foundation for creating and managing automated tests for web applications.

## Features

- Pre-configured Maven project for easy setup and dependency management.
- Integrated TestNG for organized test suite management and reporting.
- Utility functions for common Selenium operations to enhance test development efficiency.
- Example test cases to serve as a reference for writing your own tests.
- Easily adaptable for different web applications and testing scenarios.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) installed
- Maven installed
- Web browser of your choice (e.g., Chrome, Firefox) installed

### Installing Dependencies

To set up the project, run the following command:

```bash
mvn clean install
```

This will download the required dependencies and set up the project for use.

## Running Tests

To execute your tests, run the following command:

```bash
mvn test
```

This command will trigger the TestNG framework to execute all TestNG xmls located in the `src/main/resources` directory.


## Reports

After executing tests using TestNG, the framework generates HTML reports which can be located in the `target/surefire-reports` directory.

Additionally, this project utilizes the ExtentReports library for enhanced reporting capabilities. The ExtentReports generated reports can be found in the `reports/index.html` file.


## Contributing

Contributions are welcome! If you'd like to enhance this template or report issues, please open a pull request or submit an issue.

## License

This project is in the public domain. You are free to use, modify, and distribute it without any restrictions.
