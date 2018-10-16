package com.datastructure.algo;

import java.util.HashSet;
import java.util.Set;

public class SingleLinkedListOperations {

    private Node head;

    private Node tail;

    private int linkedListCount = 0;

    public void add(Object data){

        if(head == null){
            head = new Node(data);
        }

        Node newNode = new Node(data);

        Node temp = head;

        while(temp.getNode() != null) {
            temp = temp.getNode();
        }

        temp.setNode(newNode);
        tail = newNode;

        incrementCounter();
    }

    public void addFront(Object data) {

        if(head == null){
            head = new Node(data);
        }

        Node newNode = new Node(data);

        newNode.setNode(head);
        head = newNode;
        head.setNode(newNode.getNode());
        //tail = temp;

        incrementCounter();
    }

    public void addAtIndex(Object data, int index){

        Node newNode = null, prev = head;

        if(index < 0){
            System.out.println("Index cannot be less than 0");
            return;
        }

        if(index > linkedListCount){
            System.out.println("Index cannot be more than list size which is: "+linkedListCount);
            return;
        }

        if(head == null){
            newNode = new Node(data);
            return;
        }

        newNode = new Node(data);

        for(int i = linkedListCount -1; i > index ; i--){
            prev = prev.getNode();
        }

        Node position = prev.getNode();
        prev.setNode(newNode);
        newNode.setNode(position);

        incrementCounter();
    }

    public Object get(int index) {

        Node currentNode = null;

        if (index < 0) {
          System.out.println("Index Cannot be less than 0");
          return null;
        }

        if (index >= linkedListCount) {
          System.out.println("Index Cannot be more than list size which is: " + linkedListCount);
          return null;
        }

        if(head == null){
            System.out.println("Head is null, List is empty, insert elements.");
            return null;
        }else{
            currentNode = head.getNode();
            for(int i = 0; i< index; i++){
                if(currentNode.getNode() == null){
                    return null;
                }
                currentNode = currentNode.getNode();
            }
            return currentNode.getData();
        }
    }

    public boolean remove(int index) {
        boolean flag = Boolean.FALSE;

        if(index < 0){
            System.out.println("Index Cannot be less than 0");
            return flag;
        }

        if (index >= linkedListCount) {
            System.out.println("Index Cannot be more than list size which is: " + linkedListCount);
            return flag;
        }

        if(head == null){
            System.out.println("Head is null, List is empty, insert elements.");
            return flag;
        }else{
            Node temp = head;
            for(int i =0; i< index; i++){
                if(temp.getNode() == null)
                    return flag;
                temp = temp.getNode();
            }

            temp.setNode(temp.getNode().getNode());
            decrementCounter();
            flag = Boolean.TRUE;
            return flag;
        }
    }

    public String removeFirst() {

        if(head == null){
            return "Head is null, List is empty. Insert Elements.!";
        }

        Node temp = head;
        head = temp.getNode().getNode();
        temp.setNode(null);  // HELP GC

        decrementCounter();
        return "Removed First Element from Linked List.";
    }

    public void removeLast() {

        if(head == null){
            System.out.println("Linked List is empty, insert elements.!");
        }

        Node current = head, previous = head;
        while (current.getNode() != null) {
            previous = current;
            current = current.getNode();
        }
        previous.setNode(null);
        current.setNode(null); // HELP GC

        decrementCounter();
    }

    public String printMiddleElement() {

        int middleIndex = linkedListCount/2;

        Node temp = head;

        for(int i= 0; i< middleIndex; i++){
            if(temp.getNode() == null)
                return "";
            temp = temp.getNode();
        }
        return temp.getData().toString();
    }

    // USE FAST AND SLOW POINTERS TO PRINT MIDDLE ELEMENT.
    public String printMiddleElementFastSlowNode() {

        Node fastNode= head, slowNode = head;
        if(head != null){
            while(fastNode != null && fastNode.getNode()!= null){
                fastNode = fastNode.getNode().getNode();
                slowNode = slowNode.getNode();
            }
        }
        return slowNode.getData().toString();
    }

