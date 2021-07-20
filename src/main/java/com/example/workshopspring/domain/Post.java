package com.example.workshopspring.domain;

import com.example.workshopspring.dto.AuthorDTO;
import com.example.workshopspring.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

    private Collection<CommentDTO> comments = new ArrayList<>();
}
