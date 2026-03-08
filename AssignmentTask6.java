public class AssignmentTask6 {

    

    public static void pairJoin(DNode dh1, DNode dh2) {
        // Check for empty lists
        if (dh1.next == null || dh2.next == null) {
            System.out.println("One or both lists are empty");
            return;
        }
        
        DNode current1 = dh1.next;  
        DNode current2 = dh2.next;  
        
        
        while (current1 != null && current2 != null) {
          
            DNode next1 = current1.next;  
            DNode next2 = current2.next;  
            
           
            current1.next = current2;
            current2.prev = current1;
            
           
            current2.next = next1;
            if (next1 != null) {
                next1.prev = current2;
            }
          
            current1 = next1;   
            current2 = next2;   
        }
        
        
        DNode last = dh1;
        while (last.next != null) {
            last = last.next;
        }
        
        
        last.next = dh1;
        dh1.prev = last;
    


    
           



            // DNode next1 = current1.next;
            // DNode next2 = current2.next;

            // current1.next = current2;
            // current2.prev = current1;

            // current2.next = next1;
            // next1.prev = current2;
       
            // current2.next = dh1;      // H -> dh1 ✅
            // dh1.prev = current2;      // dh1.prev = H ✅
            // current1 = next1;
            // current2 = next2;
     
        // TO DO
    }

    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] list1 = {"A", "B", "C", "D"};
        Object[] list2 = {"E", "F", "G", "H"};

        DNode dh1 = LinkedListHelpers.createDummyHeadedDoublyLL(list1, false);
        DNode dh2 = LinkedListHelpers.createDummyHeadedDoublyLL(list2, false);

        System.out.println("Given Linked List 1:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh1);

        System.out.println("Given Linked List 2:");
        LinkedListHelpers.printDummyHeadedDoublyLL(dh2);

        System.out.println("\nExpected Output:");
        Object[] expected = {"A", "E", "B", "F", "C", "G", "D", "H"};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);

        //Running the Pair Join
        pairJoin(dh1, dh2);
        //Printing after Pair Join
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh1);
    }
}