    // OVERRIDE TOSTRING TO PRINT OBJECTS OF THIS CLASS.
    @Override
    public String toString() {
        String output = "Elements in the list:  ";

        if (head != null) {
            Node crunchifyCurrent = head;
            while (crunchifyCurrent != null) {
                output += "[" + crunchifyCurrent.getData().toString() + "]";
                crunchifyCurrent = crunchifyCurrent.getNode();
            }

        }
        return output;
    }

    private void incrementCounter() {
        this.linkedListCount++;
    }

    private void decrementCounter() {
        this.linkedListCount--;
    }

    // CANCEL ELEMENTS WHICH ADD UP TO 0
    public void cancelOut() {

        if(head == null) {
            System.out.println("List may be empty, insert elements.");
            return;
        }

        Node start = head, end = null;
        while(start != null) {
            end = start.getNode();
            int sum = 0;
            boolean isModified = Boolean.FALSE;
            while(end != null){
                sum = sum + Integer.valueOf(end.getData().toString());
                if(sum == 0){
                    start.setNode(end.getNode());
                    isModified = Boolean.TRUE;
                    break;
                }
                end = end.getNode();
            }
            if(!isModified)
                start = start.getNode();
        }
    }

    // THIS METHOD WILL DELETE THE MIDDLE ELEMENT OF THE LINKED LIST.
    public void deleteMiddleElement() {

        Node temp = head, prev = head;
        int middleElementIndex = linkedListCount/2;

        if(head == null){
            System.out.println("Head is null, insert elements. ");
            return ;
        }

        if(head.getData() == null){
            head =null;
            // set the new node passed as argument here.
            return;
        }

        /*while(middleElementIndex != 0){

            prev = temp.getNode();
            temp = temp.getNode();
            middleElementIndex--;
        }

        prev.setNode(temp.getNode().getNode());*/

        // USING SLOW AND FAST POINTERS.
        Node fast = head, slow = head;
        while(fast != null && fast.getNode() != null){
            slow = slow.getNode();
            fast = fast.getNode().getNode();
        }
        Node temp1 = slow.getNode();
        slow.setNode(temp1.getNode());
    }

    // THIS METHOD WILL REMOVE THE DUPLICATE ELEMENTS FROM THE SORTED LIST.
    public void removeDuplicateElementsSortedList() {

        if(head == null){
            System.out.println("Head is null, insert elements.!");
            return;
        }

        Node current = head;
        while(current != null && current.getNode() != null){
            if(current.getData() == current.getNode().getData()){
                current = current.getNode().getNode();
                head = current;
            }else {
                current = current.getNode();
            }
        }

    }

    // THIS METHOD WILL REMOVE DUPLICATE ELEMENTS FROM AN UNSORTED LIST.
    // TIME COMPLEXITY : O(n^2).
    public void removeDuplicateElementsUnsortedList() {

        if(head == null){
            System.out.println("Head is null, insert elements!");
            return;
        }

        Node ptr1 = head, ptr2 = null, dup = null;

        while(ptr1 != null && ptr1.getNode() != null){
            ptr2 = ptr1;
            while (ptr2 != null && ptr2.getNode() != null){
                if(ptr1.getData() == ptr2.getNode().getData()){
                    dup = ptr2.getNode();
                    ptr2.setNode(ptr2.getNode().getNode());
                    System.gc();
                }else{
                    ptr2 = ptr2.getNode();
                }
            }
            ptr1 = ptr1.getNode();
        }
    }

    public void removeDuplicateElementsUnsortedListUsingHashSet() {

        Node temp = head, prev = null;

        Set<Integer> hashSet = new HashSet<>();

        while(temp != null){
            int currentData = Integer.valueOf(temp.getData().toString());
            if(!hashSet.contains(currentData)){
                hashSet.add(currentData);
                prev = temp;
            }else{
                prev.setNode(temp.getNode());
            }

            temp = temp.getNode();
        }
    }

