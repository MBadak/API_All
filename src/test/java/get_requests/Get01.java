package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
    //given() kismi testin basinda request'in hazirlanmasi asamasidir. Testin temel kosullarinin hazirlanmasi

    //when() kismi olusturulan kosullarin eyleme gecirilip gerceklesmesi adimidir. get,put, post islemleri gibi...
    //Orn: Rezervasyonu onayla butonuna tiklanmasi
    //then() kismi eylemin sonuclarini kontrol etme islemidir, dogrulanmasidir.
    // Onceden belirlenen beklentilerin karsidan gelen cevaplarla karsilastirilmasi islemidir.
    // Orn:Rezervasyonunuz onaylanmistir mesajinin gorulmesi

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

        //Birinci yöntem
       // String url="https://restful-booker.herokuapp.com/booking/1";

        //İkinci yöntem
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/1";

      Response response= given().when().get();// gelen veriyi ekrana yazdırmak için Response yazdık.

        response
                .then()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");




    }
}
