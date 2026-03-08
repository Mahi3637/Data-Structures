import org.w3c.dom.ranges.Range;

public class AssignmentTask7 {



    public static void rangeMove(DNode dh, int start, int end) {
        DNode current = dh.next;
        DNode RangeFirst = null;
        DNode RangeLast = null;
        DNode nonRangeFirst = null;
        DNode nonRangeLast = null;
    
        // PASS 1: Identify all nodes
        while (current != dh) {
            int val = ((Integer) current.elem).intValue();
            
            if (val >= start && val <= end) {
                // This is a RANGE node
                if (RangeFirst == null) {
                    RangeFirst = current;
                }
                RangeLast = current;
            } else {
                // This is a NON-RANGE node
                if (nonRangeFirst == null) {
                    nonRangeFirst = current;
                }
                nonRangeLast = current;
            }
            current = current.next;
        }
        
        dh.next = nonRangeFirst;
        nonRangeFirst.prev = dh;

        nonRangeLast.next = RangeFirst;
        RangeFirst.prev = nonRangeLast;

        nonRangeLast.next = dh;
        dh.prev = nonRangeLast;
        
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
