package get_http_request_method;

import base_url.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class GetWithPojo01 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
        And
            Response body is like {
                                    "firstname": "Mary",
                                    "lastname": "Smith",
                                    "totalprice": 647,
                                    "depositpaid": false,
                                    "bookingdates": {
                                        "checkin": "2016-02-05",
                                        "checkout": "2021-01-16"
                                     }
                                      "additionalneeds": "Breakfast"
                                  }
     */
    @Test
    public void getWithPojo01(){

        // 1. Step: Set the url
        spec.pathParams("first","booking", "second",2);

        //2. Step: Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2016-12-06","2021-11-20");
        BookingPojo expectedData = new BookingPojo("Jim", "Smith", 502, false, bookingDates,"Breakfast");

        //3.Step: Send the request  and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4. Step: Do assertions
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println(actualData);

        assertEquals(200, response.getStatusCode());
//        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
//        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());




    }

    @Test
    public void getWithPojo02(){
        spec.pathParams("first","booking", "second",2);
        BookingDatesPojo bookingDates = new BookingDatesPojo("2016-12-06","2021-11-20");
        BookingPojo expectedData = new BookingPojo("Jim", "Jackson", 502, true, bookingDates,"Breakfast");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println(actualData);
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());




    }
}
