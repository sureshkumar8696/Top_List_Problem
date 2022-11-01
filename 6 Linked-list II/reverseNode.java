/**
 * Input:
 * head = [1,2,3,4,5,6,7,8] k=3
 * Output:
 * head = [3,2,1,6,5,4,7,8]
 * 
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
};

public class reverseNode {
    static Node insertNode(Node head, int val) {
        Node newHead = new Node(val);
        if (head == null) {
            head = newHead;
            return head;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newHead;
        return head;
    }

    static int lengthOfNode(Node head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            ++len;
        }
        return len;
    }

    static Node reverseKNode(Node head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = lengthOfNode(head);
        Node dummyNode = new Node(0);
        dummyNode.next = head;

        Node pre = dummyNode;
        Node cur;
        Node nxt;
        while (len >= k) {
            cur = pre.next;
            nxt = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
            len -= k;
        }
        return dummyNode.next;
    }

    static void printLinkedList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    public static void main(String[] args) {
        Node head = null;
        int k = 3;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 5);
        head = insertNode(head, 6);
        head = insertNode(head, 7);
        head = insertNode(head, 8);

        System.out.print("Original Linked List: ");
        printLinkedList(head);
        System.out.print("After Reversal of k nodes: ");
        Node newHead = reverseKNode(head, k);
        printLinkedList(newHead);

        /*
         * Time Complexity: O(N)
         * 
         * Reason: Nested iteration with O((N/k)*k) which makes it equal to O(N).
         * 
         * Space Complexity: O(1)
         */
    }
}