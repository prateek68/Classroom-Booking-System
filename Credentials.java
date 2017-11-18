package APproject;

import java.io.Serializable;

public class Credentials implements Serializable{
	private String name,EmailId,password,UserType;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return EmailId;
	}

	public void setEmailId(String emailId) {
		EmailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}
	public boolean validate(String email_id, String password) {
		return (EmailId.equals(email_id)&&this.password.equals(password));
	}

}