package com.mybalhub.service;

import com.mybalhub.repository.UserRepository;
import com.mybalhub.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	
	public ResponseEntity<String> atualizarUsuario(User user, Long id) {
		User existingUser = repository.findById(id).orElse(null);
		
		if(existingUser == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuário encontrado");
		}
		
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		repository.save(existingUser);
		
		return ResponseEntity.ok("Atualizado com sucesso!");
	}
}
