# ZipCode API Test Automation

## 📌 Project Overview
This project automates API testing for the [Zippopotam.us API](https://www.zippopotam.us/), which provides location data (city, state, country) based on zip codes.

It uses **REST Assured**, **TestNG**, and **Java** to validate API responses efficiently with **RequestSpecification**, **ResponseSpecification**, and **DataProvider**.

---

## 🛠️ Tech Stack
- **Java** (JDK 11+)
- **REST Assured** (for API requests and validation)
- **TestNG** (for test execution and DataProviders)
- **Maven** (for dependency management)

---

## 📂 Project Structure
```
📁 src
 └── 📁 main
     └── 📁 java
         └── 📁 Utility
             └── ZipCodeDataProvider.java

 └── 📁 test
     └── 📁 java
         └── ZipCodeTest.java

📄 pom.xml
📄 README.md
```

---

## 🚀 How to Run

1️⃣ **Clone the Repository:**
```bash
git clone <repository_url>
```

2️⃣ **Install Dependencies:**
```bash
mvn clean install
```

3️⃣ **Run Tests:**
```bash
mvn test
```

---

## 🧪 Test Cases

| Test Case | Country | Zip Code | Expected City |
|-----------|---------|----------|---------------|
| ✅ TC1    | US      | 90210    | Beverly Hills |
| ✅ TC2    | US      | 10001    | New York      |
| ✅ TC3    | CA      | M5S      | Toronto       |
| ✅ TC4    | FR      | 75001    | Paris         |

---

## 🔧 Configuration

- **Base URI**: `https://api.zippopotam.us`
- **Content Type**: JSON
- **Status Code**: 200 (Success)

---

## ✨ Future Improvements

- ✅ **Read zip code data from JSON/CSV file** instead of hardcoding
- ✅ **Add negative test cases** (invalid zip codes, 404 responses)
- ✅ **Integrate with CI/CD pipeline** (GitHub Actions/Jenkins)
- ✅ **Extend to other APIs**

---

Happy testing! 🚀

