package com.skilldistillery.jets.entity;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println("Open the Cargo Bay, " + this.getModel() + " load'em up!");
	}
	
}
