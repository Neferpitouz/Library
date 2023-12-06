package averestium.books_and_genres.dataLoader;

import averestium.books_and_genres.entities.Book;
import averestium.books_and_genres.entities.Genre;
import averestium.books_and_genres.repository.BookRepository;
import averestium.books_and_genres.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public void run(String... args) {
        Genre fiction = new Genre();
        fiction.setName("Fiction");
        genreRepository.save(fiction);

        Genre mystery = new Genre();
        mystery.setName("Mystery");
        genreRepository.save(mystery);

        Book book1 = new Book();
        book1.setName("The Great Gatsby");
        book1.setGenre(fiction);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setName("Sherlock Holmes");
        book2.setGenre(mystery);
        bookRepository.save(book2);
    }
}