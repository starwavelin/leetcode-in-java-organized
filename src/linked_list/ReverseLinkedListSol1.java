package linked_list;

import utils.ListUtils;

public class ReverseLinkedListSol1 {

    ListNode reverse(ListNode head) {
        ListNode pre = null, cur;

        while (head != null) {
            // Note: Java is not JavaScript, when an obj is not null, we use obj != null

            cur = head.next;
            head.next = pre;

            pre = head;
            head = cur;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode newHead1 = new ReverseLinkedListSol1().reverse(head1);
        ListUtils.displayLinkedList(newHead1);

        ListNode head2 = new ListNode(35);
        ListNode newHead2 = new ReverseLinkedListSol1().reverse(head2);
        ListUtils.displayLinkedList(newHead2);

        ListNode newHead3 = new ReverseLinkedListSol1().reverse(null);
        ListUtils.displayLinkedList(newHead3);
    }
}
