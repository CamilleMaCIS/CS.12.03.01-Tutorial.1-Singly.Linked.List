public class Main {
    public static void main(String[] args){
        SinglyLinkedList sll1 = new SinglyLinkedList(3);
        sll1.addLast(20);
        sll1.addLast(40);
        sll1.addFirst(2);
        sll1.addFirst(0);
        sll1.insert(35, 4);
        System.out.println("Original LinkedList:");
        System.out.println(sll1.toString());
        System.out.println("Size after: " + sll1.size());
        System.out.println();

        sll1.removeLast();
        System.out.println("After removed last:");
        System.out.println(sll1.toString());
        System.out.println("Size after: " + sll1.size());
        System.out.println();

        sll1.removeFirst();
        System.out.println("After removed first:");
        System.out.println(sll1.toString());
        System.out.println("Size after: " + sll1.size());
        System.out.println();

        sll1.insert(24, 3);
        System.out.println("After insert:");
        System.out.println(sll1.toString());
        System.out.println("Size after: " + sll1.size());
        System.out.println();

        System.out.println("Value at index 1 is: " + sll1.valueAt(1));
        System.out.println();

        System.out.println("After removed at index 1:");
        sll1.removeAt(1);
        System.out.println(sll1.toString());
        System.out.println("Size after: " + sll1.size());
        System.out.println();

        System.out.println("Reversed list:");
        SinglyLinkedList sll2 = sll1.reverse();
        System.out.println(sll2.toString());
        System.out.println();

        System.out.println("Does list contain value 15? " + sll1.contains(15));
        System.out.println("Does list contain value 2? " + sll1.contains(2));

        sll1.setNodeAt(0,4);
        System.out.println(sll1.toString());
        //correct answer: 4 -> 20 -> 24 -> 35 -> null

        sll1.addFirst(3);
        System.out.println(sll1.toString());
        //correct answer: 3 -> 4 -> 20 -> 24 -> 35 -> null

        sll1.reverseOriginal();
        System.out.println(sll1.toString());
        //correct answer: 35 -> 24 -> 20 -> 4 -> 3 -> null
    }
}