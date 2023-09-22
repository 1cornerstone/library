package com.akindev.library.book.models.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
public class BookDto {

    @NotBlank(message = " title is required")
    private String title;

    @NotNull(message = "number of page is required")
    private int pages;

    @NotBlank(message = "ISBN number is required")
    private String isbnNumber;

    @NotNull(message = "Date written is required")
    private Date dateWritten;

    @NotNull(message = "Price is required")
    private int price;

    @NotNull(message = "Author id is required")
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
