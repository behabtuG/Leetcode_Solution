package leetcode.com.Medium.OnlineStockSpan;

import java.util.Arrays;

public class StockSpanner {
    /**private Stack<int[]> stack;
    public StockSpanner() {
        this.stack = new Stack<>();
    }
    public int next(int price) {
        int count = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            count += stack.pop()[1];
        }
        stack.push(new int[]{price, count});
        return count;
    }
    */
    static void calculateSpan(int price[], int n, int S[])
    {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by linearly checking
        // previous days
        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                S[i]++;
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

    // Driver program to test above functions
    public static void main(String[] args)
    {
        int price[] = { 100, 80, 60, 70, 60, 75, 85};//Output [null, 1, 1, 1, 2, 1, 4, 6]
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }
}
    /**public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().getKey() <= price)
            span += stack.pop().getValue();
        stack.push(new Pair<>(price, span));
        return span;
    }
    // (price, span)
    private Stack<Pair<Integer, Integer>> stack = new Stack<>();
}
*/
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
