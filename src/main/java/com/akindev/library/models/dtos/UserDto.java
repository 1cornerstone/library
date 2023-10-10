package com.akindev.library.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {

    @NotBlank(message = "Full name is required")
    private String name;


    @NotBlank(message = "Address full name is required")
    private String address;

    @NotBlank(message = "nin is required")
    private Long nin;


}
