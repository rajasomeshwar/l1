package HellloWorld.Firsttime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {
 private int[] retrieveData;
 @Autowired
 public MongoDbDataService()
 {
	 super();
	 retrieveData=new int[] {11,22,33,44,55};;
 }
@Override
public int[] retrieveData() {
	// TODO Auto-generated method stub
	return retrieveData;
}
}
