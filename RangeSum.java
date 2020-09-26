import java.util.Scanner;
class RangeSum
{
    // Max tree size
    final static int MAX = 1000;

    static int BITree[] = new int[MAX];

    int getSum(int index)
    {
        int sum = 0; // Iniialize result

//         index in BITree[] is 1 more than
//         the index in arr[]
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

    /* Function to construct fenwick tree
    from given array.*/
    void AddInBIT(int arr[], int n)
    {
        // Initialize BITree[] as 0
        for(int i=1; i<=n; i++)
            BITree[i] = 0;
    }

    // Main function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        //We can also take generic array and take it's custom input
        int arr[] = {2, 1, 1, 3, 2, 3,
                4, 5, 6, 7, 8, 9};
        int n = arr.length;
        BinaryIndexedTree tree = new BinaryIndexedTree();

        //Range from where to where we want to get the sum
        System.out.println("Enter the upper range of index for finding the sum");
        int UpperRange = sc.nextInt();
        System.out.println("Enter the lower range of index for finding the sum");
        int LowerRange = sc.nextInt();
        // Build fenwick tree from given array
        tree.constructBITree(arr, n);
        int Sum = tree.getSum(UpperRange)- tree.getSum(LowerRange-1);
        System.out.println("Sum of elements in arr  from range:"+LowerRange+" to "+ UpperRange+
                " is "+ Sum);

    }
}
