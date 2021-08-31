package com.leetcode.crack.easy;

public class Q83 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode item1 = new ListNode(1);
        ListNode item2 = new ListNode(1);
        ListNode item3 = new ListNode(2);

        item1.next = item2;
        item2.next = item3;
        ListNode listNode = new Q83().deleteDuplicates(item1);
        ListNode start = listNode;
        while(start != null) {
            System.out.println(start.val);
            start = start.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode start = head;

        while(head.next != null) {
            ListNode current = head;
            ListNode next = head.next;
            if(next != null) {
                if(current.val == next.val) {
                    current.next = next.next;
                    continue;
                }
            }

            head = head.next;
        }
        return start;
    }
}