    // THIS METHOD WILL ADD 1 TO INDIVIDUAL ELEMENTS OF THE LIST.
    public void addOneToANumberOfLinkedList() {

        reverseLinkedList();

        int carry = 1, sum = 0;
        Node res = head, prev = null, temp = null;

        while(head != null
                && res != null){

            sum = carry + Integer.valueOf(head.getData().toString());

            carry = (sum >= 10) ? 1: 0;

            sum = sum % 10;

            head.setData(sum);

            temp = head;

            head = head.getNode();
        }

        if(carry > 0){
            temp = new Node(carry);
        }

        //reverseLinkedList();
    }

    // THIS METHOD WILL REVERSE THE LINKED LIST.
    public void reverseLinkedList() {

        if(head == null){
            return;
        }

        Node next, prev = null, current = head;

        while(current != null){
            next = current.getNode();
            current.setNode(prev);
            prev = current;
            current = next;
        }

        head = prev;
    }

    // ADD 1 TO LINKED LIST ELEMENTS WITHOUT RECURSION AND REVERSING OF LINKED LIST
    public Node addOneToLinkedListElements() {

        Node current = head, prev = null;

        while(current.getNode() != null){
            if(Integer.valueOf(current.getData().toString()) != 9){
                prev = current;
                current.setData(Integer.valueOf(current.getData().toString()) + 1);
            }else{
                prev = current;
                current.setData(Integer.valueOf(0));
                prev.setData(Integer.valueOf(prev.getData().toString()) + 1);
            }
            current = current.getNode();
        }

        if(Integer.valueOf(current.getData().toString()) != 9){
            current.setData(Integer.valueOf(current.getData().toString()) + 1);
        }// PREV WILL BE NULL IF ALL THE NODES ARE 9, IN THAT CASE  WE NEED TO GET NEW NODE OF 1 AND JOIN TO HEAD.
        else if(prev == null){
            Node newNode = new Node(1);
            newNode.setNode(head);
            while(head != null){
                head.setData(Integer.valueOf(1));
                head = head.getNode();
            }
            return newNode;
        }else{
            prev.setData(Integer.valueOf(prev.getData().toString()) + 1);
            prev = prev.getNode();
            while(prev != null){
                prev.setData(Integer.valueOf(0));
                prev = prev.getNode();
            }
        }
        return head;
    }

    public void reverseLinkedListOfGivenSize(int size) {
        reverseLinkedListOfGivenSize(head, size);
    }

