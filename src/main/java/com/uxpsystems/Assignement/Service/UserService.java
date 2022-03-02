package com.uxpsystems.Assignement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uxpsystems.Assignement.Dao.UserDAO;
import com.uxpsystems.Assignement.Entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private UserDAO dao;
	
	public User addUser(User user) {
		return dao.save(user);
		
	}
	
	public String deleteUser(long id) {
		User user= dao.getById(id);
		dao.delete(user);
		return "The user "+user.getUsername()+" is deleted Successfully!";
	}
	
	public String updateUser(User user) {
		Optional<User> userOld= dao.findById(user.getId());
		if(userOld.isPresent()) {
			User userFound=userOld.get();
			userFound.setUsername(user.getUsername());
			userFound.setPassword(user.getPassword());
			userFound.setStatus(user.getStatus());
			dao.save(userFound);
			return "The user "+user.getUsername()+" is updated successfully!";
		}
		else {
			return "This User does not exist";
		}
	}
	
	public List<User> getUser() {
		List<User> users = dao.findAll();
		System.out.println(users);
		return users;
	}
}
