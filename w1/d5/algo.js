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

	Iterate()
	{
		let str="";
		for(let node=this.head;node;node=node.next)
		{
			str+=node.value+"->";
		}
		console.log(str);
	}

	/* Add all nodes of the supplied list to this list */
	Concat(other_list)
	{
		/* Your Code Here */
	}

	/* Finds the node with the smallest value and moves it to the front. */
	MinToFront()
	{
		/* Your Code Here */
	}

	/* Split our list into two lists, where the second list starts with the node */
	/* that has the given value */
	Split(value)
	{
		/* Your Code Here */
	}
};
/*****************************************************************************/
/* Code Tests Below */
/*****************************************************************************/

/* Creates our list */
let list=new List();
let list2=new List();

/* ( Use your solution from day 1 for this to work! ) */
/* Remember, it just shoves all of these into our list! */
list.PushBackN([765,234,545,112]);
list2.PushBackN([65,567,433,656]);

list=list.Concat(list2);
list.Iterate();
/*
	Expected:765->234->545->112->65->567->433->656
*/
list.MinToFront();
list.Iterate();
/*
	Expected:65->765->234->545->112->567->433->656
*/
let split_list=list.Split(545);
list.Iterate();
split_list.Iterate();
/*
	Expected:65->765->234->
	Expected:545->112->567->433->656
*/