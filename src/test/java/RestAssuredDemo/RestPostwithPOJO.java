package RestAssuredDemo;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;

import static io.restassured.RestAssured.*;

public class RestPostwithPOJO {
    public static void main(String[] args) {

        User user = new User("Singh","Actor",504,"Taj Hotel","Jar","Finance");
        /*ArrayList<Integer> num = new ArrayList<>();
        num.add(2232);
        num.add(23232);
        user.setNumbers(num);*/

        user.setNumbers(333,44444,666666);

        user.getCompany().setClients("Paypal", "Tesla" , "Godrej");

        Response response = given().contentType(ContentType.JSON).body(user).post("https://reqres.in/api/users");
        response.prettyPrint();
        response.jsonPath();


    }
}
