package dk.aau.imi.med4.guinmp2009.networks;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		Socket con;
		try {
			int portNumber = 5000;
			String ipAddress = "127.0.0.1";
			con = new Socket(ipAddress, portNumber);
			PrintWriter out = new PrintWriter(con.getOutputStream());
			out.print("Hello Server!");
			out.write(0);
			out.flush();
			InputStreamReader in = new InputStreamReader(con.getInputStream());
			int c;
			while ((c = in.read()) != -1)
				System.out.print((char)c);
			con.close();			
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
