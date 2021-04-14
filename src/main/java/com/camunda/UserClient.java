package com.camunda;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.camunda.dto.ReqresUsersDTO;
import com.camunda.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserClient {
	private ObjectMapper mapper = new ObjectMapper(); 
	
	private static final String BASE_URL = "https://reqres.in/api";
	
	public static void main(String argv[]) {
		UserClient userClient = new UserClient();
		userClient.printUsers(1);
	}
	
	public List<UserDTO> getUsers(int page) throws IllegalArgumentException {
		ReqresUsersDTO value;
		
		if (page < 1) {
			throw new IllegalArgumentException(Integer.toString(page));
		}
		
		try {
			URL url = new URL("https://reqres.in/api/users?page=" + page);
			value = mapper.readValue(url, ReqresUsersDTO.class);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} 
		return Arrays.asList(value.getData());
	}

	public void printUsers(int page) throws IllegalArgumentException {
		List<UserDTO> users = this.getUsers(page);
		for (UserDTO user: users) {
			String msg = String.format("User %d => %s %s", user.getId(), user.getFirstName(), user.getLastName());
			System.out.println(msg);			
		}

	}

}

