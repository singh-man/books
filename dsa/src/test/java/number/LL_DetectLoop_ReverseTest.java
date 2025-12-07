package number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LL_DetectLoop_ReverseTest {

    public boolean cycle(Node a) {
        if (a == null) return false;
        Node slow, fast;
        slow = fast = a;
        for (; slow.next != null && fast.next != null && fast.next.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    @Test
    public void cycle() {
        Node a = new Node(10, null);
        Node b = new Node(20, null);
        Node c = new Node(30, null);
        Node d = new Node(40, null);
        Node e = new Node(50, null);
        Node f = new Node(60, null);
        Node g = new Node(70, null);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = c; //adding loop

        Assertions.assertEquals(true, cycle(a));

        g.next = null; // removing loop
        Assertions.assertEquals(false, cycle(a));
    }

    /**
     * 1 -> 2 -> 3 -> 4 -> 5 -> 6
     * on 5th it passes 6 which means base case/exit criteria
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) return head;
        Node rev = reverse(head.next);
        head.next.next = head; // on final stack 5 -> 6 -> = 5
        head.next = null; // and 5 -> 6 to 5 -> null
        return rev;
    }

    @Test
    public void reverse() {
        Node a = new Node(10, new Node(20, new Node(30, null)));
        Node node = reverse(a);
        System.out.println(node);
    }

    private class Node {
        int data;
        Node next;
        Node previous;

        public Node(int data, Node next) {
            this(data, next, null);
        }

        public Node(int data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", previous=" + previous +
                    '}';
        }
    }
}

