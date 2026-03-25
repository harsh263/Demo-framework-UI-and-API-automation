# Hybrid Test Automation Framework

## 🎯 Overview
A **production-ready, enterprise-grade** test automation framework supporting:
- ✅ **Web UI Testing** (Selenium WebDriver 4)
- ✅ **API Testing** (Rest Assured)
- ✅ **BDD Testing** (Cucumber 7)
- ✅ **Test Execution** (TestNG)
- ✅ **Build Management** (Maven)
- ✅ **Reporting** (Allure & ExtentReports)
- ✅ **Extensible** for Mobile (Appium) and Windows (WinAppDriver)

---

## 📋 Prerequisites

### Required
- **Java JDK 11+**
- **Maven 3.6+**
- **Chrome/Firefox/Edge Browser**

### Verify Installation
```bash
java -version    # Should show 11 or higher
mvn -version     # Should show 3.6 or higher
```

---

## 🚀 Quick Start

### 1. Build the Framework
```bash
mvn clean install -DskipTests
```

### 2. Run All Tests
```bash
mvn clean test
```

### 3. Run Specific Test Suites
```bash
# Smoke Tests
mvn clean test -DsuiteXmlFile=src/test/resources/testng-suites/smoke-tests.xml

# API Tests Only
mvn clean test -DsuiteXmlFile=src/test/resources/testng-suites/api-tests.xml
```

### 4. Run with Different Browsers
```bash
mvn clean test -Dbrowser=chrome
mvn clean test -Dbrowser=firefox
mvn clean test -Dbrowser=edge
```

### 5. Run in Headless Mode
```bash
mvn clean test -Dheadless=true
```

---

## 📁 Framework Structure

```
hybrid-automation-framework/
├── src/
│   ├── main/java/com/automation/
│   │   ├── api/              # API testing base classes
│   │   │   ├── ApiClient.java
│   │   │   └── ApiUtils.java
│   │   ├── config/           # Configuration management
│   │   │   ├── ConfigFactory.java
│   │   │   └── FrameworkConfig.java
│   │   ├── driver/           # WebDriver management
│   │   │   ├── DriverFactory.java
│   │   │   └── DriverManager.java
│   │   ├── enums/            # Enumerations
│   │   │   └── BrowserType.java
│   │   ├── mobile/           # Mobile automation (Appium)
│   │   │   └── MobileTestBase.java
│   │   ├── pages/            # Page Object Model
│   │   │   ├── BasePage.java
│   │   │   ├── LoginPage.java
│   │   │   ├── ProductsPage.java
│   │   │   └── CartPage.java
│   │   ├── reports/          # Reporting utilities
│   │   │   └── ExtentReportManager.java
│   │   ├── utils/            # Utilities
│   │   │   ├── LoggerUtil.java
│   │   │   └── SeleniumUtils.java
│   │   └── windows/          # Windows app automation
│   │       └── WindowsTestBase.java
│   │
│   ├── main/resources/
│   │   ├── config/
│   │   │   └── config.properties
│   │   └── log4j2.xml
│   │
│   ├── test/java/com/automation/
│   │   ├── runners/          # Cucumber TestNG runners
│   │   ├── stepdefinitions/  # Step definitions
│   │   │   ├── Hooks.java
│   │   │   ├── ui/
│   │   │   │   ├── LoginSteps.java
│   │   │   │   └── ProductsSteps.java
│   │   │   └── api/
│   │   │       └── ApiSteps.java
│   │   └── tests/            # TestNG test classes
│   │       └── api/
│   │           └── UserApiTest.java
│   │
│   └── test/resources/
│       ├── features/         # Cucumber feature files
│       │   ├── api/
│       │   │   └── UserAPI.feature
│       │   └── ui/
│       │       ├── Login.feature
│       │       └── Products.feature
│       └── testng-suites/    # TestNG XML files
│           ├── testng.xml
│           ├── smoke-tests.xml
│           └── api-tests.xml
│
├── target/                   # Build output
│   ├── cucumber-reports/
│   ├── extent-reports/
│   ├── logs/
│   └── screenshots/
│
├── pom.xml                   # Maven configuration
├── README.md                 # This file
└── FRAMEWORK_GUIDE.md        # Detailed guide
```

