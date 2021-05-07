package eCommerceLogin.core;

import eCommerceLogin.entities.concretes.User;
import eCommerceLogin.googleUserAcountService.GoogleUserAcountManager;

public class GoogleUserAcountManagerAdapter implements UserAcountService{

	@Override
	public void verifyUser(User user) {

		GoogleUserAcountManager googleUserAcountManager = new GoogleUserAcountManager();
		googleUserAcountManager.verifyUser(user.getEmail() + " isimli kullanýcý girþ yaptý");
	}

}
