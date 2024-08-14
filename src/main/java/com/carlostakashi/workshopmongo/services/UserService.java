package com.carlostakashi.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlostakashi.workshopmongo.domain.User;
import com.carlostakashi.workshopmongo.dto.UserDTO;
import com.carlostakashi.workshopmongo.repository.UserRepository;
import com.carlostakashi.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    
    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("objeto nao encontrado");
        }
        return user.get();
        
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}
