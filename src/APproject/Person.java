package APproject;

import java.io.Serializable;

/**
 * An abstract that is used to denote the user.
 * Every user can login, but it has different login functionalities, therefore it has a n abstract
 * login function.
 * @author Prateek and Vaibhav
 */
public abstract class Person implements Serializable{
	protected Credentials credentials=new Credentials();
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public abstract void login();


}
