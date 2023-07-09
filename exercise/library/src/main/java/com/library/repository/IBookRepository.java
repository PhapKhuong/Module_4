package com.library.repository;

import com.library.model.Book;
import com.library.query.LibraryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Query(value = LibraryQuery.SELECT_BOOK_BY_NAME, nativeQuery = true)
    Page<Book> findBookPageByName(Pageable pageable, @Param("book_name") String bookName);

}
