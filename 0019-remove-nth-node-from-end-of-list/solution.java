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
 // save n away from current pointer, as well as its 'next'
 // when this.next doesnt exist (i.e. end of list), set n.next to this node
 // if n = 1, set n.next = null
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode savedNode = head;
        ListNode returnNode = head;
        int counter = 0;

        while(head.next != null){
            if (counter >= (n)){
                savedNode = savedNode.next;
            }
            counter++;
            head = head.next;
        }

        if(n == 1){
            if(counter == 0){
                returnNode = null;
            } else {
                savedNode.next = null;
            }
        }else if(n == counter+1){
            returnNode = returnNode.next;
            return returnNode;
        }else{
            savedNode.next = savedNode.next.next;
        }
        
        return returnNode;
    }
}
