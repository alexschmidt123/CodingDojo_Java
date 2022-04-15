package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class Physician extends User implements HIPAACompliantUser{
    public Physician(Integer id) {
    	super(id);
    }
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int pin) {
    	if (pin < 1000 || pin > 9999) {
    		System.out.println("Pin must be at least 4 digits.");
    		return false;
    	}
    	this.pin = pin;
    	return true;
    };
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	return this.id == confirmedAuthID;
    };
    
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
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
