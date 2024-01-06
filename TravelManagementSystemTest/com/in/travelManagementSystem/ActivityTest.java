package com.in.travelManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ActivityTest {

	@Test
	 void testSignUpPassenger() {
       Destination destination = new Destination("Test Destination");
       Activity activity = new Activity("Test Activity", "Description", 50, 2, destination);
       Passenger passenger1 = new Passenger("Passenger 1", 1, "standard", 100);
       Passenger passenger2 = new Passenger("Passenger 2", 2, "standard", 100);

       assertTrue(activity.signUpPassenger(passenger1));
       assertTrue(activity.signUpPassenger(passenger2));
       assertFalse(activity.signUpPassenger(new Passenger("Passenger 3", 3, "standard", 100)));
   }
	
	@Test
	 void testGetters() {
       Destination destination = new Destination("Test Destination");
       Activity activity = new Activity("Test Activity", "Description", 50, 2, destination);

       assertEquals("Test Activity", activity.getName());
       assertEquals("Description", activity.getDescription());
       assertEquals(50, activity.getCost());
       assertEquals(2, activity.getCapacity());
       assertEquals(destination, activity.getDestination());
       assertTrue(activity.getEnrolledPassengers().isEmpty());
   }

}
