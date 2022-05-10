package com.example.EjerciciosManana18.Reports.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String email;
    private String content;
    private String subject;
}
