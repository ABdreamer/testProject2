package org.desky.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.desky.messenger.model.Message;
import org.desky.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	//private static final long Id = 0;
	MessageService messageService=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		
		return messageService.getAllMessages();
	}
	
//	@POST
//	@Produces(MediaType.TEXT_PLAIN)
//	public String addmessage() {
//		return "post method working";
//	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMassage(message);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	 //"My message Id is ::"+messageId;	
	}
}
