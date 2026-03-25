# Quick Start Guide

## 🚀 Get Started in 5 Minutes

### Prerequisites Check
```bash
java -version    # Should be 11+
mvn -version     # Should be 3.6+
```

---

## Step 1: Build the Framework
```bash
cd /home/harsh/self_learning/Demo-framework-UI-and-API-automation
mvn clean install -DskipTests
```

**Expected Output**: `BUILD SUCCESS`

---

## Step 2: Run Your First Test

### Option A: Run API Tests (No Browser Required)
```bash
mvn test -Dtest=UserApiTest
```

### Option B: Run All Tests
```bash
mvn clean test
```

### Option C: Run Smoke Tests Only
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-suites/smoke-tests.xml
```

---

## Step 3: View Reports

### Cucumber Reports
Open: `target/cucumber-reports/cucumber.html`

### Allure Reports
```bash
mvn allure:serve
```

### Logs
Check: `target/logs/automation.log`

---

## Common Commands

```bash
# Run with specific browser
mvn test -Dbrowser=chrome
mvn test -Dbrowser=firefox

# Run in headless mode
mvn test -Dheadless=true

# Run API tests only
mvn test -DsuiteXmlFile=src/test/resources/testng-suites/api-tests.xml

# Clean and rebuild
mvn clean install -DskipTests

# Run specific test
mvn test -Dtest=UserApiTest

# Generate reports
mvn allure:serve
```

---

## Configuration

Edit: `src/main/resources/config/config.properties`

```properties
# Change browser
browser=chrome    # Options: chrome, firefox, edge

# Change mode
headless=false    # true for headless

# Change timeout
browser.timeout=15

# Change URLs
app.url=https://www.saucedemo.com
api.base.url=https://reqres.in/api
```

---

## Troubleshooting

### Issue: Tests fail to start browser
**Solution**: 
```bash
mvn clean install -U
```

### Issue: WebDriver not found
**Solution**: WebDriverManager will auto-download. Just run tests again.

### Issue: Compilation error
**Solution**:
```bash
mvn clean compile -DskipTests
```

---

## Next Steps

1. ✅ Run the sample API test: `mvn test -Dtest=UserApiTest`
2. ✅ Explore feature files in: `src/test/resources/features/`
3. ✅ Review page objects in: `src/main/java/com/automation/pages/`
4. ✅ Add your own tests following the existing patterns
5. ✅ Read comprehensive guide: `FRAMEWORK_GUIDE.md`

---

## Framework Structure (Quick Reference)

```
src/
├── main/java/com/automation/
│   ├── pages/           # Page objects here
│   ├── api/             # API clients here
│   ├── utils/           # Utilities here
│   └── config/          # Configuration
│
└── test/
    ├── java/com/automation/
    │   ├── stepdefinitions/  # Cucumber steps
    │   └── tests/            # TestNG tests
    │
    └── resources/
        ├── features/         # .feature files
        └── testng-suites/    # TestNG XMLs
```

---

## Help & Documentation

- **Quick Start**: This file
- **Complete Guide**: FRAMEWORK_GUIDE.md
- **Implementation Details**: IMPLEMENTATION_SUMMARY.md
- **Overview**: README.md

---

**Happy Testing! 🎉**

