package com.example.jwt.SpringBoot_Security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;

	// Build Login REST API
	@PostMapping("/login")
	public ResponseEntity<JWTAuthResponse> authenticate(@RequestBody LoginDto loginDto) {
		String token = authService.login(loginDto);

		JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
		jwtAuthResponse.setAccessToken(token);

		return ResponseEntity.ok(jwtAuthResponse);
	}
}