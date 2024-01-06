package com.in.travelManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class PassengerTest {
	 @Test
	    void signUpForActivity() {
	        Passenger passenger = new Passenger("Test Passenger", 1, "standard", 100);
	        Activity activity = new Activity("Test Activity", "Description", 50, 2, new Destination("Test Destination"));

	        assertTrue(passenger.signUpForActivity(activity));
	        assertEquals(1, passenger.getEnrolledActivities().size());
	        assertEquals(50, passenger.getBalance());

	        // Test signing up with insufficient balance
	        assertFalse(passenger.signUpForActivity(new Activity("Another Activity", "Description", 150, 2, new Destination("Another Destination"))));
	        assertEquals(1, passenger.getEnrolledActivities().size()); // Ensure no additional activities added
	        assertEquals(50, passenger.getBalance()); // Ensure balance remains unchanged

	        // Test signing up for a full activity
	        Activity fullActivity = new Activity("Full Activity", "Description", 30, 1, new Destination("Full Destination"));
	        Passenger anotherPassenger = new Passenger("Another Passenger", 2, "standard", 100);
	        anotherPassenger.signUpForActivity(fullActivity);
	        assertTrue(passenger.signUpForActivity(fullActivity)); // Should still allow if the activity is full for another passenger
	        assertEquals(2, passenger.getEnrolledActivities().size());
	    }

	    @Test
	    void getters() {
	        Passenger passenger = new Passenger("Test Passenger", 1, "standard", 100);

	        assertEquals("Test Passenger", passenger.getName());
	        assertEquals(1, passenger.getPassengerNumber());
	        assertEquals("standard", passenger.getPassengerType());
	        assertEquals(100, passenger.getBalance());
	        assertTrue(passenger.getEnrolledActivities().isEmpty());
	    }

}
