---
title: Data Structure & Algorithms
author: Manish
rights:  Creative Commons Non-Commercial Share Alike 3.0
language: en-US
...
    
DS Introduction / Cheat Sheet
=============================

    pandoc.exe --toc --toc-depth 6 -s *.md -o ds_new.epub

Knowing your data structures can help you:

- Manage complexity and make your programs easier to follow.
- Build high-performance, memory-efficient programs.

### Amortized Ananlysis

Amortized analysis is a method for analyzing a given algorithm's time complexity, or how much of a resource, especially time or memory, it takes to execute. The motivation for amortized analysis is that looking at the worst-case run time per operation can be too pessimistic. 

- Online algorithm is one that can process its input piece-by-piece in a serial fashion, i.e., in the order that the input is fed to the algorithm, without having the entire input available from the start.
- Offline algorithm is given the whole problem data from the beginning and is required to output an answer which solves the problem at hand. In operations research, the area in which online algorithms are developed is called online optimization
- As an example, consider the sorting algorithms selection sort and insertion sort: Selection sort repeatedly selects the minimum element from the unsorted remainder and places it at the front, which requires access to the entire input; it is thus an offline algorithm. On the other hand, insertion sort considers one input element per iteration and produces a partial solution without considering future elements. Thus, insertion sort is an online algorithm.

### Asymptotic Notations

Classify algorithms according to their performances.
```
Definition of "big Oh" `O()` `Worst case` -> upper bound
Definition of "big Omega" `Ω()` `Best case` -> lower bound
Definition of "big Theta" `Θ()` `Avg case`
```
 > With **Asymptotic Analysis**, we can’t judge which one is better as we ignore constants in Asymptotic Analysis. Also, in Asymptotic analysis, we always talk about input sizes larger than a constant value. It might be possible that those large inputs are never given to your software and an algorithm which is asymptotically slower, always performs better for your particular situation.

| Data Structure                    | Insert   | Delete     | Balance  | Get at index | Search   | Find minimum        | Find maximum        | Space usage |
| ----                              | ----     | ----       | ----     | ----         | ----     | ----                | ----                | ----        |
| Unsorted array                    | O(1)     | O(1)       | N/A      | O(1)         | O(n)     | O(n)                | O(n)                | O(n)        |
| Sorted array                      | O(n)     | O(n)       | N/A      | O(1)         | O(log n) | O(1)                | O(1)                | O(n)        |
| Unsorted linked list              | O(1)*    | O(1)*      | N/A      | O(n)         | O(n)     | O(n)                | O(n)                | O(n)        |
| Sorted linked list                | O(n)*    | O(1)*      | N/A      | O(n)         | O(n)     | O(1)                | O(1)                | O(n)        |
| Self-balancing binary search tree | O(log n) | O(log n)   | O(log n) | N/A          | O(log n) | O(log n)            | O(log n)            | O(n)        |
| Heap                              | O(log n) | O(log n)** | O(log n) | N/A          | O(n)     | O(1) for a min-heap | O(1) for a max-heap | O(n)        |
|                                   |          |            |          |              |          | O(n) for a max-heap | O(n) for a min-heap |             |
| Hash table                        | O(1)     | O(1)       | O(n)     | N/A          | O(1)     | O(n)                | O(n)                | O(n)        |
| Trie (k = average length of key)  | O(k)     | O(k)       | N/A      | O(k)         | O(k)     | O(k)                | O(k)                | O(k n)      |

\* The cost to add or delete an element into a known location in the list (i.e. if you have an iterator to the location) is O(1). If you don't know the location, then you need to traverse the list to the location of deletion/insertion, which takes O(n) time. 

\** The deletion cost is O(log n) for the minimum or maximum, O(n) for an arbitrary element.

 > Note: Insert on an unsorted array is sometimes quoted as being O(n) due to the assumption that the element to be inserted must be inserted at one particular location of the array, which would require shifting all the subsequent elements by one position. However, in a classic array, the array is used to store arbitrary unsorted elements, and hence the exact position of any given element is of no consequence, and insert is carried out by increasing the array size by 1 and storing the element at the end of the array, which is a O(1) operation. Likewise, the deletion operation is sometimes quoted as being O(n) due to the assumption that subsequent elements must be shifted, but in a classic unsorted array the order is unimportant (though elements are implicitly ordered by insert-time), so deletion can be carried out by swapping the element to be deleted with the last element in the array and then decrementing the array size by 1, which is a O(1) operation.

This above table is only an approximate summary; for each data structure, there are special situations and variants that may lead to different costs. Also two or more data structures can be combined to obtain lower costs.

**Characteristics of Data Structures**

