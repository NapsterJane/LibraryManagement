package com.library.management.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.library.management.entity.Users;

@Service
@Transactional
public interface UserService {

	Users saveNewUser(Users user);

}
