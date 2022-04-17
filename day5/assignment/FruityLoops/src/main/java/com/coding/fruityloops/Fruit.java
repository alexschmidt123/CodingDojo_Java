package com.coding.fruityloops;
public class Fruit {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    // CONSTRUCTOR
    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }
    // Getter
    public String getName() {
      return name;
    }

    // Setter
    public void setName(String newName) {
      this.name = newName;
    }
    
    // Getter
    public double getPrice() {
      return price;
    }

    // Setter
    public void setPrice(double newPrice) {
      this.price = newPrice;
    }
}
