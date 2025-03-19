package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.listnode.ListNode;

/**
 * Author: 曹赛
 * Date: 2025/3/18
 * Description:给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
 */
public class P206ReverseList {
    public static void main(String[] args) {

    }

    /**
     * 双指针反转链表
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
