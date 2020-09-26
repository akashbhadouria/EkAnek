# EkAnek
Solution for the problem 2

Problem 2

You’re given an ordered set of n numbers (n is a power of 2). Initially all the numbers are zero. You’re supposed to perform a sequence of following online operations:

Add x to the ith entry
Report the sum of numbers between indices i and j

It’s easy to see that if you store all these numbers in an array, the first operation can be performed in O(1) time but the second operation can take O(n) time in the worst case.

Our objective today is to perform these operations efficiently. Your job is to first create a data-structure which will guarantee better than O(n) time for both operations and then write the following two methods with the given signature:

void add(int index, int value)
int sum(int startIndex, int endIndex)

Your data structure may have a simple initializer/constructor such as this:

My_custom_data_structure_instance = new MyCustomDataStructure(n)

