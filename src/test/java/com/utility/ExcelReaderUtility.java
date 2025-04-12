package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelReaderUtility {
public static Iterator<User> readExcelFile(String fileName) {
	
	File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
	XSSFWorkbook xssfWorkbook = null;
	Row row;
	Cell emailAddressCell;
	Cell passwordCell;
	User user;
	List<User> userlList = null;
	Iterator<Row> rowIterator;
	XSSFSheet xssfSheet;
	try {
		xssfWorkbook = new XSSFWorkbook(xlsxFile);
		userlList = new ArrayList<User>();
		
		xssfSheet = xssfWorkbook.getSheet("LoginTestData");
		rowIterator = xssfSheet.iterator();
		rowIterator.next();
		
		while (rowIterator.hasNext()) {
			row=rowIterator.next();
			emailAddressCell = row.getCell(0);
			passwordCell = row.getCell(1);
			user = new User(emailAddressCell.toString(), passwordCell.toString());
			userlList.add(user);
		}
		xssfWorkbook.close();
	} 
	catch (InvalidFormatException | IOException e) {
		e.printStackTrace();
	}
	return userlList.iterator();
}
}
