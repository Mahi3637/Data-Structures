import java.lang.classfile.components.ClassPrinter.ListNode;

public class LeetCode206 {
     public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // store next node
            curr.next = prev;              // reverse current node's pointer
            prev = curr;                   // move prev forward
            curr = nextTemp;               // move curr forward
        }
        return prev; // new head of reversed list
    }
}
