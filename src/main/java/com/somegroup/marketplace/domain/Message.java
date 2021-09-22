package com.somegroup.marketplace.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@Data
@ToString
public class Message {
    @Id
    private Long id;

    private String text;

    private Instant creationDateAndTime;

//    private User sender;
//
//    private User recipient;
}
