package leetcode.com.Medium.CountCompleteTreeNodes;

// class to create nodes
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}