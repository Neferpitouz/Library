package averestium.books_and_genres.service;

import averestium.books_and_genres.entities.Book;
import averestium.books_and_genres.entities.Genre;
import averestium.books_and_genres.repository.BookRepository;
import averestium.books_and_genres.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    public ResponseEntity<List<Book>> getAllBooks(String genre) {
        if (genre != null) {
            Optional<Genre> genreOptional = genreRepository.findByName(genre);
            if (genreOptional.isPresent()) {
                return ResponseEntity.ok(bookRepository.findByGenreName(genre));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
            }
        } else {
            return ResponseEntity.ok(bookRepository.findAll());
        }
    }
}
