package com.microservice.profileService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.profileService.response.ProfileResponse;
import com.microservice.profileService.service.ProfileService;

@CrossOrigin(origins = "*")
@RestController
public class ProfileController {

	@Autowired
	private ProfileService service;

	@GetMapping("/profile/{id}")
	public ResponseEntity<ProfileResponse> getProfileById(@PathVariable int id) {
		// return new ResponseEntity<ProfileResponse>(service.getProfileById(id),
		// HttpStatus.ACCEPTED);
		//wdfs
		return ResponseEntity.status(HttpStatus.OK).body(service.getProfileById(id));
	}
}
