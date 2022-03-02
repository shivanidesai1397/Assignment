package com.uxpsystems.Assignement.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uxpsystems.Assignement.Entity.User;

public interface UserDAO extends JpaRepository<User,Long> {
	
}
