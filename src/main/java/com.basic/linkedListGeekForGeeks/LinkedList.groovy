package com.basic.linkedListGeekForGeeks

class LinkedList {

    Node head

    void add(int data) {

        Node node = new Node(data)
        node.next = head
        head = node
    }

    void printList() {
        Node tHead = head
        while (tHead != null) {
            System.out.println(tHead.data)
            tHead = tHead.next
        }
    }

    Node middleNode() {

        Node fastPtr = head
        Node slowPtr = head

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next
            slowPtr = slowPtr.next
        }

        slowPtr
    }
}

class Node {

    int data
    Node next

    Node(int nodeData) {
        data = nodeData
        next = null
    }
}

class LinkedListDemo {

    static void main(String[] args) {
        LinkedList linkedList = new LinkedList()
        linkedList.add(1)
        linkedList.add(2)
        linkedList.add(3)
        linkedList.add(4)
        linkedList.add(5)
        linkedList.printList()
        System.out.println(linkedList.middleNode().data)
    }
}