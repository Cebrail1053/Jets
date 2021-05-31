package com.skilldistillery.jets.entity;

public abstract class Jet {
	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Jet() {
		
	}
	
	public Jet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public void fly() {
		double flyingTime = range / speed;
		System.out.printf("Model: " + model + " Speed: " + speed + "mph Range: " + range
						   + " miles Flying Time: %.2f hours Price: " + price + "\n", flyingTime);
	}

	@Override
	public String toString() {
		return "Jet: " + model + ", " + speed + "mph , range = " + range + " miles , price = " + price ;
	}
	
	
}
