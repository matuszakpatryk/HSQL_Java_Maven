package com.example.shdemo.service;

import java.util.List;

import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Flower;
import com.example.shdemo.domain.Purchase;
import com.example.shdemo.domain.Type;

public interface FlowerManager {

    Long addFlower(Flower flower);
    void updateFlower(Long id);
    void deleteFlower(Flower flower);
    Flower findFlowerById(Long id);
    List<Flower> getAllFlowers();

    Long addType(Type type);
    void updateType(Long id);
    void deleteType(Type type);
    Type findTypeById(Long id);
    List<Type> getAllTypes();

    Long addClient(Client client);
    void updateClient(Long id);
    void deleteClient(Client client);
    Client findClientById(Long id);
    Client findClientByPin(String pin);
    List<Client> getAllClients();
    void deleteAllClients();

    Long addPurchase(Purchase client);
    void deletePurchase(Purchase purchase);
    Purchase findPurchaseById(Long id);
    List<Purchase> getAllPurchases();
    void deleteAllPurchases();


}