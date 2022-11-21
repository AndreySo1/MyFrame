package constants;

import common.ExcelReader;
import org.testng.annotations.DataProvider;

public class ExcelDataProviders {
   
   @DataProvider
   public Object[][] usersFromSheet1() throws Exception{
      String path = "src/test/resources/data.xlsx";
      ExcelReader excelReader = new ExcelReader(path);
      return excelReader.getSheetData();
   }

   @DataProvider
   public Object[][] usersFromSheet2() throws Exception{
      String path = "src/test/resources/data.xlsx";
      ExcelReader excelReader = new ExcelReader(path, "Sheet2");
      return excelReader.getCustomSheetData();
   }

   @DataProvider
   public Object[][] usersForApi() throws Exception{
      String path = "src/test/resources/usersForReqres.xlsx";
      ExcelReader excelReader = new ExcelReader(path);
      return excelReader.getSheetData();
   }
}
