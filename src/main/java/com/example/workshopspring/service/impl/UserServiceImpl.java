package com.example.workshopspring.service.impl;

import com.example.workshopspring.domain.User;
import com.example.workshopspring.dto.UserDTO;
import com.example.workshopspring.repository.UserRepository;
import com.example.workshopspring.service.UserService;
import com.example.workshopspring.service.exception.ObjectNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public User fromDTO(UserDTO objDto) {
        return User.builder()
                .id(objDto.getId())
                .name(objDto.getName())
                .email(objDto.getEmail())
                .build();
    }

    @Override
    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    @JmsListener(destination = "create-user-sqs")
    public void consumerCreateUserSqs(String message) throws JsonProcessingException {
        log.info("Consumer Create User Sqs, message: ".concat(message));
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(message, User.class);
        this.insert(user);

        System.out.println(user);
    }
}
