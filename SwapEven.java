public class SwapEven {
    
    public static Node swap even(Node head){
          Node current1 = dh.next;
           while(current1 != dh){
             if(current1.elem %2 == 0){
                dh.next = current;
                current.prev = dh;
             }

             if( current.elem %2 != 0){
                Node current2 = new Node(elem);

                current2.prev = current;
                current.next = current2;
             }

             current = current.next;
           }

           current2.next = dh;
           dh.prev = current2;
    }
}
