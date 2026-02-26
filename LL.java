public class LL {
Node head;
    class Node{
        int data;
        Node next;
    Node(int data){
        this.data = data;
        this.next = null; //The nodes are created but those are not linked yet.
    }

    }

    public void addFirst(int data){ //The data type is int
        Node newNode = new Node(data); // first creating the field of a note where data will be stored
        if(head == null){ //checking if the head was actually null.. ****Must step
          head = newNode; //If the head was null then assign head as the new node
        }
        newNode.next = head; //But if there was a head then the next node of new node was head
        head = newNode; // assign the new Node as head
    }

    public void addLast(int data){ //data type passing
        Node newNode = new Node(data); // Creating the field of node for this method..****Must step
        if(head == null){ //Must step
            head = newNode; //Must step
            return;
        }
        Node currentNode = head; //Assigning the current node as head
        
        while(currentNode.next != null){ //The loop runs untill the nodes are finished and reaches null to add the new Node.
            currentNode = currentNode.next; //iteration like the ++
        }
        currentNode.next = newNode; // after reaching the null, new node is created after the tail

    }

    public void printList(){
        if(head == null){ //This is the error case and must be in every step
            System.out.println("The list is empty");
            return;
        }
        Node currentNode = head; // assigning the current node as head ***Must
        
        while(currentNode != null){ 
            System.out.print(currentNode.data + " ---->");
            currentNode = currentNode.next;
        }
       System.out.print("Null");
    }
    public static void main(String [] args){
        LL list = new LL();
        list.addFirst(30);
        list.printList();
        
    }
}
