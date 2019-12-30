package more;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val=val;
    }
}
public class SolutionTest {

    /**
     *删除链表的重复节点
     */
    public static ListNode removeNthFromEnd(ListNode head) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode pre = newhead;
        ListNode walkNode = newhead.next;
//        for (int i = 0; i < n; i++) {
//            f = f.next;
//        }
//        if(f == null) {
//            return head = head.next;
//        }
//        while(f.next!=null) {
//            f = f.next;
//            s = s.next;
//        }
//        s.next = s.next.next;
        while (walkNode!=null){
            if(walkNode.next!=null){
                if(walkNode.next.val!=walkNode.val){
                    if(pre.next!=walkNode){
                        pre.next = walkNode.next;
                    }
                    else {
                        pre = walkNode;
                    }
                }
            }
            else {
                if(pre.next!=walkNode){
                    pre.next = walkNode.next;
                }
                else {
                    pre = walkNode;
                }
            }
            walkNode = walkNode.next;
        }

        return newhead.next;
    }
    /**
     * 打印链表
     */
    public static void printList(ListNode head){
        if(null == head){
            return;
        }
        while(head.next!=null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println(head.val);
    }

//    public void listTest(){
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//        head = removeNthFromEnd(head, 3);
//        printList(head);
//    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        SolutionTest.removeNthFromEnd(head);
//        printList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

}
