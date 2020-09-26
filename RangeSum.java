import java.util.*;
import java.lang.*;
import java.io.*;

class RangeSum
{
    // Max tree size
    final static int MAX = 1000;

    static int BITree[] = new int[MAX];

    int getSum(int index)
    {
        int sum = 0; // Iniialize result

        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse ancestors of BITree[index]
        while(index>0)
        {
            // Add current element of BITree
            // to sum
            sum += BITree[index];

            // Move index to parent node in
            // getSum View
            index -= index & (-index);
        }
        return sum;
    }


    public static void updateBIT(int n, int index,
                                 int val) {
        // index in BITree[] is 1 more than
        // the index in arr[]
        index = index + 1;

        // Traverse all ancestors and add 'val'
        while (index <= n) {
            // Add 'val' to current node of BIT Tree
            BITree[index] += val;

            // Update index to that of parent
            // in update View
            index += index & (-index);
        }
    }

    /* Function to construct fenwick tree
    from given array.*/
            void constructBITree( int arr[], int n){
                // Initialize BITree[] as 0
                for (int i = 1; i <= n; i++)
                    BITree[i] = 0;

                // Store the actual values in BITree[]
                // using update()
                for (int i = 0; i < n; i++)
                    updateBIT(n, i, arr[i]);
    }


            // Main function
            public static void main (String args[])
            {
                Scanner sc = new Scanner(System.in);
                int freq[] = {2, 1, 1, 3, 2, 3,
                        4, 5, 6, 7, 8, 9};
                int n = freq.length;
                RangeSum tree = new RangeSum();
                System.out.println("Enter the lower range for sum");
                int LowerRange = sc.nextInt();
                System.out.println("Enter the upper range for sum");
                int UpperRange = sc.nextInt();

                // Build fenwick tree from given array
                tree.constructBITree(freq, n);

                int sum = tree.getSum(UpperRange) - tree.getSum(LowerRange - 1);

                System.out.println("Sum of elements in arr" + " from " + LowerRange + " to " + UpperRange + " is " + sum);

            }

    }
