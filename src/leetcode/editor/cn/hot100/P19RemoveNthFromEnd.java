package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.listnode.ListNode;
import leetcode.editor.cn.hot100.listnode.ListNodeUtil;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
 */
public class P19RemoveNthFromEnd {

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] nums = new int[]{1,2};  // 2,9,9
        ListNode head = listNodeUtil.createByArrays(nums);
        P19RemoveNthFromEnd removeNthFromEnd = new P19RemoveNthFromEnd();
        ListNode res = removeNthFromEnd.removeNthFromEnd(head, 1);
        listNodeUtil.printListNode(res);
    }

    /**
     * 移除倒数第n个元素
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getListLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 在链表前插入一个头节点，很有效处理去除的是倒数第length个节点 也就是第一个节点
        ListNode curr = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }

    /**
     * 获取链表长度
     * @param head 链表
     * @return 长度
     */
    public int getListLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
