package com.ty.hospital.hospitalappboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return  optional.get();
		}
		return null;
	}

	public List<User> geAlltUser() {
		return userRepository.findAll();
	}

	public User updateUser(int id, User user) {
		User exiestinguser = getUserById(id);
		if (exiestinguser != null) {
			userRepository.save(user);
			return user;
		}
		return null;
	}

	public boolean deleteUserById(int id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
