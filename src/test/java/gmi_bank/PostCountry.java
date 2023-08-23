package gmi_bank;

import base_urls.GmiBankBaseUrl;
import org.junit.Test;

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


        // Sent the Request and get response
        // Do Assertion


    }
}
