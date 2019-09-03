## 13 Java

While Java-related questions are found throughout this book,  this chapter deals with questions about the language and syntax. Such questions are more unusual at bigger companies, which believe more
in testing a candidate's aptitude than a candidate's knowledge (and  which  have the  time  and  resources to train  a candidate in a particular language). However,  at other companies, these pesky questions can be quite common.


### How to Approach

As these questions focus so much on knowledge, it may seem silly to talk about an approach to these prob­
lems. After all, isn't it just about knowing the  right  answer?

Yes and  no. Of course, the  best thing you can do to master these questions is to learn Java inside  and  out. But, if you do get  stumped, you can try to tackle it with the following approach:

1.  Create an example of the  scenario, and  ask yourself  how things should play out.

2.  Ask yourself  how other languages would handle this scenario.

3.  Consider how you would design this situation if you were the language designer. What would the impli- cations of each choice be?

Your interviewer may be equally-or more-impressed if you can derive the  answer than if you automati­ cally knew it. Don't try to bluff though. Tell the  interviewer, "I'm not  sure  I can recall the  answer,  but let me see if I can figure  it out. Suppose we have this code..."


### Overloading vs. Overriding

Overloading is a term used to describe when two  methods have the  same name but differ in the  type or number of arguments.

```
1      public  double computeArea(Circle c)  { ... }
2      public  double computeArea(Square s)  { ... }
```

Overriding, however, occurs when a method shares the  same name and  function signature as another method in its super class.

```java
1 	public  abstract  class  Shape {
2 		public  void printMe()  {
3 			System.out.println("I am a  shape.");
4 		}
5 		public abstract  double  computeArea();
6 	}
7	
8 	public   class Circle extends  Shape {
9 		private double  rad =  5;
10		public void printMe()   {
11			System.out.println("I am  a  circle.");
12		}
13	
14		public   double  computeArea()  {
15			return rad *  rad * 3.15;
16		}
17	}
18	
19	public   class Ambiguous extends  Shape {
20		private double  area =  10;
21		public   double  computeArea()  {
22			return area;
23		}
24	}
25	
26	public   class  IntroductionOverriding {
27		public  static void  main(String[] args)  {
28			Shape[]  shapes  =  new Shape[2];
29			Circle circle  =  new Circle();
30			Ambiguous  ambiguous =  new Ambiguous();
31	
32			shapes[0] = circle;
33			shapes[l] = ambiguous;
34	
35			for  (Shape  s  :   shapes)   {
36				s.printMe();
37				System.out.println(s.computeArea());
38			}
39		}
40	}
```

The above code will print:
```
1    I am  a  circle.
2    78. 75
3    I  am  a  shape.
4    10.0
```

Observe that Circle overrode printMe(), whereas Ambiguous just left this method as-is.


### Collection Framework

Java's collection framework is incredibly useful, and you will see it used throughout this book. Here are some of the most useful items:

ArrayList: An ArrayList is a dynamically resizing array, which grows as you insert elements.
```java
1    Arraylist<String> myArr =  new Arraylist<String>();
2    myArr.add("one");
3    myArr.add("two");
4    System.out.println(myArr.get(0));  /* prints <one> */
```
Vector: A vector is very similar to an Arraylist except that it is synchronized.  Its syntax is almost identical as well.

```java
1	Vector<String>  myVect	new	Vector<String>();
2	myVect.add("one");		
3	myVect.add("two");		
4   system.out.printin(myVect.get(0));
```
LinkedList: Linkedlist is, of course, Java's built-in Linkedlist class. Though it rarely comes up in an interview, it's useful to study because it demonstrates some of the syntax for an iterator.
```java
1     Linkedlist<String> mylinkedlist  = new Linkedlist<String>();
2     mylinkedlist.add("two");
3     myLinkedList.addFirst("one");
4     Iterator<String> iter  =  mylinkedlist.iterator();
5     while (iter.hasNext()) {
6          System.out.println(iter.next());
7      }
```
HashMap:The HashMap collection is widely used, both in interviews and in the real world. We've provided a snippet of the syntax below.
```java
1     HashMap<String,   String> map=  new HashMap<String,  String>();
2     map.put("one", "uno");
3     map.put("two",  "dos");
4     System .  out. println(map. get("one"));
```
Before your interview, make sure you're very comfortable with the above syntax. You'll need it.

