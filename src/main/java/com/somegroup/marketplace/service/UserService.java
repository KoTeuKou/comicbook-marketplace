package com.somegroup.marketplace.service;

import com.somegroup.marketplace.domain.User;
import com.somegroup.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Flux<User> getAllUsers() {
        return this.repository.findAll();
    }

    public Mono<User> getUserById(long userId) {
        return this.repository.findById(userId);
    }

    public Mono<User> createUser(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.repository.save(user);
    }

    public Mono<User> updateUser(long userId, final Mono<User> userMono) {
        return this.repository.findById(userId)
                .flatMap(user -> userMono.map(user1 -> {
                    user.setFirstName(user1.getFirstName());
                    user.setLastName(user1.getLastName());
                    user.setCity(user1.getCity());
                    user.setCountry(user1.getCountry());
                    return user;
                }))
                .flatMap(user -> this.repository.save(user));
    }

    public Mono<Void> deleteUser(final long userId) {
        return this.repository.deleteById(userId);
    }
}
