
public class Iterator
{
	private Iterable iterable;
	
	public Iterator()
	{
		
	}
	
	public void SetIterable(Iterable iterable)
	{
		this.iterable=iterable;
	}
	
	public Iterable GetIterable()
	{
		return iterable;
	}
	
	public void Iterate()
	{
		iterable.Iterate();
	}
};