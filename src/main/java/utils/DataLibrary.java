package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class DataLibrary {

    public static void main(String[] args) {
        XSSFWorkbook xlsx = null;
        String cellValue = null;
        try {
            xlsx = new XSSFWorkbook("/Users/praga/sde/simpleuiframe/data/testdata.xlsx");
            XSSFSheet currentSheet = xlsx.getSheet("empdata");

            System.out.println("total rows excluding header : " + currentSheet.getLastRowNum());
            System.out.println("total rows including header : " + currentSheet.getPhysicalNumberOfRows());


            for (int i = 1; i <= currentSheet.getLastRowNum(); i++) {
              /*  XSSFRow currentRow = currentSheet.getRow(i);
                XSSFCell currentCell = currentRow.getCell(0);*/
                //String cellValue = currentSheet.getRow(i).getCell(0).getStringCellValue();
                for (int j = 0; j < currentSheet.getRow(i).getLastCellNum(); j++) {
                    cellValue = currentSheet.getRow(i).getCell(j).getStringCellValue();
                    System.out.print(cellValue+"\t");
                }
                System.out.print("\n");

            }
            xlsx.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
