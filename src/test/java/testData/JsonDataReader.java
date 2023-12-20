package testData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	public String FirstName , LastName , Email , Pass ;
	public void jsonDataReader () throws FileNotFoundException, IOException, ParseException {
	
	String jsonPath = System.getProperty("user.dir") + "//src/test//java//testData//UserData.json" ;
	File srcFile = new File(jsonPath);
	JSONParser parser = new JSONParser() ;
	JSONArray jArray  =  (JSONArray)parser.parse(new FileReader(srcFile));
	for (Object jsonObj : jArray) {
		JSONObject person = (JSONObject) jsonObj ;
		
		FirstName = (String) person.get("FirstName");
		System.out.println(FirstName);
		
		LastName = (String) person.get("LastName");
		System.out.println(LastName);
		
		Email = (String) person.get("Email");
		System.out.println(Email);
		
		Pass = (String) person.get("Pass");
		System.out.println(Pass);
	}
	}
}
