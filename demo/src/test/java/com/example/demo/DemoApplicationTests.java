package com.example.demo;

import com.example.demo.security.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void jwtServiceIssuesAccessAndRefreshTokens() {
		JwtService jwtService = new JwtService("test-secret-test-secret-test-secret-1234", 15, 60);
		UserDetails userDetails = User.withUsername("visitor@test.local")
				.password("password")
				.roles("USER")
				.build();

		String accessToken = jwtService.generateAccessToken(userDetails);
		String refreshToken = jwtService.generateRefreshToken(userDetails);

		assertThat(jwtService.isAccessTokenValid(accessToken, userDetails)).isTrue();
		assertThat(jwtService.isRefreshTokenValid(refreshToken, userDetails)).isTrue();
		assertThat(jwtService.extractUsername(accessToken)).isEqualTo("visitor@test.local");
	}
}
