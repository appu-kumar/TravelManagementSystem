package com.in.travelManagementSystem;

public class Main {

	public static void main(String[] args) {
		
		 // Creating Destinations
        Destination destination1 = new Destination("Punjab");
        Destination destination2 = new Destination("chandigarh");

        // Creating Activities
        Activity activity1 = new Activity("golden temple", "Nice temple,cleaness,colorful fish etc.", 20, 10, destination1);
        Activity activity2 = new Activity("rock garden", "Explore the buildings, which have been made of waste rocks.", 30, 15, destination2);

        // Adding Activities to Destinations
        destination1.addActivity(activity1);
        destination2.addActivity(activity2);

        // Creating Passengers
        Passenger passenger1 = new Passenger("Alice", 1, "standard", 100);
        Passenger passenger2 = new Passenger("Bob", 2, "gold", 150);
        Passenger passenger3 = new Passenger("Charlie", 3, "premium",0);

        // Creating Travel Package
        TravelPackage travelPackage = new TravelPackage("Adventure Package", 3);

        // Adding Destinations to Travel Package
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        // Adding Passengers to Travel Package
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        // Passenger Signing up for Activities
        passenger1.signUpForActivity(activity1);
        passenger2.signUpForActivity(activity2);
        passenger3.signUpForActivity(activity1);

        // Printing Itinerary, Passenger List, and Available Activities
        travelPackage.printDetails();
        travelPackage.printPassengerList();
        travelPackage.printAvailableActivities();

        // Printing Individual Passenger Details
        passenger1.printDetails();


	}

}
