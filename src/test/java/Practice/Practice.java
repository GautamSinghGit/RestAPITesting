package Practice;

import Framework_TestCases.BaseClass;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import io.restassured.response.Response;

import java.util.Date;

import static io.restassured.RestAssured.*;

public class Practice extends BaseClass {

    private static String createCustomerExcelBookName = "CustomerAPI";
    private static String createCustomerExcelSheetName = "CreateCustomer";

    static Fillo fillo = new Fillo();
    static Connection connection;
    static Recordset recordset;
    public static void main(String[] args) {


       /* Response response = given().auth().basic("sk_test_51KKNN2SFUSQ3e1jUAjpjwdy8LMxxY2LCJjIDcuoFyxmVmOtj9veEhS9Kxgceh7mlHxlhjsIxB7AUqIyBB3ONinqr00QAd4uybD","")
                .formParam("name","new name").formParam("phone",9876).post("https://api.stripe.com/v1/customers");

        response.prettyPrint();*/


    //    public static Recordset getDataforCreateCustomerAPI() {

            try {
                Date d = new Date();
                System.out.println(d);
                System.out.println(d.toString().replace(":","_").replace(" ","_"));
                connection = fillo.getConnection(".//src//test//resources//" + createCustomerExcelBookName + ".xlsx");
            } catch (FilloException e) {
                e.printStackTrace();
            }
            //  String query1 = "Select * from " + createCustomerExcelSheetName + " where scenario = 'createcustomer'";
            String query1 = "Select * from "+createCustomerExcelSheetName +" Where testcasename = 'checkingCreateCustomerAPIwithInvalidSecretKey'";
            try {
                recordset = connection.executeQuery(query1);
            //    recordset.moveFirst();
                while (recordset.next()) {
                    System.out.println(recordset.getField("name"));
                    System.out.println(recordset.getCount());
                    System.out.println(recordset.getFieldNames().get(1));
                }
            } catch (FilloException e) {
                e.printStackTrace();
            }


    //        return recordset;


            //  }
     //   }

    }
}
