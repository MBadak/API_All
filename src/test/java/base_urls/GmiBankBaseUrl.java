
package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static utils.AuthenticationHerokuApp.generateToken;

public class GmiBankBaseUrl {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder()
                .setBaseUri("https://gmibank.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYXJrX3R3YWluIiwiYXV0aCI6IlJPTEVfQURNSU4sUk9MRV9NQU5BR0VSIiwiZXhwIjoxNjkyOTA1OTM2fQ.jvFhKYU7_0jWZgfp4Tm7lfcRjzy-C28YM879DInS6mmMJwFVve6rorynRpymLXHeCN_D-IqseKOHK13Ym6V8yw")
                .build();

    }
}

