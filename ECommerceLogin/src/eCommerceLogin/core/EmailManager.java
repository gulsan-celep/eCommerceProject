package eCommerceLogin.core;

import eCommerceLogin.entities.concretes.User;

public class EmailManager implements UserAcountService{

	@Override
	public void verifyUser(User user) {
		System.out.println(user.getFirstName() + " isimli kullanýcý giriþ yaptý.");		
	}
}

