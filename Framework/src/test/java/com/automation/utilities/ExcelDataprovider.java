package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {
	
	XSSFWorkbook wb;
	
	public ExcelDataprovider()
	{
		File file=new File("./Testdata/data.xlsx");
		
		try {
			FileInputStream fin=new FileInputStream(file);
					
			wb=new XSSFWorkbook(fin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public String getStringValue(String sheetName, int row, int col)
	{
		 return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringValue(int sheetIndex, int row, int col)
	{
		 return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

}
