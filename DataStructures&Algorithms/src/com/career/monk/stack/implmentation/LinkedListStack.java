package com.career.monk.stack.implmentation;

import java.util.EmptyStackException;

public class LinkedListStack {

    protected int length;

    private ListNode top;

    public LinkedListStack() {

        this.length = 0;
        top = null;
    }

    // push
    public void push(int data) {

        ListNode listNode = new ListNode(data);
        listNode.setNext(top);
        top = listNode;
        length++;

    }

    // pop
    public int pop() throws EmptyStackException {

        if(isEmpty())
            throw new EmptyStackException();

        int data = top.getData();
        top = top.getNext();
        length--;

        return data;
    }
    // peek
    public int peek() throws EmptyStackException{

        if(isEmpty())
            throw new EmptyStackException();

        return top.getData();
    }
    // size
    public int size() {

        return length;
    }

    // isEmpty
    public boolean isEmpty() {

        return length <= 0;
    }

    // toString
    public String toString() {

        String s = "[";
        ListNode current = top;
        while (current != null){
            s+= ", "+ current.getData();
            current = current.getNext();
        }

        return s + "]";
    }

    static class ListNode {

        private int data;
        private ListNode next;

        public ListNode() {
            this.data = data;
            this.next = null;
        }

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(10);

        System.out.println(linkedListStack);
    }
}

