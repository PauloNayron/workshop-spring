package com.example.workshopspring.controller.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostFullSearchDTO {
    private String text = "";
    private String minData = "1900-01-01";
    private String maxData = "2030-01-01";
}
