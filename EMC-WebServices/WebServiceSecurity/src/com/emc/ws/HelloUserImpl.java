package com.emc.ws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService(endpointInterface="com.emc.ws.HelloUserAuth")
public class HelloUserImpl implements HelloUserAuth{

	@Resource
	WebServiceContext wsctx;
	
	@Override
	public String getMyWork() {
		MessageContext mctx  = wsctx.getMessageContext();
		
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		
		List userList  = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
		
		String userName = "";
		String password ="";
		
		if(userList!=null){
			// get username 
			userName = userList.get(0).toString();
		}
		
		if(passList != null){
			// get password
			password = passList.get(0).toString();
		}
		
		// here you can connect to db, for checking the valid 
		// username and password 
		
		if(userName.equals("emc") && password.equals("india")){
			return "Hello User " + userName +" You are Valid User";
		}else{
			return "Sorry Invalid Credentials!!!";	
		}
		
		
	}
	
}
