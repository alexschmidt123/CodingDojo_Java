public class Grocery
{
	private String name;
	private String description;
	private Double price;
	private static Integer num_groceries=0;

	public Grocery()
	{
		this.name="DefaultItem";
		this.description="This is the default item";
		this.price=0D;
		Grocery.num_groceries++;
	}

	public Grocery(String name,String description,Double price)
	{
		this.name=name;
		this.description=description;
		this.price=price;
		Grocery.num_groceries++;
	}

	public void SetPrice(Double price)
	{
		if(price<0) return;
		this.price=price;
	}

	public Double GetPrice()
	{
		return price;
	}

	public static Integer GetInventory()
	{
		return num_groceries;
	}
};