| Data Structure | Advantages                           | Disadvantages                         |
| ----           | ----                                 | ----                                  |
| Array          | Quick insertion,                     | Slow search,                          |
|                | very fast access if index known.     | slow deletion,                        |
|                |                                      | fixed size.                           |
| Ordered array  | Quicker search than unsorted array.  | Slow insertion and deletion,          |
|                |                                      | fixed size.                           |
| Stack          | Provides last-in,                    | Slow access to other items.           |
|                | first-out access.                    |                                       |
| Queue          | Provides first-in,                   | Slow access to other items.           |
|                | first-out access.                    |                                       |
| Linked list    | Quick insertion,                     | Slow search.                          |
|                | Quick deletion.                      |                                       |
| Binary tree    | Quick search,                        | Deletion algorithm is complex.        |
|                | insertion,                           |                                       |
|                | deletion (if tree remains balanced). |                                       |
| Red-black tree | Quick search,                        | Complex.                              |
|                | insertion,                           |                                       |
|                | deletion.                            |                                       |
|                | Tree always balanced.                |                                       |
| 2-3-4 tree     | Quick search,                        | Complex.                              |
|                | insertion,                           |                                       |
|                | deletion.                            |                                       |
|                | Tree always balanced.                |                                       |
|                | Similar trees good for disk storage. |                                       |
| Hash table     | Very fast access if key known.       | Slow deletion,                        |
|                | Fast insertion.                      | access slow if key not known,         |
|                |                                      | inefficient memory usage.             |
| Heap           | Fast insertion,                      | Slow access to                        |
|                | deletion,                            | other items.                          |
|                | access to largest item.              |                                       |
| Graph          | Models real-world                    | Some algorithms are slow and complex. |
|                | situations.                          |                                       |

**Array Sorting Algorithm**

| Algorithm      | Time Complexity |                |                 | Space Complexity |
| ----           | ----            | ----           | ----            | ----             |
|                | **Best**        | **Average**    | **Worst**       | **Worst**        |
| Quicksort      | Ω(n log(n))     | Θ(n log(n))    | O(n²)           | O(log(n))        |
| Mergesort      | Ω(n log(n))     | Θ(n log(n))    | **O(n log(n))** | O(n)             |
| Timsort        | Ω(n)            | Θ(n log(n))    | **O(n log(n))** | O(n)             |
| Heapsort       | Ω(n log(n))     | Θ(n log(n))    | **O(n log(n))** | **O(1)**         |
| Bubble Sort    | Ω(n)            | Θ(n²)          | O(n²)           | **O(1)**         |
| Insertion Sort | Ω(n)            | Θ(n²)          | O(n²)           | **O(1)**         |
| Selection Sort | Ω(n²)           | Θ(n²)          | O(n²)           | **O(1)**         |
| Tree Sort      | Ω(n log(n))     | Θ(n log(n))    | O(n²)           | O(n)             |
| Shell Sort     | Ω(n log(n))     | Θ(n(log(n))^2) | O(n(log(n))^2)  | **O(1)**         |
| Bucket Sort    | **Ω(n+k)**      | **Θ(n+k)**     | O(n²)           | O(n)             |
| Radix Sort     | **Ω(nk)**       | **Θ(nk)**      | **O(nk)**       | O(n+k)           |
| Counting Sort  | **Ω(n+k)**      | **Θ(n+k)**     | **O(n+k)**      | O(k)             |
| Cubesort       | Ω(n)            | Θ(n log(n))    | O(n log(n))     | O(n)             |


**Common Data Structure Operations**

| Data Structure     | Time Complexity |            |               |              |            |            |               |              | Space Complexity |
| ----               | ----            | ----       | ----          | ----         | ----       | ----       | ----          | ----         | ----             |
|                    | **Average**     |            |               |              | **Worst**  |            |               |              | **Worst**        |
|                    | **Access**      | **Search** | **Insertion** | **Deletion** | **Access** | **Search** | **Insertion** | **Deletion** |                  |
| Array              | **Θ(1)**        | Θ(n)       | Θ(n)          | Θ(n)         | **O(1)**   | O(n)       | O(n)          | O(n)         | O(n)             |
| Stack              | Θ(n)            | Θ(n)       | **Θ(1)**      | **Θ(1)**     | O(n)       | O(n)       | **O(1)**      | **O(1)**     | O(n)             |
| Queue              | Θ(n)            | Θ(n)       | **Θ(1)**      | **Θ(1)**     | O(n)       | O(n)       | **O(1)**      | **O(1)**     | O(n)             |
| Singly-Linked List | Θ(n)            | Θ(n)       | **Θ(1)**      | **Θ(1)**     | O(n)       | O(n)       | **O(1)**      | **O(1)**     | O(n)             |
| Doubly-Linked List | Θ(n)            | Θ(n)       | **Θ(1)**      | **Θ(1)**     | O(n)       | O(n)       | **O(1)**      | **O(1)**     | O(n)             |
| Skip List          | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(n)       | O(n)       | O(n)          | O(n)         | **O(n log(n))**  |
| Hash Table         | N/A             | **Θ(1)**   | **Θ(1)**      | **Θ(1)**     | N/A        | O(n)       | O(n)          | O(n)         | O(n)             |
| Binary Search Tree | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(n)       | O(n)       | O(n)          | O(n)         | O(n)             |
| Cartesian Tree     | N/A             | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | N/A        | O(n)       | O(n)          | O(n)         | O(n)             |
| B-Tree             | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(log(n))  | O(log(n))  | O(log(n))     | O(log(n))    | O(n)             |
| Red-Black Tree     | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(log(n))  | O(log(n))  | O(log(n))     | O(log(n))    | O(n)             |
| Splay Tree         | N/A             | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | N/A        | O(log(n))  | O(log(n))     | O(log(n))    | O(n)             |
| AVL Tree           | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(log(n))  | O(log(n))  | O(log(n))     | O(log(n))    | O(n)             |
| KD Tree            | Θ(log(n))       | Θ(log(n))  | Θ(log(n))     | Θ(log(n))    | O(n)       | O(n)       | O(n)          | O(n)         | O(n)             |

