package com.example.workshopspring.service;

import com.example.workshopspring.domain.User;
import com.example.workshopspring.dto.UserDTO;

import java.util.Collection;

public interface UserService {
    Collection<User> findAll();

    User findById(String id);

    User fromDTO(UserDTO objDto);

    User insert(User obj);

    void delete(String id);

    User update(User obj);
}
