// LabTask1: Assemble Conga Line
public class LabTask1 {
	
    // No need to submit this task
    public static Boolean assembleCongaLine(Node head){
        //You're not suppose to create any new Linked List for this task

        //TODO
        //Hint: the Node elements are actually Object, you can type cast them
        //      into int or Integer like the following:
        //        (int)n.elem  or  (Integer)n.elem
        
        //When you're ready to return the boolean remove the following line
        if(head == null  || head.next == null){
            System.out.println("The list is empty or aleardy have been sorted");
            return false;
        }
        Node current = head;
        
        while(current.next != null){
            int currentValue = (int) current.elem; // Assuming the correct field name is 'data'
            int nextValue = (int) current.next.elem;

            if(currentValue > nextValue){
                return false;
            }
            current = current.next;
        }
        return true; 
    }

    //NOTE: if you find any issue with the driver code please inform AIB
    //DO NOT TOUCH THE DRIVER CODE BELOW
    public static void main(String[] args){

        System.out.println("==============Test Case 1=============");
        Node congaLine = LinkedList.createList(new Integer[]{10,15,34,41,56,72});
        System.out.print("Original Conga Line: ");
        LinkedList.printLL(congaLine);
        System.out.println("Expected output: true");
        System.out.println( "Your output: "+assembleCongaLine(congaLine) ); //This should print True
        System.out.println();
        System.out.println("==============Test Case 2=============");
        congaLine = LinkedList.createList(new Integer[]{10,15,44,41,56,72});
        System.out.print("Original Conga Line: ");
        LinkedList.printLL(congaLine);
        System.out.println("Expected output: false");
        System.out.println( "Your output: "+assembleCongaLine(congaLine) ); //This should print False
        System.out.println();
    }
}
