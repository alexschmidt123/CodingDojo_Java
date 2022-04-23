public class Queue extends List
{
	public Queue()
	{
		super();
	}

	public void Enqueue(Integer value)
	{
		super.PushBack(value);
	}

	public Node Dequeue()
	{
		return super.PopFront();
	}
};