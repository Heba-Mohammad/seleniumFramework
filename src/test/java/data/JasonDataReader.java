package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JasonDataReader {

	public	String firstname,lastname,email,password;
	public void JasonReader() throws FileNotFoundException, IOException, ParseException
	{
		String filePath= System.getProperty("user.dir")+"\\src\\test\\java\\data\\userData.json";
		File srcFile= new File(filePath);
		JSONParser parser= new JSONParser();
		JSONArray jarray= (JSONArray) parser.parse(new FileReader(srcFile));

		for(Object jsonObj:jarray)
		{
			JSONObject person= (JSONObject) jsonObj;
			firstname= (String) person.get("firstname");
			System.out.println(firstname);
			
			lastname= (String) person.get("lastname");
			System.out.println(lastname);
			
			email= (String) person.get("email");
			System.out.println(email);
			
			password= (String) person.get("password");
			System.out.println(password);
		
		}

	}
}
