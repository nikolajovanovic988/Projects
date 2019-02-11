package webapp.login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		
		if (user.equals("Nikola") && password.equals("somepass")){
			return true;
		}else {
			return false;
		}
	}
}
