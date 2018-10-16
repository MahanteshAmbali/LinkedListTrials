package com.datastructure.algo;

public class FlattenAndSortLinkedList {

    Node head = null;

    class Node{
        int data;
        Node right, down;

        public Node(int data){
            this.data = data;
            this.right = null;
            this.down = null;
        }
    }

    private void printList() {
        Node head_ref = head;
        while(head_ref != null){
            System.out.print(head_ref.data+" ");
            head_ref = head_ref.down;
        }

        System.out.println();
    }

    private Node mergeList(Node a, Node b){

        if(a == null)
            return b;

        if(b == null)
            return a;

        Node temp = null;

        if(a.data < b.data){
            temp = a;
            temp.down = mergeList(a.down, b);
        }else{
            temp = b;
            temp.down = mergeList(a, b.down);
        }

        return temp;
    }

    private Node flattenList(Node head_ref){

        if(head_ref == null || head_ref.right == null)
            return head_ref;

        head_ref.right = flattenList(head_ref.right);

        head_ref = mergeList(head_ref, head_ref.right);

        return head_ref;
    }

    private Node push(Node head_ref, int data) {

        Node newNode = new Node(data);

        newNode.down = head_ref;

        head_ref = newNode;

        return head_ref;
    }

    public static void main(String[] args) {
        FlattenAndSortLinkedList list =
                new FlattenAndSortLinkedList();

        list.head = list.push(list.head, 30);
        list.head = list.push(list.head, 8);
        list.head = list.push(list.head, 7);
        list.head = list.push(list.head, 5);

        list.head.right = list.push(list.head.right, 20);
        list.head.right = list.push(list.head.right, 10);

        list.head.right.right = list.push(list.head.right.right, 50);
        list.head.right.right = list.push(list.head.right.right, 22);
        list.head.right.right = list.push(list.head.right.right, 19);

        list.head.right.right.right = list.push(list.head.right.right.right, 45);
        list.head.right.right.right = list.push(list.head.right.right.right, 40);
        list.head.right.right.right = list.push(list.head.right.right.right, 35);
        list.head.right.right.right = list.push(list.head.right.right.right, 20);

        list.head = list.flattenList(list.head);

        list.printList();
    }
}
