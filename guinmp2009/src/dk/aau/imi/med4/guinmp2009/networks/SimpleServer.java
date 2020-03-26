package dk.aau.imi.med4.guinmp2009.networks;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) {
		try {
			int portNumber = Integer.parseInt(args[0]);
			ServerSocket ss = new ServerSocket(portNumber);
			while (true) {
				System.out.println("Waiting for connection request on port " + portNumber + "...");
				Socket con = ss.accept();
				System.out.println("Connection request received");
				InputStreamReader in = new InputStreamReader(con.getInputStream());
				StringBuffer msg = new StringBuffer();
				int c;
				while ((c = in.read()) != 0)
					msg.append((char)c);
				PrintWriter out = new PrintWriter(con.getOutputStream());
				out.print("Simon says: " + msg);
				out.flush();
				con.close();
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}
