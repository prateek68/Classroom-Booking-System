
public abstract class Person {
	private Credentials credentials=new Credentials();
	
	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public abstract void login();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

