package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Flower;

public class FlowerManagerTest {
	
	
	FlowerManager flowerManager = new FlowerManager();
	
	private final static String NAME_1 = "Fiolek";
	private final static double PRICE_1 = 23.77;
	private final static int VAT_1 = 8;
	private final static String TYPE_1 = "doniczkowe";
	
	@Test
	public void checkConnection(){
		assertNotNull(flowerManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Flower flower = new Flower(NAME_1, PRICE_1, VAT_1, TYPE_1);
		
		flowerManager.clearFlowers();
		assertEquals(1,flowerManager.addFlower(flower));
		
		List<Flower> flowers = flowerManager.getAllFlowers();
		Flower flowerRetrieved = flowers.get(0);
		
		assertEquals(NAME_1, flowerRetrieved.getName());
		assertEquals(PRICE_1, flowerRetrieved.getPriceNetto(), 0.0001);
		assertEquals(VAT_1, flowerRetrieved.getVat());
		assertEquals(TYPE_1, flowerRetrieved.getType());
		
	}

}
