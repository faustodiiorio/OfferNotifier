package it.offerNotifier.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

public class Utils {
	public JSONObject getJOFromUrl(String str){
		URLConnection urlConn = null;
	    BufferedReader bufferedReader = null;
	    JSONObject wsResult = null;
	    try
	    {
	        URL url = new URL(str);
	        urlConn = url.openConnection();
	        bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
	
	        StringBuffer stringBuffer = new StringBuffer();
	        String line;
	        while ((line = bufferedReader.readLine()) != null)
	        {
	            stringBuffer.append(line);
	        }
	
	       wsResult = new JSONObject(stringBuffer.toString());
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
	    finally
	    {
	        if(bufferedReader != null)
	        {
	            try {
	                bufferedReader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    return wsResult;
	}
}