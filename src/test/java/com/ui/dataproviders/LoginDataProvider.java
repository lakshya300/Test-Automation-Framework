package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		//Reading the Json file with help of Gson
		//Creating a gson object
		Gson gson = new Gson();
		//Attaching the path of the file
		File testDataFile = new File(System.getProperty("user.dir")+"\\testData\\loginData.json");
		
		//Creating a file reader
		FileReader fileReader = new FileReader(testDataFile);
		//Mapping the filereader to a java class
		TestData data = gson.fromJson(fileReader, TestData.class);
		
		//Retriving the data form the test data and adding it into a list
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for( User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		
		//returning the data list iterator
		return dataToReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.reasCSVFile("loginData.csv");
	}
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx");
	}
}
