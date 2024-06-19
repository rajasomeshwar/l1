package BootWala.example.springwebfirst.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean IsValid(String name,String pass)
	{
		 return name.equalsIgnoreCase("au") && pass.equals("pass");
	}

}
