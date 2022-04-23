/* Doubly Linked Lists! */

class Node
{
	constructor(value)
	{
		this.next=undefined;
		this.previous=undefined;
		this.value=value;
	}
};

class DList
{
	constructor()
	{
		this.head=undefined;
	}

	/* 
		Description:
		Inserts a new node with the given value at the FRONT of the list.
	 */
	/* Time: O(1) */
	/* Space: O(1) */
	PushFront(value)
	{
		/* Your Code Here */
	}

	/* 
		Description:
		Inserts a new node with the given value at the END of the list.
	 */
	/* Time: O(1) */
	/* Space: O(1) */
	PushBack(value)
	{
		/* Your Code Here! */
	}

	Log()
	{
		let str="";
		for(let r=this.head;r;r=r.next) str+=r.value+"->";
		console.log(str);
	}
};

/*****************************************************************************/
/* Code Tests Below: */
/*****************************************************************************/
let list=new List();
list.PushBack(10);
list.PushBack(20);
list.PushBack(30);
list.PushFront(40);
list.Log(); /* Expected: 40->10->20->30 */