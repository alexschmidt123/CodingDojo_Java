import java.util.ArrayList;

public class Cart
{
	private ArrayList<Grocery> items;

	public Cart()
	{
		this.items=new ArrayList<Grocery>();
	}

	public void AddGrocery(Grocery grocery)
	{
		items.add(grocery);
	}

	public Double Checkout()
	{
		// for(int i=0;i<items.size();i++)
		// {
		// 	Grocery grocery=items.get(i);
		// }
		Double total=0D;

		for(Grocery grocery:items)
		{
			total+=grocery.GetPrice();
		}
		return total;
	}
};