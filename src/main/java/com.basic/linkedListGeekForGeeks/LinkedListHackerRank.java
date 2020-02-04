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

    public static void display(Node1 head) {
        Node1 start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String[] args) {
        LinkedListHackerRank list = new LinkedListHackerRank();
        Scanner sc = new Scanner(System.in);
        Node1 head = null;
        int N = sc.nextInt();

        while (N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        display(head);
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