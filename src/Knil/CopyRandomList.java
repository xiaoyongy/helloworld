package Knil;

import java.util.HashMap;
import java.util.Map;

class DoubleNode{
    int val;
    DoubleNode next;
    DoubleNode random;
    public DoubleNode(int val, DoubleNode _next,DoubleNode _random){
        this.val = val;
        this.next = _next;
        this.random = _random;
    }
}
public class CopyRandomList {
    public DoubleNode CopyList(DoubleNode node){
        if (node==null) return null;
        Map<DoubleNode, DoubleNode> map = new HashMap<>();
        DoubleNode pNew = node;
        while (pNew!=null){
            map.put(pNew, new DoubleNode(pNew.val, null, null));
            pNew = pNew.next;
        }
        pNew = node;
        while (pNew!=null){
            map.get(pNew).next = map.get(pNew.next);
            map.get(pNew).random = map.get(pNew.random);
            pNew = pNew.next;
        }
        return map.get(node);
    }
}
