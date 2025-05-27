package com.nguyenanhtuyen.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import com.nguyenanhtuyen.dto.response.ResponseData;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@GetMapping("/listUsers")
	public ResponseData<List<UserRequestDTO>> getAllUsers() {
		System.out.println("Request get list users");
		return new ResponseData<>(HttpStatus.OK.value(), "list users",
				List.of(new UserRequestDTO("Ti", "Nguyen", "0987654321", "ti@gmail.com"),
						new UserRequestDTO("Teo", "Nguyen", "0123456789", "te0@gmail.com")));
	}

	@GetMapping("/{userId}")
	public ResponseData<UserRequestDTO> getUser(@PathVariable @Min(1) int userId) {
		System.out.println("Request get detail user, userId = " + userId);
		return new ResponseData<>(HttpStatus.OK.value(), "user",
				new UserRequestDTO("Teo", "Nguyen", "0123456789", "teo@gmail.com"));
	}

//	@PostMapping("/")
//	@ResponseStatus(value = HttpStatus.CREATED)
//	public int addUser(@Valid @RequestBody UserRequestDTO userDTO) {
//		return 1;
//	}

	// using operation to describe api document for client
//	@Operation(summary = "summary", description = "description", responses = {
//			@ApiResponse(responseCode = "201", description = "User added successfully", 
//					content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
//					examples = @ExampleObject(name = "ex name", summary = "ex summary", value = 
//					"""
//						{
//							"status": 201,
//							"message": "User added successfully",
//							"data": 1
//						}
//					""")))
//			})
	
	// option 1
//	@PostMapping("/")
//	public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO userDTO) {
//		System.out.println("Request add user " + userDTO.getFirstName());
//		return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
//	}

	// option 2
	@PostMapping("/")
	public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request add user " + userDTO.getFirstName());
		return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
	}
	
	@PutMapping("/{userId}")
	public ResponseData<?> updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request update userId = " + userId);
		return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
	}

	@PatchMapping("/{userId}")
	public ResponseData<?> updateStatus(@PathVariable @Min(1) int userId,
			@RequestParam(required = false) boolean status) {
		System.out.println("Request change user status, userId = " + userId);
		return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User Status changed");
	}

	@DeleteMapping("/{userId}")
	public ResponseData<?> deleteUser(
			@PathVariable @Min(value = 1, message = "userId must be greater than 0") int userId) {
		System.out.println("Request delete user, userId = " + userId);
		return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
	}

}
