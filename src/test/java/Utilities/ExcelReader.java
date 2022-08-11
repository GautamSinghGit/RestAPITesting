package Utilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import javax.swing.*;

public class ExcelReader {
    //   public static void main(String[] args)  {


    private static String createCustomerExcelBookName = "CustomerAPI";
    private static String createCustomerExcelSheetName = "CreateCustomer";

    static Fillo fillo = new Fillo();
    static Connection connection;
    static Recordset recordset;

    public static Recordset getDataforCreateCustomerAPI(String testName) {

        try {
            connection = fillo.getConnection(".//src//test//resources//" + createCustomerExcelBookName + ".xlsx");
        } catch (FilloException e) {
            e.printStackTrace();
        }
      //  String query1 = "Select * from " + createCustomerExcelSheetName + " where scenario = 'createcustomer'";
        String query1 = "Select * from "+createCustomerExcelSheetName +" Where testcasename = "+"'"+testName+"'";
        try {
            recordset = connection.executeQuery(query1);
         //  recordset.moveFirst();

        } catch (FilloException e) {
            e.printStackTrace();
        }


        return recordset;


        //  }
    }
}
