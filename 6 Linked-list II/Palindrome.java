class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
};

public class Palindrome {
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

    static void printLinkedList(Node head) {
        while (head.next != null) {
            System.out.print(head.num + "->");
            head = head.next;
        }
        System.out.println(head.num);
    }

    static Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node nxt = head.next;
            head.next = newHead;
            newHead = head;
            head = nxt;
        }
        return newHead;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;
        Node dummy = head;

        while (slow != null) {
            if (dummy.num != slow.num)
                return false;
            dummy = dummy.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 2);
        head = insertNode(head, 1);
        Node ans = reverse(head);
        printLinkedList(ans);
        if (isPalindrome(head) == true)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
