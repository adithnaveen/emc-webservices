package com.emc.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

public class AuthClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8877/ws/auth?wsdl");
		
		QName qname = new QName("http://ws.emc.com/", "HelloUserImplService");
		
		Service service = Service.create(url, qname);
		
		HelloUserAuth hello = service.getPort(HelloUserAuth.class);
		
		Map<String, Object> req_ctx = 
			((BindingProvider)hello).getRequestContext();
		
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, 
				"http://localhost:8877/ws/auth?wsdl");
		
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		
		headers.put("Username", Collections.singletonList("emc"));
		headers.put("Password", Collections.singletonList("India"));
		
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		
		System.out.println(hello.getMyWork());
		
		
	}
}
