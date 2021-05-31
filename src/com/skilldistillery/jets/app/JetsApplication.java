package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.CargoPlane;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.Jet;
import com.skilldistillery.jets.entity.JetImpl;

public class JetsApplication {
	private AirField airField;
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	private void launch() {
		airField = new AirField();
		List<String> jetValues = new ArrayList<>();
		readJetValuesFromFile(jetValues);
		
		// Populate the Airfield with Jets
		airField.createJets(jetValues);
		
		int selection = 0;
		
		// Display Menu & Take user selection
		do {
			dispalyUserMenu();
			selection = kb.nextInt();
			kb.nextLine();
			System.out.println();
			userChoice(selection);
			
		} while (selection != 9);
		
		kb.close();
	}

	public void readJetValuesFromFile(List<String> strList) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("jets.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				strList.add(line);
			}
			br.close();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private void dispalyUserMenu() {
		System.out.println("------- Menu -------");
		System.out.println("1. List Fleet");
		System.out.println("2. Fly All Jets");
		System.out.println("3. View Fastest Jet");
		System.out.println("4. View Jet with Longest Range");
		System.out.println("5. Load All Cargo Jets");
		System.out.println("6. Dogfight!");
		System.out.println("7. Add a Jet to Fleet");
		System.out.println("8. Remove a Jet from Fleet");
		System.out.println("9. Quit");
	}

	public void userChoice(int selection) {
		switch(selection) {
		case 1:
			airField.listFleet();
			break;
		case 2:
			airField.flyAllJets();
			break;
		case 3:
			airField.fastestJet();
			break;
		case 4:
			airField.longestRangeJet();
			break;
		case 5:
			airField.loadCargoJets();
			break;
		case 6:
			airField.dogfight();
			break;
		case 7:
			printJetTypeMenu();
			int choice = kb.nextInt();
			kb.nextLine();
			
			System.out.print("Enter a name/model: ");
			String name = kb.nextLine();
			
			System.out.print("Enter the speed of the jet: ");
			double speed = kb.nextDouble();
			kb.nextLine();
			
			System.out.print("Enter the range of the jet: ");
			int range = kb.nextInt();
			kb.nextLine();
			
			System.out.print("Enter a price: ");
			long price = kb.nextLong();
			kb.nextLine();
			
			airField.addJet(choice, name, speed, range, price);
			break;
		case 8:
			airField.removeJet(kb);
			break;
		case 9:
			System.out.println("GoodBye Commander!");
			break;
		default:
			System.out.println("Invalid Input! Try Again");
		}
	}
	
	public void printJetTypeMenu() {
		System.out.println("Select a Jet Type:");
		System.out.println("--------------");
		System.out.println("1. Fighter");
		System.out.println("2. Cargo");
		System.out.println("3. Generic");
	}
}
