import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.HttpClient;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Content con = null; 
			String s = null;
			
			con = Request.Get("http://manage.dimagi.com/api.xml").execute().returnContent();
			s = con.asString();
			System.out.print(s);
			
			String email = "";
			String password = "";
			
		    con = Request.Get("http://manage.dimagi.com/api.asp?cmd=logon&email=" + email + "&password=" + password).execute().returnContent();
			s = con.asString();
			System.out.print(s);
		    
			
			String token = "??";
			String url_base = "http://manage.dimagi.com/api.asp?token=" + token;
			con = Request.Get(url_base + "&cmd=setCurrentFilter&sFilter=114")
			.execute().returnContent();
			s = con.asString();
			
			
			con = Request.Get(url_base + "&cmd=search&cols=plugin,sTitle,sArea,tags,sPersonAssignedTo,sVersion")
			.execute().returnContent();
			s = con.asString();
			System.out.print(s);
			
			
		} catch (ClientProtocolException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
