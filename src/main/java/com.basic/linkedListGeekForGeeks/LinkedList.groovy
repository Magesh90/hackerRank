package com.basic.linkedListGeekForGeeks

class LinkedList {

    Node head

    int length = 0

    void add(int data) {
        Node node = new Node(data)
        node.next = head
        head = node
        length++
    }

    void addAtPosition(int data, int position) {

        if (position == 0 && head == null) {
            head = new Node(data)
        } else if (position == 0 && head != null) {
            Node nodeToBeAdded = new Node(data)
            nodeToBeAdded.next = head
            head = nodeToBeAdded
        } else {
            Node nodeToBeAdded = new Node(data)
            int counter = 0
            Node current = head
            Node previous = null
            while (counter < position) {
                previous = current
                current = current.next
                counter++
            }
            nodeToBeAdded.next = current
            previous.next = nodeToBeAdded
        }
        length++
    }

    void printList() {
        Node tHead = head
        while (tHead != null) {
            System.out.print(tHead.data + "-->")
            tHead = tHead.next
        }
        System.out.println("NULL")
    }

    void reverseList() {

        Node pointer = head
        Node previous = null

        while (pointer != null) {
            Node temp = previous
            previous = pointer
            pointer = pointer.next
            previous.next = temp
        }

        head = previous

        printList()
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

    Node kThNodeFromMiddle(int k) {

        int position = (length / 2) - k

        System.out.println("position of node from head is " + position)
        System.out.println("Looking for element at position:$k from middle towards head")
        if (position < 0) {
            System.out.println("Invalid value for k=$k")
            return null
        }

        Node tNode = head
        int counter = 0
        while (counter < position) {
            tNode = tNode.next
            counter++
        }
        tNode
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
        linkedList.add(6)
        linkedList.add(7)
        linkedList.add(8)
        linkedList.add(9)
        linkedList.printList()
        System.out.println("Middle Node is " + linkedList.middleNode().data)
        System.out.println("Linked List Length is " + linkedList.length)
        System.out.println("1st Node from middle is " + linkedList.kThNodeFromMiddle(1).data)
        linkedList.addAtPosition(45, 4)
        linkedList.printList()
        println("Reversing the list")
        linkedList.reverseList()
    }

}