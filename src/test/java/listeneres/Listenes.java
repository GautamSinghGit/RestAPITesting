package listeneres;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;
import java.util.Date;

public class Listenes implements ITestListener {


     public static Date d = new Date();
     public static String filePath = "Extent_"+d.toString().replace(":","_").replace(" ","_")+".html";

     public static ExtentReports reports = ExtenrManage.createExtentInstance("./Extent//"+filePath);

     public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public void onTestStart(ITestResult result) {
        ExtentTest test1 = reports.createTest(result.getTestClass().getName()+"     "+result.getMethod().getMethodName());
        test.set(test1);

    }

    public void onTestSuccess(ITestResult result) {

        String methodName = result.getMethod().getMethodName();
        String text = "<b> Test Case  ---- "+methodName+"   PASSED </b>";

        Markup m = MarkupHelper.createLabel(text, ExtentColor.GREEN);

        test.get().pass(m);




    }

    public void onTestFailure(ITestResult result) {

        String error = Arrays.toString(result.getThrowable().getStackTrace());
        String errorMesasge = "<details> <summary> <b> <font color = red> Exceptiion Occured : Click to see </font>"+
                                "</b> </summary>"+error.replaceAll(",","<br>")+"</details>"+"\n";

        test.get().fail(result.getThrowable().getMessage());
        test.get().fail(errorMesasge);

        String methodName = result.getMethod().getMethodName();
        String text = "<b> TEST CASE : "+methodName+" FAILED </b>";

        Markup m = MarkupHelper.createLabel(text,ExtentColor.RED);
        test.get().log(Status.FAIL,m);

    }

    public void onTestSkipped(ITestResult result) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
        reports.flush();

    }




}
