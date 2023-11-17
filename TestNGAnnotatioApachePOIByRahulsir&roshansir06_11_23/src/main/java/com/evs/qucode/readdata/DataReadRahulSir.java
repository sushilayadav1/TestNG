package com.evs.qucode.readdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadRahulSir {

	public static void main(String[] args) {
		//exceldataprint();
		withoutApostrophe();
//				InputStream is = null;
//				Workbook wbook = null;
//				try {
//					is = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\poi data.xlsx");
//					wbook = new XSSFWorkbook(is);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				Sheet sheetobj = wbook.getSheet("Sheet1");
//				int rn = sheetobj.getLastRowNum(); // for using this method we can find data row index base (0 start)
//				System.out.println("row num==" + rn);
//				Row rowobj = sheetobj.getRow(2);// for using this method we can find row cell number in data format
//				short cellnum = rowobj.getLastCellNum();
//				rowobj.getCell(9,MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				System.out.println("cell number=" + cellnum);
//				Cell cellobj = rowobj.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK);
//				// String dataobj = cellobj.getStringCellValue();
//				Double cellvalue = cellobj.getNumericCellValue();
//				Integer it = cellvalue.intValue();
//				String str = it.toString();
//				System.out.println(str);
			}
	
	public static void exceldataprint() {
		InputStream is = null;
		Workbook wbook = null;
		try {
			is = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\poi data.xlsx");
			wbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetobj = wbook.getSheet("Sheet1");
		int rowCount = sheetobj.getLastRowNum(); // for using this method we can find data row index base (0 start)
		System.out.println("row num==" + rowCount);
		for (int i = 0; i <= rowCount; i++) {
			Row   rowobj=sheetobj.getRow(i);
			int  cellcount= rowobj.getLastCellNum();
			for (int j=0;j<=cellcount-1;j++) {
				Cell cellobj= rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);
				String cellvalue=cellobj.getStringCellValue();
				System.out.print(cellvalue+"  ,");

			}
			System.out.println();
		}
	}
	public static void withoutApostrophe() {
		InputStream is = null;
		Workbook wbook = null;
		try {
			is = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\poi data.xlsx");
			wbook = new XSSFWorkbook(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetobj = wbook.getSheet("Sheet1");
		int rowCount = sheetobj.getLastRowNum(); // for using this method we can find data row index base (0 start)
		System.out.println("row num==" + rowCount);
		for (int i = 0; i <= rowCount; i++) {
			Row   rowobj=sheetobj.getRow(i);
			int  cellcount= rowobj.getLastCellNum();
			for (int j=0;j<=cellcount-1;j++) {
				Cell cellobj= rowobj.getCell(j, MissingCellPolicy.CREATE_NULL_AS_BLANK);

                
//				case STRING: {
//					String celldata=cellobj.getStringCellValue();
//					System.out.print(celldata+" , ");
//					break; 
//				}
//				case NUMERIC:{
//					Double  doubleCellData=cellobj.getNumericCellValue();
//					Integer intData=doubleCellData.intValue();
//					System.out.print(intData.toString()+" , ");
//					break;
//				}
//				default:
//					throw new IllegalArgumentException("Unexpected value: " + cellobj.getCellType());
//				}

                        String    cellData=null;
				    	if(cellobj.getCellType()==CellType.STRING) {
				    	 cellData=cellobj.getStringCellValue();
				    	 System.out.print(cellData);
				    	}else {
				    	Double CellData=	cellobj.getNumericCellValue();
				    Integer intdata=CellData.intValue();
				      cellData= intdata.toString();  
				      System.out.print(cellData);
				    	}


			}
			System.out.println();
		}

	}
}
