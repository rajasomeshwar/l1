package MyWebApplicaation.MyFirstProjectDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class sayHelloControl {
	//  http://localhost/8081/sayhello
	@RequestMapping("/say-Hello")
     @ResponseBody
	public String SayHello()
	{
		return "Happy Birth Day Bro!";
		
	}
	

	@RequestMapping("/say-Hello-html")
    @ResponseBody
	public String SayHellohtml()
	{
		StringBuilder stn=new StringBuilder("<html>"
				+ " <head> <title>BirthDay Boy</title> </head> "
				+ "<body><h1>Happy BirthDay </h1></body></html>");
		return stn.toString();
	}
	@RequestMapping("/say-Hello-jsp")
	public String sayHelloJsp()
	{
		 return "sayHello";
	}
	
}
