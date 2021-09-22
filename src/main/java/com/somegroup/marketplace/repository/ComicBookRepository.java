package com.somegroup.marketplace.repository;

import com.somegroup.marketplace.domain.ComicBook;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicBookRepository extends ReactiveCrudRepository<ComicBook, Long> {
}
