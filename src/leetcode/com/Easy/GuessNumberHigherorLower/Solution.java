package leetcode.com.Easy.GuessNumberHigherorLower;

public class Solution extends GuessGame {
    /**
     * public static int guessNumber(int n){
     * int l =1;
     * int r = n;
     * //Find the first guess num that >= target num
     * while(l <r){
     * final int m = l + (r -1) /2;
     * if(guess(m) <= 0) //-1,0
     * r =m;
     * else l = m +1;
     * }
     * return 1;
     * }
     */
    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10, pick = 6;// Output: 6
        System.out.println(guessNumber(n));
    }
}
