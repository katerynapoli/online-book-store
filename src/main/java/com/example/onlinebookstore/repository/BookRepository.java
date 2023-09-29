package com.example.onlinebookstore.repository;

import com.example.onlinebookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Query(value = "UPDATE books SET title = :title, author = :author, "
            + "isbn = :isbn, price = :price, description = :description, "
            + "coverImage = :coverImage WHERE id = :id", nativeQuery = true)
    Book updateById(Long id, String title, String author, String isbn, BigDecimal price,
                       String description, String coverImage);
}
