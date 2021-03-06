package dk.aau.imi.med4.guinmp2009.networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ReverseClient {
	public static void main(String[] args) throws IOException {
		String host = "localhost";
		Scanner sc = null;
		Socket socket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			socket = new Socket(host, 50000);
			out = new PrintWriter(socket.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			sc = new Scanner(System.in);
			String line = null;
			while (!(line = sc.nextLine()).equals("")) {
				out.println(line);
				System.out.println("reverse: " + in.readLine());
			}
		} catch (UnknownHostException e) {
			System.err.println("Unknown host: "+host);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
		out.close();
		in.close();
		socket.close();		
	}
}
