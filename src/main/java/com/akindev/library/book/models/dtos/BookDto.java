package com.akindev.library.book.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookDto {

    @NotBlank(message = " title is required")
    private String title;

    @NotBlank(message = " no of page is required")
    private int pages;

    @NotBlank(message = "ISBN number is required")
    private String isbnNumber;

    @NotBlank(message = "Date written is required")
    private String dateWritten;

    @NotBlank(message = "Price is required")
    private int price;

}
