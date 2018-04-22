package com.hibernate.dao.client;

import com.hibernate.model.Client;
import com.hibernate.dao.GenericDaoInterface;

import java.util.List;

public interface ClientDaoInterface extends GenericDaoInterface<Client,String> {
    public List<Client> findAll();
    public void deleteAll();
    public Client findById(String id);
}
