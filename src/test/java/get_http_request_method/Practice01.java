package get_http_request_method;

import base_url.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Practice01 extends DummyBaseUrl {
    /*
         When
             I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/
         Then
             HTTP Status Code should be 200
         And
             Content Type should be JSON
         And
            Make sure Rhona Davidson earns more than Herrod Chandler
           {
            "id": 7,
            "employee_name": "Herrod Chandler",
            "employee_salary": 137500,
            "employee_age": 59,
            "profile_image": ""
        },
        {
            "id": 8,
            "employee_name": "Rhona Davidson",
            "employee_salary": 327900,
            "employee_age": 55,
            "profile_image": ""
        },
     */
    @Test
    public void PracticeGet01(){

//        Response response = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");
//        response.prettyPrint();

        spec.pathParams("first","api","second", "v1", "third", "employee", "final", 7);

        // when() -> action
        // get() ->
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();
        System.out.println("employee_salary => " + json.getString("data.employee_salary"));



        spec.pathParams("first","api","second", "v1", "third", "employee", "final", 8);

        // when() -> action
        // get() ->
        Response response2 = given().spec(spec).when().get("/{first}/{second}/{third}/{final}");
        JsonPath json2 = response2.jsonPath();
//        System.out.println("employee_salary = >" + json2.getString("data.employee_salary"));
        Assert.assertTrue(Integer.parseInt(json.getString("data.employee_salary")) < Integer.parseInt(json2.getString("data.employee_salary")));
    }




}
