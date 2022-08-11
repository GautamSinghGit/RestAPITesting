package com.rest.APIs;

import Framework_TestCases.BaseClass;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Hashtable;

import static io.restassured.RestAssured.*;;

public class CreateCustomerAPI extends BaseClass {


    public static Response sendPostRequestToCreateCustomerAPIWithValidAuthKey(Hashtable<String,String> data){

       // if(data)
      Response response =  given().auth().basic(prop.getProperty("validSecretKey"), "")
                .formParam("email", data.get("email")).formParam("description", data.get("desc"))
                .formParam("name", data.get("name"))
                .post(prop.getProperty("createCustomerAPIEndPoint"));
      return response;

    }

    public static Response sendPostRequestToCreateCustomerAPIWithInValidAuthKey(Hashtable<String,String> data){
        Response response =  given().auth().basic(prop.getProperty("invalidSecretKey"), "")
                .formParam("email", data.get("email")).formParam("description", data.get("desc"))
                .post(prop.getProperty("createCustomerAPIEndPoint"));
        return response;

    }

}
