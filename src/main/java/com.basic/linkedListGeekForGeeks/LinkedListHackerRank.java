package com.basic.linkedListGeekForGeeks;

import java.util.Scanner;

public class LinkedListHackerRank {
    public static Node1 insert(Node1 head, int data) {
        //Complete this method
        Node1 temp = head;
        Node1 node = new Node1(data);
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        return head;
    }

    static Node1 removedDuplicates(Node1 head) {
        Node1 temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else
                temp = temp.next;
        }
        System.out.println("LinkedList after removing the duplicates");
        display(head);
        return head;
    }

    public static void display(Node1 head) {
        Node1 start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node1 head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
        removedDuplicates(head);
        sc.close();
    }
}

class Node1 {
    int data;
    Node1 next;

    Node1(int d) {
        data = d;
        next = null;
    }
}