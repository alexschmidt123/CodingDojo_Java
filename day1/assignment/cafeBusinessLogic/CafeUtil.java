import java.util.ArrayList;
import java.util.Scanner;
public class CafeUtil {
    public int getStreakGoal(int numWeeks) {
        int totalVisitCount = 0;
        for (int visitCount = 0; visitCount <= numWeeks; visitCount++) {
            totalVisitCount += visitCount;
        }
        return totalVisitCount;
    }
    public double getOrderTotal(double[] price){
        double totalPrice = 0;
        for (int orderCount = 0; orderCount < price.length; orderCount++){
            totalPrice += price[orderCount];
        }
        return totalPrice;
    }
    public void displayMenu(ArrayList<String> menuItems){
        for (int menuCount=0; menuCount<menuItems.size(); menuCount++){
            System.out.printf("%s %s \n",menuCount,menuItems.get(menuCount));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        customers.add(userName);
        System.out.printf("Hi, %s! There are %s people ahead of you. \n", userName, customers.size()-1);
        System.out.println(customers);

    }
}
