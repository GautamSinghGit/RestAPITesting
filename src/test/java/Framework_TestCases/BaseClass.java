package Framework_TestCases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public static Properties prop = new Properties();
    private FileInputStream fileInputStream;
    /*public ExtentReports extent;
    public ExtentSparkReporter spark;
    public ExtentTest test;
*/
    @BeforeSuite
    public void setUp(){

       /* extent = new ExtentReports();
        spark = new ExtentSparkReporter("./Repsots/extent.html");

        spark.config().setEncoding("utf-8");
        spark.config().setDocumentTitle("My AUtomatio Report");
        spark.config().setReportName("My API Automation Report");
        spark.config().setTheme(Theme.STANDARD);

        extent.attachReporter(spark);

        extent.setSystemInfo("Author","Gautam");
        extent.setSystemInfo("Device","WIndows");*/




        try {
            fileInputStream = new FileInputStream(".//src//test/resources//config.properties");
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestAssured.baseURI = prop.getProperty("baseURI");
        RestAssured.basePath = prop.getProperty("basePATH");


    }

    @AfterSuite
    public void teardown(){
       // extent.flush();
    }

}
