/* What is OOP / What is it's purpose?: */

/*
	Object Oriented Programming.
	Prevent DRY (Don't repeat yourself)
	Blueprint
	Scalable
	Paradigm
*/

/* What is a class?: */

/*
	Template
	Prototype
	Blueprint
	Recipe
*/

/* What are Objects?: */

/*
	class instantiation
	have properties ( variables )
	and methods ( function )
*/

/* What is a member variable?: */

/*
	attribute or characteristic that belongs to a class
	a property of an object
*/

/* What is a method?: */

/*
	things an object can do ( actions )
	methods are functions that do stuff
	these are really just functions in a class
*/

/* What is a constructor / what is it's purpose?: */

/*
	Creates an object
	Tells you what things define the object.
	Creates a brand new recipe with all of its ingredients
	Requirements for making an instance of an object.
*/

/* What does the new keyword do?: */

/*
	Prepend the object we want to create with it.
	Creates a new object with the specified constructor
	Initializes an object instance.
*/

/*****************************************************************************/
/* Afternoon Lecture: */
/*****************************************************************************/

/* What is an access modifier?: */

/*
	Indicates who can access the attributes
	and methods of of an instance.

	Getter / Setter
*/

/* What does the public keyword do?: */

/*
	Anyone can access the member variable
	or method.
*/

/* What does the private keyword do?: */

/*
	Only the owning class has access the any
	members or functions that are marked as
	private!!!!!!!!!!!!!!!!!
*/

/* What does the static keyword do?: */

/*
	"CLASS" member or method that is accessible
	to all anyone using the class
*/

/* What is method overloading?: */

/*
	Fork in the road!!!
	We can have multiple versions of the
	same function, but their arguments or
	their return is different.
*/

/* What does the "this" keyword do?: */

/*
	Refers to the most immediate scope or
	context

	serves as a reference to the current class
	memebers and properties

	tool to access data in object.

	A way to refer to each unique instance of a class within the class itself.
*/

/*****************************************************************************/
/* Make a grocery cart app together.*/
/* Make "Shopper","Cart", and "Grocery" classes */
/*****************************************************************************/

public class Program
{
	public static void main(String[] args)
	{
		System.out.println(Grocery.GetInventory());

		Grocery bananas=new Grocery("Bananas","You eat em, duh?",3.99);
		Grocery honey_buns=new Grocery("Honey Buns","Drown yourself in sadness",4.99);
		Grocery hot_dogs=new Grocery("Hot Dogs","Oscar Meyer",2.99);
		Grocery nutty_butty=new Grocery("Nutty Buddy","MMmmmm...",6.99);

		System.out.println(Grocery.GetInventory());

		Shopper mama=new Shopper();
		mama.AddGrocery(bananas);
		mama.AddGrocery(honey_buns);
		mama.AddGrocery(hot_dogs);

		System.out.println(mama.Checkout());
	}
};