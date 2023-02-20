/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Medium.ImageOverlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Glory
 */
class Solution {
    
    public static int largestOverlap(int[][] img1, int[][] img2) {
        final int n = img1.length;
        final int magic = 100;
        int ans = 0;
        List<int[]> onesA = new ArrayList<>();
        List<int[]> onesB = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1) {
                    onesA.add(new int[]{i, j});
                }
                if (img2[i][j] == 1) {
                    onesB.add(new int[]{i, j});
                }
            }
        }
        
        for (int[] a : onesA) {
            for (int[] b : onesB) {
                final int key = (a[0] - b[0]) * magic + a[1] - b[1];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        
        for (final int value : map.values()) {
            ans = Math.max(ans, value);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] img1 = {{1}};
        int[][] img2 = {{1}};
        System.out.println(largestOverlap(img1, img2));
    }
}
