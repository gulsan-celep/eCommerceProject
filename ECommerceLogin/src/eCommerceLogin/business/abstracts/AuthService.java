package eCommerceLogin.business.abstracts;

import eCommerceLogin.entities.concretes.User;

public interface AuthService {
	void signIn(User user);
	void signUp(User user);
}
