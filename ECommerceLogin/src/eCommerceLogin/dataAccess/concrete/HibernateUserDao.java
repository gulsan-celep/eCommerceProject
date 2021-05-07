package eCommerceLogin.dataAccess.concrete;

import java.util.List;

import eCommerceLogin.dataAccess.abstracts.UserDao;
import eCommerceLogin.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " added");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " updated");
		
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " deleted");
		
	}

	@Override
	public List<User> getAll() {
		System.out.println("All user is listed");
		return null;
	}

	@Override
	public User Get(String email) {
		return null;
	}

}
