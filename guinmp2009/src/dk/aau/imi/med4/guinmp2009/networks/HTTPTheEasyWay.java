package dk.aau.imi.med4.guinmp2009.networks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HTTPTheEasyWay {
	public static void main(String[] args) {
		try {
			String req = "http://www.google.com/search?q=";
			req += URLEncoder.encode(args[0], "UTF8");
			HttpURLConnection con = (HttpURLConnection)(new URL(req)).openConnection();
			con.setRequestProperty("User-Agent", "IXWT");
			con.setInstanceFollowRedirects(false);
			System.out.println(con.getHeaderField("Content-Type"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
