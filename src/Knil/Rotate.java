package Knil;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class Rotate {
    public static ListNode rotateList(ListNode list, int k){
        ListNode pre = new ListNode(0);
        ListNode r = list;
        if(list==null||list.next==null||k==0)
            return list;
        int count = 0;
        while(r!=null){
            count++;
            r = r.next;
        }
//        对k的值进行判断，是否大于链表长度
        if(k%count == 0)
            return list;
        k = k%count;

        ListNode tmp = list;
        ListNode temp = list;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }
        while(temp.next!=null){
            temp = temp.next;
            tmp = tmp.next;
        }
        pre = tmp.next;
        temp.next = list;
        tmp.next = null;

        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode list = rotateList(node1, 7);
        while (list!=null){
            System.out.println(list.val);
            list = list.next;
        }
    }
}
