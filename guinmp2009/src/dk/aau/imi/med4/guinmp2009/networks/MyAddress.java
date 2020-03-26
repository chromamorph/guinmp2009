package dk.aau.imi.med4.guinmp2009.networks;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyAddress {
	public static void main(String[] args) {
		try {
			InetAddress a = InetAddress.getLocalHost();
			System.out.println("Domain name: " + a.getHostName());
			System.out.println("IP address: " + a.getHostAddress());
		} catch (UnknownHostException e) {
			System.out.println("Help! I don't know who I am!");
		}
	}
}
