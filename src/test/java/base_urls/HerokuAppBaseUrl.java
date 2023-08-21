package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
public class HerokuAppBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void Setup(){
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
// Her sorguda tekrar eden dataları buraya gireceğizrguda tekrar eden dataları buraya gireceğiz