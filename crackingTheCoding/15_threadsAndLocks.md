## 15 Threads and  Locks


In a Microsoft, Google or Amazon interview, it's not terribly common to be asked to implement an algo­rithm with threads  (unless you're working in a team for which this is a particularly important  skill). It is, however, relatively common for interviewers at any company to assess your general understanding  of threads, particularly your understanding of deadlocks.

This chapter will provide an introduction to this topic.


### Threads in Java

Every thread in Java is created and controlled by a unique object of the java.lang.Thread class. When a standalone application is run, a user thread is automatically created to execute the main() method. This thread is called the main thread.

In Java, we can implement threads in one of two ways:

- By implementing the java. lang.Runnable interface
- By extending the java. lang. Thread class

We will cover both of these below.


###### Implementing the Runnable Interface

The Runnable interface has the following very simple structure.
```java
1     public  interface  Runnable  {
2          void run();
3      }
```

To create and use a thread using this interface, we do the following:

1.  Create a class which implements the Runnable interface. An object of this class is a Runnable object.
2.  Create an object of type Thread by passing a Runnable object as argument to the Thread constructor.
The Thread object now has a Runnable object that implements the run() method.
3. The start() method is invoked on the Thread object created in the previous step. 

For example:
```java
1     public class  RunnableThreadExample  implements   Runnable  {
2          public int  count  =  0;

4        public void run()  {
5               System.out.println("RunnableThread  starting.");
6              try {
7                   while   (count<  5)  {
8                              Thread.sleep(500);
9                              count++;
10                     }
11            }  catch  (InterruptedException exc)  {
12                 System.out.println("RunnableThread  interrupted.");
13            }
14            system.out.println("RunnableThread terminating.");
15       }
16   }
17
18  public   static void  main(String[]  args)   {
19       RunnableThreadExample instance =  new RunnableThreadExample();
20       Thread thread=  new Thread(instance);
21       thread.start();
22
23       /*  waits  until above thread counts  to  5 (slowly)  */
24       while  (instance.count  != 5)   {
25            try   {
26                 Thread.sleep(250);
27            }  catch  (InterruptedException exc)  {
28                      exc.printStackTrace();
29            }
30        }
31  }
```

In the above code, observe that all we really needed to do is have our class implement the run() method (line 4). Another method can then pass an instance of the class to new  Thread(obj) (lines 19 - 20) and call start() on the thread (line 21 ).


###### Extending the Thread Class

Alternatively, we can create a thread by extending the Thread class. This will almost always mean that we override the run() method, and the subclass may also call the thread constructor explicitly in its constructor.

The below code provides an example of this.

```java
1    public   class ThreadExample extends   Thread {
2         int count  =  0;
3
4         public   void  run()   {
5              System.out.println("Thread  starting.");
6              try  {
7                   while  (count<  5)  {
8                        Thread.sleep(500);
9                        System.out.println("In Thread, count is " + count); 
10				         count++; 
11                     }
12            }  catch  (InterruptedException exc)  {
13                 System.out.println("Thread interrupted.");
14            }
15            System.out.println("Thread  terminating.");
16        }
17   }
18
19  public  class  ExampleB {
20      public  static void main(String args[])  {
21          ThreadExample instance  =  new   ThreadExample();
22          instance.start();
23
24          while  (instance.count   !=  5) {
25              try  {
26                  Thread.sleep(250);
27              }  catch (InterruptedException exc) {
28                  exc.printStackTrace();
29              }
30          }
31        }
32     }
```
This code is very similar to the first approach. The difference is that since we are extending the Thread class, rather than just implementing an interface, we can call start() on the instance of the class itself.


###### Extending the Thread Class vs. Implementing the  Runnable Interface

When creating threads, there are two reasons why implementing  the Runnable interface may be prefer­
able to extending the Thread class:

- Java does not support multiple inheritance. Therefore, extending the Thread class means that the subclass cannot extend any other class. A class implementing the Runnable interface will be able to extend another class.
- A class might only be interested in being runnable, and therefore, inheriting the full overhead of the
Thread class would be excessive.


### Synchronization and Locks

