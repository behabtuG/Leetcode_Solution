package leetcode.com.Easy.ImplementQueueusingStacks;

import java.util.Stack;

public class MyQueue1 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) { // Stack go under the man

        while (!s1.isEmpty()) {  // step1. Move data from old stack to temporary stack
            s2.push(s1.pop());
        }
        s1.push(x); //step2. Put the last data at the end so that it can go out last

        while (!s2.isEmpty()) { // step3 fetch data from temp stack again
            s1.push(s2.pop());
        }

    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue1 myQueue1 = new MyQueue1();
        myQueue1.push(1);
        myQueue1.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue1.peek(); // return 1
        myQueue1.pop(); // return 1, queue is [2]
        myQueue1.empty(); // return false
        System.out.println(myQueue1.s1);
        System.out.println(myQueue1.s2);
    }
}
