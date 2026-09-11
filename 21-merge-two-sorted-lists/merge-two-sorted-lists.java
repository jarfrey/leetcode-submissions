/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newNode = new ListNode();
        ListNode headNode = newNode;
        if(list1 == null){
            if (list2 == null){
                return null;
            }
            return list2; 

        } else if (list2 == null){
            return list1;

        } else {
            if(list1.val > list2.val){
                newNode.val = list2.val;
                list2 = list2.next;
            } else{
                newNode.val = list1.val;
                list1 = list1.next;
            }
        }

        while(list1!=null || list2!= null){
            if (list1 == null){
                ListNode nextNode = new ListNode(list2.val);
                newNode.next = nextNode;
                list2 = list2.next;
                newNode = newNode.next;    
            } else if (list2 == null){
                ListNode nextNode = new ListNode(list1.val);
                newNode.next = nextNode;
                list1 = list1.next;
                newNode = newNode.next;
            }else if(list1.val > list2.val) {
                ListNode nextNode = new ListNode(list2.val);
                newNode.next = nextNode;
                list2 = list2.next;
                newNode = newNode.next;
            } else{
                ListNode nextNode = new ListNode(list1.val);
                newNode.next = nextNode;
                list1 = list1.next;
                newNode = newNode.next;
            }
        }
        return headNode;
    }
}

// go through both lists
// compare next value of both
// add the one thats less