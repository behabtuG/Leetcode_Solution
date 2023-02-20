package leetcode.com.Medium.ZigzagConversion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        List<Character>[] rows = new List[numRows];
        int k = 0;
        int direction = numRows == 1 ? 0 : -1;

        for (int i = 0; i < numRows; ++i)
            rows[i] = new ArrayList<>();

        for (final char c : s.toCharArray()) {
            rows[k].add(c);
            if (k == 0 || k == numRows - 1)
                direction *= -1;
            k += direction;
        }

        for (List<Character> row : rows)
            for (final char c : row)
                sb.append(c);

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;  //Output: "PINALSIGYAHRPI"
        System.out.println(convert(s, numRows));
    }
}