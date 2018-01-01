package com.example.shdemo.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Type;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.shdemo.domain.Flower;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class FlowerManagerTest {

    @Autowired
    FlowerManager flowerManager;

    private final static String TYPE_NAME_1 = "Ciete";
    private final static String TYPE_DESCRIPTION_1 = "Kwiaty ciete";
    private final static String TYPE_NAME_2 = "doniczkowe";
    private final static String TYPE_DESCRIPTION_2 = "kwiaty doniczkowe";

    private final static String CLIENT_NAME_1 = "Adam";
    private final static String CLIENT_PIN_1 = "1122";
    private final static String CLIENT_NAME_2 = "Monika";
    private final static String CLIENT_PIN_2 = "3344";

    private final static String NAME_1 = "Fiolek";
    private final static double PRICE_1 = 23.77;
    private final static int VAT_1 = 8;
    private final static String NAME_2 = "Bratek";
    private final static double PRICE_2 = 11;
    private final static int VAT_2 = 5;
    private final static String NAME_3 = "Amarylis";
    private final static double PRICE_3 = 6.99;
    private final static int VAT_3 = 3;
    private final static String NAME_4 = "Eustoma";
    private final static double PRICE_4 = 2.55;
    private final static int VAT_4 = 3;

    @Test
    public void addTypeCheck(){
        Type type = new Type();
        type.setName(TYPE_NAME_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = flowerManager.addType(type);

        Type typeRetrieved  =flowerManager.findTypeById(typeId);
        assertEquals(TYPE_NAME_1, typeRetrieved.getName());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        flowerManager.deleteType(typeRetrieved);
    }

    @Test
    public void updateTypeCheck(){
        Type type = new Type();
        type.setName(TYPE_NAME_1);
        type.setDescription(TYPE_DESCRIPTION_1);

        Long typeId = flowerManager.addType(type);
        flowerManager.updateType(typeId);

        Type typeRetrieved  =flowerManager.findTypeById(typeId);
        assertEquals("Zmiana", typeRetrieved.getName());
        assertEquals(TYPE_DESCRIPTION_1, typeRetrieved.getDescription());

        //flowerManager.deleteType(typeRetrieved);

    };

    @Test
    public void addClientCheck(){
        Client client = new Client();
        client.setFirstName(CLIENT_NAME_1);
        client.setPin(CLIENT_PIN_1);

        Long clientId = flowerManager.addClient(client);

        Client clientRetrieved  =flowerManager.findClientById(clientId);
        assertEquals(CLIENT_NAME_1, clientRetrieved.getFirstName());
        assertEquals(CLIENT_PIN_1, clientRetrieved.getPin());

        flowerManager.deleteClient(clientRetrieved);
    }

    @Test
    public void updateClientCheck(){
        Client client = new Client();
        client.setFirstName(CLIENT_NAME_1);
        client.setPin(CLIENT_PIN_1);

        Long clientId = flowerManager.addClient(client);
        flowerManager.updateClient(clientId);

        Client clientRetrieved  =flowerManager.findClientById(clientId);
        assertEquals("Zmiana", clientRetrieved.getFirstName());
        assertEquals(CLIENT_PIN_1, clientRetrieved.getPin());

        //flowerManager.deleteClient(clientRetrieved);

    };


    @Test
    public void addFlowerCheck() {

        Long id = Long.valueOf(1);
        Type type = flowerManager.findTypeById(id);
        Flower flower = new Flower();
        flower.setName(NAME_1);
        flower.setPriceNetto(PRICE_1);
        flower.setType(type);
        flower.setVat(VAT_1);
        // ... other properties here

        Long flowerId = flowerManager.addFlower(flower);
        type.getFlowers().add(flower);

        Flower retrievedFlower = flowerManager.findFlowerById(flowerId);
        assertEquals(NAME_1, retrievedFlower.getName());
        assertEquals(PRICE_1, retrievedFlower.getPriceNetto(), 5);
        assertEquals(type, retrievedFlower.getType());
        assertEquals(VAT_1, retrievedFlower.getVat());
        // ... check other properties here

        flowerManager.deleteFlower(retrievedFlower);
    }

    @Test
    public void updateFlowerCheck(){
        Long id = Long.valueOf(1);
        Type type = flowerManager.findTypeById(id);
        Flower flower = new Flower();
        flower.setName(NAME_1);
        flower.setPriceNetto(PRICE_1);
        flower.setType(type);
        flower.setVat(VAT_1);
        // ... other properties here

        Long flowerId = flowerManager.addFlower(flower);
        type.getFlowers().add(flower);
        flowerManager.updateFlower(flowerId);

        Flower retrievedFlower = flowerManager.findFlowerById(flowerId);
        assertEquals("Zmiana", retrievedFlower.getName());
        assertEquals(PRICE_1, retrievedFlower.getPriceNetto(), 5);
        assertEquals(type, retrievedFlower.getType());
        assertEquals(VAT_1, retrievedFlower.getVat());
        // ... check other properties here

        //flowerManager.deleteFlower(retrievedFlower);

    }
}