---

## ⚙️ Configuration

Edit `src/main/resources/config/config.properties`:

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

# Report Configuration
extent.report.path=target/extent-reports
```

---

## 📝 Writing Tests

### Cucumber Feature File
```gherkin
Feature: Login Functionality
  
  @smoke @ui
  Scenario: Successful login
    Given I am on the login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click on login button
    Then I should be redirected to products page
```

### Step Definition
```java
@When("I enter username {string}")
public void iEnterUsername(String username) {
    loginPage.enterUsername(username);
}
```

### TestNG API Test
```java
@Test
public void testGetUsers() {
    Response response = getRequestSpec()
        .queryParam("page", 2)
        .get("/users");
    
    ApiUtils.verifyStatusCode(response, 200);
}
```

### Page Object
```java
public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameField;
    
    public LoginPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }
}
```

---

## 📊 Reports

### Cucumber HTML Report
Location: `target/cucumber-reports/cucumber.html`

### Allure Report
```bash
# Generate and open Allure report
mvn allure:serve

# Generate report only
mvn allure:report
```

### ExtentReports
Location: `target/extent-reports/ExtentReport.html`

### Logs
Location: `target/logs/automation.log`

---

## 🏷️ Test Tags

### Cucumber Tags
- `@smoke` - Critical scenarios
- `@regression` - Full regression suite
- `@ui` - Web UI tests
- `@api` - API tests

### Run by Tags
```bash
mvn test -Dcucumber.filter.tags="@smoke"
mvn test -Dcucumber.filter.tags="@api"
mvn test -Dcucumber.filter.tags="@ui and not @smoke"
```

---

## 🔧 Extending the Framework

### For Mobile Testing (Appium)
1. Add Appium dependency to `pom.xml`
2. Implement `MobileTestBase.java`
3. Create mobile page objects
4. Add mobile feature files

### For Windows Testing (WinAppDriver)
1. Add WinAppDriver dependency
2. Implement `WindowsTestBase.java`
3. Create Windows page objects
4. Add Windows test scenarios

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
| Driver Management | WebDriverManager | 5.6.3 |
| Assertions | AssertJ | 3.25.1 |
| Configuration | Owner | 1.0.12 |

---

## ✅ Framework Features

✅ **Selenium 4** - Latest WebDriver with BiDi support  
✅ **Cucumber BDD** - Behavior-driven development  
✅ **TestNG** - Powerful test execution  
✅ **Rest Assured** - Comprehensive API testing  
✅ **Page Object Model** - Maintainable UI tests  
✅ **Thread-Safe** - Parallel execution ready  
✅ **WebDriverManager** - Automatic driver management  
✅ **Allure Reports** - Beautiful test reports  
✅ **ExtentReports** - Detailed HTML reports  
✅ **Log4j2** - Comprehensive logging  
✅ **Owner** - Type-safe configuration  
✅ **AssertJ** - Fluent assertions  
✅ **Lombok** - Reduced boilerplate  
✅ **Mobile Ready** - Extensible to Appium  
✅ **Windows Ready** - Extensible to WinAppDriver  

---

## 🎓 Best Practices

1. ✅ **Page Object Model** - Separate locators from tests
2. ✅ **DRY Principle** - Reusable utilities
3. ✅ **Meaningful Names** - Descriptive test names
4. ✅ **Proper Logging** - Debug-friendly logs
5. ✅ **Explicit Waits** - No Thread.sleep()
6. ✅ **Test Independence** - Tests run in any order
7. ✅ **Clean Code** - Follow coding standards
8. ✅ **Version Control** - Meaningful commits

---

## 🐛 Troubleshooting

### Clear Maven Cache
```bash
mvn clean install -U
```

### WebDriver Issues
```bash
rm -rf ~/.cache/selenium
```

### View Detailed Logs
```bash
mvn clean test -X
```

---

## 📞 Support

For detailed documentation, see [FRAMEWORK_GUIDE.md](FRAMEWORK_GUIDE.md)

---

## 📄 License

MIT License

---

**Happy Testing! 🚀**

