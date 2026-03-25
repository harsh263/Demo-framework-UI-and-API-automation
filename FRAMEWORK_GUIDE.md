# Hybrid Test Automation Framework

## 🎯 Overview
A comprehensive, production-ready test automation framework supporting **Web UI**, **API**, **Mobile**, and **Windows** application testing. Built with industry best practices and designed for scalability, maintainability, and ease of use.

### Key Features
- ✅ **Selenium WebDriver** for Web UI automation
- ✅ **Rest Assured** for API testing
- ✅ **Cucumber BDD** for behavior-driven testing
- ✅ **TestNG** as test execution engine
- ✅ **Maven** for build management
- ✅ **Allure & ExtentReports** for comprehensive reporting
- ✅ **Log4j2** for detailed logging
- ✅ **Page Object Model (POM)** design pattern
- ✅ **Thread-safe** driver management for parallel execution
- ✅ **Configuration management** using Owner library
- ✅ **Extension points** for Mobile (Appium) and Windows (WinAppDriver)

---

## 📋 Prerequisites

### Required
- **Java JDK 11** or higher
- **Maven 3.6+**
- **Chrome/Firefox/Edge** browser

### Optional
- **Allure CLI** for advanced reporting
- **IntelliJ IDEA** or Eclipse IDE
- **Git** for version control

---

## 🏗️ Framework Architecture

```
hybrid-automation-framework/
├── src/
│   ├── main/java/com/automation/
│   │   ├── api/              # API testing base classes
│   │   ├── config/           # Configuration management
│   │   ├── driver/           # WebDriver factory and manager
│   │   ├── enums/            # Enumerations
│   │   ├── mobile/           # Mobile testing base (Appium)
│   │   ├── pages/            # Page Object Model classes
│   │   ├── reports/          # Reporting utilities
│   │   ├── utils/            # Reusable utilities
│   │   └── windows/          # Windows app testing base
│   │
│   ├── main/resources/
│   │   ├── config/           # Configuration files
│   │   └── log4j2.xml        # Logging configuration
│   │
│   ├── test/java/com/automation/
│   │   ├── runners/          # Cucumber test runners
│   │   ├── stepdefinitions/  # Cucumber step definitions
│   │   └── tests/            # TestNG test classes
│   │
│   └── test/resources/
│       ├── features/         # Cucumber feature files
│       │   ├── api/          # API feature files
│       │   └── ui/           # UI feature files
│       └── testng-suites/    # TestNG suite XML files
│
├── target/                   # Build output and reports
├── pom.xml                   # Maven configuration
└── README.md                 # This file
```

---

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone <repository-url>
cd Demo-framework-UI-and-API-automation
```

### 2. Verify Prerequisites
```bash
java -version  # Should be 11 or higher
mvn -version   # Should be 3.6 or higher
```

### 3. Install Dependencies
```bash
mvn clean install -DskipTests
```

### 4. Run Tests

#### Run All Tests
```bash
mvn test
```

#### Run Smoke Tests Only
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-suites/smoke-tests.xml
```

#### Run API Tests Only
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-suites/api-tests.xml
```

#### Run with Specific Browser
```bash
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox
```

#### Run in Headless Mode
```bash
mvn test -Dheadless=true
```

---

## ⚙️ Configuration

### Main Configuration File
Location: `src/main/resources/config/config.properties`

```properties
# Browser Configuration
browser=chrome
headless=false
browser.timeout=15

# Application URLs
app.url=https://www.saucedemo.com
api.base.url=https://reqres.in/api

# Environment
environment=qa

# Screenshot Configuration
screenshot.on.failure=true
screenshot.on.pass=false

# Retry Configuration
retry.failed.tests=1

# Report Configuration
extent.report.path=target/extent-reports
```

---

## 📝 Writing Tests

### Cucumber BDD Tests

#### Feature File Example
```gherkin
Feature: Login Functionality
  
  @smoke @ui
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click on login button
    Then I should be redirected to products page
```

#### Step Definition Example
```java
@When("I enter username {string}")
public void iEnterUsername(String username) {
    loginPage.enterUsername(username);
}
```

### TestNG API Tests

```java
@Test(description = "Verify GET request for users")
public void testGetUsers() {
    Response response = getRequestSpec()
            .queryParam("page", 2)
            .get("/users");
    
    ApiUtils.verifyStatusCode(response, 200);
    ApiUtils.verifyResponseContains(response, "data");
}
```

---

## 📊 Reports

### Cucumber HTML Report
Generated at: `target/cucumber-reports/cucumber.html`

### Allure Report
```bash
# Generate and open Allure report
mvn allure:serve
```

### Logs
Located at: `target/logs/automation.log`

---

## 🧪 Test Execution Tags

### Cucumber Tags
- `@smoke` - Critical test scenarios
- `@regression` - Full regression suite
- `@ui` - Web UI tests
- `@api` - API tests

---

## 🔧 Extending the Framework

### Adding Mobile Testing (Appium)

1. Add Appium dependencies to pom.xml
2. Implement mobile driver in MobileTestBase.java
3. Create mobile page objects and tests

### Adding Windows Testing (WinAppDriver)

1. Add WinAppDriver dependency
2. Implement Windows driver in WindowsTestBase.java
3. Create Windows page objects and tests

---

## 📚 Technology Stack

| Component | Technology | Version |
|-----------|-----------|---------|
| Language | Java | 11+ |
| Build Tool | Maven | 3.6+ |
| UI Automation | Selenium WebDriver | 4.16.1 |
| API Testing | Rest Assured | 5.4.0 |
| BDD Framework | Cucumber | 7.15.0 |
| Test Framework | TestNG | 7.8.0 |
| Reporting | Allure, ExtentReports | 2.25.0, 5.1.1 |
| Logging | Log4j2 | 2.22.1 |

---

**Happy Testing! 🚀**

