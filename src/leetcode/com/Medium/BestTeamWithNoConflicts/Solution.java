package leetcode.com.Medium.BestTeamWithNoConflicts;

import java.util.Arrays;

public class Solution {
    /**  class Player {
     public int age;
     public int score;

     public Player(int age, int score) {
     this.age = age;
     this.score = score;
     }
     }

     /**public  int bestTeamScore(int[] scores, int[] ages) {
     final int n = scores.length;
     Player[] players = new Player[n];
     // dp[i] := max score of choosing players[0..i] w/ players[i] being selected
     int[] dp = new int[n];

     for (int i = 0; i < n; ++i)
     players[i] = new Player(ages[i], scores[i]);

     Arrays.sort(players, (a, b) -> a.age == b.age ? b.score - a.score : b.age - a.age);

     for (int i = 0; i < n; ++i) {
     // For each player, we choose it first
     dp[i] = players[i].score;
     // players[j].age >= players[i].age since we sort in descending order
     // So we only have to check that
     // players[j].score >= players[i].score
     for (int j = 0; j < i; ++j)
     if (players[j].score >= players[i].score)
     dp[i] = Math.max(dp[i], dp[j] + players[i].score);
     }

     return Arrays.stream(dp).max().getAsInt();
     }


     */
    /**
     * public static int bestTeamScore(int[] scores, int[] ages) {
     * int len=ages.length;
     * int nums[][]=new int[len][2];
     * for(int i=0;i<len;i++) {
     * nums[i][0]=ages[i];
     * nums[i][1]=scores[i];
     * }
     * Arrays.sort(nums,(a,b)->{
     * if(a[0]==b[0])
     * return a[1]-b[1];
     * return a[0]-b[0];
     * });
     * int[][] dp=new int[len+1][len+1];
     * for(int[] arr:dp)
     * Arrays.fill(arr,-1);
     * return rec(nums,1,len+1,0,dp);
     * }
     * <p>
     * int  rec(int[][] nums,int curr,int len,int maxIdx,int[][] dp) {
     * if(curr==len)
     * return 0;
     * if(dp[curr][maxIdx]!=-1)
     * return dp[curr][maxIdx];
     * int maxAge=maxIdx==0?0:nums[maxIdx-1][0];
     * int maxScore=maxIdx==0?0:nums[maxIdx-1][1];
     * int currAge=nums[curr-1][0];
     * int currScore=nums[curr-1][1];
     * int include=0;
     * if(maxAge==currAge||maxAge<currAge&&maxScore<=currScore)
     * include=currScore+rec(nums,curr+1,len,curr,dp);
     * int exclude=rec(nums,curr+1,len,maxIdx,dp);
     * return dp[curr][maxIdx]=Math.max(include,exclude);
     * }
     */
    private static class Pair {
        int score;
        int age;

        Pair(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }

    private static final int[][] memo = new int[1001][1001];

    public static int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        Pair[] p = new Pair[n];
        for (int[] x : memo) {
            Arrays.fill(x, -1);
        }
        for (int i = 0; i < n; i++) {
            p[i] = new Pair(scores[i], ages[i]);
        }
        Arrays.sort(p, (a, b) -> (a.score == b.score) ? (a.age - b.age) : a.score - b.score);
        return find(p, 0, 0, n);
    }

    private static int find(Pair[] p, int i, int max, int n) {
        if (i >= n) {
            return 0;
        }
        if (memo[i][max] != -1) {
            return memo[i][max];
        }
        if (p[i].age >= max) {
            int x1 = p[i].score + find(p, i + 1, p[i].age, n);
            int x2 = find(p, i + 1, max, n);
            memo[i][max] = Math.max(x1, x2);
        } else {
            memo[i][max] = find(p, i + 1, max, n);
        }
        return memo[i][max];
    }

    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 10, 15}, ages = {1, 2, 3, 4, 5};//Output: 34;
        System.out.println(bestTeamScore(scores, ages));
    }

}

