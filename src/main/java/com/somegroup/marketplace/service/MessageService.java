package com.somegroup.marketplace.service;

import com.somegroup.marketplace.domain.Message;
import com.somegroup.marketplace.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    public Flux<Message> getAllMessages() {
        return this.repository.findAll();
    }

    public Mono<Message> getMessageById(long messageId) {
        return this.repository.findById(messageId);
    }

    public Mono<Message> createMessage(final Message message) {
        return this.repository.save(message);
    }

    public Mono<Message> updateMessage(long messageId, final Mono<Message> messageMono) {
        return this.repository.findById(messageId)
                .flatMap(message -> messageMono.map(message1 -> {
                    // TODO: copy
                    return message;
                }))
                .flatMap(message -> this.repository.save(message));
    }

    public Mono<Void> deleteMessage(final long messageId) {
        return this.repository.deleteById(messageId);
    }
}

