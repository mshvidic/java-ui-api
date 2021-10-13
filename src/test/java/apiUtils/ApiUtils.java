package apiUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ApiUtils {
	
	
	public static URLConnection sendRequest (String apiEndpoint) {
		
		// to avoid limitation of free api.countrylayer.com account
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	
		URL request = null;
		try {
			request = new URL(apiEndpoint);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        URLConnection conn = null;
		try {
			conn = request.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return conn;
	}
	
	
	public static BufferedReader bufferedResponse (URLConnection urlConnection) {
		
		BufferedReader bResponse = null;
		try {
			bResponse = new BufferedReader(
			        new InputStreamReader(
			        urlConnection.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bResponse;
	}

}
