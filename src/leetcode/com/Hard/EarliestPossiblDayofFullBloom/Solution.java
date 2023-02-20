package leetcode.com.Hard.EarliestPossiblDayofFullBloom;

import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Glory
 */
public class Solution {

    public static int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int mat[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = plantTime[i];
            mat[i][1] = growTime[i];
        }
        Arrays.sort(mat, (a, b) -> b[1] - a[1]);
        int bloomDay = 0, seedPlantingDay = 0;
        for (int i = 0; i < n; i++) {
            int ptime = mat[i][0];
            int gtime = mat[i][1];
            int result = seedPlantingDay + ptime + gtime;
            bloomDay = Math.max(bloomDay, result);
            seedPlantingDay = seedPlantingDay + ptime;
        }
        return bloomDay;
    }

    public static void main(String[] args) {
        int[] plantTime = {1, 4, 3}, growTime = {2, 3, 1};//Output: 9
        System.out.println(earliestFullBloom(plantTime, growTime));
    }
}

/* int ans = 0;
        int time = 0;
        //Seed[] seeds = new Seed[n];
        Seed[] seeds = new Seed[time];

        for (int i = 0; i < plantTime.length; ++i) {
            seeds[i] = new Seed(plantTime[i], growTime[i]);
        }

        Arrays.sort(seeds, (a, b) -> b.g - a.g);

        for (Seed seed : seeds) {
            time += seed.p;
            ans = Math.max(ans, time + seed.g);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] plantTime = {1, 4, 3}, growTime = {2, 3, 1};
        System.out.println(earliestFullBloom(plantTime, growTime));
    }
}

class Seed {

    public int p;
    public int g;

    public Seed(int p, int g) {
        this.p = p;
        this.g = g;
    }
};
 */
