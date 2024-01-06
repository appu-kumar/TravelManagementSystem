package com.in.travelManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;


class DestinationTest {
	 @Test
	    void testAddActivity() {
	        Destination destination = new Destination("Test Destination");
	        Activity activity1 = new Activity("Activity 1", "Description 1", 30, 10, destination);
	        Activity activity2 = new Activity("Activity 2", "Description 2", 40, 15, destination);

	        destination.addActivity(activity1);
	        destination.addActivity(activity2);

	        List<Activity> activities = destination.getActivities();

	        assertEquals(2, activities.size());
	        assertEquals("Activity 1", activities.get(0).getName());
	        assertEquals("Activity 2", activities.get(1).getName());
	    }

	    @Test
	    void testGetters() {
	        Destination destination = new Destination("Test Destination");

	        assertEquals("Test Destination", destination.getName());
	        assertEquals(0, destination.getActivities().size());
	    }

}
