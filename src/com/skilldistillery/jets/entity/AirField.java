package com.skilldistillery.jets.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets;
	
	public AirField() {
		
	}

	public List<Jet> getJets() {
		return jets;
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
	
	
	
	public List<Jet> createJets(List<String> jetList) {
		jets = new ArrayList<>();
		for(String strValue : jetList) {
			String[] line = strValue.split(",");

			Jet entry;

			if (line[4].equals("Fighter")) {
				entry = new FighterJet(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]),
						Long.parseLong(line[3]));
			} else if (line[4].equals("Cargo")) {
				entry = new CargoPlane(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]),
						Long.parseLong(line[3]));
			} else {
				entry = new JetImpl(line[0], Double.parseDouble(line[1]), Integer.parseInt(line[2]),
						Long.parseLong(line[3]));
			}

			jets.add(entry);
		}
		return jets;
	}
	
	public void listFleet() {
		for(Jet jetType : jets) {
			System.out.println(jetType);
		}
		System.out.println();
	}
	
	public void flyAllJets() {
		for(Jet jetType : jets) {
			jetType.fly();
		}
		System.out.println("All Jets ready for flight!");
		System.out.println();
	}
	
	public void fastestJet() {
		double fastestJet = jets.get(0).getSpeed();
		int index = 0;
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getSpeed() > fastestJet) {
				fastestJet = jets.get(i).getSpeed();
				index = i;
			}
		}
		System.out.println(jets.get(index));
		System.out.println();
	}
	
	public void longestRangeJet() {
		double rangeJet = jets.get(0).getRange();
		int index = 0;
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getRange() > rangeJet) {
				rangeJet = jets.get(i).getRange();
				index = i;
			}
		}
		System.out.println(jets.get(index));
		System.out.println();
	}
	
	public void loadCargoJets() {
		for(Jet jetType : jets) {
			if(jetType instanceof CargoPlane) {
				((CargoPlane) jetType).loadCargo();
			}
		}
		System.out.println("All Cargo Jets loaded!!! Ready for your orders. \n");
	}

	public void dogfight() {
		for(Jet jetType : jets) {
			if(jetType instanceof FighterJet) {
				((FighterJet) jetType).fight();
			}
		}
		System.out.println("All Fighter Jets deployed and in Battle!!! \n");
	}
	
	public void addJet(int choice, String model, double speed, int range, long price) {
		Jet entry = null;
		switch(choice) {
		case 1:
			entry = new FighterJet(model, speed, range, price);
			break;
		case 2:
			entry = new CargoPlane(model, speed, range, price);
			break;
		case 3:
			entry = new JetImpl(model, speed, range, price);
			break;
		default:
			System.out.println("Invalid Choice! No Jet Added\n");
		}
		
		jets.add(entry);
	}
	
	public void removeJet(Scanner kb) {
		System.out.println("Which jet would you like to remove:");
		for(int i = 0; i < jets.size(); i++) {
			System.out.print(i+1 + ". " + jets.get(i).getModel() + "\n");
		}
		int choice = kb.nextInt();
		
		try {
			jets.remove(choice - 1);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds\n");
		}
	}
}
