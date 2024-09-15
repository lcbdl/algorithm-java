package com.sample.list;

public class FindMiddle {
  public static int findMiddle(SingleLinkedNode head) {
    SingleLinkedNode slow = head;
    SingleLinkedNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow.value;
  }

  public static void main(String[] args) {
    SingleLinkedNode head = new SingleLinkedNode(1, null);
    SingleLinkedNode cur = head;
    for (int i = 2; i <= 6; i++) {
      cur.next = new SingleLinkedNode(i, null);
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      System.out.print(cur.value + " ");
      cur = cur.next;
    }
    System.out.println("");
    System.out.println(findMiddle(head));

  }
}
