Search & Sort
=============

#### Linear Search

Given a list L of n elements with values or records L₀ ... Lₙ-₁, and target value T, the following subroutine uses linear search to find the index of the target T in L.

 1. Set i to 0.
 1. If Lᵢ = T, the search terminates successfully; return i.
 1. Increase i by 1.
 1. If i < n, go to step 2. Otherwise, the search terminates unsuccessfully.

#### Binary Search

**Works only for indexed array.**

Here is the recursive binary search algorithm :
(Precondition: s = {S₀, S₁, . . ., Sₙ-₁} is a sorted sequence of n ordinal values of the same type as x.)
(Postcondition: either the index i is returned where Sᵢ = x, or –1 is returned.)

  1. If the sequence is empty, return –1.
  1. Let Sᵢ be the middle element of the sequence.
  1. If Sᵢ = x, return itSindex i.
  1. If Sᵢ < x, apply the algorithm on the subsequence that lies above Sᵢ.
  1. Apply the algorithm on the subsequence of s that lies below Sᵢ.
    
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
     (Precondition: s = {S₀ . . . Sₙ–₁ } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence S is sorted.)  
     1. Do steps 2–4 for i = n –1 down to 1.  
     1. Do step 3 for j = 0 up to i–1.  
     1. If the two consecutive elements Sⱼ and Sⱼ+₁ , are out of order, swap them.  
     1. (Invariants: The subsequence { Sᵢ . . . Sₙ–₁ } is sorted, and Si = max{ S₀. . . Sᵢ}.)  

    > In general, where N is the number of items in the array, there are N-1 comparisons on the first pass, N-2 on the second, and so on. The formula for the sum of such a series is `(N–1) + (N–2) + (N–3) + ... + 1 = N*(N–1)/2`

  1. ##### Selection Sort
     (Precondition: s = {S₀ . . . Sₙ–₁} is a sequence of n ordinal values.)
     (Postcondition: The entire sequence S is sorted.)
     1. Do steps 2–4 for i = n –1 down to 1.
     1. Locate the index m of the largest element among {S₀ . . Sᵢ } .
     1. Swap Sᵢ and Sₘ .
     1. (Invariants: the subsequence { Sᵢ . . . Sₙ-₁ } is sorted, and Sᵢ = max{ S₀ . . . Sᵢ }.)
 
  1. ##### Merge Sort
     (Precondition: s = {Sₚ . . . S\_q–₁ } is a sequence of q – p ordinal values.)
     (Postcondition: The entire sequence S is sorted.)
     1. If q – p > 1, do steps 2–5.
     1. Split Sinto two subsequences, a = {Sₚ . . . Sₘ–₁ } and b = {Sₘ . . . S\_q–₁ }, where m = ( q – p )/2.
     1. Sort a.
     1. Sort b.
     1. Merge a and b back into s, preserving order.

  1. ##### Quick Sort
     (Precondition: s = {Sₚ . . . S\_q–₁ } is a sequence of q – p ordinal values.)
     (Postcondition: The entire sequence S is sorted.)
     1. If q – p > 1, do steps 2–5.
     1. Apply Algorithm 14.7 to s, obtaining the pivot index m.
     1. (Invariant: the pivot element Sm iSin its correct sorted position.)
     1. Apply the quick sort to {S₀ , s₁ , . . . , Sₘ–₁ }.
     1. Apply the quick sort to {Sₘ+₁ , Sᵢ+₂ , . . . , Sₙ-₁ }.

  1. ##### Tim Sort

  1. ##### Shell Sort
     (Precondition: s = {S₀ . . . Sₙ-₁ } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence S is sorted.)
     1. Set d = 1.
     1. Repeat step 3 until 9d > n.
     1. Set d = 3d + 1.
     1. Do steps 5–6 until d = 0.
     1. Apply the insertion sort to each of the d skip-d-subsequences of s.
     1. Set d = d/3.

  1. ##### Heap Sort
     (Precondition: s = {S₀ . . . Sₙ-₁ } is a sequence of n ordinal values.)
     (Postcondition: The entire sequence S is sorted.)
     1. Do steps 2–3 for i = n/2 –1 down to 0.
     1. Apply the heapify algorithm to the subsequence {Sᵢ . . . Sₙ-₁ }.
     1. (Invariant: every root-to-leaf path in S is nonincreasing.)
     1. Do steps 5–7 for i = n –1 down to 1.
     1. Swap Si with S0 .
     1. (Invariant: The subsequence {Sᵢ . . . Sₙ-₁ } is sorted.)
     1. Apply the heapify algorithm to the subsequence {S₀ . . . Sᵢ–₁ }.
      **The Heapify**
         (Preconditions: ss = {Sᵢ . . . Sⱼ–₁ } is a subsequence of j–i ordinal values, and both subsequences {Sᵢ+₁ . . . Sⱼ–₁ } and {Sᵢ+₂ . . . Sⱼ–₁ } have the heap property.)
         (Postcondition: sSitself has the heap property.)
         1. Let t = s 2ᵢ+₁ .
         1. Let sₖ = max{s 2ᵢ+₁ , s 2ᵢ+₂ }, so k = 2ᵢ+₁ or 2ᵢ+₂, the index of the larger child.
         1. If t < sₖ , do steps 4–6.
         1. Set Sᵢ = sₖ .
         1. Set i = k.
         1. If i < n/2 and Si < max{s 2ᵢ+₁ , s 2ᵢ+₂ }, repeat steps 1–4.
         1. Set sₖ = t.

### Non Comparison Sort
  1. ##### Radix Sort
     (Precondition: s = {S₀ . . . Sₙ-₁ } is a sequence of n integers or character strings with radix r and width w.)
     (Postcondition: The sequence S is sorted numerically or lexicographically.)
     1. Repeat step 2 for d = 0 up to w –1.
     1. Apply a stable sorting algorithm to the sequence s, sorting only on digit number d.
     A sorting algorithm is said to be stable if it preserves the relative order of elements with equal keys. For example, the insertion sort is stable, but the heap sort is not.
  
  1. ##### Counting Sort

#### Comparison and non comparison sort
  1. ##### Bucket Sort -> Sort of comparison algo
     (Precondition: s = {S₀ . . . Sₙ-₁ } is a sequence of n ordinal values with known minimum value min and maximum value max.)
     (Postcondition: the sequence S is sorted.)
     1. Initialize an array of n buckets (collections).
     1. Repeat step 3 for each Si in the sequence.
     1. Insert Si into bucket j, where j = rn , r = (Sᵢ – min)/(max + 1 – min).
     1. Sort each bucket.
     1. Repeat step 6 for j from 0 to n –1.
     1. Add the elements of bucket j sequentially back into s.



<!--Start Fragment-->