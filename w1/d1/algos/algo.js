let Bench=require("./Bench");

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

	/* Determine whether the list is empty. */
	IsEmpty()
	{
		/* Your Code Here */
	}

	/* Insert a node with the given value to the end of the list */
	PushBack(value)
	{
		/* Your Code Here */
	}

	/* Insert an array of nodes with the given values to the end of the list. */
	PushBackN(arr)
	{
		/* Your Code Here */
	}

	Iterate(fn)
	{
		for(let node=this.head;node;node=node.next){fn(node.value);}
	}
};

let test_data1=123;
let test_data2=234;
let test_data3=345;
let test_data4=[111,222,333,444,555];

/* Create our list */
let list=new List();
/* Insert nodes into the list: */
list.PushBack(test_data1);
list.PushBack(test_data2);
list.PushBack(test_data3);
/* Insert array of nodes into the list: */
list.PushBackN(test_data4);
/* Iterate our list, so we can see our node values */
list.Iterate(value=>console.log(value));
/* Expected output: */
/*
	123
	234
	345
	111
	222
	333
	444
	555
*/

/* If you want to see how long your code takes to execute: */

// Bench.Mark(list.PushBack,test_data1);
// Bench.Mark(list.PushBack,test_data2);
// Bench.Mark(list.PushBack,test_data3);
// Bench.Mark(list.PushBackN,test_data4);

/*
	Group Activity: See whose CPU is the fastest.
	Make a poll where students post their results.
*/

/* 	Uncomment if you dare */
// function OwMyCPU()
// {
// 	for(let i=1;i<=10000;i++)
// 	{
// 		list.PushBack(i*i*i);
// 	}
// }
// Bench.Mark(OwMyCPU);