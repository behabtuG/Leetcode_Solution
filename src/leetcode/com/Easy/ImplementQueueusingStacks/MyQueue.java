package leetcode.com.Easy.ImplementQueueusingStacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MyQueue {

    /**
     * Initialize your data structure here.
     */
    private static Deque<Integer> input = new ArrayDeque<>();
    private static Deque<Integer> output = new ArrayDeque<>();

    public MyQueue() {
        input = new ArrayDeque<>();
        output = new ArrayDeque<>();
    }


    // Push element x to the back of queue.
    public static void push(int x) {
        input.push(x);
    }

    // Removes the element from in front of queue.
    public static int pop() {
        peek();
        return output.pop();
    }

    // Get the front element.
    public static int peek() {
        if (output.isEmpty())
            while (!input.isEmpty())
                output.push(input.pop());
        return output.peek();
    }

    // Return whether the queue is empty.
    public static boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
       // String[] x = {"MyQueue", "push", "push", "peek", "pop", "empty"};//{{}, {1},{2},{},{},{}};
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
        System.out.println(myQueue.empty());
        System.out.println(myQueue.toString());
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
    //push(x) -- Push element x to the back of queue.
    // pop() -- Removes the element from in front of queue.
    // peek() -- Get the front element.
    // empty() -- Return whether the queue is empty.
}
