package Framework_TestCases;

import Utilities.TestUtil;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.rest.APIs.DeleteCUstomerAPI;
import io.restassured.response.Response;
import listeneres.Listenes;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class DeleteCustomerTestCases  extends BaseClass {


    @Test(dataProviderClass = dataprovider.DataUtil.class,dataProvider = "sendData")
    public void deletingCustomerWithValidID(Hashtable<String,String> data){

        Response response = DeleteCUstomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidID(data);
        Listenes.test.get().info(data.toString());
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(),200);

        JSONObject jsonObject = new JSONObject(response.asString());

        System.out.println(jsonObject.has("id"));
        System.out.println(jsonObject.get("id"));

        Assert.assertTrue(TestUtil.jsonHasKey(response.asString(),"id"),"ID is not present in response");
        Assert.assertEquals(TestUtil.getJsonValueFromKey(response.asString(),"id"),data.get("id"),"ID does not mateched");




    }

}
