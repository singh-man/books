Data Structure & Algorithms Detailed
====================================

### What are data structures?

Essentially, they are different methods of storing and organizing data that serve a number of different needs.

**Algorithms**: is a fancy name for step-by-step sets of operations to be performed.

Data structures are implemented with algorithms, and algorithms are implemented with data structures.

For example, there are an absurd number of algorithms for sorting a set of unordered items:

    Insertion Sort, Selection Sort, Merge Sort, Bubble Sort, Heap Sort,
    Quick Sort, Shell Sort, Timsort, Bucket Sort, Radix Sort, ...

Every single one of them will be better for *something*. So you'll need to make a decision based on what your needs are and for that you'll need a way of comparing them, a way to measure them.

 When we compare the performance of algorithms we use a rough measurement of their average and worst-case performance using something called "Big-O". 

	/*** ===================================================================== ***\
	 ** - BIG-O NOTATION ------------------------------------------------------ **
	 * ========================================================================= *
	 *           a           b                                 d                 *
	 *           a         b    O(N^2)                      d                    *
	 *     O(N!) a        b                O(N log N)    d                    c  *
	 *           a      b                            d                 c         *
	 *          a      b                          d             c        O(N)    *
	 *          a    b                         d         c                       *
	 *          a  b                       d      c                              *
	 *         a  b                     d  c                                     *
	 *         ab                   c                          O(1)              *
	 *  e    e    e    e    ec   d    e    e    e    e    e     e    e    e      *
	 *      ba        c      d                                                   *
	 *    ba   c        d                       f    f    f    f    f    f    f  *
	 ** cadf    f d    f    f    f    f    f       O(log N)                     **
	\*** ===================================================================== ***/

Big-O Notation is a way of roughly measuring the performance of algorithms in order to compare one against another when discussing them.

Big-O is a mathematical notation that we borrowed in computer science to classify algorithms by how they respond to the number (N) of items that you give them.

### There are two primary things that you measure with Big-O:

- **Time complexity** refers to the total count of operations an algorithm will perform given a set of items.

- **Space complexity** refers to the total memory an algorithm will take up while running given a set of items.

We measure these independently from one another because while an algorithm may perform less operations than another, it may also take up way more memory. Depending on what your requirements are, one may be a better choice than the other.


#### These are some common Big-O's:

| Name         | Notation   | How you feel when they show up at your party |
| ------------ | ---------- | -------------------------------------------- |
| Constant     | O(1)       | AWESOME!!                                    |
| Logarithmic  | O(log N)   | GREAT!                                       |
| Linear       | O(N)       | OKAY.                                        |
| Linearithmic | O(N log N) | UGH...                                       |
| Polynomial   | O(N ^ 2)   | SHITTY                                       |
| Exponential  | O(2 ^ N)   | HORRIBLE                                     |
| Factorial    | O(N!)      | WTF                                          |

To give you an idea of how many operations we're talking about. Let's look at what these would equal given the (N) number of items.

|  Order     | N = 5     | 10        | 20             | 30                                          |
| ---------- | --------- | --------- | -------------- | ------------------------------------------- |
| O(1)       | 1         | 1         | 1              | 1                                           |
| O(log N)   | 2.3219... | 3.3219... | 4.3219...      | 4.9068...                                   |
| O(N)       | 5         | 10        | 20             | 30                                          |
| O(N log N) | 11.609... | 33.219... | 84.638...      | 147.204...                                  |
| O(N ^ 2)   | 25        | 100       | 400            | 900                                         |
| O(2 ^ N)   | 32        | 1024      | 1,048,576      | 1,073,741,824                               |
| O(N!)      | 120       | 3,628,800 | 2,432,902,0... | 265,252,859,812,191,058,636,308,480,000,000 |

As you can see, even for relatively small sets of data you could do a *lot* of extra work.

With data structures, you can perform 4 primary types of actions:

	Accessing, Searching, Inserting, and Deleting.

It is important to note that data structures may be good at one action but bad at another.
 
Or rather...
 
|                    | Accessing | Searching | Inserting | Deleting  |
| ------------------ | --------- | --------- | --------- | --------- |
| Array              | AWESOME!! | OKAY      | OKAY      | OKAY      |
| Linked List        | OKAY      | OKAY      | AWESOME!! | AWESOME!! |
| Binary Search Tree | GREAT!    | GREAT!    | GREAT!    | GREAT!    |


Even further, some actions will have a different "average" performance and a "worst case scenario" performance.


