package com.mybalhub.service;

import com.mybalhub.repository.UserRepository;
import com.mybalhub.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository repository;
	
	@Autowired
	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> listarUsuarios() {
		return repository.findAll();
	}
	
	public void criarUsuario(User user) {
		repository.save(user);
	}
	
	public void deletarUsuario(Long id) {
		repository.deleteById(id);
	}
	
	public void atualizarUsuario(User user) {
		User existingUser = repository.findById(user.getId()).orElse(null);
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
	}
}
