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
//	private final static String NAME_2 = "Bratek";
//	private final static double PRICE_2 = 11;
//	private final static int VAT_2 = 5;
//	private final static String TYPE_2 = "ciete";

	@Test
	public void checkSearching(){
		Flower flowerFromSearch = flowerManager.searchFlower(NAME_1);

		assertEquals(NAME_1, flowerFromSearch.getName());
		assertEquals(PRICE_1-5.0, flowerFromSearch.getPriceNetto(), 5);
		assertEquals(VAT_1-3, flowerFromSearch.getVat());
		assertEquals(TYPE_1, flowerFromSearch.getType());


	}

	@Test
	public void checkUpdating(){

		Flower flower = new Flower(NAME_1, PRICE_1, VAT_1, TYPE_1);

		assertEquals(1,flowerManager.updateFlower(flower));

	}

	@Test
	public void checkAdding(){

		Flower flower = new Flower(NAME_1, PRICE_1, VAT_1, TYPE_1);

		flowerManager.clearFlowers();
		assertEquals(1,flowerManager.addFlower(flower));

		List<Flower> flowers = flowerManager.getAllFlowers();
		Flower flowerRetrieved = flowers.get(0);

		assertEquals(NAME_1, flowerRetrieved.getName());
		assertEquals(PRICE_1, flowerRetrieved.getPriceNetto(), 5);
		assertEquals(VAT_1, flowerRetrieved.getVat());
		assertEquals(TYPE_1, flowerRetrieved.getType());


	}

	@Test
	public void checkConnection(){
		assertNotNull(flowerManager.getConnection());
	}
	






}
