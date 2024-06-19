package SpringBootBackend.Testing.user;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity(name="Post1")
public class post {
	@Id
	@GeneratedValue
 private int id;
 private String description;
 @ManyToOne(fetch=FetchType.LAZY)
 @JsonIgnore
 private user userByp;
 public post() {}
 public post(int id, String description, user userByp) {
	 super();
	 this.id = id;
	 this.description = description;
	 this.userByp = userByp;
 }
public int getId() {
	return id;
}
public user getUserByp() {
	return userByp;
}
public void setUserByp(user userByp) {
	this.userByp = userByp;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
@Override
public String toString() {
	return "post [id=" + id + ", description=" + description + "]";
}


}
