package com.example.jdbcdemo.domain;

public class Flower {
	
	private int id;	
	private String name;
	private double priceNetto;
	public int vat;
	public String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPriceNetto() {
		return priceNetto;
	}
	public void setPriceNetto(double priceNetto) {
		this.priceNetto = priceNetto;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Flower(String name, double price, int vat, String type){
		this.name = name;
		this.priceNetto = price;
		this.vat = vat;
		this.type = type;
	};
	
	public Flower(){};
}
