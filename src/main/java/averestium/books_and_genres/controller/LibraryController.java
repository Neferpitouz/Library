package averestium.books_and_genres.controller;

import averestium.books_and_genres.entities.Book;
import averestium.books_and_genres.entities.Genre;
import averestium.books_and_genres.repository.BookRepository;
import averestium.books_and_genres.repository.GenreRepository;
import averestium.books_and_genres.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class LibraryController {
    private LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks (@RequestParam(required = false) String genre) {
        return libraryService.getAllBooks(genre);
    }
}
