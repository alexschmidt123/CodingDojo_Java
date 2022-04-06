public class DynamicArray<T>
{
	private static Integer scale=16;
	private Object items[];
	private Integer length;
	private Integer capacity;

	public DynamicArray()
	{
		length=0;
		capacity=DynamicArray.scale;
		items=new Object[capacity];
	}

	public Integer Length()
	{
		return length;
	}

	public Integer Capacity()
	{
		return capacity;
	}

	public void Push(T object)
	{
		if(length+1>capacity)
		{
			capacity+=DynamicArray.scale;

			Object old_items[]=new Object[length];
			for(int i=0;i<items.length;i++)
			{
				old_items[i]=items[i];
			}
			items=new Object[capacity];
			for(int i=0;i<old_items.length;i++)
			{
				items[i]=old_items[i];
			}
			System.out.println("UPSCALED TO:"+capacity);
		}
		items[length++]=object;
	}

	@SuppressWarnings("unchecked")
	public T Pop()
	{
		if(length<=0) return null;
		T last_item=(T)items[length-1];
		if((capacity-length)+1>=scale)
		{
			capacity-=DynamicArray.scale;
			Object old_items[]=new Object[capacity];
			for(int i=0;i<capacity;i++)
			{
				old_items[i]=items[i];
			}
			items=new Object[capacity];
			for(int i=0;i<capacity;i++)
			{
				items[i]=old_items[i];
			}
			System.out.println("DOWNSCALED TO:"+capacity);
		}
		length--;
		return last_item;
	}

	public void Set(Integer index,T value)
	{
		if(index<0||index>length) return;
		items[index]=value;
	}

	@SuppressWarnings("unchecked")
	public T Get(Integer index)
	{
		if(index<0||index>length) return null;
		return (T)items[index];
	}
};