/*
 * Project: Test
 * 
 * File Created at 2018年7月9日
 * 
 * Copyright 2016 CMCC Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */
package leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @Type AddTwoNumbers002.java
 * @Desc 
 * @author Administrator
 * @date 2018年7月9日 下午7:21:55
 * @version 
 */
public class AddTwoNumbers002 {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> store = new ArrayList<Integer>();
        boolean flag = false;

        while (true) {
            int sum = flag ? 1 : 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            store.add(new Integer(sum % 10));
            flag = sum / 10 > 0 ? true : false;
            if (l1 == null && l2 == null) {
                if (flag)
                    store.add(1);
                break;
            }
        }
        int n = 0;
        ListNode result = new ListNode(0);
        ListNode header = result;
        while (n < store.size()) {
            header.next = new ListNode(store.get(n++));
            header = header.next;
        }
        result = result.next;
        return result;
    }

    public void test() {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        a.next = b;
        b.next = c;

        ListNode a1 = new ListNode(2);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(2);
        a1.next = b1;
        b1.next = c1;
        ListNode result = addTwoNumbers(a1, a);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static void main(String args[]) {
        new AddTwoNumbers002().test();
    }
}

/**
 * Revision history
 * -------------------------------------------------------------------------
 * 
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2018年7月9日 Administrator creat
 */
