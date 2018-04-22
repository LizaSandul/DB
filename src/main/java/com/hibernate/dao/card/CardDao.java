package com.hibernate.dao.card;

import com.hibernate.model.Card;
import com.hibernate.dao.GenericDao;
import org.hibernate.Query;

import java.util.Date;
import java.util.List;

public class CardDao extends GenericDao<Card, String> implements CardDaoInterface {

    @SuppressWarnings("unchecked")
    public List<Card> findAll() {
        List<Card> cards = (List<Card>) getCurrentSession().createQuery("from Card").list();
        return cards;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findExpiredDate() {
        Query query = getCurrentSession().createQuery("from Card c inner join c.bookByBookId b where c.date<:paramDate");
        Date date = new Date();
        System.out.println(date);
        query.setParameter("paramDate", date );
        List<Object[]> res = query.list();
        return res;
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findClientsBooksActualDate(String name) {
        Query query = getCurrentSession().createQuery("from Card c inner join c.bookByBookId b inner join c.clientByClientId cl where c.date>:paramDate and cl.name=:paramName");
        Date date = new Date();
        System.out.println(date);
        query.setParameter("paramDate", date );
        query.setParameter("paramName", name );
        List<Object[]> res = query.list();
        return res;
    }

    public void deleteAll() {
        List<Card> entityList = findAll();
        for (Card entity : entityList) {
            delete(entity);
        }
    }
    public Card findById(String id) {
        Card card = (Card) getCurrentSession().get(Card.class, id);
        return card;
    }
}
