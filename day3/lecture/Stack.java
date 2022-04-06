public class Stack extends List
{
	public Stack()
	{
		super();
	}

	public void Push(Integer value)
	{
		super.PushFront(value);
	}

	public ListNode Pop()
	{
		return super.PopFront();
	}
};