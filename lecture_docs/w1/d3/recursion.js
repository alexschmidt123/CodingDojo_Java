function loop(start,end)
{
	/* 0>10 */
	/* 1>10 */
	/* 2>10 */
	/* 3>10 */
	/* 4>10 */
	/* 5>10 */
	/* 6>10 */
	/* 7>10 */
	/* 8>10 */
	/* 9>10 */
	/* 10>10 */
	if(start>end)
	{
		return;
	}
	console.log(start,end);
	loop(start+1,end);
}
loop(0,10);

function contains_r(node,value)
{
	if(!node) return false;
	if(node.value==value) return true;
	return contains_r(node.next,value);
}

/* 10/20/30/40 */

/* 30 */

/* let list=new List(); */

/* let contains30 = containsr( list.head, 30 ) */