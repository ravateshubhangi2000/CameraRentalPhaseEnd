package cameraRental.com.Project;

public class ValidateDetail {
public boolean validateUser(String username, String password) {
		
		LoginDetail Login = new LoginDetail();
		
		if(username.equals(Login.getUsername()) && password.equals(Login.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
}
