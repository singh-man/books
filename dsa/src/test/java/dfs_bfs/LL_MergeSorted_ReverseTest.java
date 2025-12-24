package dfs_bfs;

import org.junit.jupiter.api.Test;

public class LL_MergeSorted_ReverseTest {

    public Node sortedMerge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        if (a.data < b.data) {
            a.next = sortedMerge(a.next, b);
            return a;
        } else {
            b.next = sortedMerge(b.next, a);
            return b;
        }
    }

    @Test
    public void mergeSorted() {
        Node a = new Node(10, new Node(20, new Node(30, null)));
        Node b = new Node(11, new Node(15, new Node(31, null)));
        Node node = sortedMerge(a, b);
        System.out.println(node);
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

