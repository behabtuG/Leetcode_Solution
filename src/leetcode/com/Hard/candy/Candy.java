/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Hard.candy;

/**
 *
 * @author GLORY
 */
public class Candy {

    public static int candy(int[] ratings) {
        int sum = 0;
        int[] a = new int[ratings.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                a[i + 1] = a[i] + 1;
            }
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (a[i - 1] < (a[i] + 1)) {
                    a[i - 1] = a[i] + 1;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] a ={1,2,3};
        System.out.println(candy(a));
    }
}
