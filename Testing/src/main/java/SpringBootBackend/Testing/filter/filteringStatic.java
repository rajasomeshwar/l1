package SpringBootBackend.Testing.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filteringStatic {
        @GetMapping("/filteringStatic")
	public SomeBean filterings()
	{
		return new SomeBean("value1","value2","value3");
	}
        @GetMapping("/filteringStatic-list")
    	public List<SomeBean> filteringsLIst()
    	{
    		return   Arrays.asList(new SomeBean("value1","value2","value3"),
    				 new SomeBean("value4","value5","value6"));
    	}
            
}
