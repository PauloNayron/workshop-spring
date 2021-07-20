package com.example.workshopspring.dto;

import com.example.workshopspring.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO {
    private String id;
    private String name;

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }
}
