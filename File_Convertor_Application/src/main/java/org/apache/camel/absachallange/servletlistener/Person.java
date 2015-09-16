package org.apache.camel.absachallange.servletlistener;


import java.io.Serializable;
 
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
 
@CsvRecord(separator = ",")
public class Person implements Serializable {
    @DataField(pos = 1)
   private String id;
    @DataField(pos = 2)
   private String first_name;
    @DataField(pos = 3)
    private String last_name;
    @DataField(pos = 4)
    private String email;
    @DataField(pos = 5)
    private String country;
    
    
	public Person() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
    
    
    
}