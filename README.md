# Select problem algorithm
Empirical study (Select algorithm)

## Introduction

Problem (Finding the Kth element of Array): Find an element with rank k in an array using indexes 1
through n; the elements in Array are assumed to be unsorted, where 1 <= k <= n. Finding an element
with rank k is equivalent to answering the question: If the array were sorted in non-decreasing order, which element would be in Array[k]?.

## For example:

• The maximum of a set of elements is the last order statistics: k=n.

• The minimum of a set of elements is the first order statistic: k = 1.

• The median key (Lower median): k = floor((n+1)/2)

• The second smallest key: k = 2



The straightforward solution is the sort the array and get the element in the middle of the array.

Better Solutions!

Use Select algorithm, we will discuss two types.
1-Partitioning based solutions
  *Randomization algorithm
  *Median Of three algorithm
  *Median Of three randoms algorithm
  *Median Of medians algorithm
  *First As Pivot Algorithm // I exclude it, its very bad performance. 
  
2-Heap based solutions
   *Min Heap based Algorithm
   *Min Or Max Heap Algorithm
   
   
   
## Type of data we need to test 
   
Random Data : 10,2,1,8,7,5,3,9
Sorted Data : 1,2,3,4,5,6,8
Sorted in revers order : 8,7,5,4,3,2,1
Semi sorted : 1,2,3,4,5,6,1,2,3,4


## Measurements Factors 

Running Time (time in Milliseconds)

Data Move & Data compare counts 


Study


Run all algorithms for all types of data 20 times and take the average of time and average DC & DM.

The Array size is 100,000,000 of type integer




