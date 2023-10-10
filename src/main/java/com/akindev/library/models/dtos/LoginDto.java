package com.akindev.library.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDto {

    @NotBlank(message = "email address is required")
    private String email;

     @NotBlank(message = "password is required")
    private String password;


}
