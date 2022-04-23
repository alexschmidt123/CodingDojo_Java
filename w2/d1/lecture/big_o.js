/*****************************************************************************/
/* 		Order Of		|		Complexity		|  		Growth Rate			 */
/*****************************************************************************/
/* 		O(1)			|		Constant		|  		FASTEST				 */
/*****************************************************************************/
/* 		O(log N)		|		Logarithmic		|  							 */
/*****************************************************************************/
/* 		O(N)			|		Linear			|  							 */
/*****************************************************************************/
/* 		O(N log N)		|		Log Linear		|  							 */
/*****************************************************************************/
/* 		O(N^2)			|		Quadratic		|  							 */
/*****************************************************************************/
/* 		O(N^3)			|		Cubic			|  							 */
/*****************************************************************************/
/* 		O(2^N)			|		Exponential		|  							 */
/*****************************************************************************/
/* 		O(N!)			|		Factorial		|  		SLOWEST				 */
/*****************************************************************************/

/* Big O Notation is merely a way to track the performance or memory */
/* consumption of an algorithm. */

/* The "O" in Big O stands for "Order Of" */

/* We normally look for the worst case scenario (Upper Bound) when talking */
/* about run-time or space-time complexity. */

/* Logarithm recap: Logarithms are the inverse to exponentiation. */
/* Much like addition is the inverse of subtraction. */

/* If we write log2(128)=7, we can think of this as saying "How many 2s" */
/* "do we need to multiply to get to 128?" 2*2*2*2*2*2*2=128 */

/* With Big O notation, we drop constants, such as the exponent */
/* of a base in a log, because we really only care about how an algorithm */
/* performs. */

/*****************************************************************************/
/* Time Complexity: O(1) - Constant */
/* Space Complxity: O(1) - Constant */
/* N:8 */
/* Description: Squares the given number */
/*****************************************************************************/
function constant(n)
{
	return n*n; /* 8*8=64 */
}
/*****************************************************************************/
/* Time Complexity:  O(log N) - Logarithmic */
/* Space Complexity: O(1) 	  - Constant */
/* N:64 */
/* Description: Determines the number of bits the given number contains. */
/* Divides the input or number of operations it must perform in */
/* half each iteration. */
/*****************************************************************************/
function logarithmic(n)
{
	let bits=0;
	while(n)
	{
		n>>=1; 	/* 64,32,16,8,4,2,1,0 */
		bits++; /* 1,2,3,4,5,6,7 */
	}
	return bits;
}
/*****************************************************************************/
/* Time Complexity:  O(N) - Linear */
/* Space Complexity: O(1) - Constant */
/* N:arr.length */
/* Determines whether the given number exists in the given array. */
/*****************************************************************************/
function linear(arr,k)
{
	for(let i=0;i<arr.length;i++)
	{
		if(arr[i]==k) return true;
	}
	return false;
}
/*****************************************************************************/
/* Time Complexity:  O(N log N) - Log Linear */
/* Space Complexity: O(N) - Linear */
/* N:arr.length */
/* Description: Determines the number of bits of each number in the given array */
/* Runs our logarithmic bit calculating function for each element in the array.*/
/*****************************************************************************/
function log_linear(arr)
{
	let new_arr=[];
	for(let i=0;i<arr.length;i++)
	{
		new_arr[i]=logarithmic(arr[i]);
	}
	return new_arr;
}
/*****************************************************************************/
/* Time Complexity:  O(N^2) - Quadratic */
/* Space Complexity: O(1)   - Constant */
/* N:arr.length */
/* Description:Determines the sum of all values in the given 2d array. */
/*
	arr2d=
	[
		[10,20,30],
		[40,50,60],
		[70,80,90]
	]
*/
/*****************************************************************************/
function quadratic(arr2d)
{
	let sum=0;
	for(let i=0;i<arr2d.length;i++)
	{
		for(let j=0;j<arr2d[i].length;j++)
		{
			sum+=arr2d[i][j];
		}
	}
	return 0;
}
/*****************************************************************************/
/* Time Complexity:  O(N^3) - Cubic */
/* Space Complexity: O(1)   - Constant */
/* N:arr.length */
/* Determines the sum of all values in the given 3d array. */
/*
	arr3d=
	[
		[
			[10,20,30],
			[40,50,60],
			[70,80,90]
		],
		[
			[100,110,120],
			[130,140,150],
			[160,170,180]

		],
		[
			[190,200,210],
			[220,230,240],
			[250,260,270]
		]
	]
*/
/*****************************************************************************/
function cubic(arr3d)
{
	let sum=0;
	for(let i=0;i<arr3d.length;i++)
	{
		for(let j=0;j<arr3d[i].length;j++)
		{
			for(let k=0;k<arr3d[i][j].length;k++)
			{
				sum+=arr3d[i][j][k];
			}
		}
	}
	return sum;
}
/*****************************************************************************/
/* Time Complexity:  O(2^N) - Exponential */
/* Space Complexity: O(1)   - Constant */
/* N:5 */
/* Description: Calculates the Nth number of the fibonacci sequence. */
/*****************************************************************************/
function exponential(n)
{
	if(n<=2) return 1;
	return exponential(n-1)+exponential(n-2);
}
/*****************************************************************************/
/* Time Complexity:  O(N!) - Factorial */
/* Space Complexity: O(1)  - Constant */
/* N:5 */
/* Counts to N, calling itself each iteration and passing N-1 to the next call */
/* One example of this might be the traveling salesman problem. Where you need */
/* to find all permutations to a destination from a starting point. */
/*****************************************************************************/
function factorial(n)
{
	for(let i=0;i<n;i++)
	{
		console.log(n);
		factorial(n-1);
	}
}
/* factorial(10); // Uncomment me if you dare */