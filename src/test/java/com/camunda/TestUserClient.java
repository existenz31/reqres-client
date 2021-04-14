package com.camunda;

import java.util.List;

import com.camunda.dto.UserDTO;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestUserClient extends TestCase {

	private UserClient userClient;
	
	private void initUserClient()  {
		this.userClient = new UserClient();
	}	
	
	public void testNbUsersFound() {
		this.initUserClient();

		List<UserDTO> users = this.userClient.getUsers(1);
		
		int usersSize = users.size();
		TestCase.assertEquals("Invalid Number of Users. Expected 6, Found " + usersSize, 
				usersSize, 6);
		
		String firstUserFirstName = users.get(0).getFirstName(); // We know that we have 6 items in the list, so index 0 exists
		TestCase.assertEquals("Invalid first name of the first user. Expected George, Found " + firstUserFirstName, 
				firstUserFirstName, "George");
		
	}	
	
	public static void main(String[] argv) {
		TestSuite suite = new TestSuite("Tests complets");
		suite.addTestSuite(TestUserClient.class);
		junit.textui.TestRunner.run(suite);
	}
	
}
