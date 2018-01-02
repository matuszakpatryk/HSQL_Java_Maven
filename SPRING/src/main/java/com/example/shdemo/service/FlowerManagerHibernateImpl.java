package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Purchase;
import com.example.shdemo.domain.Type;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Flower;

@Component
@Transactional
public class FlowerManagerHibernateImpl implements FlowerManager {


    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long addFlower(Flower flower) {
        flower.setId(null);
        return (Long) sessionFactory.getCurrentSession().save(flower);

    }

    @Override
    public void updateFlower(Long id) {
        Flower flower = (Flower) sessionFactory.getCurrentSession().get(Flower.class, id);
        flower.setName("Zmiana");
    }

    @Override
    public void deleteFlower(Flower flower) {
        flower = (Flower) sessionFactory.getCurrentSession().get(Flower.class,
                flower.getId());

        sessionFactory.getCurrentSession().delete(flower);
    }

    @Override
    public Flower findFlowerById(Long id) {
        return (Flower) sessionFactory.getCurrentSession().get(Flower.class, id);
    }

    @Override
    public List<Flower> getAllFlowers() {
        return sessionFactory.getCurrentSession().getNamedQuery("flower.all").list();
    }

    @Override
    public Long addType(Type type) {
        type.setId(null);
        return (Long) sessionFactory.getCurrentSession().save(type);
    }

    @Override
    public void updateType(Long id) {
        Type type = (Type) sessionFactory.getCurrentSession().get(Type.class, id);
        type.setName("Zmiana");
    }

    @Override
    public void deleteType(Type type) {
        type = (Type) sessionFactory.getCurrentSession().get(Type.class,
                type.getId());

        sessionFactory.getCurrentSession().delete(type);
    }

    @Override
    public Type findTypeById(Long id) {
        return (Type) sessionFactory.getCurrentSession().get(Type.class, id);
    }

    @Override
    public List<Type> getAllTypes() {
        return sessionFactory.getCurrentSession().getNamedQuery("type.all").list();
    }

    @Override
    public Long addClient(Client client) {
        client.setId(null);
        return (Long) sessionFactory.getCurrentSession().save(client);
    }

    @Override
    public void updateClient(Long id) {
        Client client = (Client) sessionFactory.getCurrentSession().get(Client.class, id);
        client.setFirstName("Zmiana");
    }

    @Override
    public void deleteClient(Client client) {
        client = (Client) sessionFactory.getCurrentSession().get(Client.class,
                client.getId());

        sessionFactory.getCurrentSession().delete(client);
    }

    @Override
    public Client findClientById(Long id) {
        return (Client) sessionFactory.getCurrentSession().get(Client.class, id);
    }

    @Override
    public List<Client> getAllClients() {
        return sessionFactory.getCurrentSession().getNamedQuery("client.all").list();
    }

    @Override
    public void deleteAllClients() {
        sessionFactory.getCurrentSession().getNamedQuery("client.deleteAll").executeUpdate();
    }

    @Override
    public Long addPurchase(Purchase purchase) {
        if(purchase.getClient() != null) {
            purchase.getClient().getPurchases().add(purchase);
        }
        return (Long) sessionFactory.getCurrentSession().save(purchase);
    }

    @Override
    public void deletePurchase(Purchase purchase) {
        purchase = (Purchase) sessionFactory.getCurrentSession().get(Purchase.class,
                purchase.getId());

        sessionFactory.getCurrentSession().delete(purchase);
    }

    @Override
    public Purchase findPurchaseById(Long id) {
        return (Purchase) sessionFactory.getCurrentSession().get(Purchase.class, id);
    }

    @Override
    public List<Purchase> getAllPurchases() {
        return sessionFactory.getCurrentSession().getNamedQuery("purchase.all").list();
    }

    @Override
    public void deleteAllPurchases() {
        sessionFactory.getCurrentSession().getNamedQuery("purchase.deleteAll").executeUpdate();
    }

    @Override
    public Client findClientByPin(String pin) {
        Client client = (Client) sessionFactory.getCurrentSession().getNamedQuery("client.byPin").setString("pin", pin).uniqueResult();
        return client;

    }


}