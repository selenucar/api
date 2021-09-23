package get_http_request_method;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Comments;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Practice03Pojo extends JsonPlaceHolderBaseUrl {
        /*
         When
             I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
         Then
             HTTP Status Code should be 200
        And
             Search all ids and make sure there are 500 total records
             Use Pojo and deserialize them to Java
     */
        @Test
    public void Practice03(){
            spec.pathParam("first","comments");
            Response response = given().spec(spec).when().get("/{first}");
//            response.prettyPrint();
//            Map<String, Object> map = response.as(HashMap.class);
//            System.out.println(map);
            //otter data type -> [] from console Array
            Comments[] comments = response.as(Comments[].class);
            for (int i = 0; i < comments.length ; i++) {
                System.out.println(i +" name => "+ comments[i].getName());

            }
            // validation part
            // java.lang.AssertionError: The expected data does not match!
            Assert.assertTrue("The expected data does not match! ", comments.length == 500);


        }
}
