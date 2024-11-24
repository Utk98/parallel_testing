package com.digite.actions.commands;

import com.annotation.PageFragment;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@PageFragment
public class ExcelFunctions {

 /*
      Author:Jishnu Nambiar
      Description:Compare the data between the excel
      Input:String filePathExpected-File path of the expected excel
            String filePathActual-File path of the actual excel
      output:void
      */
 public  void verifyDataInExcelBookAllSheets(String filePathExpected, String filePathActual ) throws IOException {
     log.info("Verifying if both work books have same data.............");
     verifyIfExcelFilesHaveSameNumberAndNameOfSheets(filePathExpected,filePathActual);
     verifySheetsInExcelFilesHaveSameRowsAndColumns(filePathExpected,filePathActual);
     Workbook workbook1 = WorkbookFactory.create(new File(filePathExpected));
     Workbook workbook2 = WorkbookFactory.create(new File(filePathActual));
     int sheetCounts = workbook1.getNumberOfSheets();
     DataFormatter df=new DataFormatter();
     for (int i = 0; i < sheetCounts; i++) {
         Sheet s1 = workbook1.getSheetAt(i);
         Sheet s2 = workbook2.getSheetAt(i);
         int rowCounts = s1.getPhysicalNumberOfRows();
         for (int j = 0; j < rowCounts; j++) {
             Row row = s1.getRow(j);
             Row row1=s2.getRow(j);
             //if whole row in between is blank then to skip it and check the other column
             if (row == null && row1 ==null) {
                 rowCounts = rowCounts + 1;
                 break;
             }
             else {
                 if (row == null) {
                     Assert.isTrue(false,"WorkBook 1 is having empty row at "+(j+1)+"WorkBook 2 has some Data at same row position");
                 }
                 if(row1 ==null){
                     Assert.isTrue(false,"WorkBook 2 is having empty row at "+(j+1)+"WorkBook 1 has some Data at same row position");
                 }
             }
             int cellCounts= s1.getRow(j).getPhysicalNumberOfCells();
             for (int k = 0; k < cellCounts; k++) {
                 String expectedValue=df.formatCellValue(s1.getRow(j).getCell(k));
                 String actualValue=df.formatCellValue(s2.getRow(j).getCell(k));
                 if(!expectedValue.equals(actualValue)){
                     if(actualValue==""){
                         actualValue="Empty cell";
                     }
                     if(expectedValue==""){
                         expectedValue="Empty Cell";
                     }
                     Assert.isTrue(expectedValue.equals(actualValue),"Expected Value in Row "+(j+1)+" Column "+(k+1)+" is "+expectedValue+" the same cell of actual file had "+actualValue);
                 }
             }
         }

     }
     workbook1.close();
     workbook2.close();
 }
//    public static void verifyDataInExcelBookAllSheets(String filePathExpected, String filePathActual ) throws IOException {
//        log.info("Verifying if both work books have same data.............");
//        Workbook workbook1 = WorkbookFactory.create(new File(filePathExpected));
//        Workbook workbook2 = WorkbookFactory.create(new File(filePathActual));
//        int sheetCounts = workbook1.getNumberOfSheets();
//        // So we will iterate through sheet by sheet
//        for (int i = 0; i < sheetCounts; i++) {
//            // Get sheet at same index of both work books
//            Sheet s1 = workbook1.getSheetAt(i);
//            Sheet s2 = workbook2.getSheetAt(i);
//            log.info("*********** Sheet Name : " + s1.getSheetName() + "*************");
//            // Iterating through each row
//            int rowCounts = s1.getPhysicalNumberOfRows();
//            log.info("**********Row Count in sheet**" + rowCounts);
//            log.info("**********Row Count in sheet2**" + s2.getPhysicalNumberOfRows());
//            for (int j = 0; j < rowCounts; j++) {
//                Row row = s1.getRow(j);
//                //if whole row in between is blank then to skip it and check the other column
//                if (row == null) {
//                    rowCounts=rowCounts+1;
//                    break;
//                }
//                // Iterating through each cell
//                int cellCounts= s1.getRow(j).getPhysicalNumberOfCells();
////                    int cellCounts=cellCount.intValue();
//                for (int k = 0; k < cellCounts; k++) {
//                    // Getting individual cell
//                    Cell c1 = s1.getRow(j).getCell(k);
//                    Cell c2 = s2.getRow(j).getCell(k);
//                     log.info("**********Row Count in sheet**" + s1.getRow(j).getPhysicalNumberOfCells());
//                     log.info("**********Row Count in sheet2**" + s2.getRow(j).getCell(k));
//                    // Since cell have types and need o use different methods
//                    try{
//                        if (c1 != null && c1.getCellType().equals(c2.getCellType())) {
//                            System.out.print("Row Number=" + (j + 1) + " Cell Number" + (k + 1) + "--->");
//                            switch (c1.getCellType()) {
//                                case BOOLEAN:
//                                    boolean v1 = c1.getBooleanCellValue();
//                                    boolean v2 = c2.getBooleanCellValue();
//                                    Assert.isTrue(v1==v2,"Cell are not equal Workbook1:"+v1+" Workbook2:"+v2);
//                                     log.info("Its matched : " + v1 + " === " + v2);
//                                    break;
//                                case NUMERIC: // If cell type is numeric, we need to check if data is of Date type
//                                    if (DateUtil.isCellDateFormatted(c1) | DateUtil.isCellDateFormatted(c2)) {
//                                        // Need to use DataFormatter to get data in given style otherwise it will come as time stamp
//                                        DataFormatter df = new DataFormatter();
//                                        String v11 = df.formatCellValue(c1);
//                                        String v21 = df.formatCellValue(c2);
//                                        Assert.isTrue(v11.equals(v21),"Cell are not equal Woorkbook1:"+v11+" Workbook2:"+v21);
//                                         log.info("Its matched : " + v11 + " === " + v21);
//                                    } else {
//                                        long v11 = (long) c1.getNumericCellValue();
//                                        long v21 = (long) c2.getNumericCellValue();
//                                        Assert.isTrue(v11==v21,"Cell are not equal Woorkbook1:"+v11+" Workbook2:"+v21);
//                                         log.info("Its matched : " + v11 + " === " + v21);
//                                    }
//                                    break;
//                                case STRING:
//                                    String v = c1.getStringCellValue();
//                                    String vq = c2.getStringCellValue();
//                                    Assert.isTrue(v.equals(vq),"Cell are not equal Woorkbook1:"+v+" Workbook2:"+vq);
//                                     log.info("Its matched : " + v + " === " + vq);
//                                    break;
//                            }
//                        } else {
//                            if (c1 == null) {
//                                 log.info("Null");
//                            }
//                            // If cell types are not same, exit comparison
//                            else {
//                                Assert.isTrue(false,"Non matching cell type.");
//                            }
//                        }
//                    } catch(Exception e)
//                      {
//
//                      }
//
//                }
//            }
//        }
//        workbook1.close();
//        workbook2.close();
//         log.info("Hurray! Both work books have same data.");
//    }


