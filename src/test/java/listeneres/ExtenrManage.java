package listeneres;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtenrManage {



    public static ExtentReports createExtentInstance(String reportname){
        System.out.println(reportname);
        ExtentSparkReporter spark = new ExtentSparkReporter(reportname);
        ExtentReports reports;

        spark.config().setEncoding("utf-8");
        spark.config().setDocumentTitle("My automation report");
        spark.config().setReportName("My API Testing report");
        spark.config().setTheme(Theme.STANDARD);

        reports = new ExtentReports();
        reports.attachReporter(spark);

        reports.setSystemInfo("Author","Ayush");
        reports.setSystemInfo("Device","Windowas");

        return reports;

    }


}
