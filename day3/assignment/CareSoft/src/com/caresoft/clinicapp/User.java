package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected Integer pin;
    
    // TO DO: Getters and setters
	// Implement a constructor that takes an ID
    
    public User(Integer id) {
    	this.id = id;
    }
    public void SetId(Integer _id) {
    	id = _id;
    }
    
    public Integer GetId() {
    	return id;
    }
    
    public void SetPin (Integer pin) {
    	this.pin = pin;
    }
    public void GetPin() {
    }
}