    /*
      Author:Jishnu Nambiar
      Description:Verify the count of the row and columns in the excel
      Input:String filePathExpected-File path of the expected excel
            String filePathActual-File path of the actual excel
      output:void
      */
    public static void verifySheetsInExcelFilesHaveSameRowsAndColumns(String filePathExpected, String filePathActual ) throws IOException {
        Workbook workbook1 = WorkbookFactory.create(new File(filePathExpected));
        Workbook workbook2 = WorkbookFactory.create(new File(filePathActual));
        int sheetCounts = workbook1.getNumberOfSheets();
        for (int i = 0; i < sheetCounts; i++) {
            Sheet s1 = workbook1.getSheetAt(i);
            Sheet s2 = workbook2.getSheetAt(i);
            int rowsInSheet1 = s1.getPhysicalNumberOfRows();
            int rowsInSheet2 = s2.getPhysicalNumberOfRows();
            Assert.isTrue(rowsInSheet1==rowsInSheet2,"Row count are not same");
            int i1=0;
            while ((i1 < rowsInSheet1)) {//Since Workbook1 is the expected file we are iterating with row1
                Row row = s1.getRow(i1);
                if (row == null) {//if any row is null then we can skip and go to the next row
                    break;
                }
                i1++;
                int cellCounts1 = row.getPhysicalNumberOfCells();
                int cellCounts2 = row.getPhysicalNumberOfCells();
                Assert.isTrue(cellCounts1==cellCounts2,"Column count are not same");
            }
        }
        workbook1.close();
        workbook2.close();
    }
    /*
      Author:Jishnu Nambiar
      Description:Verify the Sheet in the excel
      Input:String filePathExpected-File path of the expected excel
            String filePathActual-File path of the actual excel
      output:void
      */
    public static void verifyIfExcelFilesHaveSameNumberAndNameOfSheets(String filePathExpected, String filePathActual) throws IOException {
         log.info("Verifying if both work books have same number of sheets.............");
        Workbook workbook1 = WorkbookFactory.create(new File(filePathExpected));
        Workbook workbook2 = WorkbookFactory.create(new File(filePathActual));
        // Get total sheets count from first excel file
        int sheetsInWorkbook1 = workbook1.getNumberOfSheets();
        // Get total sheets count from second excel file
        int sheetsInWorkbook2 = workbook2.getNumberOfSheets();
        // Compare if both excel files have same number of sheets
        Assert.isTrue(sheetsInWorkbook1==sheetsInWorkbook2,"");
        // Printing number of sheets in each work book
         log.info("Sheets in first work book : " + sheetsInWorkbook1);
         log.info("Sheets in second work book : " + sheetsInWorkbook2);
         log.info("Both work books have same number of sheets.........................");

        // Verify if sheets have same name in both workbooks
        // Sheets may not be in same order in both excel. So I am relaxing order of sheets condition.
         log.info("Verifying if both work books have same name of sheets.............");
        List<String> sheetsNameOfWb1 = new ArrayList<>();
        List<String> sheetsNameOfWb2 = new ArrayList<>();
        // Since we have already verified that both work books have same number of sheets so iteration can be done against any workbook sheet count
        for (int i = 0; i < sheetsInWorkbook1; i++) {
            // Retrieving sheet names from both work books and adding to different lists
            sheetsNameOfWb1.add(workbook1.getSheetName(i));
            sheetsNameOfWb2.add(workbook2.getSheetName(i));
        }
        Collections.sort(sheetsNameOfWb1);
        Collections.sort(sheetsNameOfWb2);
        Assert.isTrue(sheetsNameOfWb1==sheetsNameOfWb2,"Sheet name is Different");
         log.info("Sheet Names in first work book : " + sheetsNameOfWb1);
         log.info("Sheet Names in second work book : " + sheetsNameOfWb2);
         log.info("Both work books have same name of sheets.........................");
        workbook1.close();
        workbook2.close();
    }
    /*
      Author:Jishnu Nambiar
      Description:Write data in the excel
      Input:String path-File path
            String sheetName-Sheet Name of the excel
            int rowNumber-Row in which data needs to be entered
            int columnNumber-Column in which data needs to be entered
            String value-Value to entered in cell
      output:void
      */
    public static void writeExcel(String path,String sheetName,int rowNumber,int ColumnNumber,String value) throws IOException {
        File src=new File(path);
        FileInputStream fis=new FileInputStream(src);
        Workbook wb1 = WorkbookFactory.create(fis);
        Sheet xs=wb1.getSheet(sheetName);
        Row row = xs.getRow(rowNumber);
        if (row == null) {
            row = xs.createRow(rowNumber); // create a new row object if it is empty
        }
        xs.getRow(rowNumber).createCell(ColumnNumber).setCellValue(value);
        FileOutputStream fout=new FileOutputStream(src);
        wb1.write(fout);
        wb1.close();

    }
    /*
      Author:Jishnu Nambiar
      Description:delete excel
      Input:String path-File path
      output:void
      */
    public static void deleteExcel(String path){
        File file
                = new File(path);

        if (file.delete()) {
            log.info("File deleted successfully");
        }
        else {
            log.info("Failed to delete the file");
        }

    }



}
