package com.library.service.itf;

import com.library.model.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICardService {
    List<Card> findAllCardList();

    Page<Card> findAllCardPage(Pageable pageable, String bookName);

    void createCard(Card card);

    void updateCard(Card card);

    Card findCardById (String cardId);
}
