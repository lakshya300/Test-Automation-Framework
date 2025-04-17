
# Test Automation Framework

This is a Java-based test automation framework. 

It is designed to support data-driven testing, parallel execution on cloud-based platforms like LambdaTest, and provides detailed reporting and logging features.


## 🚀 About Me
Hi, My name is Lakshya Agrawal and I have 4 years of experience in automation testing using technologies like Selenium Webdriver, RestAssured.

My major expertise is in java programming language.
## Author
Lakshya Agrawal
- Email: a.lakshya300@gmail.com

## Tech Stack

**Programming Language:** Java


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/lakshya300)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/lagrawal/)


## Other Common Github Profile Sections
👩‍💻 I'm currently working on...

🧠 I'm currently learning...

👯‍♀️ I'm looking to collaborate on...

🤔 I'm looking for help with...

💬 Ask me about...

📫 How to reach me...

😄 Pronouns...

⚡️ Fun fact...


# Hi, I'm Katherine! 👋


## 🛠 Skills
Javascript, HTML, CSS...


## Prerequisites

Before running this framework, ensure the following tools are installed on your system.

- **Java** 11 installed and JAVA_HOME configured
- **Maven** installed
- An IDE like IntelliJ or Eclipse
- LambdaTest account and credentials (for cloud execution)

## Features

- **Cross-browser** testing via LambdaTest.
- **Headless mode** for faster execution.
- **Data-driven testing** with support for CSV, Excel, and JSON.
- **Fake test data** generation using Faker.
- **CLI-based execution** using Maven Surefire Plugin.
- **HTML reports** using ExtentReports.
- **Logging** using Log4j in a separate logs folder.

## 📌 Technologies & Tools Used

- **Language**: Java 11  
- **Testing Framework**: TestNG  
- **Build Tool**: Maven  
- **Data-Driven Testing**: OpenCSV, Apache POI, Gson  
- **Fake Data Generator**: Java Faker  
- **Cloud Execution**: LambdaTest  
- **Reporting**: Extent Reports  
- **Logging**: Log4j  
- **Headless Execution**: Supported via CLI flags
## Setup Instructions

**Clone the Repository**

```bash
 git clone https://github.com/lakshya300/Test-Automation-Framework.git

 cd Test-Automation-Framework
```
    
**Run tests on LambdaTest in headless mode**

```bash
mvn test -Dbrowser=chrome -Dislambdatest=true -Disheadless=false -X
```

**Run tests on local machine in headless mode**

```bash
mvn test -Dbrowser=chrome -Dislambdatest=false -Disheadless=true -X
```

## Reports and Logs

**Extent Report:** After test execution, open ./report.html to view the test execution summary in HTML format.

**Logs:** Log files are saved under the ./logs/ directory for each run.

## Integrated the project with Github Actions
This automation framework is integrated with github actions.
