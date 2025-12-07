package number;

import org.junit.jupiter.api.Test;

public class BTtoDLLTest {

    // head --> Pointer to head node of created doubly linked list
    BTNode head;

    // Initialize previously visited node as NULL. This is
    // static so that the same value is accessible in all recursive
    // calls
    static BTNode prev = null;

    private void BinaryTree2DoubleLinkedList(BTNode root) {

        // Base case
        if (root == null) return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }

    /* Function to print nodes in a given doubly linked list */
    private void printList(BTNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
//        printList(node.left);
        printList(node.right);
    }

    @Test
    public void test() {
        BTNode root = new BTNode(1,
                new BTNode(3,
                        new BTNode(6, null, null),
                        new BTNode(5, null, null)),
                new BTNode(-10,
                        new BTNode(9, null, null),
                        new BTNode(15, null, null))
        );

        // convert to DLL
        BinaryTree2DoubleLinkedList(root);

        // Print the converted List
        printList(root);
    }

    public class BTNode {
        int data;
        BTNode left;
        BTNode right;

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
