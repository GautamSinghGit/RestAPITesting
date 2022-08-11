package RestAssuredDemo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class RestAssuredFirst_Get_Method {

    public static void main(String[] args) {

         /* Response response = given().param("limit",3).auth().basic("sk_test_51KKNN2SFUSQ3e1jUAjpjwdy8LMxxY2LCJjIDcuoFyxmVmOtj9veEhS9Kxgceh7mlHxlhjsIxB7AUqIyBB3ONinqr00QAd4uybD","")
       .get("https://api.stripe.com/v1/customers");

        response.prettyPrint();

        System.out.println(response.statusCode());*/

        Response response = given().header("Authorization","Bearer sk_test_51KKNN2SFUSQ3e1jUAjpjwdy8LMxxY2LCJjIDcuoFyxmVmOtj9veEhS9Kxgceh7mlHxlhjsIxB7AUqIyBB3ONinqr00QAd4uybD")
                .get("https://api.stripe.com/v1/customers/cus_MAyYjFFJEfklBg");

        response.prettyPrint();





    }

}