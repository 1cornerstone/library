package com.akindev.library.book.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class BookDto {

    @NotBlank(message = " title is required")
    private String title;

    @NotBlank(message = " no of page is required")
    private int pages;

    @NotBlank(message = "ISBN number is required")
    private String isbnNumber;

    @NotBlank(message = "Date written is required")
    private Date dateWritten;

    @NotBlank(message = "Price is required")
    private int price;

    @NotBlank(message = "Price is required")
    private int authorId;



    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public Date getDateWritten() {
        return dateWritten;
    }

    public int getPrice() {
        return price;
    }

    public int getAuthorId() {
        return authorId;
    }
}
