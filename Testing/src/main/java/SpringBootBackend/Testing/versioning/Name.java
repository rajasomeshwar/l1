package SpringBootBackend.Testing.versioning;

public class Name {
     private String fristName;
     private String secondName;
	public Name(String fristName, String secondName) {
		super();
		this.fristName = fristName;
		this.secondName = secondName;
	}
	
	public String getFristName() {
		return fristName;
	}

	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	@Override
	public String toString() {
		return "Name [fristName=" + fristName + ", secondName=" + secondName + "]";
	}
     
}
