package get_http_request_method;

import base_url.DummyBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class Practice05 extends DummyBaseUrl {
     /*
           When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
             Make sure these people exist in the system
      {
            "id": 23,
            "employee_name": "Caesar Vance",
            "employee_salary": 106450,
            "employee_age": 21,
            "profile_image": ""
        },
        {
            "id": 24,
            "employee_name": "Doris Wilder",
            "employee_salary": 85600,
            "employee_age": 23,
            "profile_image": ""
        }
     */
     @Test
    public void Practice05(){
         spec.pathParams("first", "api","second", "v1", "third","employees");
         Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
         response.prettyPrint();
         response.then().assertThat().statusCode(200).body("data.id", hasItems(23, 24));


     }
}
