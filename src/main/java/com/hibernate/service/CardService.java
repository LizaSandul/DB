package com.hibernate.service;

import com.hibernate.dao.card.CardDao;
import com.hibernate.model.Card;

import java.util.List;

public class CardService {
    private static CardDao cardDao;

    public CardService() {
        cardDao = new CardDao();
    }

    public void persist(Card entity) {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.persist(entity);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public void update(Card entity) {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.update(entity);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public Card findById(String id) {
        cardDao.openCurrentSession();
        Card card = cardDao.findById(id);
        cardDao.closeCurrentSession();
        return card;
    }

    public void delete(String id) {
        cardDao.openCurrentSessionwithTransaction();
        Card card = cardDao.findById(id);
        cardDao.delete(card);
        cardDao.closeCurrentSessionwithTransaction();
    }

    public List<Card> findAll() {
        cardDao.openCurrentSession();
        List<Card> cards = cardDao.findAll();
        cardDao.closeCurrentSession();
        return cards;
    }

    public List<Object[]> findExpiredDate() {
        cardDao.openCurrentSession();
        List<Object[]> cards = cardDao.findExpiredDate();
        cardDao.closeCurrentSession();
        return cards;
    }
    public List<Object[]> findClientsBooksActualDate(String name) {
        cardDao.openCurrentSession();
        List<Object[]> cards = cardDao.findClientsBooksActualDate(name);
        cardDao.closeCurrentSession();
        return cards;
    }

    public void deleteAll() {
        cardDao.openCurrentSessionwithTransaction();
        cardDao.deleteAll();
        cardDao.closeCurrentSessionwithTransaction();
    }

    public CardDao cardDao() {
        return cardDao;
    }
}

