package com.somegroup.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("refdata.comic_book")
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
