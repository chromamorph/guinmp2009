package dk.aau.imi.med4.guinmp2009.networks;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ss = null;
		try {
			int portNumber = 5000;
			ss = new ServerSocket(portNumber);
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
			if (ss != null && ss.isBound() && !ss.isClosed())
				ss.close();
			System.err.println(e);
		}
	}
}
