<div align="center">
	<img align="center" src="../../res/img/java_logo.png" width=128 />
	<hr>
	<h1>Week 1 Day 1 - Intro To Java</h1>
</div>

## Topics / Concepts:

### Part 1

* Why Java?
* How Java Works (J.V.M.)
* Compiled vs Intepreted
* Hello World
* Static Types vs Dynamic Types
* Naming Conventions
* Types, Conditionals, Loops, and Operators

### Part 2

* Methods
* Casting
* Modularization / Imports & Packages
* Static Arrays, Dynamic Arrays
* Hashmaps
* Exceptions

## Why Java?

* Compiled Language
* Write One Run Anywhere
* Enormous Standard Library
* Object Oriented
* Widely Used

## How Java Works - Java Virtual Machine (J.V.M.)

TL;DR Translates code into a machine and O.S. independant executable.

The java virtual machine (JVM) lets us write code once and use that same code on any machine or operating system. The reason this is possible is because of JVM and an intermediate form of binary called bytecode upon compilation of a Java program. At this stage, we could take the resulting .class files / bytecode, and hand it off to Java / JVM on any machine or operating system and it would translate those same instructions to that machine's specific architecture. This means that the developers of Java and the JVM had to write code that would function on each operating system the same way the user intended without side effects. This means we don't have to learn how to write code for Windows, Linux, OSX, or any other platforms we intend our software to run on. Before Java, we would've had to write 3 separate programs each targeting the aforementioned platforms. With Java, we write that code once.

<div align="center">
	<img align="center" src="../../res/img/java_compilation.png" />
</div>

## Compiled VS Interpreted:

### Interpreted:

TL;DR Your code requires a host language in order to run.

Interpreted languages are languages that DO NOT compile code to machine code. They instead are programs themselves (Likely written in ASM, C, C++, Rust) that operate on source code as input. E.G. They require a host language to operate (Like parasites). The interpreter first performs lexical analysis which is the act of breaking up the source code input into "tokens" that represent keywords or actions to be processed by the parser in the next step. After lexing, the parse phase begins. This is where the source code is checked for grammatical problems and errors, and that it conforms to the language's rules. During parsing, the source code is also organized into a tree structure, typically referred to as an abstract syntax tree (A.S.T). After parsing, the interpreter has gathered enough information to execute the code it generated into the AST. The AST is then walked / travered / iterated, and the code is executed.

### Compiled:

TL;DR Your code must be compiled to machine code or close to it before it can run.

Compiled languages are languages that DO compile code to machine code, or come close to it. ( Bytecode in Java's case ). This means there is an additional compilation step performed before the program can even execute or run. Compilation also involves lexical analysis and parsing, but is much more strict, since it must be converted to machine code (Not necessarily binary 1s and 0s). The compiler must be able to read each line of code and substitute what it believes to be the most optimal CPU instruction opcode equivalent. An opcode is a hexadecimal number that corresponds to an operation that the CPU must perform, such as the SUB instruction which corresponds to the hexadecimal value 0x28 on intel x86 processors. It must do this subsitution for all code written. After this compilation process, we can finally execute the raw machine code (or byte code via JVM in Java's case) as an executable process.

## Static Types vs Dynamic Types - Variables

TL;DR We must specify data types when creating variables, functions, etc.

Most if not all compiled languages are statically typed. This means that when we create variables, functions, pass parameters to those functions, return from functions, etc, we must specify the exact type of data we are operating on, whether it be an integer, string, character, decimal, array, etc. This may seem like a monotonous waste of time coming from a dynamically typed language. However, it gives us much more control over RAM and how much space we are consuming and how much we actually require. It also gives us much more control over that data, as we can expect it to be in a specific format before operating on it. Supplying types to variables informs the compiler precisely how much space or RAM it must reserve and allocate to store data. In dynamically typed languages, this is left to the interpreter, therefore we cannot guarantee how much space will be consumed, and it may consume more than we need.

### Javascript:

```js
var age = 30;
var grade = 'B';
var name = "Bobert";
```

### Python:

```python
age = 30
grade = 'B'
name = "Bobert"
```

### Java:

```java
public class Program
{
	public static void main(String[] args)
	{
		int age = 30; /* 4 bytes on most machines. */
		char grade = 'B'; /* 1 byte on most machines. */
		String name = "Bobert"; /* 6 bytes */
	}
};
```

### Memory allocation in a nutshell:

<div align="center">
	<img align="center" src="../../res/img/alloc.png" />
</div>

## Naming Conventions

Java programs use the ```PascalCase``` naming convention for classes as a standard. This means the first letter of each word including the first word is uppercase.

PascalCase Examples:

* ```UserController```
* ```CategoryProduct```
* ```CrudRepository```
* ```CommentService```

For variable, member, method, or function names, ```camelCase``` is typically preferred. This means the first letter of the first word is lowercase, and every other word's first letter is uppercase.

camelCase Examples:

* ```myNum = 123```
* ```userService.getById(10);```
* ```groceryList.add(new Grocery("Milk"));```

## Types:

### Primitive Types:

* char - 1 byte, 8 bits, integer - 0-255
* short - 2 byte, 16 bits, integer 0-65535
* int - 4 byte, 32 bits, integer 0-4294967296
* long - 8 byte, 64 bits, integer 0-9223372036854775807
* float - 4 byte, 32 bits, decimal
* double - 8 byte, 64 bits, decimal
* boolean - 1 byte, 8 bits, true / false

