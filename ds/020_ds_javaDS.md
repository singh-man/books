Java Data Structure
===================

## Java 8 memory structure!

	Java Process Memory (Java process consuming memory in OS)
		JVM Memory 
			Java Heap (-Xms / -Xmx)
				Young Gen
					Eden
					Survivor 0
					Survivor 1
				Old Gen
			Non-Heap (Note:- This is not a part of JVM heap!)
				Thread Stacks
				Metaspace
				Compressed Class Space
				Code Cache
				NIO Direct Buffers
				Other JVM Memory
		Non-JVM Memory (native libraries)


## Java Collection hierarchy

```java
Iterable	
	Collection <I> -> add(x), addAll(x), contains(x), containsAll(x), remove(x), clear(), isEmpty(), size()
		Set <I> -> add(x), contains(x), remove(x), size(), clear(), isEmpty()
			SortedSet <I> -> uses natural order or external Comparator
				NavigableSet <I> navigation methods available
					TreeSet -> Tree ds (sorted) so no hashcode/equals; Comparable/Comparator instead
					ConcurrentSkipListSet
			HashSet -> backed by HashMap
			LinkedHashSet -> Ordered
			EnumSet
			CopyOnWriteArraySet
		List<I> -> add(i, x), get(ith)
			ArrayList -> Singly Linked List/Dyanmic Array
			CopyOnWriteArrayList -> get an immutable snapshot of the data in the list at the time iterator() was called. remove() not supported
			Vector
				Stack
			LinkedList -> DoublyLinkedList
		Queue <I> -> add(x)/offer(x), remove()/poll(), element()/peek()
			Deque <I> Double Ended Queue insert and remove elements from both ends of the queue
				ArrayDeque
				LinkedList
				BlockingDeque <I>
					LinkedBlockingDeque
				ConcurrentLinkedDeque
			PriorityQueue
			BlockingQueue <I>
				LinkedBlockingQueue -> used for producer/consumer model
				BlockingDeque <I>
					LinkedBlockingDeque
				DelayQueue
				TransferQueue <I>
					LinkedTransferQueue
				PriorityBlockingQueue
			ConcurrentLinkedQueue -> based on CAS hence non blocking

	Deque = Double Ended Queue -> use this instead of Stack
	LinkedList -> Deque implementation
	Vector and Stack are legacy avoid use
	PriorityQueue -> based on priority heap

Map <I> -> put(k,v), remove(k), contains(k), V get(k), clear(), size()
	HashTable -> sunchronized, no null key, 
		Properties
	HashMap -> not synchronized, one null key
	LinkedHashMap
	EnumMap
	IdentityHashMap -> uses == 
	WeakHashMap
	SortedMap <I>
		NavigableMap <I> navigation methods **available**
			TreeMap -> Tree ds so no hashcode/equals; Comparable/Comparator instead
			ConcurrentNavigableMap <T>
				ConcurrentSkipListMap
	ConcurrentMap <I>
		ConcurrentNavigableMap <I>
			ConcurrentSkipListMap
		ConcurrentHashMap
```

 > - HashTable is legacy avoid use.
 > - TreeMap -> Tree ds so no hashcode/equals; Comparable/Comparator instead
 > - HashMap -> uses hashCode() and then equals() -> java 1.8  collision rsolution is changed to BST after a threshold from LinkedList as used in prior versions.
 > - ConcurrentHashMap API states that its iterators do not throw ConcurrentModificationException. This is because its iterators reflect the state of the hash table at point of the creation of the iterator. This is as if its iterators work with a hash table snapshot:


| Data Structure     | List       | Queue         | Set           | Map           |
| ----               | ----       | ----          | ----          | ----          |
| Indexed            | ArrayList  | ArrayDeque    | HashSet       | HashMap       |
| Linked             | LinkedList | PriorityQueue | TreeSet       | TreeMap       |
| Indexed with links |            |               | LinkedHashSet | LinkedHashMap |
| Bit string         |            |               | EnumSet       | EnumMap       |

```java
Iterator <I>
	ListIterator <I>

Collection <I>
	Set <I>
		SortedSet <I>
			TreeSet
		HashSet 
		LinkedHashSet
	List <I>
		ArrayList
		Vector
		LinkedList
	Queue <I>
		LinkedList
		PriorityQueue

Map <I>
	HahsTable    
	LinkedHashMap    
	HashMap
	SortedMap <I>
		TreeMap
````

```
             +----------->Collection <I> <----+^-----------------------+
             |                                |                        |
             |                                |                        |
             |                                |                        |
             |                                |                        |
             +                                +                        +
    +-->Set <I> <------+                +-->List <I> <---------+     Queue <I> <----+
    |        ^         |                |         ^            |     ^              |
    |        |         +                |         |            |     |              |
    |        |    SortedSet <I>         |         |            |     |              |
    |        |            ^             |         |            |     |              |
    |        |            |             |         |            |     |              |
    +        |            +             |         |            |     |              +
HashSet LinkedHashSet    TreeSet      ArrayList   Vector    LinkedList    PriorityQueue



   +---> Map <I>  <-----------+^-----+
   |                          |      |
   |         ^                |      |
   |         |                |      +
   |         |                |    SortedMap <I>
   |         |                |          ^
   |         |                |          |
   |         |                |          |
   +         |                +          +
HahsTable    +inkedHashMap    HashMap    TreeMap
```




<!--Start Fragment-->