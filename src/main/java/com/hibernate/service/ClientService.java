package com.hibernate.service;

import com.hibernate.dao.client.ClientDao;
import com.hibernate.model.Client;

import java.util.List;

public class ClientService {
    private static ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public void persist(Client entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.persist(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public void update(Client entity) {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.update(entity);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public Client findById(String id) {
        clientDao.openCurrentSession();
        Client client = clientDao.findById(id);
        clientDao.closeCurrentSession();
        return client;
    }

    public void delete(String id) {
        clientDao.openCurrentSessionwithTransaction();
        Client client = clientDao.findById(id);
        clientDao.delete(client);
        clientDao.closeCurrentSessionwithTransaction();
    }

    public List<Client> findAll() {
        clientDao.openCurrentSession();
        List<Client> clients = clientDao.findAll();
        clientDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        clientDao.openCurrentSessionwithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionwithTransaction();
    }

    public ClientDao clientDao() {
        return clientDao;
    }
}