    public Node reverseLinkedListOfGivenSize(Node head, int size) {

        Node current = head, next = null, prev = null;

        int count = 0;

        while(count < size && current != null) {
            next = current.getNode();
            current.setNode(prev);
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.setNode(reverseLinkedListOfGivenSize(next, size));

        return prev;
    }

    // DETECT LOOP IN THE LIST.  LAST NODE POINTS TO AN ELEMENT OF LIST.

    // THIS METHOD WILL DETECT IF A LOOP IS PRESENT IN LIST.

    // This is using Hash Set, This method has O(n) - Time and Space Complexity.
    public Boolean detectLoopInListHashSet() {

        Node current = head, prev = null;
        Boolean isLoopDetected = Boolean.FALSE;

        Set<Node> hashSet = new HashSet();

        while (current != null) {
            if(hashSet.contains(current.getNode())){

                isLoopDetected = Boolean.TRUE;
                prev.setNode(null);
            }
            hashSet.add(current.getNode());
            prev = current;
            current = current.getNode();
        }

        return isLoopDetected;
    }

    // MARK VISITED NODES. ANOTHER VARIABLE WITH isVisited.? TO BE KEPT
    // AND SET TO TRUE DURING THE ITERATION. THIS HAS O(n) TIME COMPLEXITY AND O(N) SPACE COMPLEXITY.

    public void detectLoopInListMarkVisitedNode() {

    }

    // Floyd's Cycle Finding Algorithm.
    // THIS SEEMS TO BE AN EFFICIENT APPROACH SINCE THIS HAS O(N) TIME COMPLEXITY AND NO SPACE COMPLEXITY.
    public int detectLoopInListFloydsCycle() {

        Node slowPointer = head, fastPointer = head;

        while(slowPointer != null
                && fastPointer != null
                && fastPointer.getNode() != null){
            slowPointer = slowPointer.getNode();
            fastPointer = fastPointer.getNode().getNode();

            if(slowPointer == fastPointer){
                System.out.println("Given List has a loop. Removing the loop in the list.");
                removeLoopInLinkedList(slowPointer, this.head);
                return 1;
            }
        }
        return 0;
    }

    /* REMOVE A LOOP IN THE LINKED LIST.
        10 -> 20 -> 30 -> 40 -> 50 -> 60
               ^                       |
               |                       |
               | - - - - - 70 <- - - - |

        THIS METHOD IS CALLED IF LOOP IS DETECTED USING FLOYD'S APPROACH.
        1. START WITH TWO POINTERS AT LOOP NODE AND COUNT THE NUMBER OF NODES IN THE LOOP.

        2. POINT ONE POINTER AT HEAD AND ANOTHER AT KTH NODE FROM HEAD.

        3. MOVE BOTH THE POINTERS AT SAME SPEED, THEY WILL MEET AT START OF LOOP.

        4. KEEPING THE FIRST POINTER, MOVE THE SECOND POINTER TO LAST NODE.

        5. POINT THE LAST NODE'S NEXT TO NULL.
    */

    public void removeLoopInLinkedList(Node loopNode, Node head) {

        Node ptr1 = loopNode, ptr2 = loopNode;
        int numberOfNodesInLoop = 1;

        while(ptr2.getNode() != ptr1){
            ptr2 = ptr2.getNode();
            numberOfNodesInLoop++;
        }

        ptr1 = head;
        for(int i = 0; i< numberOfNodesInLoop; i++){
            ptr2 = ptr2.getNode();
        }

        while(ptr1 != ptr2){
            ptr1 = ptr1.getNode();
            ptr2 = ptr2.getNode();
        }

        ptr2 = ptr2.getNode();
        while(ptr2.getNode() != ptr1) {
            ptr2 = ptr2.getNode();
        }

        ptr2.setNode(null);
    }

    /*     FIND NTH NODE FROM END.

        THE IDEA IS TO TAKE TWO POINTERS INITIALLY AT HEAD.
        MOVE 2ND POINTER TO (N-1)TH LOCATION FROM START.
        MOVE BOTH POINTERS AT SAME SPEED UNTIL 2ND POINTER REACHES NULL(END).
        THEN 1ST POINTER WILL REACH THE NTH LOCATION FROM END.
    */

    public Object findNthNodeFromEnd(int nTHNodeFromEnd) {

        Node ptr1 = head, ptr2 = head;

        if(head == null){
            System.out.println("Head is empty, insert elements.");
            return null;
        }

        for(int i =0; i <= nTHNodeFromEnd; i++){
            if(ptr2 == null){
                System.out.println(nTHNodeFromEnd+" is greater than the number of nodes in linked list.");
                return null;
            }
            ptr2 = ptr2.getNode();
        }

        while(ptr2 != null){
            ptr1 = ptr1.getNode();
            ptr2 = ptr2.getNode();
        }

        return ptr1.getData();
    }

    /*  FUNCTION TO CHECK IF LINKED LIST IS PALINDROME.
       LOGIC:
    */

    public boolean isListPalindrome() {

        return checkIfGivenListIsPalindrome(this.head);
    }

    private boolean checkIfGivenListIsPalindrome(Node head) {

        boolean isListPalindrome;
        Node slow = head, fast = head, secondHalf;
        Node prev_slow = null;
        Node midNode = null;

        while(fast != null && fast.getNode() != null){
            fast = fast.getNode().getNode();
            prev_slow = slow;
            slow = slow.getNode();
        }

        if(fast != null){
            midNode = slow;
            slow = slow.getNode();
        }

        secondHalf = slow;
        prev_slow.setNode(null);
        secondHalf = reverseLinkedListForPalindrome(secondHalf);

        isListPalindrome = compareListElements(head, secondHalf);

        secondHalf = reverseLinkedListForPalindrome(secondHalf);

        if(midNode != null){
            prev_slow.setNode(midNode);
            midNode.setNode(secondHalf);
        }else{
            prev_slow.setNode(midNode);
        }

        return isListPalindrome;
    }

    private Node reverseLinkedListForPalindrome(Node secondHalf){
        Node prev = null, currentNode = secondHalf, next;

        while(currentNode != null){
            next = currentNode.getNode();
            currentNode.setNode(prev);
            prev = currentNode;
            currentNode = next;
        }
        secondHalf = prev;

        return secondHalf;
    }

    private boolean compareListElements(Node head, Node secondHalf){

        Node temp1 = head, temp2 = secondHalf;

        while(temp1 != null && temp2 != null){
            if(temp1.getData().equals(temp2.getData())){
                temp1 = temp1.getNode();
                temp2 = temp2.getNode();
            }else
                return false;
        }

        if(temp1 == null && temp2 == null){
            return true;
        }

        return false;
    }

    public void removeLastOccurrenceOf(int elementToRemove) {

        Node current = head, prev = null, prevOfNodeFound = null;
        boolean isAtleastOneNodeFound = false;

        if(head == null){
            System.out.println("Head is empty, insert elements");
            return;
        }

        while(current != null){
            int currentData = Integer.valueOf(current.getData().toString());
            if(elementToRemove == currentData){

                prevOfNodeFound = prev;
                isAtleastOneNodeFound = true;
            }

            prev = current;
            current = current.getNode();
        }

        if(isAtleastOneNodeFound == true)
            prevOfNodeFound.setNode(prevOfNodeFound.getNode().getNode());

        System.out.println("");
    }

    public void rotateLinkedListAfterNNodes(int n) {

        Node current = head, kThNode = null, newHead;

        if(head == null){
            System.out.println("Head is empty, insert elements");
            return;
        }

        if(n > linkedListCount){
            System.out.println("N is more than Linked List Count.");
            return;
        }

        for(int i = 1; i<= n; i++){
            if(current != null)
                current = current.getNode();
            else return;
        }

        kThNode = current;

        while(current.getNode() != null)
            current = current.getNode();

        current.setNode(head);

        head = kThNode.getNode();

        kThNode.setNode(null);
    }

    public void deleteNNodesAfterMNodes(int n, int m){

        deleteNNodesAfterMNodes(this.head, n, m);
    }

    private void deleteNNodesAfterMNodes(Node head, int n, int m){
        Node temp = head;

        if(head == null){
            System.out.println("Head is null, insert elements.!");
            return;
        }

        for(int i = 1; i< m; i++){
            if(temp != null)
                temp =temp.getNode();
        }

        if(temp != null) {
            temp.setNode(getAfterN(temp.getNode(), n));
            deleteNNodesAfterMNodes(temp, n, m);
        }
    }

    private Node getAfterN(Node node, int n){

        if(node == null)
            return node;

        int count = 0;

        Node temp = node;
        while(temp != null && count < n) {
            temp = temp.getNode();
            count++;
        }

        return temp;
    }

    static class Node{

        private Object data;

        private Node node;

        public Node(Object data) {
            this.data = data;
            this.node = null;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNode() {
            return node;
        }

        public void setNode(Node node) {
            this.node = node;
        }
    }
}
