Java Data Structure
===================

## Java 8 memory structure!

```
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
```

## Java Collection hierarchy

```java
Iterator <I>
    ListIterator <I>

Iterable <I> -> getIterator()
    Collection <I> -> add(x), addAll(x), contains(x), containsAll(x), remove(x), clear(), isEmpty(), size()
        List<I> -> add(i, x), get(ith)
            ArrayList -> Singly Linked List/Dyanmic Array
            Vector
                Stack
            LinkedList -> DoublyLinkedList
            CopyOnWriteArrayList -> get an immutable snapshot of the data in the list at the time iterator() was called. remove() not supported
        Queue <I> -> add(x)/offer(x), remove()/poll(), element()/peek()
            Deque <I> Double Ended Queue insert and remove elements from both ends of the queue
                ArrayDeque
                LinkedList
                BlockingDeque <I>
                    LinkedBlockingDeque
                ConcurrentLinkedDeque
            PriorityQueue
            BlockingQueue <I>
                ArrayBlockingQueue
                LinkedBlockingQueue -> used for producer/consumer model
                BlockingDeque <I>
                    LinkedBlockingDeque
                DelayQueue
                TransferQueue <I>
                    LinkedTransferQueue
                PriorityBlockingQueue
            ConcurrentLinkedQueue -> based on CAS hence non blocking
        Set <I> -> add(x), contains(x), remove(x), size(), clear(), isEmpty()
            HashSet -> backed by HashMap
                LinkedHashSet -> Ordered
            SortedSet <I> -> uses natural order or external Comparator
                NavigableSet <I> navigation methods available
                    TreeSet -> Tree ds (sorted) so no hashcode/equals; Comparable/Comparator instead
                    ConcurrentSkipListSet
            EnumSet
            CopyOnWriteArraySet

    Deque = Double Ended Queue -> use this instead of Stack
    LinkedList -> Deque implementation
    Vector and Stack are legacy avoid use
    PriorityQueue -> based on priority heap

Map <I> -> put(k,v), remove(k), contains(k), V get(k), clear(), size()
    HashTable -> synchronized, no null key, 
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
 > - HashMap -> uses hashCode() and then equals() -> java 1.8  collision resolution is changed to BST after a threshold from LinkedList as used in prior versions.
 > - ConcurrentHashMap API states that its iterators do not throw ConcurrentModificationException. This is because its iterators reflect the state of the hash table at point of the creation of the iterator. This is as if its iterators work with a hash table snapshot:

> Properties (String key and value) extends HashTable (Object key and value): a design break in Java. HashTable can take Properties and and both can use add and get for Object which is wrong as per Properties design which should only use String via method setProperty and getProperty.
> This is not breaking Liskov Substitution.


| Data Structure     | List       | Queue         | Set           | Map           |
| ----               | ----       | ----          | ----          | ----          |
| Indexed            | ArrayList  | ArrayDeque    | HashSet       | HashMap       |
| Linked             | LinkedList | PriorityQueue | TreeSet       | TreeMap       |
| Indexed with links |            |               | LinkedHashSet | LinkedHashMap |
| Bit string         |            |               | EnumSet       | EnumMap       |

## Java Collection Time complexity

### List

| Opeation                             | ArrayList                                                        | LinkedList  |
| ----                                 | ----                                                             | ----        |
| add(element)                         | O(1), O(n) worst-case scenario, new array and copy all elements. | O(1) always |
| add(index, element)                  | O(n)                                                             | O(n)        |   
| get(index)                           | O(1)                                                             | O(n)        |
| remove(element)                      | O(n) Iterate and remove.                                         | O(n)        |
| remove(index)                        | O(n) remaining elements other elements must be shifted           | O(n)        |
| indexOf(element) / find / search     | O(n)                                                             | O(n)        |
| contains(element) / uses indexOf()   | O(n)                                                             | O(n)        |

### Map

| Opeation | HashMap, LinkedHashMap, IdentityHashMap, WeakHashMap, EnumMap and ConcurrentHashMap (Hash based) | TreeMap, ConcurrentSkipListMap (some java version its backed by binary tree earlier it was List) |
| ----     | ----                                                                                             | ----                                                                                             |
| put                  | O(1) | O(log(n)) |
| get 	               | O(1) | O(log(n)) |
| remove               | O(1) | O(log(n)) |
| containsKey / Search | O(1) | O(log(n)) |  

### Set

| Opeation | HashSet, LinkedHashSet, and EnumSet uses internal HashMap (Hash based) | TreeSet (uses internal TreeMap) |
| ----     | ----                                                                   | ----                            |
add               | O(1) | O(log(n)) |
remove            | O(1) | O(log(n)) |
contains / search | O(1) | O(log(n)) |
