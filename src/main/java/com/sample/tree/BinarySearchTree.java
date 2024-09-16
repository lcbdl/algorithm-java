package com.sample.tree;

public class BinarySearchTree {

    private class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            this.left = this.right = null;
        }
    }

    private Node root;

    // Insert a new key into the BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node rootNode, int key) {
        if (rootNode == null) {
            rootNode = new Node(key);
            return rootNode;
        }

        if (key < rootNode.key) {
            rootNode.left = insertRecursive(rootNode.left, key);
        } else if (key > rootNode.key) {
            rootNode.right = insertRecursive(rootNode.right, key);
        }

        return rootNode;
    }

    // Delete a key from the BST
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node rootNode, int key) {
        if (rootNode == null) {
            return null;
        }

        if (key < rootNode.key) {
            rootNode.left = deleteRecursive(rootNode.left, key);
        } else if (key > rootNode.key) {
            rootNode.right = deleteRecursive(rootNode.right, key);
        } else {
            // Node with only one child or no child
            if (rootNode.left == null) {
                return rootNode.right;
            } else if (rootNode.right == null) {
                return rootNode.left;
            }

            // Node with two children
            Node minValueNode = findMinValueNode(rootNode.right);
            rootNode.key = minValueNode.key;
            rootNode.right = deleteRecursive(rootNode.right, minValueNode.key);
        }

        return rootNode;
    }

    private Node findMinValueNode(Node rootNode) {
        Node current = rootNode;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // In-order traversal of the BST
    public void inorder() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node rootNode) {
        if (rootNode != null) {
            inorderRecursive(rootNode.left);
            System.out.print(rootNode.key + " ");
            inorderRecursive(rootNode.right);
        }
    }

    // Test the BST implementation
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert elements
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("In-order traversal:");
        bst.inorder(); // Output: 20 30 40 50 60 70 80

        // Delete elements
        bst.delete(20);
        System.out.println("In-order traversal after deleting 20:");
        bst.inorder(); // Output: 30 40 50 60 70 80

        bst.delete(30);
        System.out.println("In-order traversal after deleting 30:");
        bst.inorder(); // Output: 40 50 60 70 80

        bst.delete(50);
        System.out.println("In-order traversal after deleting 50:");
        bst.inorder(); // Output: 40 60 70 80
    }
}
