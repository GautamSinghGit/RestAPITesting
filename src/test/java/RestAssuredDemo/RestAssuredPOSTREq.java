package RestAssuredDemo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredPOSTREq {


    public static void main(String[] args) {

   /* Response response = given().auth().basic("sk_test_51KKNN2SFUSQ3e1jUAjpjwdy8LMxxY2LCJjIDcuoFyxmVmOtj9veEhS9Kxgceh7mlHxlhjsIxB7AUqIyBB3ONinqr00QAd4uybD","")
            .formParam("email","arora@way.com").formParam("name","Rahul Arora").formParam("description","This is thired post request with rest assured")
            .post("https://api.stripe.com/v1/customers");

    response.prettyPrint();*/
        HashMap<String,Object> requestBody = new HashMap<>();

        String requestBod = "{\"name\":\"reena\",\"job\":\"kgf2\"}";

        requestBody.put("name","Rajat");
        requestBody.put("job","hacker");

        HashMap<String ,String> addressMap = new HashMap<>();
        addressMap.put("flat","407");
        addressMap.put("building","India gate");

        requestBody.put("address",addressMap);

        List<Integer> num = new ArrayList<>();
        num.add(23567);
        num.add(3566778);

        requestBody.put("number",num);



       /* Response response = given().contentType(ContentType.JSON).body(requestBody).post("https://reqres.in/api/users");
        response.prettyPrint();

        System.out.println(response.statusCode());*/

       Response response = given().get("https://reqres.in/api/users/2");

       response.prettyPrint();


    }
}
