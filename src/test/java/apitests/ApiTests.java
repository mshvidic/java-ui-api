package apitests;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import apiUtils.ApiUtils;

public class ApiTests {
	static final String KEYWORD1 = "Austr";
	static final String KEYWORD2 = "United";
	static final String KEYWORD3 = "Ser";
	static final String PASSED_MESSAGE = "Liste su iste";
	static final String FAILED_MESSAGE = "Liste nisu iste";


	
	@ParameterizedTest
	@ValueSource(strings = {KEYWORD1,KEYWORD2,KEYWORD3})
    public void apiTests(String keyword) throws Exception {
    
		
		URLConnection cnn = ApiUtils.sendRequest("http://api.countrylayer.com/v2/all?access_key=0fd4721112920029040912be0cc2da45");

		BufferedReader bufferedResponse = ApiUtils.bufferedResponse(cnn);
        
        String responseLine;
        

    	List<String> countriesAllEndpoint = new ArrayList<String>();

        while ((responseLine = bufferedResponse.readLine()) != null) { 
           
        	JsonParser jsonParser = new JsonParser();
        	JsonArray jo = (JsonArray)jsonParser.parse(responseLine);
        	
        	
        	for (JsonElement a : jo) {
        	
        	boolean isFound = a.getAsJsonObject().get("name").getAsString().matches("(.*)"+keyword+"(.*)");
        		
        	if(isFound) countriesAllEndpoint.add(a.getAsJsonObject().get("name").getAsString());
        	
			}
        	
            }
        
        System.out.println(countriesAllEndpoint.toString());

        bufferedResponse.close();
        
       
        
        URLConnection cnn1 = ApiUtils.sendRequest("http://api.countrylayer.com/v2/name/"+ keyword +"?access_key=0fd4721112920029040912be0cc2da45");
        
        BufferedReader bufferedResponse1 = ApiUtils.bufferedResponse(cnn1);
        		
        		
        String responseLine1;
        

    	List<String> countriesNameEndpoint = new ArrayList<String>();

        while ((responseLine1 = bufferedResponse1.readLine()) != null) { 
           
        	JsonParser jsonParser = new JsonParser();
        	JsonArray jo = (JsonArray)jsonParser.parse(responseLine1);
        	
        	
        	for (JsonElement a : jo) {
        	
        		
        	countriesNameEndpoint.add(a.getAsJsonObject().get("name").getAsString());
        	    
        	
			}
        	
            }
        
        System.out.println(countriesNameEndpoint.toString());
        
        bufferedResponse1.close();
        
        
        Collections.sort(countriesAllEndpoint);
        
        Collections.sort(countriesNameEndpoint);
                
        assertTrue(countriesAllEndpoint.equals(countriesNameEndpoint),FAILED_MESSAGE);       
        System.out.println(PASSED_MESSAGE);
         
        
    }

}
