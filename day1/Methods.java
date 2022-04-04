public class Methods
{
	public static void main(String[] args)
	{
		int result = Add(50,100);
		// Log( "asdasd" );
		// Log(result);

		String str_result=Integer.toString(result);
		Log(str_result);
	}

	public static int Add(int a,int b)
	{
		return a+b;
	}

	public static void Log(String msg)
	{
		System.out.println(msg);
	}

	public static void Log(int msg)
	{
		System.out.println(msg);
	}
};