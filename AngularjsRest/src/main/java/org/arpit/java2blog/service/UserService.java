package org.arpit.java2blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.arpit.java2blog.bean.User;
import org.arpit.java2blog.exception.CountryNotFoundException;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class UserService {

	static HashMap<Integer,User> userIdMap=getUserIdMap();


	public UserService() {
		super();

		if(userIdMap==null)
		{
			userIdMap=new HashMap<Integer,User>();
			// Creating some object of countries while initializing
			User user1=new User(1, "ali","ali@gmail.com","123");
			User user2=new User(2, "ahmed","ahmed@gmail.com","456");
			User user3=new User(3, "omar","omar@gmail.com","111");
			User user4=new User(4, "adel","adel@gmail.com","122");


			userIdMap.put(1,user1);
			userIdMap.put(2,user2);
			userIdMap.put(3,user3);
			userIdMap.put(4,user4);
		}
	}

	public List<User> getAllUsers()
	{
		List<User> users = new ArrayList<User>(userIdMap.values());
		return users;
	}

	public User getUser(int id)
	{
		User user= userIdMap.get(id);

		if(user == null)
		{
			throw new CountryNotFoundException("user with id "+id+" not found");
		}
		return user;
	}
	public User getUserByMail(String mail)
	{
		User user= userIdMap.get(mail);

		if(user == null)
		{
			throw new CountryNotFoundException("user with mail "+mail+" not found");
		}
		return user;
	}
	public User addUser(User user)
	{
		user.setId(getMaxId()+1);
		userIdMap.put(user.getId(), user);
		return user;
	}


	public static HashMap<Integer, User> getUserIdMap() {
		return userIdMap;
	}

	public static int getMaxId()
	{ 	 int max=0;
	for (int id:userIdMap.keySet()) {  
		if(max<=id)
			max=id;

	}  

	return max;


	}
}
