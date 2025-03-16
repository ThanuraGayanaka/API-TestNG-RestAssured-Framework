import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ZipCodeTest {

    private static  RequestSpecification requestSpec;

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



@BeforeClass
    public void CreaterequestSpec(){

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.zippopotam.us").build();


    }

@Test
    public void usedRequestSpec(){


        given().
                spec(requestSpec).
                when().get("us/90210").
                then().assertThat().statusCode(200);

    }
}
