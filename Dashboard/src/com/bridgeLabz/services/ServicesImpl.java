package com.bridgeLabz.services;

import org.json.simple.JSONObject;

import com.bridgeLabz.model.Login;
import com.bridgeLabz.model.Registration;
import com.bridgeLabz.repository.UserDetailsRepository;

public class ServicesImpl implements IServices {
	JSONObject jsonObject = new JSONObject();
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean addUser(Registration registration) {
		jsonObject.put("firstname",registration.getFirstName());
		jsonObject.put("lastname",registration.getLastName());
		jsonObject.put("email",registration.getEmail());
		jsonObject.put("password",registration.getPasswd());
		jsonObject.put("gender",registration.getGender());
		jsonObject.put("dob",registration.getDateOfBirth());
		jsonObject.put("age",registration.getAge());
		jsonObject.put("city",registration.getCity());
		jsonObject.put("state",registration.getState());
		jsonObject.put("zip",registration.getZip());
		
		return UserDetailsRepository.addUser(jsonObject);	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean authentication(Login login) 
	{
		jsonObject.put("email", login.getEmail());
		jsonObject.put("password", login.getPassword());
		return UserDetailsRepository.authenticateUser(jsonObject);	
	}

	@Override
	public boolean deleteUserDetails(String name) {
		return UserDetailsRepository.deleteUser(name);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean updateUserDetails(Registration registration) {
		jsonObject.put("firstname", registration.getFirstName());
		jsonObject.put("lastname", registration.getLastName());
		jsonObject.put("email", registration.getEmail());
		
		return UserDetailsRepository.update(jsonObject);
	}

}
