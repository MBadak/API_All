package practice01;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Get01_IDileContactGetirme {
    @Test
    public void get01() {
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath = "/contacts/64d7e1429a694e00130f2159";
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGI5MTc4ZGM0ZjcyYjAwMTM3ZTAzN2UiLCJpYXQiOjE2OTE4NjUzOTF9.8jUbtQOCi60kSyAcCNspFGxOZF93hKSX0tPRN68e45E";
        Response response =
                given()
                        .auth().oauth2(token)
                        .when()
                        .get();
        response.prettyPrint();
        response
                .then()
                .body("firstName", equalTo("Gürkay"))
                .body("lastName", equalToIgnoringCase("birinci"))
                .body("email", not(equalTo("gurkay@fake.com")))
                .body("email", containsString("@fake.com"))
                .body("city", startsWith("Any"))
                .body("city", endsWith("own"))
                .body("stateProvince", anyOf(equalTo("KS"), equalTo("CA")))
                .body("country", allOf(equalTo("USA"), equalToIgnoringCase("usa")))
                .body("__v", greaterThan(-1));
    }
}