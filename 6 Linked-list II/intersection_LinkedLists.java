/* 
Example 1:
Input:
List 1 = [1,3,1,2,4], List 2 = [3,2,4]
Output:
2
Explanation: Here, both lists intersecting nodes start from node 2.

Practice Link 
*/

import java.util.*;;

class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
};

public class intersection_LinkedLists {
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

    static Node interSectionPresent(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2)
                    return head2;
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    static Node interSectionPresent2(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            if (set.contains(head2))
                return head2;
            head2 = head2.next;
        }
        return null;
    }

    static void PrintNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.num + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = insertNode(head, 1);
        head = insertNode(head, 3);
        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next;
        Node head2 = null;
        head2 = head;
        System.out.print("List1: ");
        PrintNode(head1);
        System.out.println();
        System.out.print("List2: ");
        PrintNode(head2);
        System.out.println();

        // Brtue force
        // Node ans = interSectionPresent(head1, head2); // T.C. => O(m*n) & S.C. =>
        // O(1)

        Node ans = interSectionPresent2(head1, head2);
        if (ans == null)
            System.out.println("No intersection Node");
        else
            System.out.println(ans.num);
    }
}