package com.basic.tree

class BinarySearchTree {

    Node root
    class Node {
        int data
        Node left, right = null

        Node(int _data) {
            data = _data
        }
    }

    void insert(int data) {
        root = insertRec(root, data)
        displayTree()
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data)
            return root
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data)
        } else {
            root.right = insertRec(root.right, data)
            println("In right" +root.data)
        }
        root
    }

    void displayTree() {
        inOrderTraversal(root)
        println("------------------------")
    }

    private void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left)
            println(root.data)
            inOrderTraversal(root.right)
        }
    }

    static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree()
        binarySearchTree.insert(4)
        binarySearchTree.insert(2)
        binarySearchTree.insert(5)
        binarySearchTree.insert(1)
        binarySearchTree.insert(6)
        binarySearchTree.insert(7)
        binarySearchTree.insert(3)
        println("------------------------")
        binarySearchTree.displayTree()

    }
}
