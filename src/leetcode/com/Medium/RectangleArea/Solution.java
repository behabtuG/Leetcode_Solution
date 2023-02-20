package leetcode.com.Medium.RectangleArea;

public class Solution {
    /**public static int computeArea(long A, long B, long C, long D, long E, long F, long G, long H) {
        final long x = Math.max(A, E) < Math.min(C, G) ? (Math.min(C, G) - Math.max(A, E)) : 0;
        final long y = Math.max(B, F) < Math.min(D, H) ? (Math.min(D, H) - Math.max(B, F)) : 0;
        return (int) ((C - A) * (D - B) + (G - E) * (H - F) - x * y);
    }*/
    public static int computeArea(int  ax1, int  ay1, int  ax2, int  ay2, int  bx1, int  by1, int  bx2, int  by2) {
        final long x = Math.max(ax1, bx1) < Math.min(ax2, bx2) ? (Math.min(ax2, bx2) - Math.max(ax1, bx1)) : 0;
        final long y = Math.max(ay1, by1) < Math.min(ay2, by2) ? (Math.min(ay2, by2) - Math.max(ay1, by1)) : 0;
        return (int) ((ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - x * y);
    }
    public static void main(String[] args) {
        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;//Output: 45
          System.out.println(computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
      //  computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }
}
