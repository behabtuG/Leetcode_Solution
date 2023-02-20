package leetcode.com.Medium.MinimumFallingPathSum;

import java.util.Arrays;

public class Solution {
    public static int minFallingPathSum(int[][] matrix) {
        final int n = matrix.length;
        for (int i = 1; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - 1); k < Math.min(n, j + 2); ++k)
                    min = Math.min(min, matrix[i - 1][k]);
                matrix[i][j] += min;
            }
        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        int[][] matrix = {{-19, 57}, {-40, -5}};//Output: -59
        System.out.println(minFallingPathSum(matrix));
    }
}
