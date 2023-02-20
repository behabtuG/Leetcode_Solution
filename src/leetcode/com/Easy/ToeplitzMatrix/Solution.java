/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Easy.ToeplitzMatrix;

/**
 *
 * @author Glory
 */
public class Solution {

    /*
     * Given a square matrix, find if it’s a Toeplitz matrix or not. 
     * A Toeplitz (or diagonal-constant) matrix is a matrix in which each descending diagonal from left to right is constant,
     * i.e., all elements in a diagonal are same.
     * In general, any n×n matrix mat[][] is a Toeplitz matrix if every cell mat[i][j] is same as mat[i-1][j-1], mat[i+1][j+1], mat[i-2][j-2], mat[i+2][j+2], 
     *.. for every cell mat[i][j] and all the valid cells mat[i+k][j+k] or mat[i-k][j-k] 
     * The idea is very simple. For each element of first row and first column(or last row and last column) in the matrix, we check if descending diagonal starting from that element have same values or not.
     * If we found any diagonal having different values, we return false.
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i + 1 < matrix.length; ++i) {
            for (int j = 0; j + 1 < matrix[0].length; ++j) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        // Explanation:
        //In the above grid, the diagonals are:
        //"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
        System.out.println(isToeplitzMatrix(matrix));
    }
    
}
