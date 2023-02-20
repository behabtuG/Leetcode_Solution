package leetcode.com.Medium.MaximumIceCreamBars;

import java.util.Arrays;

public class Solution {
    public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        for (int i = 0; i < costs.length; ++i)
            if (coins >= costs[i])
                coins -= costs[i];
            else
                return i;
        return costs.length;
    }

    public static int maxIceCream1(int[] costs, int coins) {
        // Store ice cream costs in increasing order.
        Arrays.sort(costs);

        int n = costs.length;
        int icecream = 0;

        // Pick ice creams till we can.
        while (icecream < n && costs[icecream] <= coins) {
            // We can buy this icecream, reduce the cost from the coins.
            coins -= costs[icecream];
            icecream += 1;
        }

        return icecream;
    }

    public static int maxIceCream(int[][] costs, int coins) {
        Arrays.sort(costs);
        boolean found = false;

        for (int i = 0; i < costs.length; ++i) {
            for (int j = 0; j < costs[i].length; ++j) {
                if (coins != costs[i][j]) {
                    coins -= costs[i][j];
                    found = true;
                    break;
                } else {
                    return i;
                }
            }

        }
        return costs.length;
    }

    public static void main(String[] args) {
        int[] costs = {1, 3, 2, 4, 1};
        int coins = 7;//Output: 4
        System.out.println(maxIceCream(costs, coins));
        System.out.println(maxIceCream1(costs, coins));
        int[][] cost = {{1, 3, 2, 4, 1}, {1, 3, 2, 4, 1}};
        int coin = 7;
        //System.out.println(maxIceCream(cost, coin));
    }
}

