package SpringBoot.DeveloperSpringBoot;

public class Course {
	private int id;
	private String name,author;
	public Course(int i, String string, String string2) {
		// TODO Auto-generated constructor stub
		id=i;
	   name=string;
	   author=string2;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	

}
