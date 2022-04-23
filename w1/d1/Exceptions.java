public class Exceptions
{
	public static void main(String[] args)
	{
		int arr[]={10,20,30,40,50};
		System.out.println(arr[5]);
	
		try
		{
			/* this runs if there is no error. */
			System.out.println(arr[5]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("You went outta bounds!");
			/* run this code if there is the above problem. */
		}
	}
};