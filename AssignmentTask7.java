public class AssignmentTask7 {

    //SUBMIT ONLY THIS METHOD
//     public static void rangeMove(DNode dh, int start, int end) {
//         // TO DO

//         DNode current1 = dh.next;

//         while(current1 != null){
//             if(((Integer)current1.elem).intValue() != 5 && ((Integer)current1.elem).intValue() != 6 && ((Integer)current1.elem).intValue() != 7){
//              current1 = current1.next;
//              current1.prev = current1;
//         }

//        DNode current2 = new DNode(5);
//        DNode current3 = new DNode(6);
//        DNode current4 = new DNode(7); // Initialize current2 with a DNode object or null

//        if(current1.next != null){

       

//        if(((Integer)current2.elem).intValue() == 5 && ((Integer)current3.elem).intValue() == 6 && ((Integer)current4.elem).intValue() == 7){
//         current1.next = current2;
//         current2.prev = current1;
//         current2.next = current3;
//         current3.prev = current2;
//         current2.next = current4;
//         current4.prev = current3;
//        }
//     }

//        DNode last = dh;
//        while(last != null){
//         last = last.next;
//        }

//        last.next = dh;
//        dh.prev = last;
//     }
// }


public static void rangeMove(DNode dh, int start, int end) {
    DNode current = dh.next;
    DNode originalTail = dh.prev;  // ✅ remember where list originally ends

    while (current != dh && current != originalTail.next) {
        int val = ((Integer) current.elem).intValue();
        DNode nextNode = current.next;

        if (val >= start && val <= end) {
            // detach current
            current.prev.next = current.next;
            current.next.prev = current.prev;

            // append to back
            DNode tail = dh.prev;
            tail.next = current;
            current.prev = tail;
            current.next = dh;
            dh.prev = current;
        }

        current = nextNode;
    }
}
    //DO NOT SUBMIT THE DRIVER CODE BELOW
    //SUBMITTING IT WILL INCREASE YOUR PLAG % FOR NO REASON
    public static void main(String[] args) {
        Object[] values = {5, 3, 7, 1, 9, 6, 2, 4};
        DNode dh = LinkedListHelpers.createDummyHeadedDoublyLL(values, true);

        System.out.println("Given Linked List:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);

        System.out.println("\nExpected Output:");
        Object[] expected = {3, 1, 9, 2, 4, 5, 7, 6};
        DNode expectedHead = LinkedListHelpers.createDummyHeadedDoublyLL(expected, true);
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(expectedHead);
        
        //Running the Range Move with [5,7] range 
        rangeMove(dh, 5, 7);
        //Printing after Range Move
        System.out.println("\nYour Output:");
        LinkedListHelpers.printDummyHeadedDoublyCircularLL(dh);
    }
}
