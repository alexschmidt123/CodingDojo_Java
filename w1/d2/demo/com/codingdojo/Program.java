public class Program
{
    public static void main(String[] args)
	{
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String general_greeting = "Welcome to Cafe Java, ";
        String pending_message = ", your order will be ready shortly";
        String ready_message = ", your order is ready";
        String display_total_message = "Your total is $";
        
        // Menu variables (add yours below)
        double mocha_price = 4.99;
		double coffee=3.99;
		double cappucino=4.49;
		double latte=6.99;
		
        // Customer name variables (add yours below)
        String customer1="Cindhuri";
		String customer2="Sammy";
		String customer3="Jimmy";
		String customer4="Noah";
    
        // Order completions (add yours below)
        boolean is_ready1 = true;
        boolean is_ready2 = false;
        boolean is_ready3 = true;
        boolean is_ready4 = false;
    
		if(is_ready1)
		{
			System.out.println(customer1+ready_message);
		}
		else
		{

		}

		if(is_ready4)
		{
			System.out.println(customer4+ready_message+". "+display_total_message+cappucino);

		}

		if(is_ready2)
		{
			System.out.println(customer2+ready_message+". "+display_total_message+(latte*2));
		}

		if(is_ready3)
		{
			double jimmys_total=latte-coffee;
			System.out.println(customer3+ready_message+". "+display_total_message+jimmys_total);
		}
	}
}
