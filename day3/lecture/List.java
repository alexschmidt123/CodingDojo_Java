public class List
{
	private ListNode head;
	private ListNode tail;
	private Integer length;

	public List()
	{
		this.head=null;
		this.tail=null;
		this.length=0;
	}

	Boolean Initd(Integer value)
	{
		if(this.head==null)
		{
			this.head=new ListNode(value);
			this.tail=this.head;
			this.length=1;
			return false;
		}
		return true;
	}

	Boolean IsEmpty()
	{
		return this.head==null;
	}

	void PushBack(Integer value)
	{
		if(!this.Initd(value)) return;
		this.tail.next=new ListNode(value);
		this.tail.next.previous=this.tail;
		this.tail=this.tail.next;
		this.length++;
	}

	void PushFront(Integer value)
	{
		if(!this.Initd(value)) return;
		ListNode old_head=this.head;
		this.head=new ListNode(value);
		this.head.next=old_head;
		this.head.next.previous=this.head;
		this.length++;
	}

	ListNode PopFront()
	{
		if(this.head==null) return null;
		ListNode old_head=this.head;
		this.head=this.head.next;
		if(this.head!=null) this.head.previous=null;
		this.length--;
		return old_head;
	}

	ListNode PopBack()
	{
		if(this.tail==null) return null;
		ListNode old_tail=this.tail;
		this.tail=this.tail.previous;
		if(this.tail!=null) this.tail.next=null;
		this.length--;
		return old_tail;
	}
};