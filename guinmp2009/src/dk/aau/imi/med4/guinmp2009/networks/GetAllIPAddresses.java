package dk.aau.imi.med4.guinmp2009.networks;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class GetAllIPAddresses {
	public static void main(String[] args) throws SocketException {
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
		    NetworkInterface n = e.nextElement();
		    Enumeration<InetAddress> ee = n.getInetAddresses();
		    while (ee.hasMoreElements())
		    {
		        InetAddress i = ee.nextElement();
		        System.out.println(i.getHostAddress());
		    }
		}
	}
}

