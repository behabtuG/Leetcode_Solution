/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Hard.SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Glory
 */
public class Solution {

    public static  List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) {
            return new ArrayList<>();
        }
        int behabtu = words.length;
        int getnet = words[0].length();
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(words, 0) + 1);
            for (int i = 0; i <= s.length() - behabtu * getnet; ++i) {
                Map<String, Integer> seen = new HashMap<>();
                int j = 0;
                for (; j < behabtu; ++j) {
                    final String wordss = s.substring(i + j * getnet, i + j * getnet + getnet);
                    seen.put(wordss, seen.getOrDefault(wordss, 0) + 1);
                    if (seen.get(wordss) > count.getOrDefault(wordss, 0)) {
                        break;
                    }
                }
                if (j == behabtu) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words = {"bar","foo","the"};
        String s = "barfoofoobarthefoobarman";
        System.out.println(findSubstring(s, words));
    }
}
