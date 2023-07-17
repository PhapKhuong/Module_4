package com.libraries_trung.repository;

import com.libraries_trung.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Card, String> {
//    @Query(value = LibraryQuery.SELECT_ALL_CARD_PAGE, nativeQuery = true)
//    Page<Card> findAllCardPage(Pageable pageable, @Param("b.book_name") String bookName);
//
//    @Query(value = LibraryQuery.SELECT_ALL_CARD_LIST, nativeQuery = true)
//    List<Card> findAllCardList();
//
//    @Query(value = LibraryQuery.SELECT_CARD_BY_ID, nativeQuery = true)
//    Card findCardById(@Param("c.card_id") String cardId);

}
