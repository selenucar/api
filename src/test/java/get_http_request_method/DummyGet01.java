package get_http_request_method;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasSize;

public class DummyGet01 extends DummyBaseUrl {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
             Status Line should be HTTP/1.1 200 OK
         And
             There are 24 employees in total
     */

    @Test
    public void DummyGet01(){
        // 1.Step: Set the Url
        spec.pathParams("first","api","second","v1","third","employees");

        // 2.Step: Set the expected data

        //3. Step: Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();


        //4.Step: Do assertion
        response.
                then().
                assertThat().
                statusCode(200).
                contentType((ContentType.JSON)).
                statusLine("HTTP/1.1 200 OK").
                body("data.id",hasSize(24));

    }


}
