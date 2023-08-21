package post_requests;
import base_urls.HerokuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerOkuAppTestData;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class Post02 extends HerokuAppBaseUrl {
                /*
            Given
                        1) https://restful-booker.herokuapp.com/booking
                        2) {
                             "firstname": "John",
                             "lastname": "Doe",
                             "totalprice": 11111,
                             "depositpaid": true,
                             "bookingdates": {
                                 "checkin": "2021-09-09",
                                 "checkout": "2021-09-21"
                              }
                           }
                    When
                        I send POST Request to the Url
                    Then
                        Status code is 200
                        And response body should be like {
                                                            "bookingid": 5315,
                                                            "booking": {
                                                                "firstname": "John",
                                                                "lastname": "Doe",
                                                                "totalprice": 11111,
                                                                "depositpaid": true,
                                                                "bookingdates": {
                                                                    "checkin": "2021-09-09",
                                                                    "checkout": "2021-09-21"
                                                                }
                                                            }
                                                         }
                 */

    @Test
    public void post() {
        // Set the Url
        spec.pathParam("first","booking");
        // Set the expected data
        Map<String, String> bookingMap = new HerOkuAppTestData().bookingDateMapper("2021-09-09" ,"2021-09-21");

        Map<String,Object> expectedDataMap = new HerOkuAppTestData()
                .expectedDataMapper("John"
                        ,"Doe"
                        ,11111
                        ,true,bookingMap
                        ,null);
        System.out.println("expectedDataMap = " + expectedDataMap);

        // Sent the Request and get response
        Response response = given(spec).body(expectedDataMap).when().post("{first}");
        response.prettyPrint();

        // Do Assertion
        Map<String,Object> actualDataMap = response.as(HashMap.class);
        JsonPath json = response.jsonPath();
        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),((Map)actualDataMap.get("booking")).get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),((Map)actualDataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),((Map)actualDataMap.get("booking")).get("depositpaid"));
        //1 yol
        assertEquals(bookingMap.get("checkin"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingMap.get("checkout"), ((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));
        //2. yol
        assertEquals(bookingMap.get("checkin"), json.getString("booking.bookingdates.checkin"));
        assertEquals(bookingMap.get("checkout"),json.getString("booking.bookingdates.checkout"));
    }
}