---

Interview Questions

---

Please note that because virtually all the solutions in this book are implemented with Java, we have selected only a small number of questions for this chapter. Moreover, most of these questions deal with the"trivia" of the languages, since the rest of the book is filled with Java programming questions.



**13.1     Private Constructor:** In terms of inheritance, what is the effect of keeping a constructor private?

SOLUTION

---

Declaring a constructor private on class A means that you can only access the (private) constructor if you could  also access A's private  methods. Who, other than A, can access A's private  methods and constructor? A's inner classes can. Additionally, if A is an inner class of Q, then Q's other inner classes can.

This has direct implications for inheritance, since a subclass calls its parent's constructor. The class A can be inherited, but only by its own or its parent's inner classes.


**13.2 	Return  from  Finally:**  In Java, does the finally block get executed if we insert a return statement inside the try block of a try-catch-finally?

SOLUTION

---

Yes, it will get executed. The finally block gets executed when the try block exits. Even when we attempt to exit within the try block (via a return statement, a continue statement, a break statement or any exception), the finally block will still be executed.

Note that there are some cases in which the finally block will not get executed, such as the following: 

- If the virtual machine exits during try/catch block execution.
- If the thread which is executing during the try/ catch block gets killed.

 
**13.3    Final, etc.:** What is the difference between final, finally, and finalize?


SOLUTIONS
 
---

Despite their similar sounding names, final, finally and finalize have very different purposes. To speak in very general terms, final is used to control whether a variable, method, or class is "change­ able:' The finally keyword is used in a try/ catch block to ensure that a segment of code is always executed. The finalize() method is called by the garbage collector once it determines that no more references exist.

Further detail on these keywords and methods is provided below.


**final**

The final statement has a different meaning depending on its context.

- When  applied to a variable (primitive):The value  of the  variable cannot change.
- When  applied to a variable (reference): The reference variable cannot point to any other object on the heap.
- When  applied to a method:The method cannot be overridden.
- When  applied to a class:The class cannot be subclassed.


**finally keyword**

There is an  optional finally block  after  the  try block  or after  the  catch block.  Statements in the finally block will always be executed, even if an exception is thrown (except if Java Virtual Machine exits from the try block). The finally block  is often used to write the  clean-up code.  It will be executed after the try and catch blocks, but  before control transfers back to its origin.

Watch how thisplays out in the  example below.

```java
1 	public static  String lem() {
2 		System.out.println("lem");
3 		return "return from   lem";
4 	}
5	
6 	public static  String foo() {
7 		int X =   0;
8 		int y  =   5;
9 		try {
10			System.out.println("start  try");
11			int b  =   y  / x;
12			System.out.println("end try");
13			return  "returned  from try";
14		}  catch (Exception ex)  {
15			System.out.println("catch");
16			return lem() +  " |     returned  from catch";
17		}  finally {
18			System.out.println("finally");
19		}
20	}
21	
22	public static  void bar()  {
23		System.out.println("start  bar");
24		String v  =   foo();
25		System.out.println(v);
26		System.out.println("end  bar");
27	}
28	
29	public static  void main(String[] args) {
30		bar();
31	}
```

The output for this code is the following:
```
1      start  bar
2      start try
3      catch
4      lem
5      finally
6      return from   lem   \  returned from catch
7      end   bar
```
Look carefully  at lines 3 to 5 in the  output. The catch block is fully executed (including the  function call in the return statement), then the  finally block, and then the  function actually returns.


**finalize()**

The automatic garbage collector calls the finalize () methodjust before actually destroying the  object. A class can therefore override the  finalize () method from the  Object class in order to define custom behavior during garbage collection.
```
1      protected  void  finalize() throws  Throwable {
2           /* Close open   files,  release resources, etc */
3       }
```

**13.4     Generics vs. Templates:** Explain the  difference between templates in C++ and generics in Java.
pg/67

SOLUTION

---

Many programmers consider templates and generics to be essentially equivalent because both allow you to do something like List<String>. But, how each language does this, and why, varies significantly.

The  implementation of Java  generics is rooted in an idea  of"type erasure:'This technique eliminates the parameterized types when source code is translated to the  Java Virtual Machine (JVM) byte code.

