package post_http_request_method;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Practice06Post extends JsonPlaceHolderBaseUrl {
            /*
        Given    https://jsonplaceholder.typicode.com/comments
            {
                "name": "This class has smart people",
                "postId": 87,
                "id": 503,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
            When I send Post Request to the URL
            Then the status code should be 201
            Response should be like
                 {
                "name": "This class has smart people",
                "postId": 87,
                "id": 501,
                "body": "Congratulations Everyone",
                "email": "techproedstudents@gmail.com"
            }
         */

    @Test
    public void Practice06Post(){
        spec.pathParam("first", "comments");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "This class has smart people");
        expectedData.put("postId",87);
        expectedData.put("id", 501);
        expectedData.put("body", "Congratulations Everyone");
        expectedData.put("email", "techproedstudents@gmail.com");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println("expectedData => " + expectedData);
        System.out.println("actualData => "+ actualData);

//        assertEquals(expectedData, actualData);
        // we can specificly check for some data
        assertEquals(expectedData.get("name"), actualData.get("name"));
    }




}
