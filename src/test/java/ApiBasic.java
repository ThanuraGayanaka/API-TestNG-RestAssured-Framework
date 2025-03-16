import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Utility.ConfigReader;
import org.testng.annotations.Test;

public class ApiBasic {


        @Test
        public void Test2() {
            String baseUrl = ConfigReader.getProperty("base.url");
            String endpoint = ConfigReader.getProperty("endpoint");

            given().
                    when().
                    get(baseUrl + endpoint).
                    then().
                    assertThat().
                    statusCode(200).
                    body("places[0].'place name'", equalTo("Beverly Hills"));
        }

@Test
        public void getResponseDetails(){

        given().
log().all().when().get(ConfigReader.getProperty("base.url")+ConfigReader.getProperty("endpoint")).
                then().log().body();

        }


        @Test
        public void CheckAll(){

            given().
                    when().
                    get("https://api.zippopotam.us/us/90210").
                    then().
                    assertThat().
                    body("places.'place name'", everyItem(notNullValue()));

        }



    }




