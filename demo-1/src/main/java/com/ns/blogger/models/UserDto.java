package com.ns.blogger.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
		
	
	Integer id;
	
	@NotEmpty(message="Name should be min of 3 chars and max 8 chars.")
	@Size(min=3,max=8)
	String name;
	
	@Email(message="Email is not valid.")	
	String email;
	
	@NotEmpty(message="Password should be min of 3 chars and max 8 chars.")
	@Size(min=3,max=8)
	String password;
	
	@NotEmpty(message="About can not empty.")
	String about;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		
}
