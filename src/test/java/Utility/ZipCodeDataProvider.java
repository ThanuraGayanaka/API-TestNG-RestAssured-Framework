package Utility;

import org.testng.annotations.DataProvider;

public class ZipCodeDataProvider {

    @DataProvider(name = "zipcodes")
    public Object[][] zipData() {
        return new Object[][]{
                {"us", "90210", "Beverly Hills"},  // First batch (test case)
                {"us", "10001", "New York City"},       // Second batch (test case)
                {"ca", "M5S", "Harbord"},          // Third batch (test case)
                {"fr", "75001", "Paris 01 Louvre"},
                {"FI","00002","Helsinki"},
                // Fourth batch (test case)
        };
    }
}
