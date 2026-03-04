
public class  LinkedListCreator  {
Node head;
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
        
        Node head = new Node(-1);
        Node tail = head;
        
        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        
        return head;
    }
    
    // Helper method to print the list forward
    public static void printForward(Node head) {
        Node current = head.next;
        System.out.print("Forward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Helper method to print the list backward
    public static void printBackward(Node head) {
        if (head == null) return;
        
        // Go to the end first
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        // Print backward
        System.out.print("Backward: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public void getSize(Node head){
       int count = 0;
       Node current = head.next;
       while(current != null){
        current = current.next;
        count++;
       }
       System.out.println("The size of the list is "+ count);
    }

    public void getNode(Node head, int idx){
        Node current = head.next;

        while(current != null){
            if(current.data == idx){
                System.out.println("Node with data "+ idx + " found.");
                return;
            }
        }
        System.out.println("Node with data "+ idx + " not found.");
    } 

    public Node removeAt(Node head, int idx){
        if(head.next == null || idx > 5){
            return null;
        }
        Node current = head.next;
        
            Node remove = removeAt(head, idx);
         Node successor = remove.next;
            Node predecesor = remove.prev;
            predecesor.next = successor;
            if(successor != null){
                successor.prev = predecesor;
            }
            remove.next = remove.prev = null;
            return head;
    }

    public void print(){
        Node current = head.next;

        while(current != null){
            System.out.println(current.data + "<------->");
            current = current.next;
        }

    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        
        // Create linked list from array
        Node head = createDoublyLinkedList(arr);
        
        // Test the list
        printForward(head);   // Forward: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null
        printBackward(head);  // Backward: 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null
        
        // Verify links
        System.out.println("Second element: " + head.next.data); // 2
        System.out.println("Can go back: " + head.next.prev.data); // 1

        // Get size of the list
        LinkedListCreator listCreator = new LinkedListCreator();
        listCreator.getSize(head); // The size of the list is 5
        listCreator.getNode(head, 3); 
        listCreator.getNode(head, 5);
        listCreator.removeAt(head, 2);
        listCreator.print();
    }
}