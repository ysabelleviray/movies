package com.gcash.movie;

import com.gcash.movie.service.MovieService;
import com.gcash.movie.service.MovieServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
class MovieApplicationTests {

	MovieService service = new MovieServiceImp();

	@Test
	void contextLoads() {
	}

	@Test
	@WithMockUser("admin")
	public void testGetSecurityPositive() {
		System.out.println(service.getSecurity());
		assertNotNull(service.getSecurity());
	}

	@Test
	public void testGetSecurityNegative() {
		assertEquals("null", service.getSecurity());
	}


}
