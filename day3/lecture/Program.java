/*****************************************************************************/
/* Pre Lecture: */
/*****************************************************************************/

/*
	Mention alumni and former instructor "Adrien Dion" alumni talk at

	4:00PM CST

	1:1 Meeting at 1:00PM CST. Will be away for about an hour.

	Show off memviz ( memory visualization tool )

	Show off phys engine ( extreme OOP example )
*/

/*****************************************************************************/
/* Morning Lecture: */
/*****************************************************************************/

/* What is an IDE? What does it stand for? */
/*

	Integrated Development Environment.
	Can compile and run our programs.
	Like MS Word for coding.

	Also a text editor
	Support autocompletion
	Generates getter and setters
	Syntax highlighting
	Makes packaging easier

*/

/* What are the four pillars of OOP? */
/*
	Polymorphism
	Encapsulation
	Inheritance
	Abstraction























	Encapsulation
	Inheritance
	Polymorphism
	Abstraction
*/


/* What is encapsulation? */
/*
	Keeps code organized

	Scalabity

	Wrapping data inside methods to secure
	and standardize

























	The idea of grouping members and methods (variables and functions)
	into an object, with the ability to hide information from an
	end user ( access modifiers / private / public ).
*/

/* What is inheritance? */
/*
	Child class taking on attyributes
	and methods of a parent class




























	Using the same members and methods from
	one class in another, without having
	to rewrite it all.
*/

/* What are annotations? */
/*
	metadata. notes to the compiler and other 
	developers.

	public class User
	{
		@Size(min=1,max=255)
		private String name;

		public User()
		{

		}
	};

























	A way to supply or describe information about
	a class, member or method. 
*/

/* What is so super about super? */
/*
	super is parent

	Lets us talk to parent class, optionally using its
	functionality on top of our own functionality in a
	derived, extended, or child class.
*/

/*****************************************************************************/
/* Afternoon Lecture: */
/*****************************************************************************/

/* What is polymorphism? */
/*
	methods can have same characteristics as parent but also be different and have their own methoids

	Having many forms. The ability to use a parent class'
	functionality while also being able to change it altogether.
*/

/* What is abstraction? */
	
/*
	abstraction is like your alexa that can turn your lights on and off.
	Alexa doesn't know how the light works it just knows it can be turned on and off.

	
	Hiding the fine details about
	how an object performs a task
	in order to make code easier to
	understand
*/

/* What is an interface? */
/*
	A contract that all classes implementing must abide by

	Contains abstract methods that must be implemented by the first concrete class

	Like a recipe, but without the ingredients,
	and only the steps needed in order to create
	the recipe. E.G. blank functions with
	optional default functionality.
*/

/* What is an abstract class? */
/*
	Contains abstract methods that must be implemented by the first 
	concrete class copied from john

	Something that isn’t exactly as precisely clear as one would imagine

	Its like abstract art, you don't need to know what its a painting of as long as its pretty.

	is a restricted class that cannot be used to create objects

	A class which cannot be instantiated or created.
	It is merely a basis for other classes to derive from.
	Mostly used when we need similar properties or functionality
	across different classes, where those different classes perform
	those same tasks differently.
*/

/*****************************************************************************/
/* What we're coding: */

/* An app that lets us specify how our custom data structures should each */
/* be iterated differently based on how they store information internally. */
/* Demonstrates all pillars of OOP in one place. */

/* Goals: */

/* Make an Iterable interface, so that we can have our data structures */
/* abide by a "Iterate()" method */

/* Make an Iterator class that lets us select a data structure to iterate */

/* Do Math Lib example for abstract classes. */
/*****************************************************************************/

public class Program
{
	public static void main(String[] args)
	{
		DynamicArray<Integer> arr=new DynamicArray<Integer>();
		arr.Push(123);
		arr.Push(234);
		arr.Push(345);
		arr.Push(456);
		arr.Push(567);

		List list=new List();
		list.PushFront(10);
		list.PushFront(20);
		list.PushFront(30);
		list.PushFront(40);

//		Stack stack=new Stack();
//		stack.Push(100);
//		stack.Push(200);
//		stack.Push(300);
//		stack.Push(400);
//
//		Queue queue=new Queue();
//		queue.Enqueue(300);
//		queue.Enqueue(200);
//		queue.Enqueue(100);
//		queue.Enqueue(50);

		 Iterator iterator=new Iterator();
		 iterator.SetIterable(list);
		 iterator.Iterate();
	}
};