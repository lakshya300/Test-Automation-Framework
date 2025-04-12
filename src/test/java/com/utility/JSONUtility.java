package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;
import com.constants.Env;
import com.google.gson.Gson;


public class JSONUtility {
public static Environment readJSON(Env env) {
	
	Gson gson = new Gson();
	File josnFile = new File(System.getProperty("user.dir") + "//config//config.json");
	FileReader fileReader = null;
	try {
		fileReader = new FileReader(josnFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Config config= gson.fromJson(fileReader, Config.class);
	Environment environment = config.getEnvironments().get("QA");
	return environment;
	
}
}