Threads within a given process share the same memory space, which is both a positive and a negative. It enables threads to share data, which can be valuable. However, it also creates the opportunity for issues when two threads modify a resource at the same time. Java provides synchronization  in order to control access to shared resources.

The keyword synchronized and the lock form the basis for implementing synchronized execution of code.


###### Synchronized Methods

Most commonly, we restrict access to shared resources through the use of the synchronized keyword.  It can be applied to methods and code blocks, and restricts multiple threads from executing the code simul­ taneously on the same object.

To clarify the last point, consider the following code:
```java
1     public  class  MyClass extends Thread  {
2         private  String  name;
3          private  MyObject  myObj;
4
5          public  MyClass(MyObject obj,  String  n) {
6            name   =  n;
7            myObj   = obj;
8            }
9
10       public void  run() {
11            myObj.foo(name);
12     }
13   }
14
15  public class  MyObject {
16       public synchronized void  foo(String name) {
17            try {
18                 System.out.println("Thread " + name + ".foo(): starting");
19                 Thread.sleep(3000);
20                 System.out.println("Thread " + name + ".foo():  ending");
21          } catch  (InterruptedException  exc)  {
22                 System.out.println("Thread  "  +  name +  ":  interrupted.");
23          }
24     }
25   }
```
Can two instances of MyClass call foo at the same time? It d epends. If they have the same instance of
MyObject, then no. But, if they hold different references, then the a nswer is yes.
```java
1    /*   Difference references  -  both  threads can  call  MyObject.foo() */
2   MyObject objl =  new MyObject();
3   MyObject obj2  =  new MyObject();
4   MyClass thread!    new MyClass(obj1,   "1");
5   MyClass thread2      new MyClass(obj2,  "2");
6   threadl.start();
7   thread2.start()
8
9   /* Same  reference to obj. Only one will be  allowed  to call foo,
10   *    and the  other will be forced to wait.   */
11  MyObject obj=  new MyObject();
12  MyClass thread!     new MyClass(obj,   "1");
13  MyClass thread2 =  new MyClass(obj,  "2");
14  threadl.start()
15  thread2.start()
```

Static methods synchronize on the class lock. The two threads above could not simultaneously execute synchronized static methods on thesame class, even if one is calling foo and the other is calling bar.

```java
1    public class MyClass extends Thread   {
2
3            public void  run() {
4              if (name.equals("!"))  MyObject.foo(name);
5                  else if (name.equals("2")) MyObject.bar(name);
6       }
7       }
8
9    public class MyObject {
10       public static  synchronized void  foo(String name) {/* same  as  before */}
11       public static  synchronized void bar(String name) {/* same as  foo  */}
12 }
```

If you run this code,  you  will see the following printed: 
```
Thread  1.foo(): starting
Thread  1.foo(): ending
Thread  2.bar(): starting
Thread  2.bar(): ending
```

###### Synchronized Blocks

Similarly, a block of code can be synchronized. This operates very similarly to synchronizing a method.

```java
1     public  class MyClass extends Thread  {
2			...
3          public  void run() {
4           myObj.foo(name);
5            }
6      }
7     public  class MyObject {
8          public  void foo(String  name)  {
9                    synchronized(this) {
10					....
11               }
12        }
13   }
```

Like synchronizing a method, only one thread per instance ofMyObj ect can execute the code within the synchronized block. That means that if threadl and thread2 have the same instance ofMyObject, only one will be allowed to execute the code block at a time.


###### Locks

For more granular control, we can utilize a lock. A lock (or monitor) is used to synchronize access to a shared resource by associating the resource with the lock. A thread gets access to a shared resource by first acquiring the lock associated with the resource. At any given time, at most one thread can hold the lock and, therefore, only one thread can access the shared resource.

A common use case for locks is when a resource is accessed from multiple places, but should be only accessed by one thread at a time. This case is demonstrated in the code below.

