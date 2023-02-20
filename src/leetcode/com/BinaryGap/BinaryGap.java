package leetcode.com.BinaryGap;


public class BinaryGap {
    public static int getLongestBinaryGap(int N) {
        // Convert the integer N to its binary representation
        String binary = Integer.toBinaryString(N);
        // Split the binary string into an array of 0s and 1s
        String[] digits = binary.split("");
        // Initialize the count and the maximum count to 0
        int count = 0, maxCount = 0;
        // Iterate through the array
        for (String digit : digits) {
            // If the digit is a 1, reset the count and update the maximum count if necessary
            if (digit.equals("1")) {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
            // If the digit is a 0, increment the count
            else if (digit.equals("0")) {
                count++;
            }
        }
        // Return the maximum count
        return maxCount;
    }

    public static void main(String[] args) {
        // Test the getLongestBinaryGap function

        int N = 1041;
        System.out.println(getLongestBinaryGap(N)); //5

    }
}