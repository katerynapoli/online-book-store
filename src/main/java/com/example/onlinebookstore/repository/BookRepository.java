package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Query("UPDATE Book b SET b.title = :title, b.author = :author, "
            + "b.isbn = :isbn, b.price = :price, b.description = :description, "
            + "b.coverImage = :coverImage WHERE b.id = :id")
    Book updateById(Long id, String title, String author, String isbn, BigDecimal price,
                    String description, String coverImage);
}
