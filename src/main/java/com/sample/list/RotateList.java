package com.sample.list;

public class RotateList {
  public static SingleLinkedNode rotate(SingleLinkedNode head, int x) {
    SingleLinkedNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
    }
    SingleLinkedNode newHead = null;
    for (int i = 0; i < x; i++) {
      newHead = head.next;
      head.next = null;
      tail.next = head;
      head = newHead;
      tail = tail.next;
    }
    return head;
  }

  public static void main(String[] args) {
    SingleLinkedNode head = new SingleLinkedNode(1, null);
    SingleLinkedNode cur = head;
    for (int i = 2; i <= 8; i++) {
      cur.next = new SingleLinkedNode(i, null);
      cur = cur.next;
    }
    System.out.println("before: ");
    cur = head;
    while (cur != null) {
      System.out.print(cur.value + " ");
      cur = cur.next;
    }
    System.out.println("\nAfter: ");
    cur = rotate(head, 3);
    while (cur != null) {
      System.out.print(cur.value + " ");
      cur = cur.next;
    }
  }
}
