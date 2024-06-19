package HellloWorld.Firsttime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan
public class Running {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(var context=new AnnotationConfigApplicationContext(Running.class))
		{
			System.out.println(context.getBean(BussinessCalculationService.class).findmax());
		}
		

	}

}
