package com.hibernate.dao.book;

import com.hibernate.model.Book;
import com.hibernate.dao.GenericDao;

import java.util.List;

public class BookDao extends GenericDao<Book, String> implements BookDaoInterface {

    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }

    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }
    public Book findById(String id) {
        Book book = (Book) getCurrentSession().get(Book.class, id);
        return book;
    }
}
