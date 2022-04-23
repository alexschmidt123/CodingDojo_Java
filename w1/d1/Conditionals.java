public class Conditionals
{
	public static void main(String[] args)
	{
		int a = 10;
		int b = 20;

		// if(b > a)
		// {
		// 	System.out.println("B is Bigger!");
		// }
		// else if(a == b)
		// {
		// 	System.out.println("A is equal to B!");
		// }
		// else
		// {
		// 	System.out.println("A is Bigger!");
		// }

		int i = 1;

		switch(i)
		{
			case 0:
			{
				System.out.println("I is 0");
				break;
			}
			case 1:
			{
				System.out.println("I is 1");
				break;
			}
			case 2:
			{
				System.out.println("I is 2");
				break;
			}
			default:
			{
				System.out.println("I run when none of the above are true!");
			}
		}
	}
};