For example, suppose you have the Java code below:
```
1     Vector<String>  vector  =  new Vector<String>();
2     vector.add(new String("hello"));
3     String str  =  vector.get(0);
```
During compilation, this code is re-written into:
```
1     Vector vector  = new  Vector();
2     vector.add(new String("hello"));
3     String  str  =  (String) vector.get(0);
```
The use of Java generics didn't really change much about our capabilities; it just made things a bit prettier. For this reason, Java generics are sometimes called"syntactic sugar:'

This is quite different from  C++. In C++, templates are essentially a glorified macro set, with  the  compiler creating a new  copy  of the  template code for each type.  Proof of this  is in the  fact  that an  instance of MyClass<Foo> will not  share a static variable withMyClass<Bar>. Two instances ofMyClass<Foo>, however, will share a static variable.

To illustrate this, consider the  code below:

```c
1 	/*** MyClass.h  ***/
2 	template<class T> class MyClass   {
3 	public:
4 		static int val;
5 		MyClass(int v) {  val     v;}
6 	};
7	
8 	/*** MyClass.cpp ***/
9 	template<typename T>
10	int MyClass<T>::bar;
11	
12	template class  MyClass<Foo>;
13	template class  MyClass<Bar>;
14	
15	/*** main.cpp ***/
16	MyClass<Foo> * fool = new MyClass<Foo>(10);
17	MyClass<Foo> * foo2 = new MyClass<Foo>(15);
18	MyClass<Bar> * barl = new MyClass<Bar>(20);
19	MyClass<Bar> * bar2 = new MyClass<Bar>(35);
20	
21	int fl =  fool->val;  //  will equal 15
22	int f2 =  foo2->val; //  will equal 15
23	int bl =  barl->val;  //  will equal 35
24	int b2 =  bar2->val; //  will equal 35
```

In Java, static variables are shared across instances of MyClass, regardless of the different type parameters. Java generics and C++ templates have a number of other differences. These include:

- C++ templates can use primitive types, like int. Java cannot and must instead use Integer.
- InJava, you can restrict the template's type parameters to be of a certain type.For instance, you might use generics to implement a CardDeck and specify that the type parameter must extend from CardGame.
- In C++, the type parameter can be instantiated, whereas Java does not support this.
- In Java, the type parameter  (i.e., the Foo in MyClass<Foo>) cannot be used for static methods and variables, since these would be shared between MyClass<Foo> and MyClass<Bar>. In C++, these classes are different, so the type parameter can be used for static methods and variables.
- In Java, all instances of MyClass, regardless of their type parameters, are the same type. The type parameters are erased at runtime. In C++, instances with different type parameters are different types.

Remember: Although Java generics and C++ templates look the same in many ways, they are very different.


**13.5      TreeMap, HashMap, LinkedHashMap:** Explain the differences between TreeMap, HashMap, and
LinkedHashMap. Provide an example of when each one would be best.

SOLUTION

---

All offer a key->value map and a way to iterate through the keys. The most important distinction between these classes is the time guarantees and the ordering of the keys.

- HashMap offers O(1) lookup and insertion. If you iterate through the keys, though,  the ordering of the keys is essentially arbitrary. It is implemented by an array of linked lists.
- TreeMap offers O(log   N) lookup and insertion. Keys are ordered, so if you need to iterate through the keys in sorted order, you can. This means that keys must implement the Comparable interface. TreeMap is implemented by a Red-Black Tree.
- LinkedHashMap  offers O(1)  lookup and insertion. Keys are ordered by their insertion  order. It is implemented by doubly-linked buckets.

Imagine you passed an empty TreeMap, HashMap, and LinkedHashMap into the following function:

```java
1 	void  insertAndPrint(AbstractMap<Integer,   String> map) {
2 		int[]  array = {1,   -1,   0};
3 		for (int x  :   array) {
4 			map.put(x,  Integer.toString(x));
5 		}
6	
7 		for (int k :  map.keySet()) {
8 			System.out.print(k + ",   ");
9 		}
10	}
```

The output for each will look like the results below.

| HashMap        | LinkedHashMap | TreeMap    |
| --             | --            | --         |
| (any ordering) | {1, -1, 0}    | {-1, 0, 1} |


