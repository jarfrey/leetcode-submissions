/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
    // add all items to a hashset so we know which nodes we have been over
    // once we find a duplicate node, we know we've been sent back and can just return this
    // otherwise, we keep iterating
    // if no loop, it'll return null.

    Set<ListNode> nodeSet = new HashSet<>();
    while(head!=null){
        if (nodeSet.contains(head)){
            return head;
        }
        nodeSet.add(head);
        head = head.next;
    }
    return null;
    }
}

    
    // for testing
    
    // ListNode headTwo = head; 
    // for(int i = 0; i < 5; i++){
    //     if (headTwo != null){
    //         System.out.println("Object Identifier: " + System.identityHashCode(headTwo));
    //         headTwo=headTwo.next;
    //     }
    // }

    // original implementation, but realized i was doing too much

    // Map<Integer, ListNode> nodeMap = new HashMap<>();
    // while(head!=null){
    //     int headAdd = System.identityHashCode(head);
    //     if (nodeMap.containsKey(headAdd)){
    //         return nodeMap.get(headAdd);
    //     }
    //     nodeMap.put(headAdd, head);
    //     head = head.next;
    // }
    // return null;