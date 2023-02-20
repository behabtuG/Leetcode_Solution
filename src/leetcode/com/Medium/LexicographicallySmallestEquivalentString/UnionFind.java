package leetcode.com.Medium.LexicographicallySmallestEquivalentString;

public class UnionFind {
    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; ++i)
            id[i] = i;
    }

    public void union(int u, int v) {
        final int i = find(u);
        final int j = find(v);
        if (i > j)
            id[i] = j;
        else
            id[j] = i;
    }

    public int find(int u) {
        return id[u] == u ? u : (id[u] = find(id[u]));
    }

    private int[] id;
}
