public class AssignmentTask6 {

    //SUBMIT ONLY THIS METHOD
    //public static void pairJoin(DNode dh1, DNode dh2) {

    //     DNode current1 = dh1.next;
    //     DNode current2 = dh2.next;

    //     if(current1.next == null && current2.next == null){
    //         System.out.println("Both lists are empty");
    //         return;
    //     }

    //     while(current1.next != dh1 && current2.next != dh2){
    //         DNode next1 = current1.next;
    //         DNode next2 = current2.next;

    // //         current1.next = current2;      
    // //         current2.prev = current1;

    // //         current2.next = next1;
    // //         next1.prev = current2;
    // //         current2.next = dh1;
    // //         dh1.prev = current1;
                    
    // //         current1 = next1;                  
    // //          current2 = next2;
    // //    System.out.print(current1.elem+ "--->");
    // //     current1 = current1.next;
    // //     current2 = current2.next;



    // current1.next = current2;
    // current2.prev = current1;
    // current2.next = next1;
    // next1.prev = current2;
    // current1 = next1;
    // current2 = next2;
    // DNode last = dh1;
    // while (last.next != null) {
    //     last = last.next;
    // }
    
    // // Make it circular
    // last.next = dh1;
    // dh1.prev = last;
    
    // // = current1.next;
    // //System.out.print(current1.elem+ "--->");

    public static void pairJoin(DNode dh1, DNode dh2) {
        // Check for empty lists
        if (dh1.next == null || dh2.next == null) {
            System.out.println("One or both lists are empty");
            return;
        }
        
        DNode current1 = dh1.next;  // First actual node of list1 (A)
        DNode current2 = dh2.next;  // First actual node of list2 (E)
        
        // We'll interleave until we reach the end of either list
        while (current1 != null && current2 != null) {
            // Store the next nodes before we break links
            DNode next1 = current1.next;  // Next in list1 (B, then C, then D, then null)
            DNode next2 = current2.next;  // Next in list2 (F, then G, then H, then null)
            
            // STEP 1: Link current1 to current2
            // A -> E
            current1.next = current2;
            current2.prev = current1;
            
            // STEP 2: Link current2 to next1
            // E -> B
            current2.next = next1;
            if (next1 != null) {
                next1.prev = current2;
            }
            
            // Move to next pair
            current1 = next1;   // Now current1 = B (or C, D, null)
            current2 = next2;   // Now current2 = F (or G, H, null)
        }
        
        // Make the list circular as per the expected output
        // Find the last node (which will be H in the example)
        DNode last = dh1;
        while (last.next != null) {
            last = last.next;
        }
        
        // Make it circular
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

