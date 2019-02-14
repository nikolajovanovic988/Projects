package webapp.login;

public class LoginService {
	
	private String name = "Nikola";
	private String pass = "pass";
	
	public boolean checkIfExist(String name, String pass) {
		if(this.name.equals(name) & this.pass.equals(pass)) {
			return true;
		} else {
			return false;
		}
	}
}
