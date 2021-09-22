package com.somegroup.marketplace.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@ToString
public class ComicBook {
    @Id
    private Long id;

    private String tittle;

    private String publisher;

    private String writer;

    private String artist;

    private BigDecimal price;

    private Instant publicationDate;

    private String description;

    private Float condition;

//    private User user;

}
