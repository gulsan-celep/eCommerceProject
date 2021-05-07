package eCommerceLogin;

import eCommerceLogin.business.concretes.AuthManager;
import eCommerceLogin.business.concretes.UserManager;
import eCommerceLogin.core.EmailManager;
import eCommerceLogin.core.GoogleUserAcountManagerAdapter;
import eCommerceLogin.dataAccess.concrete.HibernateUserDao;
import eCommerceLogin.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user = new User();
		user.setId(1);
		user.setFirstName("Gülþan");
		user.setLastName("Celep");
		user.setEmail("gulsan.celep@gmail.com");
		user.setPassword("123456");
		UserManager userManager = new UserManager(new HibernateUserDao());
		userManager.add(user);
		
		AuthManager authManager = new AuthManager(new HibernateUserDao(), new EmailManager());
		authManager.signUp(user);
		authManager.signIn(user);
		
		User user2 = new User();
		user2.setId(1);
		user2.setFirstName("T");
		user2.setLastName("T");
		user2.setEmail("gulsan.celep");
		user2.setPassword("1234");
		
		AuthManager authManager2 = new AuthManager(new HibernateUserDao(), new GoogleUserAcountManagerAdapter());
		authManager2.signUp(user2);
		authManager2.signIn(user2);
		
	}

}
