package HellloWorld.Firsttime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
	private int[] data;

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		return data;
	}
    @Autowired
    public MySQLDataService()
    {
    	data=new int[] {1,2,3,4,5};
    }
    
    

}
