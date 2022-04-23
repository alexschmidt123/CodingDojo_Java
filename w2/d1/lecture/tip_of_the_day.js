randf=(min,max)=>min+Math.random()*(max-min);
randi=(min,max)=>randf(min,max)|0;

/* What is a Jump Table?! */

/* Remember ninja gold? */

/* You probably did something like this for processing each location: */

let gold=0;

function process_gold(location)
{
	if(location=="farm")
	{
		gold+=randi(1,10);
	}
	else if(location=="cave")
	{
		gold+=randi(5,10);
	}
	else if(location=="house")
	{
		gold+=randi(2,5);
	}
	else if(location=="casino")
	{
		let rand=randi(50,100);
		gold+=randi(0,10)>5?rand:-rand;
	}
}

/* what if we instead made an object whose keys represented */
/* each location, and whose values were the function to call  */
/* based on the given location? This would look something like: */

let locations={};
locations.farm=function()
{
	gold+=randi(1,10);
}

location.cave=function()
{
	gold+=randi(5,10);
}

location.house=function()
{
	gold+=randi(2,5);
}

location.casino=function()
{
	let rand=randi(50,100);
	gold+=randi(0,10)>5?rand:-rand;
}

/* We attempt to "look up" the supplied key in our  */
/* table. If we didnt find it, we abort. If we did */
/* find it, we run the function associated with it's key. */
/* What if we had 10 more separate locations? No problem. */
/* This code doesn't need to be changed, because it accounts */
/* for scalability. */
function better_process_gold(location)
{
	if(!locations[location]) return;
	locations[location]();
}