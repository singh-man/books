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
1      public  double computeArea(Circle c)   {   .•• }
2      public   double  computeArea(Square s)  {  •••  }
```

Overriding, however, occurs when a method shares the  same name and  function signature as another method in its super class.

```java
1      public  abstract  class  Shape {
2           public  void printMe()  {
3                 System.out.println("I am a  shape.");
4            }
5           public abstract  double  computeArea();
6     }
7
8     public   class Circle extends  Shape {
9         private double  rad=  5;
10       public   void  printMe()   {
11            System.out.println("I am  a  circle.");
12       }
13
14       public   double  computeArea()  {
15            return rad*  rad*3.15;
16       }
17   }
18
19   public   class Ambiguous extends  Shape {
20        private double  area=  10;
21       public   double  computeArea()  {
22            return area;
23           }
24   }
25
26  public   class  IntroductionOverriding {
27       public  static void  main(String[] args)  {
28            Shape[]  shapes  =  new Shape[2];
29            Circle circle  =  new Circle();
30            Ambiguous  ambiguous =  new Ambiguous();
31 
32            shapes[0] = circle;
33            shapes[l] = ambiguous;
34
35            for  (Shape  s  :   shapes)   {
36                 s.printMe();
37                 System.out.println(s.computeArea());
38            }
39          }
40   }
```

The above code will print:
```
1    I am  a  circle.
2    78. 75
3    I  am  a  shape.
4    10.0
```

Observe that Cire le overrode printMe(), whereas Ambiguous just left this method as-is.


### Collection Framework

Java's collection framework is incredibly useful, and you will see it used throughout this book. Here are some of the most useful items:

ArrayList: An ArrayList is a dynamically resizing array, which grows as you insert elements.
```
1    Arraylist<String> myArr =  new Arraylist<String>();
2    myArr. add("one");
3    myArr.add("two");
4    System.out.println(myArr.get(0));  /*   prints <one>*/
```
Vector: A vector is very similar to an Arraylist except that it is synchronized.  Its syntax is almost identical as well.

```
1	Vector<String>  myVect	new	Vector<String>();
2	myVect.add("one");		
3	myVect. add("two");		
4   system.out.printin(myVect.get(0));
```
LinkedList: Linkedlist is, of course, Java's built-in Linkedlist class. Though it rarely comes up in an interview, it's useful to study because it demonstrates some of the syntax for an iterator.
```
1     Linkedlist<String> mylinkedlist  = new Linkedlist<String>();
2     mylinkedlist. add("two");
3     myLinkedList.addFirst("one");
4     Iterator<String> iter  =  mylinkedlist.iterator();
5     while   (iter.hasNext()) {
6          System.out.println(iter.next());
7      }
```
HashMap:The HashMap collection is widely used, both in interviews and in the real world. We've provided a snippet of the syntax below.
```
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

13.1      Private Constructor: In terms of inheritance, what is the effect of keeping a constructor private?

Hints:#404


13.2     Return from Finally:  In Java, does the finally block get executed if we insert a return state­
ment inside the try block of a try-catch-finally?

Hints:#409 


13.3    Final, etc.: What is the difference between final, finally, and finalize?

Hints:#412


13.4    Generics vs. Templates: Explain the difference between templates in C++ and generics in Java.

Hints:#416, #425


13.5    TreeMap, HashMap, LinkedHashMap: Explain the differences between TreeMap, HashMap, and
LinkedHashMap. Provide an example of when each one would be best.

Hints:#420, #424, #430, #454


 
13.6     Object Reflection: Explain what object reflection is in Java and why it is useful.

Hints:#435
 
13.7 		Lambda Expressions: There is a class Country that  has methods  getContinent()   and getPopulation(). Write a function int  getPopulation(List<Country> countries, String  continent) that computes the total population of a given continent, given a list of all countries and the name of a continent.

Hints:#448, #467, #464

13.8 		Lambda   Random:    Using   Lambda   expressions,   write   a    function    List<Integer> getRandomSubset(List<Integer>   list) that returns a random subset of arbitrary size. All subsets (including the empty set) should be equally likely to be chosen.

Hints:#443, #450, #457....                 pa 439

Additional Questions: Arrays and Strings (#1.3), Object-Oriented Design (#7.12), Threads and Locks (#15.3) 

Hints start on page 676.