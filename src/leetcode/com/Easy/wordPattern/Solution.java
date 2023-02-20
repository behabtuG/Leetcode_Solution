/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Easy.wordPattern;

import java.util.HashMap;

/**
 * @author GLORY
 */
public class Solution {
    /**
     * public static boolean wordPattern(String pattern, String str) {
     * if (pattern == null || pattern.length() == 0) {
     * return pattern.equals(str);
     * }
     * String[] strCollection = str.split(" ");
     * if (strCollection.length != pattern.length()) {
     * return false;
     * }
     * HashMap<Character, String> map = new HashMap<Character, String>();
     * for (int i = 0; i < pattern.length(); i++) {
     * char c = pattern.charAt(i);
     * if (map.containsKey(c)) {
     * if (!map.get(c).equals(strCollection[i])) {
     * return false;
     * }
     * } else {
     * if (map.containsValue(strCollection[i])) {
     * return false;
     * }
     * map.put(c, strCollection[i]);
     * }
     * }
     * return true;
     * }
     */
    public static boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char current_char = pattern.charAt(i);
            if (map.containsKey(current_char)) {
                if (!map.get(current_char).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(current_char, words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";//should return true.
        //pattern = "aaaa", str = "dog cat cat dog" should return false
        System.out.println(wordPattern(pattern, str));
    }
}
