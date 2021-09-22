package com.somegroup.marketplace.api;

import com.somegroup.marketplace.domain.Message;
import com.somegroup.marketplace.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("all")
    public Flux<Message> getAll() {
        return this.messageService.getAllMessages();
    }

    @GetMapping("{messageId}")
    public Mono<ResponseEntity<Message>> getMessageById(@PathVariable long messageId) {
        return this.messageService.getMessageById(messageId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<Message> createMessage(@RequestBody Mono<Message> messageMono) {
        return messageMono.flatMap(this.messageService::createMessage);
    }

    @PutMapping("{messageId}")
    public Mono<Message> updateMessage(@PathVariable long messageId, @RequestBody Mono<Message> messageMono) {
        return this.messageService.updateMessage(messageId, messageMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteMessage(@PathVariable long id) {
        return this.messageService.deleteMessage(id);
    }
}
