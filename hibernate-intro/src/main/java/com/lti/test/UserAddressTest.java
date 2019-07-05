package com.lti.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lti.dao.UserAddressDao;
import com.lti.entity.Address;
import com.lti.entity.User;

public class UserAddressTest {

	UserAddressDao dao = new UserAddressDao();
	Address address = new Address();
	User user = new User();
	
	@Test
	public void testAddUser() {
		user.setName("Saurav Sanyal");
		user.setEmail("sanyal.s271@gmail.com");
		dao.save(user);
	}
	
	@Test
	public void testAddAddressForAnExistingUser() {
		user = (User) dao.fetchById(User.class, 221);
		address.setCity("Whiterun");
		address.setPincode(696969);
		address.setState("Tamriel");
		address.setUser(user);
		dao.save(address);
	}

	@Test
	public void addUserAndAddressTogether() {

		user.setName("Shreyansh Singh");
		user.setEmail("singh.shrey@gmail.com");

		address.setCity("Baghdad");
		address.setPincode(666210);
		address.setState("DMZ");
		
		user.setAddress(address);
		address.setUser(user);
		
		dao.save(user);
	}
	
	@Test
	public void fetchUserAndAddressBoth() {
		user = (User) dao.fetchById(User.class, 241);
		System.out.println(user);	
	}
}
