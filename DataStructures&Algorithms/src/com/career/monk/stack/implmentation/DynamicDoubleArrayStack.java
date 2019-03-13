package com.career.monk.stack.implmentation;

public class DynamicDoubleArrayStack {

    protected int capacity;

    private static final int CAPACITY = 16;

    private static final int MIN_CAPACITY = 1<<15;

    protected int[] stackRep;

    private int top = -1;

    public DynamicDoubleArrayStack() {

        stackRep = new int[CAPACITY];
    }

    public DynamicDoubleArrayStack(int capacity) {
        this.capacity = capacity;
        stackRep = new int[this.capacity];
    }

    // size
    public int size() {
        return (top + 1);
    }

    // top
    public int top() throws Exception{

       if(isEmpty())
           throw new Exception("Stack Empty Exception");

       return stackRep[top + 1];
    }

    // isEmpty
    public boolean isEmpty() {

        return (top < 0);
    }

    // push
    public void push(int data) {

        if(this.capacity == CAPACITY)
            expand();
        stackRep[++top] = data;
    }

    private void expand() {

        int length = stackRep.length;
        int newArray[] = new int[length << 1];
        System.arraycopy(stackRep, 0, newArray, 0, length);
        stackRep = newArray;
        this.capacity = this.capacity << 1;
    }

    // pop
    public int pop() throws Exception{

        int data;
        if(isEmpty())
            throw new Exception("Stack Empty, Cannot Pop.");

        data = stackRep[top];

        stackRep[top--] = Integer.MIN_VALUE;

        shrink();

        return data;
    }

    // shrinks the array to 1/2 if 3/4th of the Array is not occupied.
    private void shrink() {

        int length = top + 1;
        if(length <= MIN_CAPACITY || top << 2 >= length)
            return;

        length = length + (top << 1);
        if(top < MIN_CAPACITY)  length = MIN_CAPACITY;
        int[] newArray = new int[length];
        System.arraycopy(stackRep, 0, newArray, 0, top + 1);
        stackRep = newArray;
        this.capacity = length;
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
