const PI = 3.14159;

/* Optimization Tricks: */

/* The way you probably floor things: */

console.log( Math.floor(PI) );

/* The faster way to floor things AND save a function call: */

console.log( PI | 0 );

/* The way you probably ceil things: */

console.log( Math.ceil( PI ) );

/* The faster way to CEIL things: */

console.log( ( PI + 1 ) | 0 ); /* <- Adds one to PI, then chops off its mantissa / bits */

/* The way you probably round things: */

console.log( Math.round(PI) );

/* The faster way to round things: */

let mantissa = PI - ( PI | 0 ); /* <- Extracts the digits after the decimal point. */
/* ^ Doesn't have to be a separate step, here for readability. */

console.log( mantissa < 0.5 ? ( PI | 0 ):( ( PI | 0 ) + 1 ) );
/* ^ if the digits after the decimal point are less than 0.5, we floor it. */
/* otherwise, we floor it and add 1 */