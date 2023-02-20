/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Hard.PalindromePairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Glory
 */
public class Solution {
    public static List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>(); // {reversed word: its index}

    for (int i = 0; i < words.length; ++i)
      map.put(new StringBuilder(words[i]).reverse().toString(), i);

    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      // Special case to prevent duplicate calculation
      if (map.containsKey("") && map.get("") != i && isPalindrome(word))
        ans.add(Arrays.asList(i, map.get("")));
      for (int j = 1; j <= word.length(); ++j) {
        final String l = word.substring(0, j);
        final String r = word.substring(j);
        if (map.containsKey(l) && map.get(l) != i && isPalindrome(r))
          ans.add(Arrays.asList(i, map.get(l)));
        if (map.containsKey(r) && map.get(r) != i && isPalindrome(l))
          ans.add(Arrays.asList(map.get(r), i));
      }
    }

    return ans;
  }

  private static boolean isPalindrome(final String word) {
    int l = 0;
    int r = word.length() - 1;
    while (l < r)
      if (word.charAt(l++) != word.charAt(r--))
        return false;
    return true;
  }
    public static void main(String[] args) {
       String[] words = {"bat","tab","cat"}; //Output: [[0,1],[1,0]]
        System.out.println(palindromePairs(words));
    }
}
