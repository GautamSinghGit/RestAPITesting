package dataprovider;

import Framework_TestCases.BaseClass;
import Utilities.ExcelReader;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

public class DataUtil extends BaseClass {


    @DataProvider(name = "sendData",parallel = true)
    public Object[][] getData(Method m) throws FilloException {
        Recordset recordset = ExcelReader.getDataforCreateCustomerAPI(m.getName());
        recordset.moveFirst();
     //   Object[][] data = new Object[recordset.getCount()][recordset.getFieldNames().size() - 1];
        Object[][] data = new Object[recordset.getCount()][1];

        for (int i = 0; i < recordset.getCount(); i++) {
            Hashtable<String , String> table = new Hashtable<>();
            for (int j = 1; j < recordset.getFieldNames().size(); j++) {
               // data[i][j - 1] = recordset.getField(j).value();
                String testData = recordset.getField(j).value();
                String colName = recordset.getFieldNames().get(j);
                table.put(colName, testData);
            }
            table.values().removeIf(e->e.equalsIgnoreCase(""));
            data[i][0] = table;
            if (i == recordset.getCount() - 1)
                break;
            recordset.moveNext();
        }

        return data;


    }
}
