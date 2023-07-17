package com.libraries.service.impl;

import com.libraries.model.Card;
import com.libraries.repository.ICardRepository;
import com.libraries.service.itf.ICardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService implements ICardService {
//    private ICardRepository cardRepository;
//
//    private CardService(ICardRepository cardRepository) {
//        this.cardRepository = cardRepository;
//    }
//
//    @Override
//    public List<Card> findAllCardList() {
//        return cardRepository.findAllCardList();
//    }
//
//    @Override
//    public Page<Card> findAllCardPage(Pageable pageable, String bookName) {
//        return cardRepository.findAllCardPage(pageable, bookName);
//    }
//
//    @Override
//    public void createCard(Card card) {
//        cardRepository.save(card);
//    }
//
//    @Override
//    public void updateCard(Card card) {
//        cardRepository.save(card);
//    }
//
//    @Override
//    public Card findCardById(String cardId) {
//        return cardRepository.findCardById(cardId);
//    }
}
