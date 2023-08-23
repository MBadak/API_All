package post_requests;

import base_urls.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.booking.BookingResponsePojo;
import pojos.booking.BookingDatesPojo;
import pojos.booking.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post04  extends HerokuAppBaseUrl{
    /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
              }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 16,
                    "booking" :{
                        "firstname": "Ali",
                        "lastname": "Can",
                        "totalprice": 999,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2021-09-21",
                            "checkout": "2021-12-21"
                        },
                        "additionalneeds": "Breakfast"
                       }
                  }
     */

    @Test
    public void post01() {
        // Set the Url
       spec.pathParam("first", "booking");

        // Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo expectedData = new BookingPojo("Ali","Can",999,true,bookingDates,"Breakfast");


        System.out.println("expectedData = " + expectedData);

        // Sent the Request and get response
        Response response = given(spec).body(expectedData).when().post("{first}");
        response.prettyPrint();

        // Do Assertion
        BookingResponsePojo actuacDate = response.as(BookingResponsePojo.class);
        System.out.println("actuacDate = " + actuacDate);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname() , actuacDate.getBooking().getFirstname());
        assertEquals(expectedData.getLastname() , actuacDate.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice() , actuacDate.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid() , actuacDate.getBooking().getDepositpaid());
        assertEquals(expectedData.getBookingdates().getCheckin() , actuacDate.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actuacDate.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds() , actuacDate.getBooking().getAdditionalneeds());

    }
}
