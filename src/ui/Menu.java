package ui;

import java.util.List;
import java.util.Scanner;

import model.Calculator;
import model.aSet;

public class Menu {
	
	private Scanner sc;
	private Calculator calc;
	private boolean hasSets;
	
//	private Set<Integer> a;
//	private Set<Integer> b;

	public Menu() {
		
		sc = new Scanner(System.in);
//		a = new HashSet<Integer>();
//		b = new HashSet<Integer>();
		calc = new Calculator();
		hasSets = false;
	}
	
	public void mainMenu() {
		
		int option = 0;

		System.out.println("\n\n--------MAIN MENU--------\n");

		System.out.println("-Set A: " + calc.getA().print());
		System.out.println("-Set B: " + calc.getB().print());

		System.out.println(
				"\nSelect an option:\n" + 
						"(1) to Add Sets" + 
						
//						"\n\n(2) for Union" + 
//						"\n(3) for Intersection" +
//						"\n(4) for Symmetric Difference"+
						
						"\n(2) for Operations" +
						"\n(3) for Deleting Sets" + 

				"\n\n(0) to exit");

		option = sc.nextInt();
		sc.nextLine();

		if(option != 0) {

			switch(option) {

			default:
				System.out.println("\n---Invalid Option");
				mainMenu();;
				break;

			case 1:
				
				if(!hasSets) {
					
					List<Integer> setA = calc.createSet(inputData('A'));
					
					for(int i = 0; i < setA.size(); i++) {
						
						calc.getA().addElement(setA.get(i));
					}
					
					calc.getA().insertionSort();
					
					List<Integer> setB = calc.createSet(inputData('B'));
					
					for(int i = 0; i < setB.size(); i++) {
						
						calc.getB().addElement(setB.get(i));
					}
					
					calc.getB().insertionSort();;
					
//					System.out.println(calc.getA().print());
//					System.out.println(calc.getB().print());
					
//					calc.setA(calc.createSet(inputData('A')));
//					calc.setB(calc.createSet(inputData('B')));
					hasSets = true;
					
				} else {
					
					System.out.println("--Sets already values");
				}
				
				mainMenu();
				break;
				
			case 2:
				
				if(hasSets) {
					
					System.out.println();
					
					aSet union = calc.getA().findUnion(calc.getB());
					aSet intersection = calc.getA().findIntersection(calc.getB());
					aSet symmDiff = calc.getA().findSymmetricDifference(calc.getB());
					
					System.out.println("-Union: " + union.print());
					System.out.println("-Intersection: " + intersection.print());
					System.out.println("-Symmetric Difference: " + symmDiff.print());
					
//					System.out.println();
//					System.out.println("-Union: " + calc.setUnion());
//					System.out.println("-Intersection: " + calc.setIntersection());
//					System.out.println("-Symmetric Difference: " + calc.setSymmetricDifference());
					
				} else {

					System.out.println("--Sets have no values");
				}
				
				mainMenu();
				break;
				
			case 3:
				
				if(hasSets) {
					
					calc.getA().getElements().removeAll(calc.getA().getElements());
					calc.getA().setSize(0);
					calc.getB().getElements().removeAll(calc.getB().getElements());
					calc.getB().setSize(0);
					
//					calc.getA().removeAll(calc.getA());
//					calc.getB().removeAll(calc.getB());
					hasSets = false;
					
				} else {
					
					System.out.println("--Sets have no values");
				}
				
				mainMenu();
				break;
			} 
			
		} else if (option == 0) {
			
			System.out.println("\n-----OPERATION ENDED-----\n");
		}
	}
	
	private String inputData(char x) {
		
		if(x == 'A') {
			
			System.out.print("\nTerms for A: ");
			
		} else if(x == 'B') {
			
			System.out.print("\nTerms for B: ");
		}
		
		String data = sc.nextLine();
		
//		System.out.println("-Input: " + data + "\n");
		
		return data;
	}
}
