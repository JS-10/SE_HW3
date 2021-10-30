package de.uni.koeln.se.state;

/**
 * All transitions implemented for Elevator
 * 
 * @author Johannes
 *
 */
public class Elevator{
	
	// Chooses current floor by random (number between 0 and 10)
	public static int current_Floor=(int) Math.rint((Math.random() * 10));;
	int dest_Floor;
	
	private Elv_States State = new Elv_States();
	
	/**
	 * Constructor
	 * 
	 * @param dest_floor
	 */
	public Elevator (int dest_floor)	{
		// Initial state of Elevator
		State.current_state = State.idle;
		this.dest_Floor=dest_floor;
		System.out.println("*** Destination floor is: "+ dest_Floor +" ***");
		System.out.println("---------------------------------------------------");
		System.out.println("All Transitions of Elevator for this sequence:");
		System.out.println("----------------------");
		System.out.println("Initial state: "+ State.current_state);
		System.out.println("----------------------");
		// If destination floor is higher than current floor, Elevator has to go up
		if(current_Floor < dest_Floor) {
			go_up();
		// Else, if destination floor is lower than current floor, Elevator has to go down	
		}else if(current_Floor > dest_Floor){
			go_down();
		// Else, Elevator is already at the right floor
		}else {
			arrive_atFloor();
		}
	}

	/**
	 * Elevator has arrived at destination floor
	 */
	private void arrive_atFloor() {
		State.current_state = State.idle;
		System.out.println("State: " + State.current_state);
		System.out.println("Current Floor is " + current_Floor);
		System.out.println("---------------------------------------------------");
		if(current_Floor == dest_Floor) {
			exit();
		}
	}

	/**
	 * Elevator is moving up
	 */
	private void go_up() {
		State.current_state = State.moving_up;
		System.out.println("State: " + State.current_state);
		current_Floor += 1;
		System.out.println("Current Floor is " + current_Floor);
		System.out.println("----------------------");
		// If destination floor is still higher than current floor, Elevator has to continue going up
		if(current_Floor < dest_Floor) {
			go_up();
		// Else, Elevator arrived at destination floor
		}else {
			arrive_atFloor();
		}
	}
	
	/**
	 * Elevator is moving down
	 */
	private void go_down() {
		State.current_state = State.moving_down;
		System.out.println("State: " + State.current_state);
		current_Floor -= 1;
		System.out.println("Current Floor is " + current_Floor);
		System.out.println("----------------------");
		// If destination floor is still lower than current floor, Elevator has to continue going down
		if(current_Floor > dest_Floor) {
			go_down();
		// Else, Elevator arrived at destination floor
		}else {
			arrive_atFloor();
		}
	}

	/**
	 * Elevator stays at its current floor and the process terminates
	 */
	private void exit() {
		System.out.println("*** Elevator has arrived at its destination. ***");
	}
}
