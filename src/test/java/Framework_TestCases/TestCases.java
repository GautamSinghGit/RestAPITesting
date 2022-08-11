package Framework_TestCases;

import Utilities.ExcelReader;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.rest.APIs.CreateCustomerAPI;
import io.restassured.response.Response;
import listeneres.Listenes;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;

import static io.restassured.RestAssured.*;


public class TestCases extends BaseClass {


    @Test(dataProviderClass = dataprovider.DataUtil.class, dataProvider = "sendData")
    public void checkingCreateCustomerAPIwithValidSecretKey(Hashtable<String,String> data) throws FilloException {

       // test = extent.createTest("checkingCreateCustomerAPIwithValidSecretKey");
        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuthKey(data);
        Listenes.test.get().info(data.toString()) ;
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

    }

//(groups = { "tagName", "t:another-tagName", "a:authorName", "d:deviceName" })

    @Test(dataProviderClass = dataprovider.DataUtil.class,dataProvider = "sendData")
    public void checkingCreateCustomerAPIwithInvalidSecretKey(Hashtable<String ,String> data) throws FilloException {
    //   test = extent.createTest("checkingCreateCustomerAPIwithInvalidSecretKey");

        System.out.println(data.get("name")+"   "+data.get("email"));
        Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuthKey(data);
        Listenes.test.get().info(data.toString());
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);
    }


   /* @AfterMethod
    public void afterMethod(ITestResult r){

        if(r.getStatus()==ITestResult.FAILURE){
            String methodName = r.getMethod().getMethodName();
            String text = "<b>"+" Test Case :----> "+methodName+"  FAILED "+"</b>";
            Markup m = MarkupHelper.createLabel(text,ExtentColor.RED);
            test.fail(m);

        }
        else if(r.getStatus()==ITestResult.SUCCESS){

            String mehtodName = r.getMethod().getMethodName();
            String text = "<b>"+"Test Case :-> "+mehtodName+" PASSED "+"</b>";
            Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);
            test.pass(m);

        }
        else if(r.getStatus()==ITestResult.SKIP){

        }

    }*/


}
