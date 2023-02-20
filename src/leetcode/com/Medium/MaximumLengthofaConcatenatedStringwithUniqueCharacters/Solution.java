package leetcode.com.Medium.MaximumLengthofaConcatenatedStringwithUniqueCharacters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static int maxLength(String[] args) {
        List<String> arr = Arrays.asList(args);
        int maxLen = 0;
        arr = arr.stream().filter(str -> isUnique(str)).collect(Collectors.toList());
        Map<String, Integer> mem = new HashMap<>();
        maxLen = dfs(arr, "", 0, maxLen, mem);
        return maxLen;
    }

    private static int dfs(List<String> arr, String path, int i, int maxLen, Map<String, Integer> mem) {
        if (mem.get(path) != null) return mem.get(path);
        boolean pathIsUnique = isUnique(path);
        if (pathIsUnique) {
            maxLen = Math.max(path.length(), maxLen);
        }
        if (i == arr.size() || !pathIsUnique) {
            mem.put(path, maxLen);
            return maxLen;
        }

        for (int j = i; j < arr.size(); j++) {
            maxLen = dfs(arr, path + arr.get(j), j + 1, maxLen, mem);
        }
        mem.put(path, maxLen);
        return maxLen;
    }


    public static boolean isUnique(String str) {
        char[] characters = str.toCharArray();
        if (characters != null) Arrays.sort(characters);
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //  Scanner scanner = new Scanner(System.in);
        String[] arr = {"abcdefghijklmnopqrstuvwxyz"}; //  Output: 26
        // String[] wordList = scanner.nextLine().split(" ");
        // scanner.close();
        System.out.println(maxLength(arr));
    }
}