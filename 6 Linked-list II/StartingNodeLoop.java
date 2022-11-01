class Node {
    int num;
    Node next;

    Node(int val) {
        num = val;
        next = null;
    }
};

public class StartingNodeLoop {
    public static Node insertNode(Node head, int val) {
        Node newHead = new Node(val);
        if (head == null)
            return newHead;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newHead;
        return head;
    }

    static void createCycle(Node head, int pos) {
        Node ptr = head;
        Node temp = head;
        int cnt = 0;
        while (temp.next != null) {
            if (pos != cnt) {
                ++cnt;
                ptr = ptr.next;
            }
            temp = temp.next;
        }
        temp.next = ptr;
    }

    static Node CycleDetecte(Node head) {
        if (head == null || head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        Node entry = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertNode(head, 1);
        head = insertNode(head, 2);
        head = insertNode(head, 3);
        head = insertNode(head, 4);
        head = insertNode(head, 3);
        head = insertNode(head, 6);
        head = insertNode(head, 10);

        createCycle(head, 2);
        Node RecieveNode = CycleDetecte(head);
        if (RecieveNode == null)
            System.out.println("No Cycle");
        else {
            Node temp = head;
            int pos = 0;
            while (temp != RecieveNode) {
                pos++;
                temp = temp.next;
            }
            System.out.println(pos);
        }
    }

}
