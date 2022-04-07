class Node
{
	constructor(value)
	{
		this.next=undefined;
		this.value=value;
	}
};

class List
{
	constructor()
	{
		this.head=undefined;
	}

	IsEmpty(){}
	PushBack(value){}
	PushBackN(arr){}
	Iterate(fn)
	{
		for(let node=this.head;node;node=node.next){fn(node.value);}
	}
	PushFront(value){}
	PopFront(){}
	Average(){}
	Contains(value){}
	ContainsR(node,value){}
	PopBack(){}
	MaxR(node){}

	/* Return the second to last node's value in the list */
	SecondToLast()
	{
		/* Your Code Here */
	}

	/* Remove a node whose value matches the given value */
	/* ( You will need to fix .next pointers too! ) */
	RemoveValue(value)
	{
		/* Your Code Here */
	}

	/* Inserts a new node before a node whose value is the search_value. */
	/* Example: */
	/*
		Before:
		10
		30
		40

		Prepend(20,30)

		After:
		10
		20
		30
		40
	*/
	Prepend(new_value,search_value)
	{
		/* Your Code Here */
	}
};
/*****************************************************************************/
/* Code Tests Below */
/*****************************************************************************/

/* Creates our list */
let list=new List();

/* ( Use your solution from day 1 for this to work! ) */
/* Remember, it just shoves all of these into our list! */
list.PushBackN([111,222,333,444,555,666]);

console.log(list.SecondToLast()) /* Expected: 555 */

list.RemoveValue(333); /* No Output */

/* I'm a freebie, don't delete me! */
list.Iterate(value=>console.log(value));
/*
	Expected Output after RemoveValue(333):
	111
	222
		<-- this was 333
	444
	555
	666
*/

list.Prepend(333,444);

/* I'm a freebie, don't delete me! */
list.Iterate(value=>console.log(value));
/*
	Expected Output after Prepend(333,444):
	111
	222
	333 <- 333 should be back
	444
	555
	666
*/
