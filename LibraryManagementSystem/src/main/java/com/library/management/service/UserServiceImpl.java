package com.library.management.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.entity.Users;
import com.library.management.repository.UsersRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UsersRepository userrepository;
	
	@Override
	public Users saveNewUser(Users user) {
		user = userrepository.save(user);
		return user;
	}

}
