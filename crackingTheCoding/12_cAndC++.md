## 12 C and C++

A good interviewer won't demand that you code in a language you don't profess to know. Hopefully, if you're asked to code in C++, it's listed on your resume. If you don't remember  all the APls, don't worry-most interviewers (though not all) don't care that much. We do recommend, however, studying up on basic C++ syntax so that you can approach these questions with ease.


### Classes and Inheritance

Though C++ classes have similar characteristics to those of other languages, we'll review some of the syntax below.

The code below demonstrates the implementation of a basic class with inheritance.

```C
1     #include <iostream>
2    using namespace  std;
3
4    #define NAME_SIZE  50 II Defines a macro
5
6    class  Person {
7          int id;  II all members  are private  by default
8          char name[NAME_SIZE];
9
10     public:
11      void aboutMe() {
12          cout << "I  am  a person.";
13        }
14    } ;
15
16  class  Student :    public  Person {
17     public:
18        void  aboutMe() {
19          cout <<  "I  am  a student.";
20      }
21   };
22
23  int main() {
24      Student *  p = new   Student();
25     p->aboutMe(); II prints  "I  am  a student."
26      delete  p; II Important! Make sure to delete  allocated  memory.
27     return  0;
28     }
```

All data members and  methods are  private by  default in C++. One  can  modify  this  by introducing the keyword public.


### Constructors and Destructors

The constructor of a class  is automatically called  upon an object's creation. If no constructor is defined, the compiler automatically generates one  called  the  Default  Constructor.  Alternatively, we can define our own constructor.

If you just need to initialize primitive types,  a simple way to do it is this:

```C
1      Person(int a) {
2           id =  a;
3       }
```

This works for primitive types,  but  you might instead want to do this:

```C
1      Person(int a)  :   id(a) {
2
3      }
```

The  data member id  is assigned before the  actual object is created and  before the  remainder of the constructor code is called. This approach is necessary when the  fields are constant or class types.

The destructor cleans up upon object deletion and  is automatically called  when an object is destroyed. It cannot take  an argument as we don't explicitly call a destructor.

```C
1     -Person() {
2           delete  obj;   //  free  any  memory   allocated  within  class 
3      }
```


### Virtual  Functions

In an earlier example, we defined p to be of type Student:

```
1      Student *  p  =  new  Student();
2      p->aboutMe();
```

What would happen if we defined p to be a Person\*, like so?

```
1      Person *  p  =  new  Student();
2      p->aboutMe();
```

In this case, "I   am  a  person" would be printed instead. This is because the function aboutMe is resolved at compile-time, in a mechanism known as static binding.

If we want to ensure that the  Student's implementation of aboutMe is called, we can define aboutMe in the  Person class to be virtual.

```C
1      class  Person {
2
3           virtual void  aboutMe() {
4                 cout <<  "I am a  person.";
5           }
6      };
7
8      class  Student :   public  Person {
9        public:
10         void  aboutMe() {
11               cout <<  "I am a  student.";
12       }
13   } ;
```

Another usage for virtual functions is when we can't (or don't want to) implement a method for the parent class. Imagine, for example, that we want Student and Teacher to inherit from Person so that we can implement a common method such as addCourse(string  s). Calling addCourse on Person, however, wouldn't make much sense since the implementation depends on whether the object is actually a Student or Teacher.

In this case, we might want addCourse to be a virtual function defined within Person, with the imple­
mentation being left to the subclass.

```C
1     class Person {
2         int  id;// all members  are private by default
3          char name[NAME_SIZE];
4      public:
5           virtual  void aboutMe() {
6              cout <<  "I  am a  person." <<  endl;
7          }
8          virtual  bool addCourse(string s) =  0;
9      };
10
11 class Student :    public Person {
12    public:
13        void aboutMe() {
14            cout <<  "I  am a  student." <<  endl;
15       }
16
17       bool addCourse(string s) {
18            cout <<  "Added course " <<  s <<  "to student." <<  endl;
19            return true;
20        }
21   };
22
23   int  main() { 
24		Person *  p  = new  Student();
25		p->aboutMe();  //  prints  "I am a  student." 
26		p->addCourse("History");
27		delete p; 
28    }
```

Note that by defining addCourse to be a "pure virtual function;· Person is now an abstract class and we cannot instantiate it.


### Virtual Destructor

The virtual function naturally introduces the concept of a "virtual destructor."Suppose we wanted to imple­
ment a destructor method for Person and Student. A naive solution might look like this:

```C
1   class  Person {
2       public:
3          ~Person() {
4           cout << "Deleting a person." << endl;
5            }
6     };
7
8     class Student    public Person   {
9       public:
10      ~student() {
11          cout << "Deleting  a student."  << endl;
12        }
13   } ;
14
15   int  main() {
16      Person *  p      new  Student();
17     delete  p; //  prints "Deleting  a person."
18  }
```

As in the earlier example, since p is a Person, the destructor for the Person class is called. This is problem­atic because the memory for Student may not be cleaned up.

To fix this, we simply define the destructor  for Person to be virtual.

```C
1    class  Person {
2     public:
3          virtual �Person() {
4            cout << "Deleting  a person."  << endl;
5           }
6    };
7
8     class  Student :  public  Person {
9       public:
10      ~student() {
11          cout << "Deleting  a student."  < <   endl;
12         }
13   } ;
14
15   int  main() {
16        Person *  p      new  Student();
17     delete  p;
18  }
```

This will output the following: 
```
Deleting  a student.
Deleting  a person.
```

### Default Values