```java
1  public  class LockedATM   {
2  	private  Lock lock;
3  	private int  balance=  100;
4 	
5  	public  LockedATM() {
6  		lock= new  Reentrantlock();
7  	}
8 	
9  	public  int  withdraw(int value) {
10 		lock.lock();
11 		int  temp= balance;
12 		try {
13 			Thread.sleep(100);
14 			temp=  temp  -  value;
15 			Thread.sleep(100);
16 			balance =  temp;
17 		}   catch (InterruptedException              }
18 			lock.unlock();
19 			return temp;
20 		}
21 		
22 		public  int  deposit(int  value) {
23 			lock. lock();
24 			int  temp= balance;
25 			try {
26 				Thread.sleep(100);
27 				temp=  temp+  value; 
28 				Thread.sleep(300); 
29 				balance=  temp;
30 			} catch (InterruptedException e)  {          }
31 			lock.unlock();
32 			return  temp; 
33 		}
34 	}
```
 

Of course, we've added code to intentionally slow down the execution of withdraw and deposit, as it helps to illustrate the potential problems that can occur. You may not write code exactly like this, but the situation it mirrors is very, very real. Using a lock will help protect a shared resource from being modified in unexpected ways.


### Deadlocks and Deadlock Prevention

A deadlock is a situation where a thread is waiting for an object lock that another thread holds, and this second thread is waiting for an object lock that the first thread holds (or an equivalent situation with several threads). Since each thread is waiting for the other thread to relinquish a lock, they both remain waiting forever. The threads are said to be deadlocked.

In order for a deadlock to occur, you must have all four of the following conditions met:

1.   Mutual Exclusion: Only one process can access a resource at a given time. (Or, more accurately, there is limited access to a resource. A deadlock could also occur if a resource has limited quantity.)
2.  Hold and Wait: Processes already holding a resource can request additional resources, without relin­
quishing their current resources.
3.  No Preemption: One process cannot forcibly remove another process' resource.
4.  Circular Wait: Two or more processes form a circular chain where each process is waiting on another resource in the chain.

Deadlock prevention entails removing any of the above conditions, but it gets tricky because many of these conditions are difficult to satisfy. For instance, removing #1  is difficult because many resources can only be used by one process at a time (e.g., printers). Most deadlock prevention  algorithms focus on avoiding condition #4: circular wait.

---
Interview Questions
---
 
15.1     Thread vs. Process: What's the difference between a thread and a process?

Hints:#405


15.2     Context Switch:  How would you measure the time spent in a context switch?

Hints:#403, #407, #475, #447
 

15.3		Dining Philosophers:  In the famous dining philosophers problem, a bunch of philosophers are sitting around a circular table with one chopstick between each of them. A philosopher needs both chopsticks to eat, and always picks up the left chopstick before the right one. A deadlock could potentially occur if all the philosophers reached for the left chopstick at the same time. Using threads and locks, implement a simulation of the dining philosophers problem that prevents dead­ locks.

Hints:#419, #437

15.4     Deadlock-Free Class:  Design a class which provides a lock only if there are no possible deadlocks.

Hints: #422, #434


15.5    Call In Order:  Suppose we have the following code:

```java
public class  Foo {
public Foo()  {   ... }
public void  first() {  ... } public void  second()   {   ... } public void  third() {  ... }
}
```
The same instance of Foo will be passed to three different threads. ThreadA  will call first, threads will call second,  and thread( will call third. Design a mechanism to ensure that first is called before second and second is called before third.

Hints:#4 77, #433, #446


15.6 		Synchronized Methods: You are given a class with synchronized method A and a normal method B. If you have two threads in one instance of a program, can they both execute A at the same time? Can they execute A and B at the same time?

Hints:#429


15.7 	FizzBuzz: In the classic problem FizzBuzz, you are told to print the numbers from 1  to n. However, when the number is divisible by 3, print"Fizz''. When it is divisible by 5, print"Buzz''. When it is divis­ ible by 3 and 5, print "FizzBuzz''. In this problem, you are asked to do this in a multithreaded way. Implement a multithreaded version of FizzBuzz with four threads. One thread checks for divisibility of 3 and prints "Fizz''. Another thread is responsible for divisibility of 5 and prints"Buzz''. A third thread is responsible for divisibility of 3 and 5 and prints"FizzBuzz''. A fourth thread does the numbers.

Hints:#4 7 4, #439, #447, #458


Hints start on page 676.