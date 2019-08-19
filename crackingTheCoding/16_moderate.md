## 16 Moderate

16.1      Number Swapper: Write a function to swap a number  in place (that is, without  temporary  vari­
ables).

Hints: #492, #716, #737


16.2	Word  Frequencies: Design a method to find the frequency of occurrences of any given word in a book. What if we were running this algorithm multiple times?

Hints:#489, #536


16.3 		Intersection: Given two straight line segments (represented as a start point and an end point), compute the point of intersection, if any.

Hints:#465, #472, #497, #517, #527


16.4    Tic Tac Win: Design an algorithm to figure out if someone has won a game of tic-tac-toe.

Hints:#710, #732

16.5     Factorial Zeros: Write an algorithm which computes the number of trailing zeros in n factorial.

Hints:#585, #711, #729, #733, #745


16.6	Smallest Difference: Given two arrays of integers, compute  the pair of values (one value in each array) with the smallest (non-negative) difference. Return the difference.

EXAMPLE

Input: {1, 3,  15,  11,  2}, {23,  127,235,  19, 8} 

Output: 3. That is, the pair  (11, 8).

Hints:#632, #670, #679

16.7		Number Max: Write a method that finds the maximum of two numbers. You should not use if-else or any other comparison operator.

Hints: #473, #513, #707, #728


