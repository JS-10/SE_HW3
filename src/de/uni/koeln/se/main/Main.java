package de.uni.koeln.se.main;

import java.util.Scanner; 

import de.uni.koeln.se.state.Elevator;
import de.uni.koeln.se.state.Elv_States;

/**
 * Main class to demonstrate process of state machine diagram "Elevator" 
 * 
 * @author Johannes
 *
 */
public class Main {
	public static void main(String[] args) 	{
		
		Scanner in = new Scanner(System.in); 
		
		System.out.println("Current Floor is " + Elevator.current_Floor); 
       
		System.out.println("Enter destination Floor: (0 to 10):"); 
		
		int dest_floor = in.nextInt(); 

		// If input is not a number between 0 and 10, user has to select again until input is valid 
		while(dest_floor < 0 || dest_floor > 10) {
			System.out.println("Input not valid - Enter destination Floor: (0 to 10):"); 
			dest_floor = in.nextInt(); 
		}
		
		// Process starts only if input is valid
		if(dest_floor >= 0 || dest_floor <= 10) {
			in.close();
			System.out.println("---------------------------------------------------");
			new Elevator(dest_floor);
			System.out.println("---------------------------------------------------");
		}
		
	}

}
