package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
   private String excelFilePath;
   private XSSFSheet sheet;
   private XSSFWorkbook book;
   private String sheetName;

   public ExcelReader(String excelFilePath) throws IOException {
      this.excelFilePath = excelFilePath;
      File file = new File(excelFilePath);
      try {
         FileInputStream fileInputStream = new FileInputStream(file);
         book = new XSSFWorkbook(fileInputStream);
         sheet = book.getSheet("Sheet1");
      } catch (IOException e) {
         throw new IOException("MY ERROR: Not support format");
      }
   }

   //overLoading
   public ExcelReader(String excelFilePath, String sheetName) throws IOException {
      this.excelFilePath = excelFilePath;
      this.sheetName = sheetName;
      File file = new File(excelFilePath);
      try {
         FileInputStream fileInputStream = new FileInputStream(file);
         book = new XSSFWorkbook(fileInputStream);
         sheet = book.getSheet(sheetName);
      } catch (IOException e) {
         throw new IOException("Not support format");
      }     
   }

   public String cellToString(XSSFCell cell) throws Exception {
      Object result = null;
      CellType type = cell.getCellType();

      switch(type){
         case NUMERIC: //double
            result = cell.getNumericCellValue();
            break;
         case STRING:
            result = cell.getStringCellValue();
            break;
         case FORMULA:
            result = cell.getCellFormula();
            break;
         case BLANK:
            result = "";
            break;
         default: throw new Exception("Error reading");
      }

      return result.toString();      
   }

   private int xlsxCounColumn(){
      return sheet.getRow(0).getLastCellNum();
   }

   private int xlsxCountRow(){
      return sheet.getLastRowNum()+1;
   }

   public String[][] getSheetData() throws Exception{
      File file = new File(excelFilePath);
      FileInputStream fileInputStream = new FileInputStream(file);

      book = new XSSFWorkbook(fileInputStream);
      sheet = book.getSheet("Sheet1");
      int numberOfColumn = xlsxCounColumn();
      int numberOfRows = xlsxCountRow();

      String[][] data = new String[numberOfRows-1][numberOfColumn];

      for(int i=1; i<numberOfRows; i++){
         for(int j=0; j<numberOfColumn; j++){
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(j);
            String value = cellToString(cell);
            data[i-1][j]=value;
            if(value == null){
               System.out.println("Cell empty");
            }
         }
      }

      return data;
   }

   //overLoading
   public String[][] getCustomSheetData() throws Exception{
      File file = new File(excelFilePath);
      FileInputStream fileInputStream = new FileInputStream(file);

      book = new XSSFWorkbook(fileInputStream);
      sheet = book.getSheet(sheetName);
      int numberOfColumn = xlsxCounColumn();
      int numberOfRows = xlsxCountRow();

      String[][] data = new String[numberOfRows-1][numberOfColumn];

      for(int i=1; i<numberOfRows; i++){
         for(int j=0; j<numberOfColumn; j++){
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell = row.getCell(j);
            String value = cellToString(cell);
            data[i-1][j]=value;
            if(value == null){
               System.out.println("Cell empty");
            }
         }
      }

      return data;
   }

}
