  public class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
      
    public static LinkedListNode reverse(LinkedListNode head){
	
        if (head == null){
            return null;
        }
        LinkedListNode prev = null;
        LinkedListNode cur = head;
        LinkedListNode next = head.next;
     	
        if ( next == null ){
        	return head;
        }
        while(cur != null && cur.next != null){
            cur.next = prev;
         
            prev = cur;
            cur = next;
            next = cur.next;
        }
		
        cur.next = prev;
        return cur;
            
    }
    public static void main(String[] args) {

        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
		LinkedListNode n4 = new LinkedListNode(4);
         LinkedListNode n0 = null;
       // n1.next = n2;
        //n2.next = n3;
        //n3.next = n4;
        System.out.println(reverse(n0));
    }
}