### Object Types:

* Character
* Long
* Integer
* Double
* Boolean
* String
* ArrayList
* HashMap

## Operators

```java
public class Program
{
	public static void main(String[] args)
	{
		int a = 100;
		int b = 200;

		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);

		System.out.println(a > b);
		System.out.println(a < b);
		System.out.println(a <= b);
		System.out.println(a >= b);
		System.out.println(a == b);
		System.out.println(a != b);
	}
};
```

## Conditionals

```java
public class Program
{
	public static void main(String[] args)
	{
		int a = 20;
		int b = 30;

		if( a > b )
		{
			System.out.println("A is Bigger!");
		}
		else if( a == b )
		{
			System.out.println("A is equal to B!");
		}
		else
		{
			System.out.println("B is Bigger!");
		}

		/* alternatively using a ternary: */
		String result_string = a > b ? "A is bigger" : "B is bigger!";

		System.out.println(result_string);
	}
}
```

## Loops

```java
public class Program
{
	public static void main(String[] args)
	{
		for(int i=0; i < 10; i++)
		{
			System.out.println(i*i);
		}

		int j = 1;
		while(j < 20)
		{
			System.out.println( j );
			j += 2;
		}
	}
};
```

## Methods

```java
public class Program
{
	public static void main(String[] args)
	{
		int sum = Program.add(10,20);
		System.out.print(sum);
	}

	/* Static Method */

	public static int add(int a,int b)
	{
		return a+b;
	}
};

/* User.java */

public class User
{
	private String name;
	private String email;

	/* Constructor */

	public User(String _name,String email)
	{
		name=_name;
		this.email=email;
		Register();
		Login();
	}

	/* Instance Methods */

	public void Register()
	{
		System.out.println("Do database saving. Ensure email doesn't exist");
	}

	public void Login()
	{
		System.out.println("Check password and user existance");
	}
};
```

## Casting

Casting is the act of attemping to change an object's type to another.

```java
public class Program
{
	public static void main(String[] args)
	{
		double pi = 3.14159;
		int n = (int)pi;
		System.out.println(n);
	}
};
```

## Arrays

```java
public class Program
{
	public static void main(String[] args)
	{
		/* Declaration */
		int[] my_nums;
		/* Initialization */
		my_nums = new int[5];
		my_nums[0]=10;
		my_nums[1]=20;
		my_nums[2]=30;
		my_nums[3]=40;
		my_nums[4]=50;

		for(int i=0;i<my_nums.length;i++)
		{
			System.out.println(my_nums[i]);
		}
		/* Declaration and initialization */
		float[] my_floats = new float[3];
		my_floats[0]=3.14;
		my_floats[1]=1.23;
		my_floats[2]=4.56;
		/* Declaration, initialization, and */
		/* assignment, without specifying a size. This size is determined by the number of elements we initially put in, 5. */
		String[] my_groceries =
		{
			"Milk",
			"Bread",
			"Eggs",
			"Bananas",
			"Oranges"
		};
		/* Alternative for loop if we only care about values, not indices. */
		for(String grocery: my_groceries)
		{
			System.out.println(grocery);
		}
	}
};
```

## ArrayLists

```java
import java.util.ArrayList;

public class Program
{
	public static void main(String[] args)
	{
		ArrayList<Integer> nums=new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
		nums.add(40);
		nums.add(50);

		Integer num = nums.get(2);
		System.out.println(num);
		/* Iterate V1 */
		for(int i=0;i<nums.length;i++)
		{
			System.out.println(nums.get(i));
		}
		/* Iterate V2 */
		for(Integer value:nums)
		{
			System.out.println(value);
		}
	}
};
```

## HashMaps

```java
import java.util.HashMap;

public class Program
{
	public static void main(String[] args)
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("name","Bobert");
		map.put("email","bob@ert.com");
		map.put("fav_hobby","Play Sportsball");

		String val = map.get("email");
		System.out.println(val);
		
		/* Iterate V1 */

		for(Map.Entry<String,String> set:map.entrySet())
		{
			String key = set.getKey();
			String value = set.getValue();
			System.out.println(key+":"+value);
		}

		/* Iterate V2 */

		for(String key:map.keySet())
		{
			System.out.println(key+":"+map.get(key));
		}
	}
};
```

## Exceptions

```java
public class Program
{
	public static void main(String[] args)
	{
		int[] nums=new int[]
		{
			10,
			20,
			30,
			40,
			50
		};

		try
		{
			System.out.println(nums[10]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("OUT OF BOUNDS!");
		}
	}
};
```

## Modularization / imports / packages

Importing code from other libraries or sources is not only common in Java, but in every other language.

Packages or modules in Java are really just folders with code in them. The package keyword reflects this directory structure.

Most Java developers use the reverse domain naming convention for organizing their code base.

This may look something like:

Program.java:

```java
package com.codingdojo.myapp; /* <- the package our Program.java resides in */
/* Dependencies of our program */
import java.util.ArrayList;
import java.util.HashMap;
```

You can see that it looks like a URL in reverse. We can also determine where to look for this source code, since we know each word in the package name represents a folder. This means, that Program.java resides in the com/codingdojo/myapp folder.


## Useful Resources:

https://godbolt.org/

https://javap.yawk.at

http://ref.x86asm.net/coder64.html#x0F90

https://www.asciitable.com/

## End Of Day: Cafe Java
