package Knil;

public class ReverseBetween {
    public ListNode CutList(ListNode node, int m,int n){
        ListNode head = new ListNode(0);
        head.next = node;
        ListNode cur = head;
        ListNode pre, front=null, last;
        for(int i = 1;i<=m-1; ++i){
            cur = cur.next;
        }
        pre = cur;
        last = cur.next;
        for(int i = 1;i<n;i++){
            cur = pre.next;
            pre.next = cur.next;
            cur.next = front;
            front = cur;
        }
        last.next = pre.next;
        pre.next = front;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        node.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode result = new ReverseBetween().CutList(node, 2, 4);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
