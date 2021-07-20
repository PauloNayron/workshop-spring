package com.example.workshopspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO implements Serializable {
    private  static final long serialVersionUID = 1L;

    private String text;
    private LocalDate date;
    private AuthorDTO author;
}
