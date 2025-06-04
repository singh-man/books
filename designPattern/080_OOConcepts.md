OO Concepts
===========

### If-Else style

- novice developer: uses if-else may be switch
- avg developer: overloading
- good developer: overriding (running short of english text words) (overriding changes the behavior in a way that is not compatible with the base class's behavior, it violates LSP). [More](#oops-critics)
- god developer: delegates logic to data-structure or functional paradigm

### DIvsIOC

### OO Defination

#### Abstraction
Concept of hiding the details of implementation and exposing only the necessary functionalities. The keywords to keep in mind here are: 'Implementation hiding'.

#### Encapsulation
Concept of encapsulating or wrapping up the member variables (data) and the methods (behavior) of an object into a single unit, such as a class.

(funny term) takes the part that vary and encapsulate it so that it will not effect the other things. Here's another way to think about this principle: take the parts that vary and encapsulate them, so that later you can alter or extend the parts what vary without affecting those that don't and then remember to program to an interfaces (provide a constructor or setter/getter injection to provide the concrete object).

Encapsulation is literally a way to design so that object will never go into invalid state or at least make it to fail fast

#### Inheritance (Is-A)
Establishes a hierarchical relationship between two classes. Inherited dependency (but can exist independently)

#### Composition (Has-A)
strong dependency (can not exist independently) delegate can come here (hardcoded in constructor via new opertor)

#### Aggregation (Uses-A)
loose dependency (can exist independently) (data and its behaviour should follow this) delegates can come here

> Aggregation over > Composition over > Inheritance
>> Goalng has no inheritance of data it uses composition to enhance data.
>>> Avoid coupling Data and behaviour [Tell Don't Ask](https://martinfowler.com/bliki/TellDontAsk.html)
>>> Circle-ellipse or PersonWalk-PrisonWalk like problem can be avoided by not using inheritance.

#### Association
Objects knows eachother

#### Polymorphism
Capability of an object to be represented in different forms.

### Reference type:-

#### Soft reference
A soft reference is one of the strengths or levels of 'non strong' reference defined in the Java programming language, the others being weak and phantom.The garbage collector will always collect weakly referenced objects, but will only collect softly referenced objects when its algorithms decide that memory is low enough to warrant it. Soft and weak references provide two quasi-priorities for non-strongly referenced objects. Soft references may be used, for example, when writing a cache: weakly referenced objects may disappear too quickly to make the cache useful.

#### Weak reference:
In computer programming, a weak reference is a reference that does not protect the referenced object from collection by a garbage collector. An object referenced only by weak references is considered unreachable (or "weakly reachable") and so may be collected at any time. Weak references are used to avoid keeping memory references by unneeded objects. Some garbage-collected languages feature or support various levels of weak references, such as Java, C#, Python, Perl or Lisp

#### Phantom reference:
An object is phantomly referenced after it has been finalized, but before its allocated memory has been reclaimed.

#### Circular reference:
A circular reference is a series of references where the last object references the first, resulting in a closed loop.
The Sun JRE does treat SoftReferences differently from WeakReferences. *We attempt to hold on to object referenced by a SoftReference if there isn't pressure on the available memory. One detail: the policy for the "-client" and "-server" JRE's are different: the -client JRE tries to keep your footprint small by preferring to clear SoftReferences rather than expand the heap, whereas the -server JRE tries to keep your performance high by preferring to expand the heap (if possible) rather than clear SoftReferences. One size does not fit all.*

#### Misc:
- Class -> is a blueprint/template, has members like:
    - Field -> (generally known as variables); holds the state of the program
    - methods -> operate on field(s) (state)
    - Object -> also called instance; runtime instance of class in memory
- Refrence -> a variable that points to an object
- import x.y.z.* on this package classes are imported not sub-packages
- Stack memory is a sort of memory allocation that the OS continuously manages and uses to store local variables in a LIFO order. On the other hand, heap memory is a type of dynamic memory allocation used for storing objects and data structures that require a longer lifespan than stack memory.

#### OOPS Critics
1. Data hiding can practically be termed as implementation hiding
1. Getters (queires) -> preferably returns some value but are definitely indempotent, setters (commands) -> preferably returns void
2. Interfaces are not designed they are discovered as the system grows Start with specific behaviour and then discover abstractions as commonality emerges
2. Rule of 3 -> unless there are 3 examples of code that looks similar avoid abstraction
2. Liskov substitution (applies to classes not interface)
    1. append only
    2. If S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering any of the desirable properties of that program.
    1. keep the system correct (don't go out of the boundries of the system)
    1. Probable reason of violoation
        1. NotSupportedException indicates the violation of liskov substitution
        1. Extracted interfaces/abstraction (after coding)
        1. downcast
        1. Often violated when an attempt to remove feature
1. Reused abstraction principle compliance indicates liskov substitution principle compliance
2. Circle-Ellipse problem breaks liskov substition

Letting the client define the interface is much better than the vice versa Clients define the interfaces (because they consume it) and interface decision must be what the clients consume

Role interfaces (with one member) is better in handling liskov substituion

Objects are data with behavoiur

Functions are pure behaviour

closures are behaviours with data

### DI principle
1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
1. Abstractions should not depend on details. Details should depend on abstractions.

Decorator patter is well suiter for Quieris(getters) better than composition (can be used for caching after save) Decorator is like russian doll
change composition to aggregation design will become DI inheritance - is-a composition - has-a aggregation - uses-a The difference between HAS-A and USES-A is with regard to ownership. With the HAS-A relationship though your class is responsible for the lifetime of the object it contains, so if your class has a pointer to the object it is responsible for deleting the pointer. USES-A may use shared_ptr to the object. -—

### Predicate Programming
Predicate (mathematical logic) / computing too :
In mathematics, a predicate is commonly understood to be a Boolean-valued function P: X→ {true, false}, called the predicate on X.
predicate is a statement that may be true or false depending on the values of its variables.

## AOP
job of an aspect is called advice. Advice defines both the what and the when of an aspect. In addition to describing the job that an aspect will perform, advice addresses the question of when to perform the job. Should it be applied before a method is invoked? After the method is invoked? Both before and after method invocation? Or should it only be applied if a method throws an exception?

application may have thousands of opportunities for advice to be applied. These opportunities are known as joinpoints. A joinpoint is a point in the execution of the application where an aspect can be plugged in.

If advice defines the what and when of aspects then pointcuts define the where. A pointcut definition matches one or more joinpoints at which advice should be woven. an aspect doesn’t necessarily advise all joinpoints in an application.pointcuts using explicit class and method names or through regular expressions that define matching class and method name patterns

An aspect(the advisor we create in spring which combines advice and pointcust is aspect) is the merger of advice and pointcuts.

interceptor is an aspect; it consist of advice and pointcut (means an advisor)

interface Performer 	Class Instrumentalist 	Class Vocal

Audience : take seat, applause etc. is a concern that need to be aspected on Performer interface AudienceAdvice : defines what to do(we inject audience object and triggers the concerns on it) and when to do(Before, after, after throwing, around) implements MethodBeforeAdvice / MethodAfterAdvice / AfterThrowing or MethodInterceptor 1. traditional way

```xml
<!-- ASPECT/ADVISOR combines advice and pointcut--> 
<bean id="audienceAdvisor" class="org.springframework.aop.support.RegexpMethodPointcutAdvisor"> 	
    <property name="advice" ref="audienceAdvice" /> 	
    <property name="pattern" value=".*perform" /> 
</bean> 

<bean id="duke" class="org.springframework.aop.framework.ProxyFactoryBean"> 	
    <property name="target" ref="dukeTarget" /><!-- target object--> 	
    <property name="interceptorNames" value="audienceAdvisor" /> <!-- aspect: can be a list of advisors too--> 	
    <property name="proxyInterfaces" value="com.springinaction.springidol.Performer" /> 
</bean> 
```
actual call flow happens: duke proxy -> audienceAdvisor -> target 

2. @Aspect way 
But with @~AspectJ annotations, we can revisit our Audience class and turn it into an aspect without the need for any additional classes or bean declarations. 

No need of writing an advice Concern can be declared as an Aspect and Pointcut can be declared on its method hence - *@Aspect and @pointcut annotation eliminates writing a new Advice* java class and declaring pointcuts and advisor in xml configuration

#### Strangler pattern
