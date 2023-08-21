package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponsePojo;
import test_data.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static utils.ObjectMapperUtils.convertJsonToJava;

public class Put02 extends DummyRestApiBaseUrl {
    /*

    Given
       1) URL: https://dummy.restapiexample.com/api/v1/update/21
       2) Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                       }

     When
      Kullanici PUT Request gönderiri



      Then
                i) Status code is 200
      And
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */

    @Test
    public void put02() {
        // Set the Url
        spec.pathParams("first","update","second",21);
        // Set the expected data
        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);
        // Sent the Request and get response
        Response response = given(spec).body(expectedData).when().put("{first}/{second}");
        response.prettyPrint();
        // Do Assertion
        DummyRestApiResponsePojo actualData = convertJsonToJava(response.asString(),DummyRestApiResponsePojo.class);

        Assert.assertEquals(200,response.statusCode());
        Assert.assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        Assert.assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        Assert.assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        Assert.assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
        Assert.assertEquals("success",actualData.getStatus());
        Assert.assertEquals("Successfully! Record has been updated.",actualData.getMessage());



    }
}
