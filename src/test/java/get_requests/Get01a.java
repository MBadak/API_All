package get_requests;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01a {
    /*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       Kullanıcı URL'e bir GET request gönderir
   Then
       HTTP Status Code 200 olmalı
   And
       Content Type "application/json" olmalı
   And
       Status Line "HTTP/1.1 200 OK" olmalı
*/

    @Test
    public void get01(){
        //  1- Set the URL = URL'i tanımla
        String url = "https://restful-booker.herokuapp.com/booking/3";

        //   2- Set the expected data = Beklenen dataları ayarla
        //    3- Send the request and get the response = İsteği gönder ve cevabı al
        Response response = given().when().get(url);
        response.prettyPrint();

        //    4- Do assertion = Doğrulama yap

        response
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");

    }

}
