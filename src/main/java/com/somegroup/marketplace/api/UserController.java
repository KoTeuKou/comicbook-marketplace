package com.somegroup.marketplace.api;

import com.somegroup.marketplace.domain.User;
import com.somegroup.marketplace.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("user")
public class UserController {

    final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping
    public Flux<User> getAll() {
        logger.info("getAll request");
        return this.userService.getAllUsers();
    }

    @GetMapping("{userId}")
    public Mono<ResponseEntity<User>> getUserById(@PathVariable long userId) {
        logger.info("getUserById request for id {}", userId);
        return this.userService.getUserById(userId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("register")
    public Mono<User> createUser(@RequestBody Mono<User> userMono) {
        logger.info("createUser request for {}", userMono);
        return userMono.flatMap(this.userService::createUser);
    }

    @PutMapping("{userId}")
    public Mono<User> updateUser(@PathVariable long userId, @RequestBody Mono<User> userMono) {
        logger.info("updateUser request for {}", userId);
        return this.userService.updateUser(userId, userMono);
    }

    @DeleteMapping("{userId}")
    public Mono<Void> deleteUser(@PathVariable long userId) {
        logger.info("deleteUser request for {}", userId);
        return this.userService.deleteUser(userId);
    }
}
