package gmi_bank;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.gmi_bank.PostCountryPojo;
import pojos.gmi_bank.StatesPojo;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostCountry extends GmiBankBaseUrl {
      /*
    Given
        https://gmibank.com/api/tp-countries
    And
        {
          "name": "Muz Cumhuriyeti",
          "states": [
            {
              "id": 1,
              "name": "Elma"
            },
            {
              "id": 2,
              "name": "Armut"
            },
            {
              "id": 3,
              "name": "Portakal"
            }
          ]
        }
    When
        Kullanıcı POST request gönderir
    Then
        Status Code = 201
    And
        Body:
            {
                "id": 191781,
                "name": "Muz Cumhuriyeti",
                "states": [
                    {
                        "id": 1,
                        "name": "Elma",
                        "tpcountry": null
                    },
                    {
                        "id": 2,
                        "name": "Armut",
                        "tpcountry": null
                    },
                    {
                        "id": 3,
                        "name": "Portakal",
                        "tpcountry": null
                    }
                ]
            }
 */
  @Test
    public void postCountry() {

        // Set the Url
        spec.pathParams("first","api", "second", "tp-countries");


        // Set the expected data
      StatesPojo state1  = new StatesPojo(1,"Elma" );
      StatesPojo state2 = new StatesPojo(2,"Armut" );
      StatesPojo state3 = new StatesPojo(3,"Portakal" );

      List<StatesPojo> stateList = new ArrayList<>();
     stateList.add(state1);
     stateList.add(state2);
     stateList.add(state3);


      PostCountryPojo expectedData =  new PostCountryPojo("Muz Cumhuriyeti",stateList);
      System.out.println("expectedData.toString() = " + expectedData.toString());

      // Sent the Request and get response
      Response response = given(spec).body(expectedData).when().post("{first}/{second}");
      response.prettyPrint();
        // Do Assertion
      PostCountryPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), PostCountryPojo.class);
      Assert.assertEquals(201, response.statusCode());
      Assert.assertEquals(expectedData.getName(), actualData.getName());
      Assert.assertEquals(expectedData.getStates().get(0).getId(), actualData.getStates().get(0).getId());
      Assert.assertEquals(expectedData.getStates().get(0).getName(), actualData.getStates().get(0).getName());
      Assert.assertEquals(expectedData.getStates().get(1).getId(), actualData.getStates().get(1).getId());
      Assert.assertEquals(expectedData.getStates().get(1).getName(), actualData.getStates().get(1).getName());
      Assert.assertEquals(expectedData.getStates().get(2).getId(), actualData.getStates().get(2).getId());
      Assert.assertEquals(expectedData.getStates().get(2).getName(), actualData.getStates().get(2).getName());






    }
}
