function is_even(n)
{
	if(n%2==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

function is_even_better(n)
{
	return n%2==0;
}

function is_empty(list)
{
	if(!this.head) return true;
	return false;
}

function is_empty_better(list)
{
	return list.head==null;
}