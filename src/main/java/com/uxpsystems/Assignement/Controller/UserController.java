package com.uxpsystems.Assignement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.uxpsystems.Assignement.Entity.User;
import com.uxpsystems.Assignement.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String Greeting() {
		return "You are Welcome!!";
	}
	
	@RequestMapping("/getAll")
	public List<User> getUser() {
		return userService.getUser();
		
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User user) {
		return userService.updateUser(user);	
	}
}

