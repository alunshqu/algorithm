package com.aaron.algorithm.link;

public class ReverseLink {

    public LinkNode reverseLink(LinkNode head) {
        LinkNode prev = null;
        LinkNode cur = head;
        while (cur != null) {
            LinkNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();

        LinkNode head = new LinkNode(1);
        head.next = new LinkNode(2);
        head.next.next = new LinkNode(3);
        head.next.next.next = new LinkNode(4);
        head.next.next.next.next = new LinkNode(5);
        head.next.next.next.next.next = new LinkNode(6);
        LinkNode cur = head;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }

        cur = reverseLink.reverseLink(head);

        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }
}
