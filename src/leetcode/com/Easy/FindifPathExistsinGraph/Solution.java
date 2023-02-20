package leetcode.com.Easy.FindifPathExistsinGraph;

public class Solution {
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        Graph g = new Graph(edges, n);
        g.visit(source, destination);
        return g.isVisited(destination);
    }


    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0, destination = 5;
        System.out.println(validPath(n, edges, source, destination)); //Output: false
    }
}
