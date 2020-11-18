package com.upemor.petsorerest.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upemor.petsorerest.model.User;
import com.upemor.petsorerest.service.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> login(@RequestBody final User usuario) {
		Map<String, Object> response = new HashMap<>();
		
		User userDB = userService.findUserForLogin(usuario.getEmail(), usuario.getPassword());
		
		if (userDB != null) {
			response.put("ok", true);
			response.put("usuario", userDB);
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} else { 
			response.put("ok", false);
			response.put("message", "Usuario/Password invalidos");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
		}
	}
}
