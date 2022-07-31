package com.ty.hospital.hospitalappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.hospital.hospitalappboot.dao.UserDao;
import com.ty.hospital.hospitalappboot.dto.User;
import com.ty.hospital.hospitalappboot.exception.IdNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao userdao;

	public User saveUser(User user) {
		return userdao.saveUser(user);
	}

	public User getUserById(int id) {
		User user = userdao.getUserById(id);
		if (user == null) {
			throw new IdNotFoundException();
		}
		return user;
	}

	public List<User> getAllUser() {
		List<User> users = userdao.geAlltUser();
		if (users.isEmpty()) {
			throw new IdNotFoundException();
		}
		return users;
	}

	public User updateUserById(int id, User user) {
		User user1 = userdao.updateUser(id, user);
		if (user1 == null) {
			throw new IdNotFoundException();
		}
		return user1;
	}

	public boolean deleteUserByID(int id) {
		boolean user = userdao.deleteUserById(id);
		if (user == false) {
			throw new IdNotFoundException();
		}
		return true;
	}
}
