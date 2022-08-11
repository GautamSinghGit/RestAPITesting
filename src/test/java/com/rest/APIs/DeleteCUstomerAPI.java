package com.rest.APIs;

import Framework_TestCases.BaseClass;
import io.restassured.response.Response;

import java.util.Hashtable;

import static io.restassured.RestAssured.*;

public class DeleteCUstomerAPI extends BaseClass {

    public static Response sendDeleteRequestToDeleteCustomerAPIWithValidID(Hashtable<String,String> data){

        Response response = given().auth().basic(prop.getProperty("validSecretKey"),"")
                .delete(prop.getProperty("CustomerAPIEndPoint")+"/"+data.get("id"));

        return response;


    }


}
