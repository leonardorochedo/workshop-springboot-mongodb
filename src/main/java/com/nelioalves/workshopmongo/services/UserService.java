package com.nelioalves.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = userRepo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return userRepo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id); // caso nao ache vai disparar uma exeção
		userRepo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
