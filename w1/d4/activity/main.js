class Paddle
{
	constructor(x,y,w,h)
	{
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.color="#f00";
	}

	draw()
	{
		ctx.fillStyle="#fff";
		ctx.fillRect(this.x,this.y,this.w,this.h);
	}
};

class Ball extends Paddle
{
	constructor(x,y,w,h,r)
	{
		super(x,y,w,h);
		this.color="#fff";
		this.r=r;
	}

	draw()
	{
		ctx.fillStyle=this.color;
		ctx.beginPath();
		ctx.arc(this.x,this.y,this.r,0,Math.PI*2);
		ctx.fill();
	}
};

cvs=undefined;
ctx=undefined;
paddle1=new Paddle(16,300,16,256);
paddle2=new Paddle(1500,300,16,256);
ball=new Ball(750,300,16,16,32);

onload=()=>
{
	cvs=document.getElementById("cvs");
	ctx=cvs.getContext("2d");
	main();
};

move_paddle=(element)=>
{
	console.log(element);
};

main=()=>
{
	resize();
	clear();
	draw();
	requestAnimationFrame(main);
}

resize=()=>
{
	ctx.canvas.width=window.innerWidth;
	ctx.canvas.height=window.innerHeight;
}

clear=()=>
{
	ctx.fillStyle="#000";
	ctx.fillRect(0,0,ctx.canvas.width,ctx.canvas.height);
}

draw=()=>
{
	paddle1.draw();
	paddle2.draw();
	ball.draw();
	
}