package com.somegroup.marketplace.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@ToString
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private boolean activated = false;

    private String imageUrl;

    private String activationKey;

    private String resetKey;

    private String country;

    private String city;

//    private Set<ComicBook> comicBooks;
}
