package SpringBoot.DeveloperSpringBoot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ReteriveData {
	@RequestMapping("/Courses")
	 public List<Course> reterive()
	 {
		 return (List<Course>) Arrays.asList(new Course(1,"Learn AWS","BY ME"),new Course(3,"Learn Develoops","BY Eramark"));
	 }

}
