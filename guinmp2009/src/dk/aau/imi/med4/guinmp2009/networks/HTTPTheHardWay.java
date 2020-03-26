package dk.aau.imi.med4.guinmp2009.networks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URLEncoder;

public class HTTPTheHardWay {
	public static void main(String[] args) {
		try {
			Socket con = new Socket("www.google.com", 80);
			String req = "/search?q=" + URLEncoder.encode(args[0], "UTF8");
			BufferedWriter out = new BufferedWriter (new OutputStreamWriter(con.getOutputStream(), "UTF8"));
			out.write("GET " + req + " HTTP/1.1\r\n");
			out.write("Host: www.google.com\r\n");
			out.write("User-agent: IXWT\r\n\r\n");
			out.flush();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line + "\n");
			}
			in.close();
			out.close();
			con.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
