package com.emc.soapfault;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class CompanyInfo {
	@WebMethod
	@WebResult(name="outputCompanyInfo")
	public String getCompanyInfo( @WebParam(name="lookupInput") String property)
		throws InvalidCompanyException{
		if(property.equals("emc")){
			return "You are Allowed";
		}
		
		// we one of two things either turn "", null,
		// you can create a custome exception and throw 
		
		throw new InvalidCompanyException("Sorry Invalid Company Got");
	}
	
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:5656/nav", new CompanyInfo());
		System.out.println("Published.. ");
	}
}