16.8    English  Int: Given any integer, print an English phrase that describes the integer (e.g., "One Thou­
sand, Two Hundred Thirty Four").

Hints: #502, #588, #688


16.9     Operations: Write methods to implement the multiply, subtract, and divide operations for integers.
The results of all of these are integers. Use only the add operator.

Hints: #572, #600, #613, #648


16.10  Living  People: Given a list of people  with their birth and death  years, implement  a method  to compute the year with the most number of people alive. You may assume that all people were born between 1900 and 2000 (inclusive). If a person was alive during any portion of that year, they should be included in that year's count. For example, Person (birth= 1908, death= 1909) is included in the counts for both 1908 and 1909.

Hints: #476, #490, #507, #514, #523, #532, #541, #549,  #576


16.11  Diving Board: You are building a diving board by placing a bunch of planks of wood end-to-end.
There are two types of planks, one of length shorter and one of length longer. You must use exactly K planks of wood. Write a method to generate all possible lengths for the diving board.

Hints: #690, #700, #715, #722, #740, #747


16.12  XML Encoding: Since  XML is very verbose, you are given a way of encoding it where each tag gets mapped to a pre-defined integer value. The language/grammar is as follows:
```
Element       --> Tag Attributes  END  Children END 
Attribute  --> Tag Value
END                     -->  0
Tag              -->  some predefined mapping  to int
Value           -->   string value
```
For example, the following XML might be converted into the compressed string below (assuming a mapping of family  ->   1,   person  ->2,  firstName  ->   3,   lastName  ->  4,  state
->  5).
```xml
<family  lastName="McDowell"  state="CA">
<person  firstName="Gayle">Some  Message</person>
</family> Becomes:
```

1 4  McDowell SCA  0  2  3 Gayle  0  Some Message  0  0

Write code to print the encoded version of an XML element (passed in Element and Attribute objects).

Hints:#466

16.13   Bisect Squares: Given two squares on a two-dimensional plane, find a line that would cut these two squares in half. Assume that the top and the bottom sides of the square run parallel to the x-axis.

Hints: #468, #479, #528, #560


16.14  Best  Line:  Given a two-dimensional graph with points on it, find a line which passes the most number of points.

Hints:#491, #520, #529, #563


16.15   Master Mind: The Game of Master Mind is played as follows:
The computer has four slots, and each slot will contain a ball that is red (R). yellow (Y). green (G) or blue (B). For example, the computer might have RGGB (Slot #1 is red, Slots #2 and #3 are green, Slot #4 is blue).

You, the user, are trying to guess the solution. You might, for example, guess YRGB.

When you guess the correct color for the correct slot, you get a "hit:'  If you  guess a color that exists but is in the wrong slot, you get a "pseudo-hit:' Note that a slot that is a hit can never count as a pseudo-hit.

For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit. 

Write a method that, given a guess and a solution, returns the number of hits and pseudo-hits. 

Hints:#639, #730                  pg494

16.16  Sub Sort:  Given an array of integers, write a method to find indices m and n such that if you sorted elements m through n, the entire array would be sorted. Minimize n  -  m (that is, find the smallest such sequence).

EXAMPLE

lnput:1,   2,   4,  7,   10,   11,   7,   12,   6,   7,   16,   18,   19

Output: (3,  9)

Hints:#482, #553, #667, #708, #735, #746

16.17   Contiguous Sequence: You are given an array of integers (both positive and negative).  Find the contiguous sequence with the largest sum. Return the sum.

EXAMPLE

lnput:2,    -8,    3,   -2,  4,  -10

Output:5   ( i. e • , { 3,   -2,  4})

Hints:#537, #551, #567, #594, #614

16.18  Pattern Matching: You are given two strings, pattern and value. The pattern string consists of just the letters aand b, describing a pattern within a string. For example, the string catcatgocatgo matches the pattern aabab (where cat is a and go is b). It also matches patterns like a, ab, and b. Write a method to determine if value matches pattern.

Hints:#631, #643, #653, #663, #685, #718, #727


16.19  Pond Sizes: You have an integer matrix representing  a plot of land, where the value at that loca­ tion represents the height above sea level. A value of zero indicates water. A pond is a region of water connected  vertically, horizontally, or diagonally. The size of the pond is the total number of connected  water cells. Write a method to compute the sizes of all ponds in the matrix.

EXAMPLE

Input:
```
0	2	1  0
0	1	0  1
1	1	0  1
0	1	0  1
```
Output: 2, 4, 1 (in any order)

Hints:#674, #687, #706, #723


16.20  T9: On old cell phones, users typed on a numeric keypad and the phone would provide a list of words that matched these numbers. Each digit mapped to a set of O - 4 letters. Implement an algo­ rithm to return a list of matching words, given a sequence of digits. You are provided a list of valid words (provided in whatever data structure you'd like). The mapping is shown in the diagram below:

![](media/IX_16_01.JPG)
 
EXAMPLE 

Input: 8733

Output: tree,   used 

Hints:#477, #487, #654, #703, #726, #744


16.21  Sum Swap: Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.

EXAMPLE

Input: {4, 1, 2, 1, 1, 2} and {3, 6, 3, 3} 

Output: {1, 3}

Hints:#545, #557, #564, #577,#583, #592, #602, #606, #635


16.22   Langton's Ant: An ant is sitting on an infinite grid of white and black squares. It initially faces right.
At each step, it does the following:

(1) At a white square, flip the color of the square, turn 90 degrees right (clockwise), and move forward one unit.

(2) At a black square, flip the color of the square, turn 90 degrees left (counter-clockwise), and move forward one unit.
Write a program to simulate the first  K moves that the ant makes and print the final board as a grid. Note that you are not provided with the data structure to represent the grid. This is something you must design yourself. The only input to your method is K. You should print the final grid and return nothing. The method signature might be something like void printKMoves(int  K).

Hints:#474, #481, #533, #540, #559, #570, #599, #616, #627


16.23  Rand7  from  Rands: Implement a method rand7() given rand5(). That is, given a method that generates a random number between O and 4 (inclusive), write a method that generates a random number between O and 6 (inclusive).

Hints:#505, #574, #637, #668, #697, #720

16.24  Pairs  with  Sum:  Design an algorithm to find all pairs of integers within an array which sum to a specified value.

Hints:#548, #597, #644, #673 ......pg520

16.25  LRU Cache: Design and build a "least recently used" cache, which evicts the least recently used item. The cache should map from keys to values (allowing you to insert and retrieve a value associ­ ated with a particular key) and be initialized with a max size. When it is full, it should evict the least recently used item.

Hints: #524, #630, #694........- pg521

16.26   Calculator: Given an arithmetic equation consisting of positive integers, +, -, * and / (no paren­theses), compute the result.

EXAMPLE 

Input: 2*3+5/6*3+15

Output: 23.5 
 
Hints:#521, #624, #665, #698