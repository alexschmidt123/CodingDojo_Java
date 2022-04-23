import java.util.HashMap;

public class Maps
{
	public static void main(String[] args)
	{
		HashMap<String,String> student=new HashMap<String,String>();

		student.put("first_name","Eljiah");
		student.put("last_name","Dlubak");
		student.put("email","elijah@dlubak.com");

		String elijahs_email=student.get("email");

		System.out.println(elijahs_email);

		for(String key:student.keySet())
		{
			System.out.println( key+":"+student.get(key) );
		}
	}
};