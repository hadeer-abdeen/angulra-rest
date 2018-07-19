package org.arpit.java2blog.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.arpit.java2blog.bean.User;
import org.arpit.java2blog.service.UserService;

@Path("/users")
public class UserController {

UserService userService=new UserService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<User> getCountries()
	{
		
		List<User> listOfUsers=userService.getAllUsers();
		return listOfUsers;
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") int id)
	{
		return userService.getUser(id);
	}
    
//    @GET
//    @Path("/{mail}")
//    @Produces(MediaType.APPLICATION_JSON)
//	public User getUserByMail(@PathParam("mail") String mail)
//	{
//		return userService.getUserByMail(mail);
//	}
   
   
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public User addUser(User user)
	{
		return userService.addUser(user);
	}

}
