Search & Sort
=============

#### Linear Search

Given a list L of n elements with values or records L0 ... Ln−1, and target value T, the following subroutine uses linear search to find the index of the target T in L.

 1. Set i to 0.
 1. If Li = T, the search terminates successfully; return i.
 1. Increase i by 1.
 1. If i < n, go to step 2. Otherwise, the search terminates unsuccessfully.

#### Binary Search

**Works only for indexed array.**

Here is the recursive binary search algorithm :
(Precondition: s = {S0 , s 1 , . . ., Sn-1 } is a sorted sequence of n ordinal values of the same type as x.)
(Postcondition: either the index i is returned where Si = x, or –1 is returned.)

  1. If the sequence is empty, return –1.
  1. Let Si be the middle element of the sequence.
  1. If Si = x, return itSindex i.
  1. If Si < x, apply the algorithm on the subsequence that lies above Si .
  1. Apply the algorithm on the subsequence of s that lies below Si .
    
    G.P. = a(1-r^n)/(1-r)
    T(n)=T(n/2)+1
    T(n/2)= T(n/4)+1+1
    Put the value of The(n/2) in above so T(n)=T(n/4)+1+1 . . . . T(n/2^k)+1+1+1.....+1
    =T(2^k/2^k)+1+1....+1 up to k
    =T(1)+k
    As we taken 2^k=n
    K = log n
    So Time complexity is O(log n)

$$c^2$$

## Sort

### Comparison Sort
  1. ##### Insertion Sort

  1. ##### Bubble Sort
     (Precondition: s = {S0 . . . Sn–1 } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)  
     1. Do steps 2–4 for i = n –1 down to 1.  
     1. Do step 3 for j = 0 up to i–1.  
     1. If the two consecutive elements Sj and Sj+1 , are out of order, swap them.  
     1. (Invariants: The subsequence { Si . . . Sn–1 } is sorted, and Si = max{ S0 . . . Si }.)  

    > In general, where N is the number of items in the array, there are N-1 comparisons on the first pass, N-2 on the second, and so on. The formula for the sum of such a series is `(N–1) + (N–2) + (N–3) + ... + 1 = N*(N–1)/2`

  1. ##### Selection Sort
     (Precondition: s = {S0 . . . Sn–1 } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)
     1. Do steps 2–4 for i = n –1 down to 1.
     1. Locate the index m of the largest element among {S0 . . Si } .
     1. Swap Si and Sm .
     1. (Invariants: the subsequence { Si . . . Sn-1 } is sorted, and Si = max{ S0 . . . Si }.)
 
  1. ##### Merge Sort
     (Precondition: s = {Sp . . . Sq–1 } is a sequence of q – p ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)
     1. If q – p > 1, do steps 2–5.
     1. Split Sinto two subsequences, a = {Sp . . . Sm–1 } and b = {Sm . . . Sq–1 }, where m = ( q – p )/2.
     1. Sort a.
     1. Sort b.
     1. Merge a and b back into s, preserving order.

  1. ##### Quick Sort
     (Precondition: s = {Sp . . . Sq–1 } is a sequence of q – p ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)
     1. If q – p > 1, do steps 2–5.
     1. Apply Algorithm 14.7 to s, obtaining the pivot index m.
     1. (Invariant: the pivot element Sm iSin its correct sorted position.)
     1. Apply the quick sort to {S0 , s 1 , . . . , Sm–1 }.
     1. Apply the quick sort to {Sm+1 , Si+2 , . . . , Sn-1 }.

  1. ##### Tim Sort

  1. ##### Shell Sort
     (Precondition: s = {S0 . . . Sn-1 } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)
     1. Set d = 1.
     1. Repeat step 3 until 9d > n.
     1. Set d = 3d + 1.
     1. Do steps 5–6 until d = 0.
     1. Apply the insertion sort to each of the d skip-d-subsequences of s.
     1. Set d = d/3.

  1. ##### Heap Sort
     (Precondition: s = {S0 . . . Sn-1 } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence Sis sorted.)
     1. Do steps 2–3 for i = n/2 –1 down to 0.
     1. Apply the heapify algorithm to the subsequence {Si . . . Sn-1 }.
     1. (Invariant: every root-to-leaf path in Sis nonincreasing.)
     1. Do steps 5–7 for i = n –1 down to 1.
     1. Swap Si with S0 .
     1. (Invariant: The subsequence {Si . . . Sn-1 } is sorted.)
     1. Apply the heapify algorithm to the subsequence {S0 . . . Si–1 }.
      **The Heapify**
         (Preconditions: ss = {Si . . . Sj–1 } is a subsequence of j–i ordinal values, and both subsequences {Si+1 . . . Sj–1 } and {Si+2 . . . Sj–1 } have the heap property.)
         (Postcondition: sSitself has the heap property.)
         1. Let t = s 2i+1 .
         1. Let s k = max{s 2i+1 , s 2i+2 }, so k = 2i+1 or 2i+2, the index of the larger child.
         1. If t < s k , do steps 4–6.
         1. Set Si = s k .
         1. Set i = k.
         1. If i < n/2 and Si < max{s 2i+1 , s 2i+2 }, repeat steps 1–4.
         1. Set s k = t.

### Non Comparison Sort
  1. ##### Radix Sort
     (Precondition: s = {S0 . . . Sn-1 } is a sequence of n integers or character strings with radix r and width w.)
     (Postcondition: The sequence Sis sorted numerically or lexicographically.)
     1. Repeat step 2 for d = 0 up to w –1.
     1. Apply a stable sorting algorithm to the sequence s, sorting only on digit number d.
     A sorting algorithm is said to be stable if it preserves the relative order of elements with equal keys. For example, the insertion sort is stable, but the heap sort is not.
  
  1. ##### Counting Sort

#### Comparison and non comparison sort
  1. ##### Bucket Sort -> Sort of comparison algo
     (Precondition: s = {S0 . . . Sn-1 } is a sequence of n ordinal values with known minimum value min and maximum value max.)
     (Postcondition: the sequence Sis sorted.)
     1. Initialize an array of n buckets (collections).
     1. Repeat step 3 for each Si in the sequence.
     1. Insert Si into bucket j, where j = rn , r = (Si – min)/(max + 1 – min).
     1. Sort each bucket.
     1. Repeat step 6 for j from 0 to n –1.
     1. Add the elements of bucket j sequentially back into s.



<!--Start Fragment-->