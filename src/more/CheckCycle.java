package more;

public class CheckCycle {
    public boolean CycleLink(Node node){
        if (node==null) return false;
        Node fast = node.next;
        Node slow = node;
        while (fast!=null||fast.next!=null){
            if (fast == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
