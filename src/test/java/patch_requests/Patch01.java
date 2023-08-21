package patch_requests;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
    /*
    Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                  "title": "Wash the dishes"
                }
         When
          I send PATCH Request to the Url
        Then
              Status code is 200
              And response body is like   {
                                "userId": 10,
                                "title": "Wash the dishes",
                                "completed": true,
                                "id": 198
                               }
    */
    @Test
    public void patch01() {
        // Set the Url

        spec.pathParams("first","todos" ,"second",198);

        // Set the expected data

        Map<String,Object> payLoad = new JsonPlaceHolderTestData()
                .expectedDataMapper(null,"Wash the dishes",null); //degistirdigimiz veri icin

        Map<String,Object> expectedData = new JsonPlaceHolderTestData()
                .expectedDataMapper(10,"Wash the dishes",true); //tüm veriler icin


        // Sent the Request and get response
        Response response = given(spec).body(payLoad).when().patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}