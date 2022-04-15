package com.caresoft.clinicapp;
import java.util.ArrayList;
import java.util.Date;
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{

    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    public AdminUser(Integer id, String role){
    	super(id);
    	this.setRole(role);
    	this.securityIncidents = new ArrayList<String>();
    }
    
    public ArrayList<String> Report(){
    	return securityIncidents;
    }
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    public boolean assignPin(Integer pin) {
    	if (pin < 100000 && pin > 999999) {
    		System.out.println("Pin must be at least 6 digits.");
    		return false;
    	}
    	return true;
    }
    public boolean accessAuthorized(Integer confirmedAuthID){
    	if(this.id == confirmedAuthID) {
    		return true;
    	}else {
    		authIncident();
    		return false;
    	}
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
    
    // TO DO: Setters & Getters
}
