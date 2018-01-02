package com.example.shdemo.service;


import com.example.shdemo.domain.Client;
import com.example.shdemo.domain.Purchase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
public class FlowerManagerTestWithoutTransactional {
    @Autowired
    FlowerManager flowerManager;

    private final static String CLIENT_NAME_1 = "Adam";
    private final static String CLIENT_PIN_1 = "1122";


    @Test
    public void lazyExceptionCheck()
    {
        Long id = Long.valueOf(1);
        flowerManager.deleteAllClients();
        flowerManager.deleteAllPurchases();

        Client client = new Client();
        client.setFirstName(CLIENT_NAME_1);
        client.setPin(CLIENT_PIN_1);

        Purchase purchase = new Purchase();
        purchase.setClient(client);

        flowerManager.addPurchase(purchase);

        Client retrievedClient = flowerManager.findClientById(id);

        boolean pass = false;

        try{
            System.out.println(retrievedClient.getPurchases().size());
        } catch (org.hibernate.LazyInitializationException e) {
            e.printStackTrace();
            pass = true;
        }

        if (!pass)
            org.junit.Assert.fail();

        flowerManager.deleteAllClients();
        flowerManager.deleteAllPurchases();
    }
}