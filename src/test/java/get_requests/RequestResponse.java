package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {

    /*
    Notlar: 1-Manuel testler için PostMan kullanacağız.
            2-API otomasyon testleri için REST Assured kütüphanesini kullacağız.
            3-Otomasyon kodlarını yazarken şu adımları takip edeceğiz;
                a-Gereksinimleri anlamak
                b-Test Senaryonlarını yazmak
                    i. Test senaryolarını yazarken Gherkin dilini kullanacağız.
                        - Given: Ön koşullar; Endpoint, body
                        - When: İşlemler: Get, Post,Put, Delete...
                        - Then: Assertion ve Close işlemleri
                        - And : Çoklu işlemlerin yapılacağı zaman kullanılır.

                C. Otomasyon kodlarını yazarken şu adımları takip ederiz.
                    i. Set the URL
                    ii. Set the Expected data
                    iii. Send the request and get the response
                    iv. Do  assertion

     */
    public static void main(String[] args) {
        String url="https://petstore.swagger.io/v2/pet/9898";
        Response response=given().when().get(url);

        response.prettyPrint();//sadece body kısmını yazdırır.

        // Status kod nasıl yazdılır.
        System.out.println(response.statusCode());

        //Contentype nasıl yazılır
        System.out.println(response.contentType());

        //status Line nasıl yazdılır.
        System.out.println(response.statusLine());

        //Her bölümdeki bir veri nasıl yazdılır.
        System.out.println(response.header("Server"));

        //Headers bölümü nasıl yazdırılır
        System.out.println(response.headers());

        //Time bilgisi nasıl yazdırılır
        System.out.println(response.time());

    }
}
