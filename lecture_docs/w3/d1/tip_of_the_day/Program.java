import java.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;

/* Java has lambdas / arrow / anonymous functions too you know... */

public class Program
{
	@SuppressWarnings("unchecked")
	public static void Iterate(ArrayList<String> arr,Function fn)
	{
		for(String str:arr) fn.apply(str);
	}

	public static void main(String[] args)
	{
		ArrayList<String> waltons=new ArrayList<>();
		waltons.add("JimBob");
		waltons.add("Mary Ellen");
		waltons.add("JohnBoy");
		waltons.add("Liv");
		waltons.add("John");
		waltons.add("Esther");
		waltons.add("Jason");
		waltons.add("Elizabeth");

		Iterate(waltons,(walton)->{
			System.out.println(walton);
			return null;
		});
	}
};