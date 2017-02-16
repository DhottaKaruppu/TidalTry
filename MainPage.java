import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("http://tpapvtescm01:8080/api/tes-6.2-prod/post");
		
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoInput(true);
		conn.setDoOutput(true);
		 
		conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		 
		String userNamePassword = "Takedapharm\bharavi:Takeda@135";
	
		conn.setRequestProperty("Authorization", userNamePassword);
		 
		String postCommand ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><entry xmlns=\"http://purl.org/atom/ns#\"><tes:Job.get xmlns:tes=\"http://www.tidalsoftware.com/client/tesservlet\"><id></id><selectColumns>id,ownerid,parentid,parentname,runtimeusername</selectColumns><queryCondition>job.agentname like '%TPA101%'</queryCondition></tes:Job.get></entry>";
		String payload = "data="+ java.net.URLEncoder.encode(postCommand, "ISO-8859-1");
		 
		conn.setRequestProperty("Content-Length", Integer.toString(payload.getBytes().length));
		conn.setFixedLengthStreamingMode(payload.getBytes().length);
		DataOutputStream out = new DataOutputStream(conn.getOutputStream());
		out.writeBytes(payload);
		out.flush();
		 
		BufferedReader reader = new BufferedReader(new InputStreamReader(
		conn.getInputStream()));
		String resp = "";
		String next = null;
		while ((next = reader.readLine()) != null)
		resp += next;
		System.out.println(resp);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

