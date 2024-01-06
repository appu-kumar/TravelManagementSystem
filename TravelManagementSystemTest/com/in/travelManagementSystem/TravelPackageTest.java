package com.in.travelManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;


class TravelPackageTest {
   
	 @Test
	    void testAddDestination() {
	        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
	        Destination destination = new Destination("Test Destination");
	        travelPackage.addDestination(destination);
	        assertEquals(1, travelPackage.getDestinations().size());
	    }

	    @Test
	    void testAddPassenger() {
	        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
	        Passenger passenger = new Passenger("Test Passenger", 1, "standard", 100);
	        assertTrue(travelPackage.addPassenger(passenger));
	        assertEquals(1, travelPackage.getPassengers().size());
	    }

	    @Test
	    void testPrintDetails() {
	        TravelPackage travelPackage = new TravelPackage("Test Package", 3);
	        Destination destination1 = new Destination("Mountain Resort");
	        Activity activity1 = new Activity("Hiking", "Enjoy a hike in the mountains", 20, 10, destination1);
	        destination1.addActivity(activity1);
	        travelPackage.addDestination(destination1);

	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        travelPackage.printDetails();

	        String expectedOutput = "Travel Package: Test Package\n" +
	                "\n" +
	                "Destination: Mountain Resort\n" +
	                "Activity: Hiking, Cost: 20.0, Capacity: 10, Description: Enjoy a hike in the mountains\n";

	        assertEquals(expectedOutput, outContent.toString());
	    }

	    @Test
	    void testPrintPassengerList() {
	        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
	        Passenger passenger1 = new Passenger("Passenger 1", 1, "standard", 100);
	        Passenger passenger2 = new Passenger("Passenger 2", 2, "standard", 100);
	        travelPackage.addPassenger(passenger1);
	        travelPackage.addPassenger(passenger2);

	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        travelPackage.printPassengerList();

	        String expectedOutput = "Passenger List for Travel Package: Test Package\n" +
	                "Passenger Capacity: 2\n" +
	                "Number of Passengers Enrolled: 2\n" +
	                "Passenger: Passenger 1, Passenger Number: 1\n" +
	                "Passenger: Passenger 2, Passenger Number: 2\n";

	        assertEquals(expectedOutput, outContent.toString());
	    }

	    @Test
	    void testPrintAvailableActivities() {
	        TravelPackage travelPackage = new TravelPackage("Test Package", 3);
	        Destination destination = new Destination("Mountain Resort");
	        Activity activity1 = new Activity("Hiking", "Enjoy a hike in the mountains", 20, 2, destination);
	        Activity activity2 = new Activity("Skiing", "Ski down the slopes", 30, 3, destination);
	        destination.addActivity(activity1);
	        destination.addActivity(activity2);
	        travelPackage.addDestination(destination);

	        // Sign up passengers to fill up some activities
	        Passenger passenger1 = new Passenger("Passenger 1", 1, "standard", 100);
	        Passenger passenger2 = new Passenger("Passenger 2", 2, "standard", 100);
	        Passenger passenger3 = new Passenger("Passenger 3", 3, "standard", 100);
	        travelPackage.addPassenger(passenger1);
	        travelPackage.addPassenger(passenger2);
	        travelPackage.addPassenger(passenger3);
	        passenger1.signUpForActivity(activity1);
	        passenger2.signUpForActivity(activity1);
	        passenger3.signUpForActivity(activity2);

	        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outContent));

	        travelPackage.printAvailableActivities();

	        String expectedOutput = "Available Activities:\n" +
	                "Activity: Skiing, Destination: Mountain Resort, Spaces Available: 2\n";

	        assertEquals(expectedOutput, outContent.toString());
	    }

}
