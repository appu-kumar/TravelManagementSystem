package com.in.travelManagementSystem;

import java.util.ArrayList;
import java.util.List;


public class Activity {

	private String name;
	private String description;
	private double cost;
	private int capacity;
	private Destination destination;
	private List<Passenger> enrolledPassengers;

	public Activity(String name, String description, double cost, int capacity, Destination destination) {
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.capacity = capacity;
		this.destination = destination;
		this.enrolledPassengers = new ArrayList<>();
	}

	public boolean signUpPassenger(Passenger passenger) {
		if (enrolledPassengers.size() < capacity) {
			enrolledPassengers.add(passenger);
			return true;
		} else {
			return false; // Activity is full
		}
	}

	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}
	
    public Destination getDestination() {
        return destination;
    }

    public List<Passenger> getEnrolledPassengers() {
        return enrolledPassengers;
    }

}
