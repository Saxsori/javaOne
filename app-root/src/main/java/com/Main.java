package com;

import com.menu.Global;
import com.menu.Menu;

import java.util.Scanner;
import java.util.Arrays;


class Main implements Global {
	
	static Menu menu;
	
	/*
	 * 
	 * Main function where evrything starts
	 * First it prints the main menu
	 * Then it takes the user choice
	 * Then it calls the function that the user wants
	 * Also it has a loop that keeps the program running until the user wants to exit
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		while (true) {
			if (choice == 3)
			break;
			menu.out.printMain();
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			switch (choice) {
	        	case 1:
		        	menu.sortFeatures();
		        	break ;
		        case 2:
					menu.out.printCategory(Option.ALL);
		        	menu.makeOrder();
		        	break ;
		        case 3:
	          		System.out.println("Bye !");
					break ;
		        default:
		          System.out.println("Sorry This Service Doesn't Exist please Try Agian !");
				  break ;
	      	}
		}
	}
}
