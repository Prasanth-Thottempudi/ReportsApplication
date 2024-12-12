package com.reports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reports.entity.Users;
import com.reports.exceptions.UserAlreadyExistsException;
import com.reports.request.UserSubscriptionRequest;
import com.reports.service.UserService;

@RestController
@RequestMapping("/reports")
public class ReportsController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/demo")
	public ResponseEntity<String> home(){
		return ResponseEntity.ok("reports demo application");
	}
	
	@PostMapping("/add-user")
	public ResponseEntity<Users> saveUserDetails(@RequestBody UserSubscriptionRequest request) throws UserAlreadyExistsException{
		return ResponseEntity.ok(userService.saveUserAndSubscriptions(request));
	}

}
