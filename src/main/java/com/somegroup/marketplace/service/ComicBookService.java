package com.somegroup.marketplace.service;

import com.somegroup.marketplace.domain.ComicBook;
import com.somegroup.marketplace.repository.ComicBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ComicBookService {

    @Autowired
    private ComicBookRepository repository;

    public Flux<ComicBook> getAllComicBooks() {
        return this.repository.findAll();
    }

    public Mono<ComicBook> getComicBookById(long comicBookId) {
        return this.repository.findById(comicBookId);
    }

    public Mono<ComicBook> createComicBook(final ComicBook comicBook) {
        return this.repository.save(comicBook);
    }

    public Mono<ComicBook> updateComicBook(long comicBookId, final Mono<ComicBook> comicBookMono) {
        return this.repository.findById(comicBookId)
                .flatMap(comicBook -> comicBookMono.map(comicBook1 -> {
                    // TODO: copy
                    return comicBook;
                }))
                .flatMap(comicBook -> this.repository.save(comicBook));
    }

    public Mono<Void> deleteComicBook(final long comicBookId) {
        return this.repository.deleteById(comicBookId);
    }
}

