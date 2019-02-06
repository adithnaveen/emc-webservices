package emc.service;

import javax.xml.ws.Endpoint;

public class PicturePublisher {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:3456/mtom", 
				new PictureServiceImpl());
	
		System.out.println("published @ http://localhost:3456/mtom");
	}
	
}
