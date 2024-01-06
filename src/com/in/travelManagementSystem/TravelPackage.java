package com.in.travelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage implements Printable {

	
	private String name;
    private int passengerCapacity;
    private List<Destination> destinations;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        } else {
            return false;  // Travel package is full
        }
    }

    public String getName() {
		return name;
	}

	public int getPassengerCapacity() {
		return passengerCapacity;
	}

	public List<Destination> getDestinations() {
		return destinations;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}



	@Override
    public void printDetails() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : destinations) {
            System.out.println("\nDestination: " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() +
                        ", Cost: " + activity.getCost() +
                        ", Capacity: " + activity.getCapacity() +
                        ", Description: " + activity.getDescription());
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers Enrolled: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName() +
                    ", Passenger Number: " + passenger.getPassengerNumber());
        }
    }

    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : destinations) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getEnrolledPassengers().size() < activity.getCapacity()) {
                    System.out.println("Activity: " + activity.getName() +
                            ", Destination: " + activity.getDestination().getName() +
                            ", Spaces Available: " + (activity.getCapacity() - activity.getEnrolledPassengers().size()));
                }
            }
        }
    }
}
