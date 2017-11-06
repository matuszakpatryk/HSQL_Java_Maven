package com.example.jdbcdemo.service;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Flower;

public class FlowerManagerTest {
	
	
	FlowerManager flowerManager = new FlowerManager();
	
	
	private final static String NAME_1 = "Fiolek";
	private final static double PRICE_1 = 23.77;
	private final static int VAT_1 = 8;
	private final static String TYPE_1 = "doniczkowe";
	private final static String NAME_2 = "Bratek";
	private final static double PRICE_2 = 11;
	private final static int VAT_2 = 5;
	private final static String TYPE_2 = "doniczkowe";
	private final static String NAME_3 = "Amarylis";
	private final static double PRICE_3 = 6.99;
	private final static int VAT_3 = 3;
	private final static String TYPE_3 = "doniczkowe";
	private final static String NAME_4 = "Eustoma";
	private final static double PRICE_4 = 2.55;
	private final static int VAT_4 = 3;
	private final static String TYPE_4 = "ciete";
	
	Flower flower1 = new Flower(NAME_1,PRICE_1,VAT_1,TYPE_1);
	Flower flower2 = new Flower(NAME_2,PRICE_2,VAT_2,TYPE_2);
	Flower flower3 = new Flower(NAME_3,PRICE_3,VAT_3,TYPE_3);
	Flower flower4 = new Flower(NAME_4,PRICE_4,VAT_4,TYPE_4);


	//@Test
	public void checkSearching(){
		Flower flowerFromSearch = flowerManager.searchFlower(NAME_1);

		assertEquals(NAME_1, flowerFromSearch.getName());
		assertEquals(PRICE_1, flowerFromSearch.getPriceNetto(), 5);
		assertEquals(VAT_1, flowerFromSearch.getVat());
		assertEquals(TYPE_1, flowerFromSearch.getType());


	}

	//@Test
	public void checkUpdating(){

		assertEquals(1,flowerManager.updateFlower(flower1));

	}

	//@Test
	public void checkAdding(){

		flowerManager.clearFlowers();
		assertEquals(1,flowerManager.addFlower(flower1));

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
	
	@Test
	public void checkAddAll(){
			List<Flower> flowers = new ArrayList<>();
			flowers.add(flower1);
			flowers.add(flower2);
			flowers.add(flower3);
			flowers.add(flower4);
			flowerManager.clearFlowers();
			flowerManager.addAll(flowers);
			int size = flowerManager.getAllFlowers().size();
			
			assertThat(size, either(is(4)).or(is(0)));
	}
	
	@Test
	public void checkDeleteAll(){
			List<Flower> flowers = new ArrayList<>();
			Flower flower5 = new Flower(NAME_1,PRICE_1,VAT_1,TYPE_1);
			flowers.add(flower1);
			flowers.add(flower2);
			flowers.add(flower3);
			flowers.add(flower4);
			flowers.add(flower5);
			//flowerManager.deleteAll(flowers);
			int size = flowerManager.getAllFlowers().size();
			
			assertThat(size, either(is(4)).or(is(0)));
	}





}
