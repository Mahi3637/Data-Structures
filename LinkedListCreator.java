import javax.swing.plaf.synth.SynthTabbedPaneUI;

public class LinkedListCreator {
    Node head;  // instance head
    Node tail;  // instance tail
    
    static class Node {
        int data;
        Node prev;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    
    // Method to create doubly linked list from array
    public static Node createDoublyLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        
        Node head = new Node(-1);  // dummy head
        Node tail = head;
        
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        return head;  // returns dummy head
    }
    
    // ************************************************FORWARD*************************************************************
    public static void printForward(Node head) {
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head.next;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data+ "<------>");
            current = current.next;
        }
        System.out.println(" -> null");
    }
    
    // Helper method to print the list backward
    public static void printBackward(Node head) {
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return;
        }
        
        // Go to the end first
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
       // ***************************************************BACKWARD***********************************************************
        System.out.print("Backward: ");
        while (current != head) {  // Stop at dummy head
            System.out.print(current.data);
            if (current.prev != head) {
                System.out.print(" <-> ");
            }
            current = current.prev;
        }
        System.out.println(" -> null");
    }
    
    // **************************************************GRT SIZE ******************************************************
    public void getSize(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        int count = 0;
        Node current = head.next;
        while (current != null) {
            current = current.next;
            count++;
        }
        System.out.println("The size of the list is " + count);
    }
    
   // ********************************************************GET NODE *********************************************************
    public void getNode(Node head, int value) {
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head.next;
        int position = 0;
        
        while (current != null) {
            if (current.data == value) {
                System.out.println("Node with data " + value + " found at position " + position);
                return;
            }
            current = current.next;  // ← This was missing!
            position++;
        }
        System.out.println("Node with data " + value + " not found.");
    }
    
    // ********************************************************REMOVE AT ********************************************************
    public Node removeAt(Node head, int idx) {
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return head;
        }
        
        // Find the node to remove (idx is 0-based for actual data nodes)
        Node current = head.next;
        int count = 0;
        
        while (current != null && count < idx) {
            current = current.next;
            count++;
        }
        
        // If index is invalid
        if (current == null) {
            System.out.println("Index " + idx + " out of bounds");
            return head;
        }
        
        // Remove the node
        Node predecessor = current.prev;
        Node successor = current.next;
        
        predecessor.next = successor;
        if (successor != null) {
            successor.prev = predecessor;
        }
        
        // Clean up removed node
        current.next = null;
        current.prev = null;
        
        System.out.println("Removed node at index " + idx + " with data " + current.data);
        return head;
    }
    
   // *********************************************************PRINT******************************************************
    public void print(Node head) {
        if (head == null || head.next == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head.next;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <-> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    // ********************************************RANDOM **********************************************************************
    public void displayRandom(Node random) {
        if (random == null) {
            System.out.println("Node is null");
            return;
        }
        
        // Go to the beginning (dummy head)    
        Node temp = random;
        while (temp.prev != null) {
            temp = temp.prev;
        }
        
        // Print from dummy head's next
        temp = temp.next;
        System.out.print("From random node (full list): ");
        while (temp != null) {
            System.out.print(temp.data + "<---->");
            temp = temp.next;
        }
        System.out.println();
    }
     //********************************************************************************PREPENDING******************************************
    public Node prepend(Node head, int data){
        Node newNode = new Node(data);
        Node current = head.next;  // node after dummy
    
        newNode.next = current;
        newNode.prev = head;
        head.next = newNode;
    
        
            current.prev = newNode;
        
    
        return head; 
    }

    public   Node insertAt(Node head, int idx, int data){
        Node newNode = new Node(data);
        Node predecessor = insertAt(head, idx -1, data);
        Node successor = predecessor.next;
        predecessor.next = newNode;
        newNode.prev = predecessor;
        newNode.next = successor;
        successor.prev = newNode;
        return head;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        // Create linked list from array
        Node head = createDoublyLinkedList(arr);
        
        // Test the list
        printForward(head);
        printBackward(head);
        
        // Verify links
        System.out.println("Second element: " + head.next.data);
        System.out.println("Can go back: " + head.next.prev.data);
        System.out.println("Dummy head value: " + head.data);  // Should be -1
        
        // Create instance for non-static methods
        LinkedListCreator listCreator = new LinkedListCreator();
        
        // Test methods
        System.out.println("\n--- Testing getSize ---");
        listCreator.getSize(head);
        
        System.out.println("\n--- Testing getNode ---");
        listCreator.getNode(head, 3);
        listCreator.getNode(head, 5);
        listCreator.getNode(head, 10);  // Not in list
        
        System.out.println("\n--- Testing removeAt ---");
        head = listCreator.removeAt(head, 2);  // Remove element at index 2 (value 3)
        printForward(head);  // Should show: 1, 2, 4, 5
        
        System.out.println("\n--- Testing print ---");
        listCreator.print(head);
        
        System.out.println("\n--- Testing displayRandom ---");
        // Get a random node (e.g., node with value 4)
        Node random = head.next.next.next;  // This is node with value 4
        listCreator.displayRandom(random);
        
        System.out.println("\n--- After all operations ---");
        printForward(head);
        listCreator.print(head);
        listCreator.print(head);
       
        head = listCreator.prepend(head, 20);
        listCreator.print(head);

        System.out.println("-------------------------------------------");
        listCreator.print(head);
        listCreator.insertAt(head, 3, 100);
        listCreator.print(head);
    }
}