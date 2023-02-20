package leetcode.com.PairString;

public class Solution {

    public static int[] findPair(String[] S) {
        for (int i = 0; i < S.length; i++) {
            for (int j = i + 1; j < S.length; j++) {
                for (int k = 0; k < S[i].length(); k++) {
                    if (S[i].charAt(k) == S[j].charAt(k)) {
                        int[] result = {i, j, k};
                        return result;
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] S = {"abc", "bca", "dba"};
        String[] St = {"zzzz", "ferz", "zdsr", "zdsr", "fgtd"};
        int[] result = sol.findPair(S);
        int[] results = sol.findPair(St);
        System.out.println(findPair(St).toString());
        if (results.length == 0) {
            System.out.println("No pair of strings found");
        } else {
            System.out.println("Pair of strings found: " + St[results[0]] + " and " + St[results[1]]);
            System.out.println("Position of common letter: " + results[2]);
        }
    }

}
