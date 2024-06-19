package SpringBootBackend.Testing.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
@Entity()
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})// LALZY 
public class user {
	@Id
	@GeneratedValue
  private int id;
	@Size(min=2)
  private String name;
	@OneToMany(mappedBy="userByp")
	@JsonIgnore
	private List<post> posts;
	@Past
	@JsonProperty("Date of Birth") // it used to json date change to date of brith in json format
  private LocalDate date;
  public user()
  {
	  
  }
public user(int id, String name, LocalDate date) {
	super();
//	this.id = id;
	this.name = name;
	this.date = date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDate() {
	return date;
}
public void setDate(LocalDate date) {
	this.date = date;
}
public List<post> getPosts() {
	return posts;
}
public void setPosts(List<post> posts) {
	this.posts = posts;
}
@Override
public String toString() {
	return "user [id=" + id + ", name=" + name + ", date=" + date + "]";
}
}
