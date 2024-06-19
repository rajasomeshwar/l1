package SpringBootBackend.Testing.filter;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties() // it used not display in broswer we pass the variable name which are not displayed
@JsonFilter("someFilter")
public class SomeBean {
   private String field1;
 //  @JsonIgnore // it not display in broswer json it used on variable 
   private String field2;
   private String field3;
public SomeBean(String field1, String field2, String field3) {
	super();
	this.field1 = field1;
	this.field2 = field2;
	this.field3 = field3;
}
public String getField1() {
	return field1;
}
public String getField2() {
	return field2;
}
public String getField3() {
	return field3;
}
@Override
public String toString() {
	return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
}
   
}
