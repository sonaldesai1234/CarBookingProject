package com.mycipl.domain;
import com.mycipl.service.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mycipl.repository.AuthorityRepository;
import com.mycipl.repository.UserProfileRepository;
import com.mycipl.repository.UserRepository;
import com.mycipl.service.UserProfileService;
import com.mycipl.service.UserService;
import com.mycipl.service.impl.UserProfileServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.reflect.TypeToken;
import com.mycipl.domain.User;
import com.mycipl.domain.UserProfile;

import com.mycipl.web.rest.errors.BadRequestAlertException;

// for user
public class JsonRead {
	
	private final Logger log = LoggerFactory.getLogger(UserService.class);

	public static void main(String[] args) {
		
		List<String> userList=new ArrayList<String>();
		 JSONParser jsonParser = new JSONParser();
		   JSONArray jsonArray = null;
	        try (FileReader reader = new FileReader("D:\\Documents\\Prod Database Drive\\PROD Data\\Book.json"))
	        {
	            
	        	
	        	
	        //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONObject jSONObject = (JSONObject) obj;
	            
	            jsonArray=(JSONArray)jSONObject.get("results");
	         
	            for (Object object : jsonArray)
	            {
	            	String s1 = null;
	        	 JSONObject jsonObject2=(JSONObject)object;
	        	 
	        	 String jsonDoc=""+jsonObject2.get("jsonDoc");
	        	 
	        	 ObjectMapper mapper = new ObjectMapper();
	        	 Map<String,Object> map = mapper.readValue(jsonDoc, Map.class);
	        	 
	        	 //String dseLoginId=""+map.get("dseLoginID");
	        	 String actualEndTime=""+map.get("actualEndTime");
	        	 if(actualEndTime.length()==0)
	        	 {
	        		
		        	 
	        	 }
	        	// System.out.println(s);
	        	
	        	 
	        
	        	// System.out.println(dseLoginId);
	        	 userList.add(actualEndTime);
	        	// userList.add(actualEndTime);
	        	 
		        	
	            }
	            System.out.println(userList);
	         
	          } catch (Exception e) {
	            e.printStackTrace();
	        }	
	        
	      /*  String str;
	        str = jsonArray.toString().replaceAll("\\\\", "");
            str=str.trim();
          
		str=str.replace("\"{", "{");
		str=str.replace("}\"", "}");
		str=str.replace("\"2017-","ISODate(\"2017-");
		str=str.replace("Z\"", "Z\")");
		
		str=str.replace("\"2018-","ISODate(\"2018-");
		
		
		str=str.replace("\"2019-","ISODate(\"2019-");
		
		
		str=str.trim();
			System.out.println(str);
			
	        try {
				//String jsonString = FileUtils.readFileToString(new File("data/newclicklogs.json"), "UTF-8");

				
			

				FileWriter file = new FileWriter("D:\\Documents\\Prod Database Drive\\convert\\test.json") ;
				//File Writer creates a file in write mode at the given location 
				file.write(str);

				//write function is use to write in file,
				//here we write the Json object in the file
				file.flush();
				}
				catch (Exception e) 
				{
					System.out.println(e);
				}
		
		
		*/
		
		
		
		/*
		
		 
		JSONParser parser = new JSONParser();
		UserProfile userProfile=new UserProfile();
    	String dsePassword="Cipl@123";
    	User us=new User();
    	List<User>u=new ArrayList<User>();
    	
    	
    	
		try {
			
			Object obj = parser.parse(new FileReader("D:\\Documents\\Prod Database Drive\\PROD Data\\(UserDetails)MYCIPLQUIQBOOKUAT-SERVICE-JSONDocuments.json"));
			JSONObject jsonObject = (JSONObject) obj;
		    JSONArray jSONArrayFinal = new JSONArray();
            JSONArray jSONArray = (JSONArray) jsonObject.get("results");
            String str=null;
            for (int i = 0; i <jSONArray.size(); i++) 
            {
            
            	
            	JSONObject jSONObjecttemp =new JSONObject();
            	jSONObjecttemp=(JSONObject) jSONArray.get(i);
            	
            	jSONArrayFinal.add(jSONObjecttemp.get("jsonDoc"));
            	//System.out.println(jSONObjecttemp);
            	us.setDseLoginId((String) jSONObjecttemp.get("dseLoginId"));
            	us.setPassword(dsePassword);
            	
            	
            	u.add(us);
            	
            	
            	}
            	
            System.out.println(u);
            	
  
        str = jSONArrayFinal.toString().replaceAll("\\\\", "");
            
        str=str.trim();
          
		str=str.replace("\"{", "{");
		str=str.replace("}\"", "}");
		str=str.replace("\"2017-","ISODate(\"2017-");
		str=str.replace("Z\"", "Z\")");
		
		str=str.replace("\"2018-","ISODate(\"2018-");
		
		
		str=str.replace("\"2019-","ISODate(\"2019-");
		
		str=str.replace("emailId","email");
    	str=str.replace("contactNumber","dseMobileNumber");       
		
		str=str.trim();
		
		
		//	System.out.println(u);
			try {
				FileWriter file = new FileWriter("D:\\Documents\\Prod Database Drive\\convert\\user.json") ;
				//File Writer creates a file in write mode at the given location 
				file.write(str);

				//write function is use to write in file,
				//here we write the Json object in the file
				file.flush();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	*/}

}