package get_http_rewuest_method;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.*;

public class Get02 extends HerOkuAppBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status Code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains “Not Found”
        And
            Response body does not contain “TechProEd”
        And
            Server is “Cowboy”
    */

     // Note: PAth Parameters are used to make resource smaller
     @Test
    public void get02(){

         // 1.Step: Set the URL
//         String url = "https://restful-booker.herokuapp.com/booking/1001"; ==> NOT RECOMMENDED

         spec.pathParams("first","booking", "second",1001);

         // 2. Step : Set the expected data

         // 3. Step: Send the request and get the respond
         Response response = given().spec(spec).when().get("/{first}/{second}"); // names of the parameters by using /
         response.prettyPrint(); // Not Found -> because there is no id with 1001

         // 4. Step:
         response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
         // assertTrue(true)==> Green tick              assertTrue(false)==> Red cross
         assertTrue(response.asString().contains("Not Found")); // if response.asString().contains("Not Found") returns true, ypu will get green tick

         // assertFalse(false)==> Green tick            assertFalse(true)==> Red tick
         assertFalse(response.asString().contains("TechProEd")); // we will get false from here
                                                                 // response.asString().contains("TechProEd") returns false,  ypu will get green tick

         assertEquals("Cowboy",response.getHeader("Server")); // first: Expected Data comes from test case,
                                                                          // second: actual data comes from API
         // assertEquals() returns true if the arguments match



    }



}
