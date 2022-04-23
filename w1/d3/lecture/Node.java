public class Node
{
	public Node next;
	public Node previous;
	public Integer value;

	public Node(Integer value)
	{
		this.next=null;
		this.previous=null;
		this.value=value;
	}
};