package APproject;

import java.io.Serializable;

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
