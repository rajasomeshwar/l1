package BootWala.example.springwebfirst;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class firstWebApplication {
	@RequestMapping("say-Hello")
	@ResponseBody
	public String sayHello()
	{
		return "FIrst application Hi bro VOTE FOR BRS";
	}
	@RequestMapping("say-Hello-JSP")
	public String sayHelloJsp()
	{
		return "sayhello";
	}

}
