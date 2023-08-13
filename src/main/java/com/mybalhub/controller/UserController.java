package com.mybalhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mybalhub.entity.User;
import com.mybalhub.service.UserService;

@RestController
public class UserController {
	private final UserService service;
	
	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/api/users")
	public List<User> getAll() {
		return service.listarUsuarios();
	}
	
	@PostMapping("/api/users")
	public String createUser(@RequestBody User user) {
		service.criarUsuario(user);
		return "Criado";
	}
	
	@DeleteMapping("/api/user/{requestedId}")
	public String deleteUser(@PathVariable Long id) {
		service.deletarUsuario(id);
		return id + "Deletado com sucesso";
	}
	
	@PutMapping("/api/users")
	public void updateUser(@RequestBody User user) {
		service.atualizarUsuario(user);
	}

}
