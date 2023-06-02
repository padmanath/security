package com.alibou.security.auth;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibou.security.ResponseClass;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;

	private final ResponseClass responseClass;

	@PostMapping("/register")
	public ResponseEntity<ResponseClass> register(@RequestBody RegisterRequest request) {

		AuthenticationResponse register = service.register(request);
		if (register != null) {

			responseClass.setMessage("register successfully done");
			responseClass.setStatus("200");
			return new ResponseEntity<ResponseClass>(responseClass, HttpStatus.ACCEPTED);
		} else {

			responseClass.setMessage("register failed");
			responseClass.setStatus("500");
			return new ResponseEntity<ResponseClass>(responseClass, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
		return ResponseEntity.ok(service.authenticate(request));
	}

}
