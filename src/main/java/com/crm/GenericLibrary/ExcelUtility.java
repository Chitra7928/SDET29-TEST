package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheet, int rownum,int cellnum) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row row=sh.getRow(rownum);
		Cell cel= row.getCell(cellnum);
		String value=cel.getStringCellValue();
		return value;
	}
	
	public int getRowCount(String sheet) throws IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int rowCount=sh.getLastRowNum();
		return rowCount;
	}
	public void writeDataToExcel(String sheet,int rowNum,int cellNum,String data) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		cel.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);
		wb.close();
}

	}
