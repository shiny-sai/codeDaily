package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.listnode.ListNode;
import leetcode.editor.cn.hot100.listnode.ListNodeUtil;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class P2AddTwoNumbers {

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] nums1 = new int[]{0};  // 2,9,9
        int[] nums2 = new int[]{0};  // 1,3,4
        ListNode list1 = listNodeUtil.createByArrays(nums1);
        ListNode list2 = listNodeUtil.createByArrays(nums2);
        P2AddTwoNumbers addTwoNumbers = new P2AddTwoNumbers();
        ListNode res = addTwoNumbers.addTwoNumbers(list1, list2);

    }

    /**
     * 计算两个链表的和
     * @param l1 链表1
     * @param l2 链表1
     * @return 和的链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;

        // 只要有一个不为null 就继续计算，为null的当0处理
        while (l1 != null || l2 != null) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;

            int sum = carry + n1 + n2;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
}
