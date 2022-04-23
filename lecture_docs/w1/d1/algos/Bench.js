class Bench
{
	static Mark(fn,...args)
	{
		let now=performance.now();
		let res=fn(args);
		let after=performance.now();
		let millis=after-now;
		let fmt=fn.name+" took:\n";
		fmt+=millis+" milliseconds\n";
		console.log(fmt);
		return res;
	}
};
module.exports=Bench;