package com.emc.timeserver;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface TimeServer {
	
	@WebMethod
	public String getTimeAsString();
	
	@WebMethod
	public String getTimeFromServer();
	
	@WebMethod
	public String getTicketFare(String src, String dest);
}
