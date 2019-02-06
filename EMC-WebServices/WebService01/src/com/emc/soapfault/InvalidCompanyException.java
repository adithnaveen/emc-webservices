package com.emc.soapfault;

public class InvalidCompanyException extends Exception{
	String msg;
	public InvalidCompanyException(String msg){
		this.msg = msg;
	}
	
	public String companyMessage(){
		return msg;
	}
}
