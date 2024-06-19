package BootWala.example.springwebfirst.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import BootWala.example.springwebfirst.login.service.AuthenticationService;

@Controller
public class loginpage {

	private AuthenticationService auth;
	
	public loginpage(AuthenticationService auth) {
		super();
		this.auth = auth;
	}
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String loginPage()
	{
		return "login";
	}
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String welcome(@RequestParam String name,@RequestParam String pass,ModelMap model)
	{
		if(auth.IsValid(name, pass))
		{
			model.put("name", name);
			model.put("pass", pass);
			return "weclome";
		}
		model.put("ErrorPage", "Invalid userName and password");
		return "login";			
	}
//	@RequestMapping("login")
//	public String loginpageq(@RequestParam String name,ModelMap model )
//	{
//		model.put("name", name);
//		System.out.println(name);
//		return "login";
//	}
}
