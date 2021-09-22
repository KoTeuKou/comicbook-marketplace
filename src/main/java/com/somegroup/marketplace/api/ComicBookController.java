package com.somegroup.marketplace.api;

import com.somegroup.marketplace.domain.ComicBook;
import com.somegroup.marketplace.service.ComicBookService;
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
@RequestMapping("comicBook")
public class ComicBookController {

    @Autowired
    private ComicBookService comicBookService;

    @GetMapping("all")
    public Flux<ComicBook> getAll() {
        return this.comicBookService.getAllComicBooks();
    }

    @GetMapping("{comicBookId}")
    public Mono<ResponseEntity<ComicBook>> getComicBookById(@PathVariable long comicBookId) {
        return this.comicBookService.getComicBookById(comicBookId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ComicBook> createComicBook(@RequestBody Mono<ComicBook> comicBookMono) {
        return comicBookMono.flatMap(this.comicBookService::createComicBook);
    }

    @PutMapping("{comicBookId}")
    public Mono<ComicBook> updateComicBook(@PathVariable long comicBookId, @RequestBody Mono<ComicBook> comicBookMono) {
        return this.comicBookService.updateComicBook(comicBookId, comicBookMono);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteComicBook(@PathVariable long id) {
        return this.comicBookService.deleteComicBook(id);
    }
}
