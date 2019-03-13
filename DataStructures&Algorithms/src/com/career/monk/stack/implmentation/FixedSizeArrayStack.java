package com.career.monk.stack.implmentation;

public class FixedSizeArrayStack {

    protected int capacity;

    protected static final int CAPACITY = 10;

    protected int[] stackRep;

    protected int tos = -1;

    public FixedSizeArrayStack() {

        this(CAPACITY);
    }

    public FixedSizeArrayStack(int capacity) {

        this.capacity = capacity;
        stackRep = new int[this.capacity];
    }

    // size - Returns size of the stack     - O(1)
    public int size() {

        return (tos + 1);
    }

    // isEmpty - If stack is empty, returns True, else False - O(1)
    public boolean isEmpty() {

        return (tos < 0);
    }

    // top - Returns the top of stack element - O(1)
    public int top() throws Exception{

        if(isEmpty())
            throw new Exception("Stack Empty Exception.");

        return stackRep[tos];
    }

    // push - Pushes an item on top of stack, if the CAPACITY is not full. - O(1)
    public void push(int data) throws Exception{

        if(size() == CAPACITY)
            throw new Exception("Stack Full Exception");

        stackRep[++tos] = data;
    }

    // pop

    public int pop() throws Exception{

        int data;

        if(isEmpty())
            throw new Exception("Stack Empty, Cannot Pop.");

        data = stackRep[tos];
        stackRep[tos--] = Integer.MIN_VALUE;
        return data;
    }

    @Override
    public String toString() {
        String s;
        s = "[";
        if(size() > 0)
            s+= stackRep[0];

        if(size() > 1){
            for (int i = 1; i <= size() - 1; i++){
               s+= ", "+stackRep[i];
            }
        }

        return s+"]";
    }
}