Very important: The output  of LinkedHashMap and TreeMap  must look like the above. For HashMap, the output was, in my own tests, { 0,   1,  -1}, but it could be any ordering. There is no guarantee on the ordering.

When might you need ordering in real life?

- Suppose you were creating a mapping  of names to Person objects. You might want to periodically output the people in alphabetical order by name. A TreeMap lets you do this.
- A TreeMap  also offers a way to, given a name, output  the next 10 people. This could be useful for a
"More"function in many applications.
- A LinkedHashMap is useful whenever you need the ordering of keys to match the ordering of inser­
tion. This might be useful in a caching situation, when you want to delete the oldest item.

Generally, unless there is a reason not to, you would use HashMap. That is, if you need to get the keys back in insertion order, then use LinkedHashMap. If you need to get the keys back in their true/natural  order, then use TreeMap. Otherwise, HashMap is probably best. It is typically faster and requires less overhead.


**13.6     Object Reflection:** Explain what object reflection is in Java and why it is useful.

SOLUTION

---

Object Reflection is a feature in Java that provides a way to get reflective information about Java classes and objects, and perform operations such as:

1.   Getting information about the methods and fields present inside the class at runtime.

2.  Creating a new instance of a class.

3.  Getting and setting the object fields directly by getting field reference, regardless of what the access modifier is.

The code below offers an example of object reflection.

```java
1 	/*Parameters */
2 	Object[]  doubleArgs   =  new Object[]  { 4.2,  3.9  };
3	
4 	/*  Get  class */
5 	Class   rectangleDefinition     Class.forName("MyProj.Rectangle");
6	
7 	/*  Equivalent: Rectangle rectangle  =  new  Rectangle(4.2, 3.9);  */
8 	Class[]  doubleArgsClass =  new Clas s[] {double.clas s,  double.class};
9 	Constructor doubleArgsConstructor =
10	rectangleDefinition.getConstructor(doubleArgsClass);
11	Rectangle rectangle  =  (Rectangle) doubleArgsConstructor.newlnstance(doubleArgs);
12	
13	/*  Equivalent:  Double area  =  rectangle.area();  */
14	Method  m  =  rectangleDefinition.getDeclaredMethod("area");
15	Double area  =  (Double) m.invoke(rectangle);
```
This code does the equivalent of:

```java
1      Rectangle rectangle  =  new Rectangle(4.2, 3.9);
2      Double area  =  rectangle.area();
```

**Why Is Object Reflection Useful?**

Of course, it doesn't seem very useful in the above example, but reflection can be very useful in some cases. Three main  reasons are:

1.  It can help you observe or manipulate the runtime behavior of applications.
2.   It can help you debug or test programs, as you have direct access to methods, constructors, and fields.
3.  You can call methods by name when you don't know  the  method in advance. For example, we may  let the user pass  in a class name, parameters for the constructor, and a method name. We can then use this information to create an object and  call a method. Doing  these operations without reflection would require a complex series of if-statements, if it's possible at all.


**13.7 	Lambda Expressions:** There is  a  class  Country  that has  methods getContinent() and getPopulation(). Write a function int getPopulation(List<Country>  countries, String  continent) that computes the total population of a given  continent, given  a list of all
countries and the name of a continent.

SOLUTION

---

This question really comes in two  parts. First, we need to generate a list of the countries in North  America. Then, we need to compute their total population.

Without lambda expressions, this is fairly straightforward to do.

```java
1	int  getPopulation(List<Country> countries,   String  continent)  {
2		int sum  =  0;
3		for  (Country c   :   countries)  {
4			if (c.getContinent().equals(continent))  {
5				sum  +=  c.getPopulation();
6			}
7		}
8		return sum;
9	}
```

To implement this with  lambda expressions, let's break this up into multiple parts.

First, we use filter to get a list of the countries in the specified continent.

