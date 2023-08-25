package gmi_bank;

import base_urls.GmiBankBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.gmi_bank.*;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getCustomer extends GmiBankBaseUrl {  /*
        Given
            https://www.gmibank.com/api/tp-customers/133986
        When
            User sends Get request
        Then
            Status code should be 200
         And
            Response body should be like:
                {
                    "id": 133986,
                    "firstName": "Danika",
                    "lastName": "Huel",
                    "middleInitial": "S",
                    "email": "danikahuel@gmail.com",
                    "mobilePhoneNumber": "155-489-7844",
                    "phoneNumber": "155-489-7844",
                    "zipCode": "32476",
                    "address": "3848 Lang Hill",
                    "city": "Free City",
                    "ssn": "725-97-6213",
                    "createDate": "2022-01-21T05:00:00Z",
                    "zelleEnrolled": false,
                    "country": {
                        "id": 187679,
                        "name": "Banana",
                        "states": null
                    },
                    "state": "Apple",
                    "user": {
                        "id": 134701,
                        "login": "raymundo.moen",
                        "firstName": "Danika",
                        "lastName": "Huel",
                        "email": "danikahuel@gmail.com",
                        "activated": true,
                        "langKey": "en",
                        "imageUrl": null,
                        "resetDate": null
                    },
                    "accounts": [
                        {
                            "id": 128481,
                            "description": "Description",
                            "balance": 0,
                            "accountType": "CHECKING",
                            "accountStatusType": "ACTIVE",
                            "createDate": "2022-01-04T21:00:00Z",
                            "closedDate": "2022-01-04T21:00:00Z",
                            "employee": null,
                            "accountlogs": null
                        },
                        {
                            "id": 131776,
                            "description": "mfy",
                            "balance": 536846,
                            "accountType": "CREDIT_CARD",
                            "accountStatusType": "ACTIVE",
                            "createDate": "2022-01-18T21:00:00Z",
                            "closedDate": "2022-01-18T21:00:00Z",
                            "employee": null,
                            "accountlogs": null
                        }
                    ]
                }
         */
    @Test
    public void getCountry() {
        // Set the URL
        spec.pathParams("first", "api", "second", "tp-customers", "third", 133986);

        // Set the expected data
        CountryPojo country = new CountryPojo(187679, "Banana", null);
        UserPojo user = new UserPojo(134701, "raymundo.moen", "Danika", "Huel", "danikahuel@gmail.com", true, "en", null, null);

        AccountsPojo account1 = new AccountsPojo(128481, "Description", 0, "CHECKING", "ACTIVE",
                "2022-01-04T21:00:00Z", "2022-01-04T21:00:00Z", null, null);
        AccountsPojo account2 = new AccountsPojo(131776, "mfy", 536846, "CREDIT_CARD", "ACTIVE",
                "2022-01-18T21:00:00Z", "2022-01-18T21:00:00Z", null, null);

        List<AccountsPojo> accountsList = new ArrayList<>();
        accountsList.add(account1);
        accountsList.add(account2);

        CustomerPojo expectedData = new CustomerPojo(133986, "Danika", "Huel", "S", "danikahuel@gmail.com", "155-489-7844",
                "155-489-7844", "32476", "3848 Lang Hill", "Free City", "725-97-6213", "2022-01-21T05:00:00Z", false, country,
                "Apple", user, accountsList);
        System.out.println("expectedData = " + expectedData);

        // Sent the Request and get response
        Response response = given(spec).when().get("{first}/{second}/{third}");
        response.prettyPrint();

        // Do Assertion
        CustomerPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), CustomerPojo.class);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(expectedData.getId(), actualData.getId());
        Assert.assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(expectedData.getLastName(), actualData.getLastName());
        Assert.assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        Assert.assertEquals(expectedData.getEmail(), actualData.getEmail());
        Assert.assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        Assert.assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        Assert.assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        Assert.assertEquals(expectedData.getAddress(), actualData.getAddress());
        Assert.assertEquals(expectedData.getCity(), actualData.getCity());
        Assert.assertEquals(expectedData.getSsn(), actualData.getSsn());
        Assert.assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        Assert.assertFalse( actualData.isZelleEnrolled());
        Assert.assertEquals(expectedData.getState(), actualData.getState());

        Assert.assertEquals(country.getId(), actualData.getCountry().getId());
        Assert.assertEquals(country.getName(), actualData.getCountry().getName());
        Assert.assertEquals(country.getStates(), actualData.getCountry().getStates());

        Assert.assertEquals(user.getId(), actualData.getUser().getId());
        Assert.assertEquals(user.getLogin(), actualData.getUser().getLogin());
        Assert.assertEquals(user.getFirstName(), actualData.getUser().getFirstName());
        Assert.assertEquals(user.getLastName(), actualData.getUser().getLastName());
        Assert.assertEquals(user.getEmail(), actualData.getUser().getEmail());
        Assert.assertTrue( actualData.getUser().isActivated());
        Assert.assertEquals(user.getLangKey(), actualData.getUser().getLangKey());
        Assert.assertEquals(user.getImageUrl(), actualData.getUser().getImageUrl());
        Assert.assertEquals(user.getResetDate(), actualData.getUser().getResetDate());

        Assert.assertEquals(account1.getId(), actualData.getAccounts().get(0).getId());
        Assert.assertEquals(account1.getDescription(), actualData.getAccounts().get(0).getDescription());
        Assert.assertEquals(account1.getBalance(), actualData.getAccounts().get(0).getBalance());
        Assert.assertEquals(account1.getAccountType(), actualData.getAccounts().get(0).getAccountType());
        Assert.assertEquals(account1.getAccountStatusType(), actualData.getAccounts().get(0).getAccountStatusType());
        Assert.assertEquals(account1.getCreateDate(), actualData.getAccounts().get(0).getCreateDate());
        Assert.assertEquals(account1.getClosedDate(), actualData.getAccounts().get(0).getClosedDate());
        Assert.assertEquals(account1.getEmployee(), actualData.getAccounts().get(0).getEmployee());
        Assert.assertEquals(account1.getAccountlogs(), actualData.getAccounts().get(0).getAccountlogs());

        Assert.assertEquals(account2.getId(), actualData.getAccounts().get(1).getId());
        Assert.assertEquals(account2.getDescription(), actualData.getAccounts().get(1).getDescription());
        Assert.assertEquals(account2.getBalance(), actualData.getAccounts().get(1).getBalance());
        Assert.assertEquals(account2.getAccountType(), actualData.getAccounts().get(1).getAccountType());
        Assert.assertEquals(account2.getAccountStatusType(), actualData.getAccounts().get(1).getAccountStatusType());
        Assert.assertEquals(account2.getCreateDate(), actualData.getAccounts().get(1).getCreateDate());
        Assert.assertEquals(account2.getClosedDate(), actualData.getAccounts().get(1).getClosedDate());
        Assert.assertEquals(account2.getEmployee(), actualData.getAccounts().get(1).getEmployee());
        Assert.assertEquals(account2.getAccountlogs(), actualData.getAccounts().get(1).getAccountlogs());



    }
}
