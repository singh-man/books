package dfs_bfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class BT_Transversal_convertToMirror_findCount_IsMirrorTest {

    public void printPostOrder(BTNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + " ");
    }

    public void printInOrder(BTNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }

    public void printPreOrder(BTNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void bfs(BTNode node) {
        if (node == null) return;
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BTNode poll = queue.poll();
            System.out.print(poll.data + " ");
            if (poll.left != null) queue.add(poll.left);
            if (poll.right != null) queue.add(poll.right);
        }
    }

    @Test
    public void traversal() {
        BTNode root = new BTNode(1,
                new BTNode(3,
                        new BTNode(6, null, null),
                        new BTNode(5, null, null)),
                new BTNode(10,
                        new BTNode(9, null, null),
                        new BTNode(15, null, null))
        );
        System.out.println("Original: ");
        System.out.println(root);
        printPreOrder(root);
        System.out.println("PreOrder: ");
        printPostOrder(root);
        System.out.println("PostOrder also called Bottom's UP: ");
        printInOrder(root);
        System.out.println("InOrder: ");
        bfs(root);
        System.out.println("BFS: ");
    }

    /**
     *       1         |          1
     *   3      10     |     10        3
     * 6   5  9   15   |  15    9    5   6
     */
    private BTNode convertToMirror(BTNode node) {
        if (node == null) return node;

        BTNode left = convertToMirror(node.left);
        BTNode right = convertToMirror(node.right);
        // Swap nodes
        node.left = right;
        node.right = left;

        return node;
    }

    @Test
    public void convertToMirror() {
        BTNode root = new BTNode(1,
                new BTNode(3,
                        new BTNode(6, null, null),
                        new BTNode(5, null, null)),
                new BTNode(10,
                        new BTNode(9, null, null),
                        new BTNode(15, null, null))
        );
        System.out.println("Pre mirror InOrder: ");
        bfs(root);
        System.out.println();
        BTNode mirror = convertToMirror(root);
        System.out.println("After mirror InOrder: ");
        bfs(mirror);
    }

    private int findCount(BTNode node, int find, int count) {
        if (node == null) return count;
        if (node.data == find) count++;
        count = findCount(node.left, find, count);
        count = findCount(node.right, find, count);
        return count;
    }

    @Test
    public void testCountInBT() {
        BTNode root = new BTNode(1,
                new BTNode(3,
                        new BTNode(6, null, null),
                        new BTNode(5, null, null)),
                new BTNode(6,
                        new BTNode(9, null, null),
                        new BTNode(6, null, null))
        );
        Assertions.assertEquals(3, findCount(root, 6, 0));
        Assertions.assertEquals(0, findCount(root, 12, 0));
    }

    /**
     *       1
     *   2       2
     * 4   5   5   4
     */
    boolean isMirror(BTNode node1, BTNode node2) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.data == node2.data) {
            return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
        }
        return false;
    }

    @Test
    public void isMirror() {
        BTNode root = new BTNode(1,
                new BTNode(2,
                        new BTNode(4, null, null),
                        new BTNode(5, null, null)),
                new BTNode(2,
                        new BTNode(5, null, null),
                        new BTNode(4, null, null))
        );
        Assertions.assertEquals(true, isMirror(root, root));

        root.left.left.left = new BTNode(6, null, null);
        Assertions.assertEquals(false, isMirror(root, root));
    }

    public class BTNode {
        private int data;
        private BTNode left;
        private BTNode right;

        public BTNode(int data, BTNode left, BTNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "BTNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
