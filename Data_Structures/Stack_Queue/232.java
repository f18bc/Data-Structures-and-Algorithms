class MyQueue {
    //15min accepted
    //5 mins for thinking and trying the definition of Class in Java, such as private variables and constructors
    //5 mins for thinking how to implement by two stacks
    //then gave up and 5 mins for coding
    
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    //Time O(1) Space O(n)
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    //Time O(1) Space O(1)
    //
    public int pop() {
        if(empty()) return -1;
        else if (s2.isEmpty()){
            while(!s1.isEmpty()) s2.push(s1.pop());
            return s2.pop();
        }
        else return s2.pop();
    }
    
    /** Get the front element. */
    //Time O(1) Space O(1)
    public int peek() {
        int temp = pop();
        if (temp!=-1)s2.push(temp);
        return temp;
    }
    
    /** Returns whether the queue is empty. */
    //Time O(1) Space O(1)
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
