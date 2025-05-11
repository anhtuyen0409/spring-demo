package com.nguyenanhtuyen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenanhtuyen.dto.request.UserRequestDTO;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/listUsers")
	public List<UserRequestDTO> getAllUsers() {
		System.out.println("Request get list users");
		return List.of(new UserRequestDTO("Ti", "Nguyen", "0987654321", "ti@gmail.com"), 
				new UserRequestDTO("Teo", "Nguyen", "0123456789", "te0@gmail.com"));
	}

	@GetMapping("/{userId}")
	public UserRequestDTO getUser(@PathVariable int userId) {
		System.out.println("Request get detail user, userId = " + userId);
		return new UserRequestDTO("Teo", "Nguyen", "0123456789", "teo@gmail.com");
	}

	@PostMapping("/")
	public String addUser(@RequestBody UserRequestDTO userDTO) {
		return "User added";
	}

	@PutMapping("/{userId}")
	public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request update userId = " + userId);
		return "User updated";
	}

	@PatchMapping("/{userId}")
	public String changeStatus(@PathVariable int userId, @RequestParam(required = false) boolean status) {
		System.out.println("Request change user status, userId = " + userId);
		return "User status changed";
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable int userId) {
		System.out.println("Request delete user, userId = " + userId);
		return "User deleted";
	}

}