```java
1   Stream<Country> northAmerica  =  countries.stream().filter(
2        country  ->  {  return country.getContinent().equals(continent);}
3   );
```
Second, we convert this into a list of populations using map.
```java
1   Stream<Integer> populations  =  northAmerica.map(
2        c ->   c.getPopulation()
3   );
```
Third and finally, we compute the sum using reduce.
```
1	int population = populations.reduce(0, (a,  b)   ->  a  + b); 
```
This function puts it all together.
```java
1 	int  getPopulation(List<Country> countries,  String  continent)  {
2 		/* Filter  countries. */
3 		Stream<Country>  sublist =  countries.stream().filter(
4 			country  ->  {  return  country.getContinent().equals(continent);}
5 		);
6	
7 		/* Convert to list of populations. */
8 		Stream<Integer> populations  =  sublist.map(
9 			c  ->  c.getPopulation()
10		) ;
11	
12		/* Sum list. */
13		int  population =  populations.reduce(0, (a,  b) ->  a  +  b);
14		return  population;
15	}
```

Alternatively, because of the  nature of this specific  problem, we can  actually remove the  filter entirely. The reduce operation can  have  logic that maps the  population of countries not  in the  right  continent to zero. The sum will effectively  disregard countries not  within continent.
```java
1  int  getPopulation(List<Country> countries,  String  continent)  {
2        Stream<Integer> populations  =  countries.stream().map(
3              c  ->  c.getContinent().equals(continent)  ?  c.getPopulation()  :  0);
4        return populations.reduce(0, (a,  b) ->  a  +  b);
5  }
```
Lambda functions were  new  to Java 8, so if you don't recognize them, that's probably why. Now is a great time  to learn  about them, though!


**13.8     Lambda    Random:** Using Lambda expressions, write a function List<Integer> getRandomSubset( List<Integer> list) that returns a random subset of arbitrary size. All subsets (including the empty set) should be equally likely to be chosen.
 
SOLUTION

---

It's tempting to approach this problem by picking a subset size from 0 to N and then generating a random subset of that size.

That creates two  issues:

1. We'd have  to weight those probabilities. If N   >  1, there are more subsets of size N/2 than there are of subsets of size N (of which  there is always  only one).
2. It's actually more difficult  to  generate a subset of a restricted size (e.g., specifically 1O) than it is to generate a subset of any size.

Instead, rather than generating  a subset based on sizes, let's think about it based on elements. (The fact that we're told to use lambda expressions is also a hint that we should think about some sort of iteration or processing through the elements.)

Imagine we were iterating through { 1,   2,   3} to generate a subset. Should 1 be in this subset?

We've got two choices: yes or no. We need to weight the probability of"yes"vs."no" based on the percent of subsets that contain 1. So, what percent of elements contain 1?

For any specific element, there are as many subsets that contain the element as do not contain it. Consider the following: 

```
{}		 {1}
{2}      {1,  2}
{3}      {1,  3}
{2,  3}  {l,  2, 3} 
```
Note how the difference between the subsets on the left and the subsets on the right is the existence of

1. The left and right sides must have the same number of subsets because we can convert from one to the other by just adding an element.

This means that we can generate  a random subset by iterating through the list and flipping a coin (i.e., deciding on a 50/50 chance) to pick whether or not each element will be in it.

Without lambda expressions, we can write something like this:
```java
1 	List<Integer>  getRandomSubset(List<Integer> list) {
2 		List<Integer> subset =  new ArrayList<Integer>();
3 		Random  random =  new Random();
4 		for (int item   :   list) {
5 			/* Flip   coin.   */
6 			if (random.nextBoolean())  {
7 				subset.add(item);
8 			}
9 		}
10		return  subset;
11	}
```
To implement this approach using lambda expressions, we can do the following:
```java
1	List<Integer>  getRandomSubset(List<Integer> list) {
2		Random  random =  new Random();
3		List<Integer> subset =  list.stream().filter(
4			k  ->  { return  random.nextBoolean(); /*  Flip  coin.  */
5		}).collect(Collectors.tolist());
6		return  subset;
7	}
```
Or, we can use a predicate (defined within the class or within the function):
```java
1 	Random  random =  new Random();
2 	Predicate<Object> flipCoin  =  o  ->  {
3 		return random.nextBoolean();
4 	};
5	
6 	List<Integer>  getRandomSubset(List<Integer> list) {
7 		List<Integer> subset =  list.stream().filter(flipCoin).
8 		collect(Collectors.tolist());
9 		return subset;
10	}
```
The nice thing about this implementation is that now we can apply the flipCoin predicate in other places.



