package nowcode;

import java.util.ArrayList;
import java.util.List;

class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val = val;
    }
}
public class ListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode node = new ListNode(0);
        while(listNode!=null){
            ListNode temp = listNode;
            listNode = listNode.next;
            temp.next = node.next;
            node.next = temp;
        }
        node = node.next;
        while(node!=null){
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        ArrayList result = new ListFromTailToHead().printListFromTailToHead(head);
        System.out.println(result);
//        while (head != null) {
//            int num = head.val;
//            System.out.println(num);
//            head = head.next;
//        }
    }
}
