package emc.client;

import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import emc.model.Picture;
import emc.service.PictureService;

public class DownloadPicture {
	public static void main(String[] args)  throws Exception{
		String wsdl = "http://localhost:3456/mtom?wsdl";
		String nameSpace="http://serivce.emc/";
		String serviceName= "PictureServiceImplService";
		
		URL url = new URL(wsdl);
		
		QName qName= new QName(nameSpace, serviceName);
		
		Service service = Service.create(url, qName);
		
		PictureService port = service.getPort(PictureService.class);
		
		Picture p = port.getPicture("dog");
		
		FileOutputStream fos = new FileOutputStream(p.getShortName()+".jpg");
		fos.write(p.getContent());
		fos.close();
		
		
		
		
		System.out.println("File Downloaded... ");
		
		
		
		
		
		
	}
}
