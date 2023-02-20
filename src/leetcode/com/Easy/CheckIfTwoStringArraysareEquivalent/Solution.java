/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.com.Easy.CheckIfTwoStringArraysareEquivalent;

import java.util.Objects;

/**
 *
 * @author Glory
 */
class Solution {

    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (String word : word1) {
            s1.append(word);
        }
        for (String word : word2) {
            s2.append(word);
        }
        return Objects.equals(s1.toString(), s2.toString());

    }

    public static void main(String[] args) {
        String[] s1 = {"behabtu", "Getnet"};
        String[] s2 = {"kidest", "Anteneh"};
        System.out.println(arrayStringsAreEqual(s1, s2));
    }
}
