
import java.util.*;

class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
};

public class CycleDetecte {
    static Node insertNode(Node head, int val) {
        Node newHead = new Node(val);
        if (head == null) {
            head = newHead;
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newHead;
        return head;
    }

    static void creatCycle(Node head, int a, int b) {
        Node p1 = head;
        Node p2 = head;
        int cnta = 0;
        int cntb = 0;
        while (cnta != a || cntb != b) {
            if (cnta != a) {
                p1 = p1.next;
                ++cnta;
            }
            if (cntb != b) {
                p2 = p2.next;
                ++cntb;
            }
        }
        p2.next = p1;
    }

    static boolean detecteCycle(Node head) {
        HashSet<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;
            else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    static boolean detecteCycle2(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        // creatCycle(head, 1, 3);// creating cycle in the list

        // if (detecteCycle(head) == true) //T.C. => O(n)
        // System.out.println("Cycle detected");
        // else
        // System.out.println("Cycle not detected");

        if (detecteCycle2(head) == true) // T.C. => O(n)
            System.out.println("Cycle detected");
        else
            System.out.println("Cycle not detected");
    }
}
