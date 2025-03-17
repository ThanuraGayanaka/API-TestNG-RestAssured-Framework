import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ZipCodeTest {

    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    @BeforeClass
    public void setupSpecs() {
        // Request setup
        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.zippopotam.us")
                .build();

        // Response setup
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    // ✅ Data-driven test using external DataProvider class
    @Test(dataProvider = "zipcodes", dataProviderClass = Utility.ZipCodeDataProvider.class)
    public void testZipCode(String country, String zipCode, String expectedCity) {
        given()
                .spec(requestSpec)
                .pathParam("country", country)
                .pathParam("zip", zipCode)
                .when()
                .get("/{country}/{zip}")
                .then()
                .spec(responseSpec)
                .body("places[0].'place name'", equalTo(expectedCity));
    }

    // ✅ Separate test using the requestSpec
    @Test
    public void usedRequestSpec() {
        given()
                .spec(requestSpec)
                .when()
                .get("us/90210")
                .then()
                .spec(responseSpec);
    }
}
