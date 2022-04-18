/* Use vscode debugger for algos! */

/* if you don't have node js installed, you can download it here: */
/* *Gives you a head start for MERN anyways* */
/* https://nodejs.org/en/download/ */

/* Who has used a debugger before? */

/* 1. Set a breakpoint */
/* 2. Click the debugger tab in VsCode */
/* 3. Click Run and Debug */
/* 4. Select NodeJS as you environment */
/* 5. Use step into or step over to see your changes realtime! */

function loop(n)
{
	if(n>10) return;
	console.log(n);
	loop(n+1);
}
loop(0);