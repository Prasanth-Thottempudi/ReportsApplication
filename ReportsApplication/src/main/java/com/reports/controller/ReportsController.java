package com.reports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reports.entity.Users;
import com.reports.exceptions.UserAlreadyExistsException;
import com.reports.request.UserRequest;
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
	
	@PostMapping(path="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file, 
            @RequestParam("text") String text) {
        
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UserRequest userProfile = objectMapper.readValue(text, UserRequest.class);
            
            String fileName = file.getOriginalFilename();
            
            System.out.println(userProfile);
            System.out.println("File received: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Failed to parse JSON or handle file.");
        }

        return ResponseEntity.ok("File and data uploaded and saved successfully.");
    }
	
	
}
