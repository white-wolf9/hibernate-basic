package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.UserAddressDao;
import com.lti.entity.Address;
import com.lti.entity.User;

public class UserAddressTest {

	UserAddressDao dao = new UserAddressDao();
	
	@Test
	public void testAddUser() {
		User user = new User();
		user.setName("Saurav Sanyal");
		user.setEmail("sanyal.s271@gmail.com");
		dao.save(user);
	}
	
	@Test
	public void testAddAddressForAnExistingUser() {
		Address address = new Address();
		User user = (User) dao.fetchById(User.class, 221);
		address.setCity("Whiterun");
		address.setPincode(696969);
		address.setState("Tamriel");
		address.setUser(user);
		dao.save(address);
	}

	@Test
	public void addUserAndAddressTogether() {
	
		User user = new User();
		user.setName("Shreyansh Singh");
		user.setEmail("singh.shrey@gmail.com");
	
		Address address = new Address();
		address.setCity("Baghdad");
		address.setPincode(666210);
		address.setState("DMZ");
		
		user.setAddress(address);
		address.setUser(user);
		
		dao.save(user);
	}
}