## Recursion

**Tail recursion?** A recursive function is tail recursive when recursive call is the last thing executed by the function.

 1. **Factorial**: n! = n(n-1)! {n > 1} 
                   n! = 1 {n = 0}

 1. **Fibonacci**: Fn = F(n-1) + F(n-2) {n > 1}
                      = 0 {n = 0}
                      = 1 {n = 1}
    
> Fibonacci by recursive can be made faster by using **Memonization!** i.e. by memorizing the return of the function calls already done!
~~~
             F(n)
            /    \
        F(n-1)   F(n-2)
        /   \     /      \
    F(n-2) F(n-3) F(n-3)  F(n-4)
   /    \
 F(n-3) F(n-4)

    fib(1)-->1
   fib(2)
    fib(0)-->0
  fib(3)
   fib(1)-->1
 fib(4)
   fib(1)-->1
  fib(2)
   fib(0)-->0
fib(5)
   fib(1)-->1
  fib(2)
   fib(0)-->0
 fib(3)
  fib(1)-->1
~~~

1. **Towers Of Hanoi**
  The general solution to the Towers of Hanoi game is naturally recursive:
  - Part I: Move the smaller n–1 disks from peg A to peg B.
  - Part II: Move the remaining disk from peg A to peg C.
  - Part III: Move the smaller n–1 disks from peg B to peg C.
  Problem Statement: Move all the n disk from tower x to tower y using tower z.

https://github.com/singh-man/projecs/blob/master/ds/src/main/java/HanoiTowers.java

Time Complexity `T(n) = 2T(n-1) + 1; (1 is constant)`
```
T(n) = 2*T(n-1) + 1
T(n) = 2 * ( 2 * T(n-2) + 1) + 1
T(n) = (2 ^ 2) * T(n-2) + 2^1 + 2^0
T(n) = (2^k) * T(n-k) + 2^(k-1) + 2^(k-2) + ... + 2^0
Solving this the closed from comes out to be
T(n) = (2^n) - 1 with T(0) = 0

O(2^n)
```

1. **Euclid's** GCD(x, 0) = x and GCD(x, y) = GCD(y, x % y)
```java
public int GCD(int x, int y) {
  if (y == 0) {
      return x;
  } else {
    return GCD(y, x % y);
  }
}
```

2. **Euclidean Algorithm** calling either gcd(m,n-m) or gcd(m-n,n) :
```java
public static int gcd(int m, int n) {
    if (m == n) {
        return n; // basis
    } else if (m < n) {
        return gcd(m, n - m); // recursion
    } else {
        return gcd(m - n, n); // recursion
    }
}
```

3. **LOG**: log(2, 4) -> 2; log(10, 1000) -> 3
https://github.com/singh-man/projecs/blob/master/ds/src/main/java/Number_DecimalToBinaryMisc.java


4. **Multiply** -> multiply(2, 3) -> 6
```java
public int multiply(int x, int y) {
    if (x == 0) {
        return x;
    } else {
        return multiply(x - 1, y) + y;
    }
}
```

5. **Cumulative Sum**: sum of values fropm 1 to k. sumtok(5) -> 15
https://github.com/singh-man/projecs/blob/master/ds/src/main/java/Number_DecimalToBinaryMisc.java

6. **Add Odd Values**: 
https://github.com/singh-man/projecs/blob/master/ds/src/main/java/Number_DecimalToBinaryMisc.java

7. **Sum of the Digits** -> sumOfDigits(1234) -> 10
```java
int getsum(int n) {
    return n == 0 ? 0 : n % 10 + getsum(n / 10);
}
```

8. **Count Characters** in string "ctcowAt" find no. of A in string
```java
public int countChr(String str) {
    if (str.length() == 0) {
        return 0;
    }
    int count = 0;
    if (str.substring(0, 1).equals("A")) {
        count = 1;
    }
    return count + countChr(str.substring(1, str.length()));
}
```

9. Find max width of binary tree
```java
Queue
```

<!--Start Fragment-->
