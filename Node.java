import java.util.*;
public class Node{
  public int data;
  Node next;
  Node head;

  Node(int data){
    this.data = data;
    this.next = null;
  }

  public void addFirst(int data){
    Node newNode = new Node(data);
    if( head == null){
      newNode = head;
      return; 
    }
    newNode.next = head;
    head = newNode;
  }

  public void addLast(int data){
    Node newNode = new Node(data);
    if(head == null){
      newNode = head;
      return;      
   }
   Node currentNode = head;

   while(currentNode.next != null){
    currentNode = currentNode.next;
   }
   currentNode.next = newNode;
  }

  public void display() {
    Node currentNode = head;
    while (currentNode != null) {
        System.out.print(currentNode.data + " -> ");    
        currentNode = currentNode.next;
    }
    System.out.println("null");
}
  public void deleteFirst(){
    if(head == null){
      System.out.println("Does not exist");
      return;
    }
    head.next = head;
  }

  public void deleteLast() {
    if(head == null) {
        System.out.println("The list is empty");
        return;
    }

    if(head.next == null) {
        head = null;
        return;
    }

    Node secondLast = head;
    Node lastNode = head.next;

    while(lastNode.next != null) {
      lastNode = lastNode.next;
      secondLast = secondLast.next;
  }
    secondLast.next = null;
}

public void fromArr(int[]arr){
  if(arr.length == 0){
    System.out.println("Array does not exist");
    return;
  }
  else{
    head = new Node(arr[0]);
    Node tail = head;
    for(int i = 0; i<arr.length; i++){
      Node newNode = new Node(arr[i]);
      tail.next = newNode;
      tail = newNode;
    }
  }
}
  public static void main(String [] args){
    Node n1 = new Node(10);
    Node n2 = new Node (20);
    Node n3 = new Node (30);
    Node head = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = null;
    n1.head = head;

    n1.display(); 

    System.out.println("After appending and prepending: ");
    n1.addFirst(50);
    n1.addLast(100);
    n1.display();
    n1.deleteFirst();
    n1.display();

    int[] arr = {1,2,3,4,5};
    n1.fromArr(new int[]{5});
    
    
  }
}