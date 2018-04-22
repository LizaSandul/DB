package com.hibernate.dao.client;

import com.hibernate.model.Client;
import com.hibernate.dao.GenericDao;

import java.util.List;

public class ClientDao extends GenericDao<Client, String> implements ClientDaoInterface {
    @SuppressWarnings("unchecked")
    public List<Client> findAll() {
        List<Client> clients = (List<Client>) getCurrentSession().createQuery("from Client").list();
        return clients;
    }

    public void deleteAll() {
        List<Client> entityList = findAll();
        for (Client entity : entityList) {
            delete(entity);
        }
    }
    public Client findById(String id) {
        Client client = (Client) getCurrentSession().get(Client.class, id);
        return client;
    }
}
