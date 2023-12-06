package averestium.books_and_genres.repository;

import averestium.books_and_genres.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenreName(String genreName);
}
