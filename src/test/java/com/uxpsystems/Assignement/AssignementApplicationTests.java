package com.uxpsystems.Assignement;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import static org.junit.Assert.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uxpsystems.Assignement.Dao.UserDAO;
import com.uxpsystems.Assignement.Entity.User;
import com.uxpsystems.Assignement.Service.UserService;
import static org.junit.Assert.assertEquals;




@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignementApplicationTests {
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserDAO userDao;
	
	@Test
	public void getUserTest() {
		when(userDao.findAll()).thenReturn(Stream
				.of(new User(1,"Shivani","password","Activated"),new User(2,"Saurabh","password1","Activated")).collect(Collectors.toList()));
		assertEquals(2, service.getUser().size());
	}
	
	@Test
	public void addUserTest() {
		User user = new User(22, "abc", "password", "Activated");
		when(userDao.save(user)).thenReturn(user);
		assertEquals(user, service.addUser(user));
	}
	
}
