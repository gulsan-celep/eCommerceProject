package eCommerceLogin.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerceLogin.business.abstracts.AuthService;
import eCommerceLogin.core.UserAcountService;
import eCommerceLogin.dataAccess.abstracts.UserDao;
import eCommerceLogin.entities.concretes.User;

public class AuthManager implements AuthService{
	
	private UserDao userDao;
	private UserAcountService userAcountService;
	
	public AuthManager(UserDao userDao, UserAcountService userAcountService) {
		this.userDao = userDao;
		this.userAcountService = userAcountService;
	}

	@Override
	public void signIn(User user) {
		if(validateEmail(user.getEmail()) && checkPassword(user.getPassword()) &&
		   checkUser(user.getEmail(),user.getPassword())) {
			userAcountService.verifyUser(user);
		}
		else {
			System.out.println("Email yada þifre hatalýdýr");
		}
	}

	@Override
	public void signUp(User user) {
		if(isTeEnteredInformationBlank(user) && checkNameSurname(user) &&
		   checkPassword(user.getPassword()) && validateEmail(user.getEmail()) 
		   && isTheEmailEnteredDifferent(user.getEmail())) {
			System.out.println("Kullanýcý üye oldu");
		}
		else {
			System.out.println("Bilgileri doðru girdiðinizde emin olunuz.");
		}
	}
	
	private boolean isTeEnteredInformationBlank(User user) {
		
		if(user.getFirstName().isEmpty() && user.getLastName().isEmpty() && user.getEmail().isEmpty()
				&& user.getPassword().isEmpty()) {
			System.out.println("Boþ alan býrakýlamaz");
			return false;
		}
		return true;
	}
	
	private boolean checkNameSurname(User user) {
		if(user.getFirstName().length() >=2 && user.getLastName().length() >=2) {
			return true;
		}
		System.out.println("Ýsim ve soyad en az 2 karakter olmalýdýr.");
		return false;
	}
	
	private boolean checkPassword(String password) {
		if(password.length() >= 6) {
			return true;
		}
		System.out.println("Þifre en az 6 karakterden oluþmalýdýr.");
		return false;
	}	
	
	private boolean validateEmail(String email) {
		final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if(matcher.find()) {
			return true;
		}
		System.out.println("Geçerli bir email giriniz");
		return false;
		}
	
	
	private boolean isTheEmailEnteredDifferent(String email) {
		if(userDao.Get(email)== null) {
			return true;
		}
		System.out.println("Bu email sistemimize kayýtlýdýr");	
		return false;
	   }	
	
	private boolean checkUser(String email, String password) {
		return true;
	}
}
