package com.gigadev.bookingapp.user;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public List<User> searchAllUsers() {		
		return (List<User>) userRepo.findAll();
	}
	
	public void create(User user) {
		userRepo.save(user);
	}
	
	public User read(Long id) {
		return userRepo.findById(id).get();
	}
	
	public void update(User user) {
		userRepo.save(user);
	}
	
	public void delete(Long id) {
		userRepo.deleteById(id);
	}

}
