package com.in.travelManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Passenger implements Printable {

	
	private String name;
    private int passengerNumber;
    private String passengerType;
    private double balance;
    private List<Activity> enrolledActivities;
    
    public String getName() {
		return name;
	}

	public int getPassengerNumber() {
		return passengerNumber;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public double getBalance() {
		return balance;
	}

	public List<Activity> getEnrolledActivities() {
		return enrolledActivities;
	}


	

    public Passenger(String name, int passengerNumber, String passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.enrolledActivities = new ArrayList<>();
    }

    public boolean signUpForActivity(Activity activity) {
        if (activity.signUpPassenger(this)) {
            double cost = activity.getCost();
            if ("gold".equals(passengerType)) {
                cost *= 0.9;  // 10% discount for gold passengers
            } else if ("standard".equals(passengerType)) {
                if (cost > balance) {
                    activity.getEnrolledPassengers().remove(this);
                    return false;  // Insufficient balance for standard passenger
                }
                balance -= cost;
            }
            // For premium passengers, activities are free, no balance deduction
            enrolledActivities.add(activity);
            return true;
        } else {
            return false;  // Activity is full
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Passenger Details:");
        System.out.println("Name: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        if ("standard".equals(passengerType) || "gold".equals(passengerType)) {
            System.out.println("Balance: " + balance);
        }
        System.out.println("Enrolled Activities:");
        for (Activity activity : enrolledActivities) {
            System.out.println("- Activity: " + activity.getName() +
                    ", Destination: " + activity.getDestination().getName() +
                    ", Cost: " + activity.getCost());
        }
    }
}
