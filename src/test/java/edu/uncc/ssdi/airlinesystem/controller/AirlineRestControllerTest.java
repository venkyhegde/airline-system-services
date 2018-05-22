/**
 * 
 */
package edu.uncc.ssdi.airlinesystem.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import edu.uncc.ssdi.airlinesystem.dto.UserDto;

/**
 * @author venky
 *
 */
public class AirlineRestControllerTest {

	@Test(timeout = 3000)
	public void testRegisterUser() {
		RestTemplate restTemplate = new RestTemplate();

		UserDto userDto = new UserDto();
		userDto.setFirstName("Rahul");
		userDto.setLastName("Dravid");
		userDto.setAddress("Bangalore");
		userDto.setAdmin(true);
		userDto.setEmail("rahuldravid@gmail.com");
		userDto.setPassword("password123");
		userDto.setDob("2015-11-10");
		
		String test = restTemplate.postForObject("http://localhost:8080/airline/rest/register", userDto, String.class);

		System.out.println("Ride: " + test);
	}

}
