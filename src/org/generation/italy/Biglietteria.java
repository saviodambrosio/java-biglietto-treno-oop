package org.generation.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		
	////// LAVORO SVOLTO NELLA SALA ROOM 1 ///////
		
		Scanner scanner = new Scanner(System.in);
		int age; int km;
		boolean flessibile;
		String sceltaflessibile = "";
		
		try {
			System.out.print("How many kilometers do you want to do? km:");
			km = scanner.nextInt();
			System.out.print("How old are you? Age:");
			age = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Do you want a flexible ticket? Type yes or no (yes/no)");
			sceltaflessibile = scanner.nextLine();
			if (sceltaflessibile.equalsIgnoreCase("yes")) {
				flessibile = true;
			}else {
				flessibile = false;
			}
			
			Biglietto biglietto = new Biglietto(km,age);
			System.out.println(biglietto.calcolaPrezzo());
			System.out.println("Data di scadenza del biglietto: ");
			System.out.println(biglietto.calcolaDataScadenza());
		}catch(Exception e) {
			System.out.println("Insert a valid age (0 to 150) and the right amount of kms(1 to 10000)");
		}
		 scanner.close();

	}

}
