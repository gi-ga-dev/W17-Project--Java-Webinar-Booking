package com.gigadev.bookingapp.user;

import java.util.ArrayList;
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
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userServ;

	// http://localhost:8080/users
	@GetMapping
	public List<User> searchAllUsers() {
		try { return userServ.searchAllUsers(); } 
		catch (Exception e) {
			log.error("Searching all users unsuccessful");
			return new ArrayList<User>();
		}		
	}

	@PostMapping
	public void create(@RequestBody User user) {
		try { userServ.create(user); } 
		catch (Exception e) { log.error("Creation unsuccessful..."); }		
	}

	// http://localhost:8080/users/id
	@GetMapping("/{id}")
	public User readById(@PathVariable Long id) {
		try { return userServ.read(id); } 
		catch (Exception e) { 
			log.error("Reading by id unsuccessful..."); 
			return new User();
		}	
	}

	@PutMapping
	public void update(@RequestBody User user) {
		try { userServ.update(user); } 
		catch (Exception e) { log.error("Update unsuccessful..."); }
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		try { userServ.delete(id); } 
		catch (Exception e) { log.error("Delete by id unsuccessful..."); }		
	}

}
