package RestAssuredDemo;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class GetJosnFieldFromJsonResponse {


    public static void main(String[] args) {


        Response response =given().auth().basic("sk_test_51KKNN2SFUSQ3e1jUAjpjwdy8LMxxY2LCJjIDcuoFyxmVmOtj9veEhS9Kxgceh7mlHxlhjsIxB7AUqIyBB3ONinqr00QAd4uybD","")
                .formParam("name","Mark").formParam("email","mark@ex.com").formParam("address[line1]","Santacruz")
                .formParam("address[city]","NewYork").formParam("preferred_locales[0]","Hindi")
                .post("https://api.stripe.com/v1/customers");

        response.prettyPrint();

        System.out.println(response.statusCode());

        System.out.println((String) response.jsonPath().get("name"));
        System.out.println(response.jsonPath().getString("email"));
        System.out.println(response.jsonPath().getString("address"));
        System.out.println(response.jsonPath().getMap("address").size());
        System.out.println(response.jsonPath().getString("preferred_locales[0]"));




    }
}
