public class Shopper
{
	public String first_name;
	private String email;
	private Cart cart;

	public Shopper()
	{
		this.first_name="John";
		this.email="John@Doe.com";
		this.cart=new Cart();
	}

	private Shopper(String _first_name,String _email)
	{
		// first_name=_first_name;
		// email=_email;

		this.first_name=_first_name;
		this.email=_email;
	}

	public void AddGrocery(Grocery grocery)
	{
		this.cart.AddGrocery(grocery);
	}

	public Double Checkout()
	{
		return this.cart.Checkout();
	}
};