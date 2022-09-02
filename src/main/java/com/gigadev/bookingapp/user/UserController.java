package com.gigadev.bookingapp.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServ;

	// http://localhost:8080/users
	@GetMapping
	public List<User> searchAllUsers() {
		return userServ.searchAllUsers();
	}

	@PostMapping
	public void create(@RequestBody User user) {
		userServ.create(user);
	}

	// http://localhost:8080/users/id
	@GetMapping("/{id}")
	public User readById(@PathVariable Long id) {
		return userServ.read(id);
	}

	@PutMapping
	public void update(@RequestBody User user) {
		userServ.update(user);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		userServ.delete(id);
	}

}
