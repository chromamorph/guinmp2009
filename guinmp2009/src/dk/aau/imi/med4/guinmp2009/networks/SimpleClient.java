package dk.aau.imi.med4.guinmp2009.networks;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleClient {
	public static void main(String[] args) {
		Socket con;
		try {
			int portNumber = Integer.parseInt(args[1]);
			String ipAddress = args[0];
			con = new Socket(ipAddress, portNumber);
			PrintWriter out = new PrintWriter(con.getOutputStream());
			out.print(args[2]);
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
