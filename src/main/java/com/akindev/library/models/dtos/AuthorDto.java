package com.akindev.library.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;



@Data
public class AuthorDto {
    @NotBlank(message = "The author name is required.")
    private String name;

    public String getName() {
        return name;
    }

}
