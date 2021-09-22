package com.somegroup.marketplace.repository;

import com.somegroup.marketplace.domain.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
