package SpringBootBackend.Testing.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class filteringDynamic {
        @GetMapping("/filteringDynamic")
	public MappingJacksonValue filteringdynamic()
	{
        	SomeBean someBean=new SomeBean("value1","value2","value3");
        	
        MappingJacksonValue map=new MappingJacksonValue(someBean);// it used to add some dynamic filter
        
                                                                          //name used for identify that too same on class SameBean
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field3","field2");
		FilterProvider filterprovider=new SimpleFilterProvider().addFilter("someFilter", filter);
		map.setFilters(filterprovider);
		return map;
	}
        @GetMapping("/filteringDynamic-list")
    	public MappingJacksonValue filteringDLIst()
    	{
    		var someBeans=   Arrays.asList(new SomeBean("value1","value2","value3"),
    				 new SomeBean("value4","value5","value6"));
    		
            MappingJacksonValue map=new MappingJacksonValue(someBeans);// it used to add some dynamic filter
            
                                                                              //name used for identify that too same on class SameBean
            SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2");
    		FilterProvider filterprovider=new SimpleFilterProvider().addFilter("someFilter", filter);
    		map.setFilters(filterprovider);
    		return map;
    	}
            
}
