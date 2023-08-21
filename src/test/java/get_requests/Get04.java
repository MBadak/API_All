package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 extends JsonPlaceHolderBaseUrl {
    /*
        Given  https://jsonplaceholder.typicode.com/todos
    When   I send a GET request to the Url
    And    Accept type is "application/json"
    Then   HTTP Status Code should be 200
    And    Response format should be "application/ison"
    And    200 adet todos olmalı
    And    başlıklarından birisi  "quis eius est sint explicabo" olmalı
    And    userIds ler arasında 2, 7, and 9 bulunmalı
     */

    @Test
    public void Get(){
        //1. Set Base url

        // String url = "https://jsonplaceholder.typicode.com/todos";// --> Tercih edilmeyen yöntem
        spec.pathParam("first","todos");

        // Base Url= Her sorguda tekrarlanan kısım
        // path Parametresi: "/" dan sonra base url ye eklenen kısım

        //2. Set expected data
        //3. Sent req and get resp
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();

        //4. Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",hasSize(200)
                        ,"title",hasItem("quis eius est sint explicabo")
                        ,"userId",hasItems(2,7,9));
    }
}
// hasSize: listenin boyutunu sorgular
// hasItem() --> contais() mtd gibi çalışır
// hasItems() --> containsAll() gibi çalışır