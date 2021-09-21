package post_http_request_method;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post02 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201 // means new data created
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post02() {
        //1.step set the URL
        spec.pathParam("first","todos");

        //2. set the expected data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap = expectedData.expectedDataSetUpWithAllKeys(66,"Tidy your room", false);

//        Map<String, Object> expectedData = new HashMap<>();
//        expectedData.put("userId",55);
//        expectedData.put("title","Tidy your room");
//        expectedData.put("completed",false);

        //3.step send repuest and get the response
        Response response =given().
                                spec(spec).
                                auth().
                                basic("admin","1234").
                                contentType(ContentType.JSON).
                                body(expectedDataMap).
                            when().
                                post("/{first}");
        response.prettyPrint();
        //I addad Status Code to use it in assertion
        expectedDataMap.put("StatusCode",201);//mostly 201 for post request...

        //4.step do assertion
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        assertEquals(expectedDataMap.get("StatusCode"),response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));
    }

}
