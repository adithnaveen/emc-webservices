package com.emc.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.emc.entity.Message;
import com.emc.service.MessageService;

@Path("/message")
public class MessageResource {
	//which will take 1 param and return the object of
	// message 
	
	static MessageService messageService = new MessageService();

	
	/*
	 * if you want to take multiple parameters
	 * public Message getMessage(
				@PathParam("messageId") long messageId,
				@PathParam("another") String anotherMessage
		){
	 */
	// @Produces("application/json")
		// or 
		
	
	// http://localhost:8080/app/resources/message/1/author
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Message getMessage(
				@PathParam("messageId") long messageId, @Context UriInfo uriInfo){
		// we get the details from the Db 
		
			Message message = messageService.getMessage(messageId);
			String uri = getUriForSelf(messageId, uriInfo);
			String authorUri = getUriForAuthor(messageId, uriInfo);
			
			message.addLink(uri, "self");
			message.addLink(authorUri, "author");
			
			return message;
	}


	private String getUriForAuthor(long messageId, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(messageId))
				.path(AuthorResource.class)
				.build().toString(); 
		return uri;
	}


	private String getUriForSelf(long messageId, UriInfo uriInfo) {
		String uri = uriInfo.getBaseUriBuilder()
				.path(MessageResource.class)
				.path(Long.toString(messageId))
				.build().toString();
		return uri;
	}
	
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}
	

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message postMessage(Message message){
		return messageService.insertMessage(message);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Message updateMessage(Message message){
		return messageService.updateeMessage(message);
	}
	
	
	@DELETE
	@Path("/{messageId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMessage(
				@PathParam("messageId") long messageId){
		return  messageService.deleteMessage(messageId);
	}
	
}




