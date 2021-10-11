package com.somegroup.marketplace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("refdata.users")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private String login;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    @Transient
    private boolean activated;

    private String imagePath;

    @Transient
    private String activationKey;

    @Transient
    private String resetKey;

    private String country;

    private String city;

//    private Set<ComicBook> comicBooks;
}
