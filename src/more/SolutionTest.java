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
     *删除链表的倒数第N个节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode f = head;
        ListNode s = head;
        for (int i = 0; i < n; i++) {
            f = f.next;
        }
        if(f == null) {
            return head = head.next;
        }
        while(f.next!=null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;

        return head;
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
        head.next.next.next.next = new ListNode(5);
        head = SolutionTest.removeNthFromEnd(head, 3);
//        printList(head);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }

}
