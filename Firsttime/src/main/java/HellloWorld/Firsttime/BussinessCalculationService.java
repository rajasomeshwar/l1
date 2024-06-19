package HellloWorld.Firsttime;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BussinessCalculationService {
	private DataService data;
	@Autowired
	public BussinessCalculationService(DataService data)
	{
		super();
		this.data=data;
	}
	public int findmax()
	{
		return Arrays.stream(data.retrieveData()).max().orElse(0);
	}

}
