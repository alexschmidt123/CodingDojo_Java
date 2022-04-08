class Node
{
	constructor(value)
	{
		this.value=value;
		this.next=null;
	}
};

class List
{
	constructor()
	{
		this.head=null;
	}

	PushBack(value)
	{
		let train_cart=this.head;

		while(train_cart.next!=null)
		{
			train_cart=train_cart.next;
		}

		train_cart.next=new Node(value);
	}
};

let list=new List();
list.head=new Node(20);
list.PushBack(30);
list.PushBack(40);
list.PushBack(50);
list.PushBack(60);
list.PushBack(70);

let train_cart=list.head;

while(train_cart!=null)
{
	console.log(train_cart.value);
	train_cart=train_cart.next;
}