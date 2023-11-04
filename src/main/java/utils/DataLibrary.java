package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class DataLibrary {

    public String[][] readExcel(String currentWorkBook) {

        String[][] data = null;

        XSSFWorkbook xlsx = null;
        String cellValue = null;
        try {
            xlsx = new XSSFWorkbook("/Users/praga/sde/simpleuiframe/data/" + currentWorkBook + ".xlsx");
            XSSFSheet currentSheet = xlsx.getSheet("empdata");

            System.out.println("total rows excluding header : " + currentSheet.getLastRowNum());
            System.out.println("total rows including header : " + currentSheet.getPhysicalNumberOfRows());
            data = new String[currentSheet.getLastRowNum()][currentSheet.getRow(0).getLastCellNum()]; //assuming we will have excel column values across all rows

            for (int i = 1; i <= currentSheet.getLastRowNum(); i++) {
              /*  XSSFRow currentRow = currentSheet.getRow(i);
                XSSFCell currentCell = currentRow.getCell(0);*/
                //String cellValue = currentSheet.getRow(i).getCell(0).getStringCellValue();
                for (int j = 0; j < currentSheet.getRow(i).getLastCellNum(); j++) {
                    cellValue = currentSheet.getRow(i).getCell(j).getStringCellValue();
                    data[i - 1][j] = cellValue;
                   // System.out.print(cellValue + "\t");
                }
               // System.out.print("\n");

            }
            xlsx.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(data);
        return data;
    }
}
/*
Question
1. finally?
 */