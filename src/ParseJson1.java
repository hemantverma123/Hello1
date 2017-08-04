import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONArray;
 
public class ParseJson1 {
    public static void main(String[] args) throws MalformedURLException, IOException {
        String url = "https://60x5ngk368.execute-api.eu-west-1.amazonaws.com/dev/applicants/create/2";

        String myJson = IOUtils.toString(new URL(url));
        //System.out.println(myJson);
        
        JSONObject json = new JSONObject(myJson);
        // get the message
        System.out.println(json.get("message"));
        // get the array data
        JSONArray genreArray = (JSONArray) json.get("message");

        	//Method1 to parse the data
	        genreArray.forEach(item -> {
	            JSONObject studentObj = (JSONObject) item;
	            String     firstName     = studentObj.get("firstname").toString();
	            String     middleName = studentObj.get("middlename").toString();
	            String     lastName = studentObj.get("lastname").toString();
	            System.out.println(firstName);
	            System.out.println(middleName);
	            System.out.println(lastName);
	        });
	        
	        //Method2 to parse the data	        
	        JSONObject studentObj;
	        for (int i=0; i < genreArray.length(); i++) {
	        	studentObj = genreArray.getJSONObject(i);
	        	String     lastName = studentObj.get("lastname").toString();
	            System.out.println("\nFinally  "+ lastName);
	        	
	        }
	            
        }                              


}