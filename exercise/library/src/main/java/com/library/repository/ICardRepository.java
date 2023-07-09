package com.library.repository;

import com.library.model.Card;
import com.library.query.LibraryQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICardRepository extends JpaRepository<Card, String> {
    @Query(value = LibraryQuery.SELECT_ALL_CARD_PAGE, nativeQuery = true)
    Page<Card> findAllCardPage(Pageable pageable, @Param("b.book_name") String bookName);

    @Query(value = LibraryQuery.SELECT_ALL_CARD_LIST, nativeQuery = true)
    List<Card> findAllCardList();

    @Query(value = LibraryQuery.SELECT_CARD_BY_ID, nativeQuery = true)
    Card findCardById(@Param("c.card_id") String cardId);

}
