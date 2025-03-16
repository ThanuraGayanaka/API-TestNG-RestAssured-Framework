import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZipCodeTest {

    @Test(dataProvider = "zipcodes", dataProviderClass = Utility.ZipCodeDataProvider.class)
    public void testZipCode(String country, String zipCode, String expectedCity) {
        RestAssured.baseURI = "https://api.zippopotam.us";

        given()
                .pathParam("country", country)
                .pathParam("zip", zipCode)
                .when()
                .get("/{country}/{zip}")
                .then()
                .statusCode(200)
                .body("places[0].'place name'", equalTo(expectedCity));
    }
}
