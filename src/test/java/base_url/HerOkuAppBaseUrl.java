package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

public class HerOkuAppBaseUrl {

    // Create an object in RequestSpecification data type
    protected RequestSpecification spec;

    // if you use @Before annotation at  the top of method it means the method will be executed before every test method
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com/").build();

    }
}
