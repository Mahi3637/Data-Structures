public class Node2 {
    public int data;
    Node next;
    Node head;
    int target;
    
        Node2(int data) {
            this.data = data;
            this.next = null;
        }

    public void addFirst(int data){
    Node newNode = new Node(data);

    if(head == null){
        System.out.println("The list does not exixt");
        return;
    }
    newNode.next = head;
    head = newNode;
    }

    public void addLast(int data){
    Node newNode = new Node(data);

    if(head == null){
        System.out.println("The list empty");
        return;
    }
    Node currentNode = head;

    while(currentNode.next != null){
        currentNode = currentNode.next;
    }
    currentNode.next = newNode;
    }

    public void display(){
        Node currentNode = new Node(data);
        
        if(head == null){
            System.out.println("jsdihu");
            return;
        }

        while(currentNode != null){
            System.out.print(currentNode.data + "---->");
            currentNode = currentNode.next;
        }
        System.out.print("Null");
    }
    
    public int getSize(Node head) { 
        if(head == null) {
            System.out.println("List is empty");
            return 0;
        }
    
        Node currentNode = head;
        int count = 0;  
    
        while(currentNode != null) {
            currentNode = currentNode.next;
            count++;
        }
    
        return count;
    }
  

  public int indexOf(int target){
    if(head == null){
        System.out.println("No List Mf");
        return -1;
    }
    Node currentNode =head;
    int index = 0;
    while(currentNode != null){
        if(currentNode.data == target){
            return index;
        }
        index++;
        currentNode = currentNode.next;
    }
    System.out.println(index);
    return -1;
  }

    public static void main(String[] args){
    Node n1 = new Node(10);
    Node n2 = new Node (20);
    Node n3 = new Node (30);
    Node head = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = null;
    n1.head = head;

        System.out.println("Show the original List: ");
        n1.display();

        System.out.println("After prepending:");
        n1.addFirst(100);
        n1.display();

        System.out.println("After appending: ");
        n1.addLast(1000);
        n1.display();

        System.out.println("Size of List:");
        System.out.println(head.getSize(head));

        System.out.println("Index of 20:");
        n1.indexOf(20);

        System.out.println("Index of 100:");
        System.out.println(n1.indexOf(100));
        
    }
}
