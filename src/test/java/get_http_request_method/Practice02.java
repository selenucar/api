package get_http_request_method;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Practice02 extends JsonPlaceHolderBaseUrl {
    /*
         When
             I send a GET Request to the URL https://jsonplaceholder.typicode.com/comments
         Then
             HTTP Status Code should be 200
        And
             Search all ids that are less than 30
             the number of ids less than 30 should be 29
     */

    @Test
    public void PracticeGet02(){
        spec.pathParam("first","comments");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        // it-> we are using while calling as a list  (like this keyword)
        List<Integer> actualIds = json.getList("findAll{it.id<30}.id");
        System.out.println("actual id list: " + actualIds);
        Assert.assertTrue("The expected data does not Match! ", actualIds.size() == 29);
    }

}