Functions can specify default values, as shown below. Note that all default parameters must be on the right side of the function declaration,  as there would be no other way to specify how the parameters line up.

```
1   int func(int a, int b =  3) {
2             X  =  a;

3	y =  b;
4 return  a +  b;	
5	}	
6		
7	w = func(4);
8	z = func(4,  5);
```

### Operator Overloading

Operator overloading enables us to apply operators like + to objects that would otherwise not support these operations. For example, if we wanted to merge two BookShelves into one, we could overload the
+ operator as follows.

1      Bookshelf  BookShelf::operator+(BookShelf  &other)  {  ... }


### Pointers and References

A pointer holds the  address of a variable and  can  be used to perform any operation that could be directly done on the  variable,  such  as accessing and  modifying it.

Two pointers can  equal each other,  such  that changing one's  value  also changes the  other's value  (since they, in fact, point to the  same address).

```
1	int *  p = new  int;
2	*p  =  7;	
3	int *  q = p;
4	*p = 8	
5   cout << *q;  // prints  8
```

Note  that the  size of a pointer varies  depending on the  architecture: 32 bits on a 32-bit  machine and  64 bits on a 64-bit  machine. Pay attention to this difference, as it's common for interviewers to ask exactly  how much space a data structure takes  up.


##### References

A reference is another name (an alias) for a pre-existing object and  it does not have memory of its own. For example:

```
1     int a  =  s·,
2       int &    b =  a.,
3      b 
4      cout << a; // prints  7 
```

In line 2 above, b is a reference to a; modifying b will also modify  a.

You cannot create a reference without specifying where in memory it refers to. However, you can create a free-standing reference as shown below:
```
1  /* allocates  memory  to store 12  and  makes   b  a  reference to this
2   *  piece of memory.   *I
3    const int  &    b  =  12;
```
Unlike pointers, references cannot be null and  cannot be reassigned to another piece of memory.

##### Pointer Arithmetic

One  will often see programmers perform addition on a pointer, such  as what you see  below:

```
1      int *  p  =  new  int[2];
2      p[0] =   0;
3      p[l] =  1;
4      p++;
5      cout <<  *p;  // Outputs  1
```

Performing p++  will skip ahead by  sizeof(int) bytes,  such  that the  code outputs 1. Had p  been of different type, it would skip ahead as many  bytes as the  size of the  data structure.


### Templates

Templates are a way of reusing code to apply the same class to different data types. For example, we might have a list-like data structure which we would like to use for lists of various types. The code below imple­ ments this with the Shiftedlist class.

```C
1    template  <class T>class ShiftedList  {
2           T* array;
3            int  offset,  size;
4     public:
5            Shiftedlist(int sz)  :   offset(0),  size(sz) {
6              array=  new  T[size];
7            }
8
9         ~Shiftedlist()  {
10           delete  [] array;
11        }
12
13         void  shiftBy(int  n)  {
14           offset=  (offset+  n)%  size;
15          }
16
17          T  getAt(int i) {
18               return array[convertindex(i)];
19        }
20
21         void  setAt(T  item,  int i) {
22            array[convertindex(i)]  =  item;
23           }
24
25    private:
26         int  convertlndex(int i) {
27               int index  =  (i -  offset)%  size;
28           while  (index  <   0)  index  +=  size;
29               return  index;
30       }
31   };
```

---
Interview Questions
---
 
12.1    Last K Lines: Write a method to print the last Klines of an input file using C++.

Hints:#449, #459

12.2 	Reverse String: Implement a function void reverse( char* str) in C or C++ which reverses a null-terminated string.

Hints:#410, #452....... 423

12.3 	Hash Table vs. STL Map: Compare and contrast a hash table and an STL map.  How  is a hash table implemented? If the number of inputs is small, which data structure options can be used instead of a hash table?

Hints:#423 ....pg423

12.4    Virtual Functions: How do virtual functions work in C++?

Hints:#463

12.5	Shallow vs. Deep Copy: What is the difference between deep copy and shallow copy? Explain how you would use each.

Hints:#445


12.6    Volatile: What is the significance of the keyword"volatile"in C?

Hints:#456


12.7    Virtual Base Class: Why does a destructor in base class need to be declared virtual?

Hints:#421, #460 ··--·····------- --·--- ..........--P9 427

12.8 	Copy Node: Write a method that takes a pointer to a Node structure as a parameter and returns a complete copy of the passed in data structure. The Node data structure contains two pointers to other Nodes.

Hints:#427, #462

12.9 	Smart Pointer: Write a smart pointer class. A smart pointer is a data type, usually implemented with templates, that simulates a pointer while also providing automatic garbage collection. It automati­ cally counts the number of references to a SmartPointer<T\*> object and frees the object of type T when the reference count hits zero.

Hints: #402, #438, #453 ,..            pg428

12.10  Malloc: Write an aligned malloc and free function that supports allocating memory such that the memory address returned is divisible by a specific power of two.

EXAMPLE

align_malloc (1000, 128) will return a memory address that is a multiple of 128 and that points to memory of size 1000 bytes.

aligned_free () will free memory allocated by align_malloc.

Hints:#473, #432, #440 .......pg430

12.11 20 Alloc: Write a function in C called my2DA1loc  which allocates a two-dimensional array. Mini­ mize the number of calls to malloc and make sure that the memory is accessible by the notation arr[i][j].

Hints: #406, #478, #426

Additional Questions: Linked Lists (#2.6), Testing (#11.1), Java  (#13.4), Threads and Locks (#15.3). 

Hints start on page 676.