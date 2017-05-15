package it.offerNotifier.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;

public class Utils {
//	personal data: don't show
	public final static String MY_APP_ID = "FaustoDi-OfferNot-PRD-908fa563f-53b506fd";
//	versions: MUST UPDATE OFTEN
	public final static String SERVICE_VERSION = "967";
	public final static String FIND_VERSION = "9.8.9";
//	data format
	public final static String RESPONSE_DATA_FORMAT = "JSON";
//	language
	public final static String GLOBAL_ID= "EBAY-IT";
	public final static String SITE_ID = "101";
//	urls
	public final static String URL_SEARCH = "http://svcs.ebay.com/services/search/";
	public final static String URL_CATEGORY = "http://open.api.ebay.com/Shopping/";
//	specific
	public final static String GET_CATEGORY_INFO = "GetCategoryInfo";
	public final static String FINDING_SERVICE = "FindingService/v1";
	public final static String FIND_ITEMS_BY_KEYWORDS = "findItemsByKeywords";
	public final static String FIND_ITEMS_BY_CATEGORY = "findItemsByCategory";
	public final static String FIND_ITEMS_ADVANCED = "findItemsAdvanced";
	public final static String CALLBACK = "cb_findItemsByKeywords";
	
	public static JSONObject getJOFromUrl(String str){
		URLConnection urlConn = null;
	    BufferedReader bufferedReader = null;
	    JSONObject wsResult = null;
	    try
	    {
	        URL url = new URL(str);
	        urlConn = url.openConnection();
	        bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), Charset.forName("UTF-8")));
	
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
	
	public static
	<T extends Comparable<? super T>> List<T> asSortedList(Collection<T> c) {
	  List<T> list = new ArrayList<T>(c);
	  Collections.sort(list);
	  return list;
	}
}