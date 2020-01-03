package more;

class Node {

    Node next; //下一个节点的引用
    Object obj; //节点元素


    public Node(Object obj) {
        this.obj = obj;
    }

}
public class LinkList {

    Node head = null;// 创建一个空链表
    Node last = head;// 尾节点，并记录当前节点的位置
    int modCount = 0; // 统计节点个数

    // 添加一个元素
    public void add(Object obj) {
        Node node = new Node(obj);
        modCount++;
        if (head == null) {
            head = node; // 如果链表为空，定义头节点
        } else {
            last.next = node; // 当前节点的下一个节点
        }
        last = node; // 最后的节点为当前节点

    }
    // 打印链表-node表示从哪个节点开始打印
    public void printNode(Node node) {
        if (node != null) {
            System.out.println(node.obj);
            node = node.next;
            printNode(node);// 递归调用
        }
    }
    public Node DeletedRepeat(Node node){
        if (node == null){
            return null;
        }
        Node newNode = new Node(0);
        newNode.next = node;
        Node walkNode = newNode.next;
        Node pre = newNode;
        while(walkNode != null){
            if(walkNode.next != null){
                if(walkNode.next.obj == walkNode.obj){
                    if(pre.next == walkNode){
                        pre = walkNode;
                    }else {
                        pre.next = walkNode.next;
                    }
                }
                else {
                    if (pre.next == walkNode){
                        pre = walkNode;
                    }else {
                        pre.next = walkNode.next;
                    }
                }
            }
            walkNode = walkNode.next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        LinkList ls = new LinkList();
        ls.add(1);
        ls.add(3);
        ls.add(5);
        ls.add(5);
        ls.add(5);
//        ls.remove(0); // 删除下标为0的节点
        ls.add(7);
//        LinkList.DeletedRepeat(ls);
        ls.printNode(ls.head);
    }

}
