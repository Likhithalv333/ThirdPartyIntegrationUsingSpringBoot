package com.task.biotech.service;

import com.task.biotech.entity.Login;

public interface LoginService {
	

	String registration(Login login);
	boolean authenticateUser (String userId, String password);

}
