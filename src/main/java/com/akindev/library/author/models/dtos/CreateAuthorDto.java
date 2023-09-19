package com.akindev.library.author.models.dtos;

import lombok.Data;
import javax.validation.constraints.NotBlank;



@Data
public class CreateAuthorDto {
    @NotBlank(message = "The author name is required.")
    private String name;
    @NotBlank(message = "The admin code is required.")
    private String adminCode;

    public String getName() {
        return name;
    }

    public String getAdminCode() {
        return adminCode;
    }
}
