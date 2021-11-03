package org.ctf.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.*;

public final class ExcelReaderUtil {

    private ExcelReaderUtil() {
        //Preventing from creating instances
    }

    private static XSSFSheet loadExcelFile(String filePath,String sheetName) {
        try(FileInputStream fileInputStream = new FileInputStream(filePath); ) {
            XSSFWorkbook xssfWorkBook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = xssfWorkBook.getSheet(sheetName);
            return sheet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object[][] getMultipleColumnData(String filePath, String sheetName) {
        XSSFSheet sheet = loadExcelFile(filePath,sheetName);
        int rowNumber = sheet.getLastRowNum();
        int columnNumber = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowNumber][columnNumber];
        for (int i=1 ; i <= rowNumber ; i++) {
            for (int j=0 ; j < columnNumber ; j++) {
                data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }

    public static String[] getSingleColumnData(String filePath, String sheetName) {
        XSSFSheet sheet = loadExcelFile(filePath,sheetName);
        int rowNumber = sheet.getLastRowNum();
        String[] data = new String[rowNumber];
        for (int i = 1 ; i <= rowNumber ; i++) {
            data[i-1] = sheet.getRow(i).getCell(0).getStringCellValue();
        }
        return data;
    }

    public static List<Map<String, String>> getExcelDataList(String filePath, String sheetName) {
        XSSFSheet sheet = loadExcelFile(filePath,sheetName);
        List<Map<String,String>> excelDataList = new ArrayList<>();
        int rowNumber = sheet.getLastRowNum();
        int columnNumber = sheet.getRow(0).getLastCellNum();
        for (int i=1 ; i <= rowNumber ; i++) {
            Map<String,String> excelColumnMap = new HashMap<>();
            for (int j = 0 ; j < columnNumber ; j++) {
                excelColumnMap.put(sheet.getRow(0).getCell(j).getStringCellValue() , sheet.getRow(i).getCell(j).getStringCellValue());
            }
            excelDataList.add(excelColumnMap);
        }
        return excelDataList;
    }
}
