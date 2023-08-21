package put_requests;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
public class Put01a extends JsonPlaceHolderBaseUrl {
    /*
    Given
          1) https://jsonplaceholder.typicode.com/todos/198
          2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
       I send PUT Request to the Url
      Then
          Status code is 200
          And response body is like   {
                      "userId": 21,
                      "title": "Wash the dishes",
                      "completed": false
                     }
     */
    @Test
    public void put(){
        // Set base Url
        spec.pathParams("first","todos"
                ,"second",198);
        // 2 Set expected data:    bu kismi methoddan cagirdik
        Map<String,Object> expectedData = new JsonPlaceHolderTestData().expectedDataMapper(21,"Wash the dishes",false);
        // Sent req get resp
        Response response =  given(spec).body(expectedData).when().put("{first}/{second}"); // Serialization
        // Do Assertion
        Map<String ,Object> actualData =  response.as(HashMap.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
