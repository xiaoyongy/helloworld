/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
//struct ListNode{
//
//        };
//class addNum {
//public:
//    ListNode* addNum(ListNode* l1, ListNode* l2) {
//        ListNode* newhead=new ListNode(0);
//        ListNode* head=newhead;
//        ListNode* cur1=l1;
//        ListNode* cur2=l2;
//        int Sum=0;
//        while(cur1 || cur2)
//        {
//            if(cur1!= NULL)
//            {
//                Sum+=cur1->val;
//                cur1=cur1->next;
//            }
//            if(cur2!= NULL)
//            {
//                Sum+=cur2->val;
//                cur2=cur2->next;
//            }
//            //%最终的结果是余数
//            ListNode* newnode=new ListNode(Sum%10);
//            head->next=newnode;
//            head=head->next;
//            // ‘/’最终的结果是商
//            Sum=Sum/10;
//        }
//        //若两个都是空时,判断一下最终的sum需不需要进位
//        if(Sum!=0)
//        {
//            ListNode* newnode=new ListNode(Sum%10);
//            head->next=newnode;
//            head=head->next;
//        }
//        return newhead->next;
//    }
//};