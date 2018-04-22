package com.hibernate.dao.card;

import com.hibernate.model.Card;
import com.hibernate.dao.GenericDaoInterface;

import java.util.List;

public interface CardDaoInterface extends GenericDaoInterface<Card,String> {
    public List<Card> findAll();
    public void deleteAll();
    public Card findById(String id);
    public List<Object[]> findExpiredDate();
}
