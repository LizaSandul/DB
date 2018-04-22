package com.hibernate.dao.book;

import com.hibernate.model.Book;
import com.hibernate.dao.GenericDaoInterface;

import java.util.List;

public interface BookDaoInterface extends GenericDaoInterface<Book,String> {
    public List<Book> findAll();
    public void deleteAll();
    public Book findById(String id);
}
