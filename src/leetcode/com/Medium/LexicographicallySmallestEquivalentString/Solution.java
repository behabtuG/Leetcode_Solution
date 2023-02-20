package leetcode.com.Medium.LexicographicallySmallestEquivalentString;

public class Solution {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        StringBuilder sb = new StringBuilder();
        UnionFind uf = new UnionFind(26);

        for (int i = 0; i < s1.length(); ++i)
            uf.union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');

        for (final char c : baseStr.toCharArray())
            sb.append((char) ('a' + uf.find(c - 'a')));

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "leetcode", s2 = "programs", baseStr = "sourcecode";//Output: "aauaaaaada"
        System.out.println(smallestEquivalentString(s1, s2, baseStr));
    }
}
