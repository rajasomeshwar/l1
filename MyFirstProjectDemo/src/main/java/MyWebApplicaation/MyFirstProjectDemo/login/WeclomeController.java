package MyWebApplicaation.MyFirstProjectDemo.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WeclomeController {
	
 	@RequestMapping(value="/",method=RequestMethod.GET)
 	public String Weclome(ModelMap model)
 	{
 		model.put("name", getLoggedinUsername());
 	//	System.out.println(getLoggedinUsername()+" x ");
 		return "welcome";
 	}
 	// to username who logined
 	private String getLoggedinUsername()
 	{
 		Authentication auth=
 				SecurityContextHolder.getContext().getAuthentication();
 		return auth.getName();
 		
 	}
}
