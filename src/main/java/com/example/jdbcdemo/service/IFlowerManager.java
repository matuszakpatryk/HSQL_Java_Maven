package com.example.jdbcdemo.service;

import java.sql.Connection;
import java.util.List;

import com.example.jdbcdemo.domain.Flower;

public interface IFlowerManager {
	
	int addFlower(Flower flower);
	int updateFlower(Flower flower);
	Flower searchFlower(String s);
	List<Flower> getAllFlowers();
	void clearFlowers();
	Connection getConnection();
	void addAll(List<Flower> flowers);
	void deleteAll(List<Flower> flowers);

}
