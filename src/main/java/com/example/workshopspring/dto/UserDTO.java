package com.example.workshopspring.dto;

import com.example.workshopspring.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String id;
    private String name;
    private String email;

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