Let's imagine a chunk of memory like this:

| Values: | 0    | 1    | 2    | 3    | 4    | 5    | 6    | 7    | 8    | 9...    |
| ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- | ---- |
| Addresses: | 1001 | 0110 | 1000 | 0100 | 0101 | 1010 | 0010 | 0001 | 1101 | 1011... |

Every program running on your machine is stored within this same *physical* data structure. Without layers of abstraction over it, it would be extremely difficult to use.

But these abstractions serve two additional purposes:

- Storing data in memory in a way that is more efficient and/or faster to work with.
- Storing data in memory in a way that makes it easier to use.

Data Strucutre that uses memory directly
----

### ARRAYS

An array is a representation of an ordered sequence of values where the same value may appear many times.

`Note that we want to store the length separately because in real life the "memory" doesn't have a length you can read from.`
  
  - Functions
    - get(address)

Lists are great for fast access and dealing with items at the end. However, as we've seen it isn't great at dealing with items not at the end of the list and we have to manually hold onto memory addresses.
  

### HASH TABLES

A hash table is a data structure that's *unordered*. Instead we have "keys" and "values" where we computed an address in memory using the key.

The basic idea is that we have keys that are "hashable" (which we'll get to in a second) and can be used to add, access, and remove from memory very efficiently.

Basically it takes a key and serializes it into a unique number for that key.

You have to be careful though, if you had a really big key you don't want to match it to a memory address that does not exist.

So the hashing algorithm needs to limit the size, which means that there are a limited number of addresses for an unlimited number of values.

The result is that you can end up with collisions. Places where two keys get turned into the same address.

Any real world hash table implementation would have to deal with this

  - Functions
    - hashKey(key)
    - get(key)
    - set(key, value)
    - remove(key)


Data Strucutre that don't uses memory directly
----

  - Organizing data based on how it is used
  - Abstracting away implementation details


### STACKS

  Often implemented as an array or a linked list. 
  
  Array is efficient because the most recently inserted item is placed at the end of the array. If the stack will contain a lot of data and the amount can’t be predicted accurately in advance (as when recursion is implemented as a stack), a linked list is a better choice.

  - Functions
    - push(value)
    - pop()
    - peek()


### QUEUES

  Queues can be implemented as arrays or linked lists

  - Functions
    - enqueue(value)
    - dequeue()
    - peek()

The important thing to note here is that because we used a **Array** to back our queue it inherits the performance of "shift" which is linear O(N) "OKAY."


### GRAPHS


Imagine it like this:
```
A –→ B ←–––– C → D ↔ E
↑    ↕     ↙ ↑     ↘
F –→ G → H ← I ––––→ J
     ↓     ↘ ↑
     K       L
```
We have a bunch of "nodes" (A, B, C, D, ...) that are connected with lines.

These nodes are going to look like this:

```
Node {
  value: ...,
  lines: [(Node), (Node), ...]
}
```
The entire graph will look like this:

```
Graph {
  nodes: [
    Node {...},
    Node {...},
    ...
  ]
}
```
  - Funtions
    - addNode(value)
    - find
    - addLine(startValue, endValue)


### LINKED LISTS

Next we're going to see how a graph-like structure can help optimize ordered lists of data.

Linked lists are a very common data structure that is often used to implement other data structures because of its ability to efficiently additems to the start, middle, and end.

The basic idea of a linked list is similar to a graph. You have nodes that point to other nodes. They look sorta like this:

    1 -> 2 -> 3 -> 4 -> 5

Visualizing them as a JSON-like structure looks like this:
    
```
{
  value: 1,
  next: {
    value: 2,
    next: {
      value: 3,
      next: {...}
    }
  }
}
```
    
  - Functions
    - get(position)
    - add(value, position)
    - remove(position)


### Tree Data Structure

  - Binary Trees:

      AA Tree, AVL Tree, Binary Search Tree, Binary Tree, Cartesian Tree, left child/right sibling tree, order statistic tree, Pagoda, ...

  - B Trees: are multiway trees, commonly used in external storage, in which nodes correspond to blocks on the disk. 

      B Tree, B+ Tree, B* Tree, B Sharp Tree, Dancing Tree, 2-3 Tree, ...

  - Heaps:

      Heap, Binary Heap, Weak Heap, Binomial Heap, Fibonacci Heap, Leonardo Heap, 2-3 Heap, Soft Heap, Pairing Heap, Leftist Heap, Treap, ...

  - Trees:

      Trie, Radix Tree, Suffix Tree, Suffix Array, FM-index, B-trie, ...

  - Multi-way Trees:

      Ternary Tree, K-ary tree, And-or tree, (a,b)-tree, Link/Cut Tree, ...

  - Space Partitioning Trees:

      Segment Tree, Interval Tree, Range Tree, Bin, Kd Tree, Quadtree, Octree, Z-Order, UB-Tree, R-Tree, X-Tree, Metric Tree, Cover Tree, ...

  - Application-Specific Trees:

      Abstract Syntax Tree, Parse Tree, Decision Tree, Minimax Tree, ...


Trees are much like graphs or linked lists except they are "unidirectional". All this means is that they can't have loops of references.

```
  Tree:         Not a Tree:

    A                 A
  ↙   ↘             ↗   ↘
B       C         B ←–––– C

Unequal Ordered Trees
  A          A
 / \        / \
B   C  !=  C   B
          |      |
          D      D
```

If you can draw a loop between connected nodes in a tree... well, you don't have a tree.

 Trees have many different uses, they can be used to optimize searching or sorting. They can organize programs better. 

Extremely simple tree structure. It doesn't have any special rules to it and looks something like this:

    Tree {
      root: {
        value: 1,
        children: [{
          value: 2,
          children: [...]
        }, {
          value: 3,
          children: [...]
        }]
      }
    }


  - Functions
    - traverse(callback)
    - walk(node)
    - add(value, parentValue)

A tree is said to be full if all of its internal nodes have the same degree and all of its leaves are at the same level. 

    The full tree of order d and height h has nodes. (d^(h+1) -1)/(d-1) nodes.
    The height of a full tree of order d and size n is h = log d (nd – n + 1) – 1
    The full binary tree of height h has l = 2^h leaves and m = 2^h – 1 internal nodes.

#### Tree Traversal

 1. The level order traversal **BFS** -> use queue
 1. The Preorder Traversal **DFS** -> recursion which represents **Stack**
  - In Order Traversal
  - Post order Traversal --> This is also the bootom up, means all child nodes L, R than at last parent node.
```java
Node mirror(Node node) {
    if (node == null) return node;

    Node left = mirror(node.left);
    Node right = mirror(node.right);
    // Swap nodes
    node.left = right;
    node.right = left;

    return node;
}

class BinaryTree {
    // Root of Binary Tree
    Node root;
 
    BinaryTree() { root = null; }
 
    void printPostorder(Node node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.key + " ");
    }
 
    void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
 
    void printPreorder(Node node) {
        if (node == null) return;
        System.out.print(node.key + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
```
#### Heap

Priority queues can be implemented as an ordered array or as a heap. Insertion into an ordered array is slow, but deletion is fast. With the heap implementation, both insertion and deletion take O(logN) time.

 - Max Heap
 - Min Heap

 > level-order traversal of the tree. In the resulting array, the parent of the element at index i is at index i/2, and the children are at indexes 2i and 2i+1.

#### BINARY SEARCH TREES

Binary search trees are a fairly common form of tree for their ability to efficiently access, search, insert, and delete values all while keeping them in a sorted order.

Imagine taking a sequence of numbers:

     1  2  3  4  5  6  7

And turning it into a tree starting from the center.
```    
              4
           /     \
        2           6
      /   \       /   \
     1     3     5     7
    -^--^--^--^--^--^--^-
     1  2  3  4  5  6  7
```    
 This is how a binary tree works. Each node can have two children:
   - Left: Less than parent node's value.
   - Right: Greater than parent node's value.

  > Note: In order to make this work all values must be unique in the tree.

This makes the traversal to find a value very efficient. Say we're trying to find the number 5 in our tree:

```    
       (4)         <--- 5 > 4, so move right.
    /      \
   2        (6)    <--- 5 < 6, so move left.
 /   \     /   \
1     3  (5)    7  <--- We've reached 5!
```    
 Notice how we only had to do 3 checks to reach the number 5. If we were to expand this tree to 1000 items. We'd go:

    500 -> 250 -> 125 -> 62 -> 31 -> 15 -> 7 -> 3 -> 4 -> 5
    Only 10 checks for 1000 items!

  > The other important thing about binary search trees is that they are similar to linked lists in the sense that you only need to update the immediately surrounding items when adding or removing a value.

  - Functions
    - contains(value)
    - add(value) // loop until; either added our item or discovered it



<!--Start Fragment-->
