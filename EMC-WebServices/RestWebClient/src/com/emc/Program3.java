package com.emc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

public class Program3 {
	public static void main(String[] args) {

		String uri = "http://localhost:8080/Rest-Work1/resources/message";

		Builder builder = ClientBuilder.newClient().target(uri).request();

		String data = getFileContent("/Volumes/Naveen/sample.json");

		Entity<String> entity = Entity.entity(data, "application/json");
		Response resp = builder.post(entity);
		System.out.println(resp.readEntity(String.class));
	}

	private static String getFileContent(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			int size = fis.available();

			byte[] bytes = new byte[size];
			fis.read(bytes);
			fis.close();

			return new String(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

}