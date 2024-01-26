public class SinglyLinkedList<T> {

    // Inner Node class.
    public class Node<T> {
        // Properties of the Node class.
        // The two properties should be:
        // 1. data (the data stored in the node).
        private T data;
        // 2. next (a reference (also known as a pointer) to the next node).
        private Node next;


        // Constructor of the Node class.
        // The constructor should set the data property of the Node to be the value passed as a parameter.
        // The constructor should set the next property of the Node to be null.
        public Node(T t){
            data = t;
            next = null;
        }

    }

    // Properties of the Singly Linked List class.
    // The three properties should be:
    // 1. size (records the number of nodes in our Singly Linked List)
    private int size;
    // 2. head (a reference to the first (also known as the head) node in our Singly Linked List).
    private Node head;
    // 3. tail (a reference to the last (also known as the tail) node in our Singly Linked List).
    private Node tail;

    // Constructor.
    // Creates a Singly Linked List with a head node.
    public SinglyLinkedList(T value) {
        head = new Node<>(value);
        tail = head;
        this.size = 1;
    }

    public SinglyLinkedList() {
        head = null;
    }

    // Methods

    // size
    // returns the size of the Singly Linked List.
    public int size() {
        return size;
    }

    // isEmpty
    // returns whether the Singly Linked List is empty.
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        return false;
    }

    // peekFirst
    // returns the data stored in the head node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekFirst() {
        if (isEmpty()){
            throw new NullPointerException("Singly Linked List is empty. There is no first node");
        }
        return (T) head.data;

    }

    // peekLast
    // returns the data stored in the tail node.
    // throws a run time exception if the Singly Linked List is empty.
    public T peekLast() {
        if (isEmpty()){
            throw new RuntimeException("Singly Linked List is empty. There is no last node");
        }
        return (T) tail.data;

    }

    // addFirst
    // Adds a node to the front of the Singly Linked List.
    public void addFirst(T value) {
        this.size++;
        Node node = new Node<>(value);
        if (isEmpty()){
            head = node;
            tail = node;
        }
        else{
            node.next = head;
            //added head node is now the new head
            head = node;
        }
    }

    // addLast
    // Adds a node to the back of the Singly Linked List.
    public void addLast(T value) {
        this.size++;
        Node node = new Node<>(value);
        if (isEmpty()){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            //added last node is now the new tail
            tail = node;
        }
    }

    // insertAt
    // Inserts a node at a specific index.
    // If the index is equal to 0, then we can invoke the addFirst method.
    // If the index is equal to size, then we can invoke the addLast method.
    // throws an illegal argument exception if the index is invalid.
    public void insert(T value, int index) {
        if (index == 0){
            addFirst(value);
        }
        else if (index == size()){
            addLast(value);
        }
        else if (index < 0 || index > size()){
            throw new IllegalArgumentException("Index is invalid");
        }
        else{
            int i = 0;
            Node node = new Node<>(value);
            //temporary pointer to the previous node index
            //e.g. if index = 3, previous points to node with index 2
            Node previous = head;
            while (i < index - 1){
                previous = previous.next;
                i++;
            }
            node.next = previous.next;
            previous.next = node;
            this.size++;
        }
    }

    // removeFirst
    // Removes the first (also known as the head node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the head node.
    public T removeFirst() {
        if (isEmpty()){
            throw new RuntimeException("Singly Linked List is empty. There is no first node");
        }

        // If the size of the Singly Linked List becomes 0, need to set the head and tail to null.
        if (size() == 1){
            T t = (T) head.data;
            head = null;
            tail = null;
            this.size--;
            return t;
        }
        else{
            head = head.next;
            this.size--;
            return (T) head.data;
        }
    }

    // removeLast
    // Removes the last (also known as the tail node) from the Singly Linked List.
    // Throws a run time exception if the Singly Linked List is empty.
    // Returns the data stored in the tail node.
    // If the size of the Singly Linked List becomes 0, need to set the tail to null.
    public T removeLast() {
        if (isEmpty()){
            throw new RuntimeException("Singly Linked List is empty. There is no last node");
        }

        // If the size of the Singly Linked List becomes 0, need to set the head and tail to null.
        if (size() == 1){
            T t = (T) head.data;
            head = null;
            tail = null;
            this.size--;
            return t;
        }
        else{
            int i = 0;
            Node temp = head;
            //temp will loop until temp reaches second last node
            while (i < size() - 2){
                temp = temp.next;
                i++;
            }
            T t = (T) tail.data;
            //update the tail
            tail = temp;
            tail.next = null;
            this.size--;
            return t;
        }
    }

    // removeAt
    // Removes a node at a specific index.
    // Returns the data stored in the removed node.
    // If the index is equal to 0, then we can invoke the removeFirst method.
    // If the index is equal to size-1, then we can invoke the removeLast method.
    // throws an illegal argument exception if the index is invalid.

    public T removeAt(int index) {

        if (index < 0 || index > size() - 1){
            throw new IllegalArgumentException("Index is invalid");
        }
        else if (index == 0){
            removeFirst();
        }
        else if (index == size() - 1){
            removeLast();
        }
        else{
            int i = 0;
            //temporary pointer to the previous node index
            //e.g. if index = 3, previous points to node with index 2
            Node previous = head;
            Node deleted = previous.next;
            while (i < index - 1){
                previous = previous.next;
                deleted = deleted.next;
                i++;
            }
            previous.next = deleted.next;
            this.size--;
            return (T) deleted.data;
        }
        return null;

    }

    // contains
    // Determines whether the Singly Linked List contains a node that holds data equivalent to the value passed.
    // Returns a boolean.
    public boolean contains(T value) {
        if (isEmpty()){
            return false;
        }
        int i = 0;
        Node temp = head;
        if (temp.data == value){
            return true;
        }
        //temp will loop until temp reaches tail
        while (i < size() - 1){
            temp = temp.next;
            if (temp.data == value){
                return true;
            }
            i++;
        }
        return false;

    }

    // valueAt
    // Returns the data held in the node at a specified index.
    // Throws an illegal argument exception if the index is invalid.
    public T valueAt(int index) {

        if (index < 0 || index > size() - 1){
            throw new IllegalArgumentException("Index is invalid");
        }

        int i = 0;
        Node temp = head;
        while (i < index){
            temp = temp.next;
            i++;
        }
        return (T) temp.data;

    }

    // reverse
    // Reverses the Singly Linked List.
    public SinglyLinkedList reverse() {
        //the head of the current LinkedList will be the tail for the new linked list
        SinglyLinkedList reversed = new SinglyLinkedList(head.data);

        //no need to start at the head, can start
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
            reversed.addFirst(temp.data);
        }

        return reversed;
        //this method only needs to loop through the LinkedList once
        //which means that the Big O complexity is N

        //another way to do is swap the 1st node with size - 1 node
        //swap 2nd node with size - 2 node
        //swap Nth node with size - N node... etc.
        //however this will need to implement a valueAt(index) or nodeAt(index) method
        //which means it will take longer for the program to find the size - n node, and then swap
        //everytime it searches for the node at Nth index, program will have to run through the LinkedList again
        //this will take N^2 time
    }

    // toString
    // Returns a String representation of the Singly Linked List.
    public String toString() {
        Node temp = head;
        String str = "";
        while (temp.next != null){
            str += temp.data + " -> ";
            temp = temp.next;
        }
        //last node
        str += temp.data + " -> null";
        return str;
    }

}
