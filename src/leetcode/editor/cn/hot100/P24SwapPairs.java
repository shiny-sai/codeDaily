package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.listnode.ListNode;
import leetcode.editor.cn.hot100.listnode.ListNodeUtil;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
 */
public class P24SwapPairs {

    public static void main(String[] args) {
        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] nums = new int[]{1,2,3,4,5};  // 2,9,9
        ListNode head = listNodeUtil.createByArrays(nums);
        P24SwapPairs swapPairs = new P24SwapPairs();
        ListNode res = swapPairs.swapPairs(head);
        listNodeUtil.printListNode(res);
    }

    /**
     * 将链表内元素两两交换
     * @param head 链表
     * @return 两两交换后的链表
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;  // 记录前序节点

        while (head != null && head.next != null) {
            ListNode first = head;  // 指向第一个节点
            ListNode second = head.next;    // 指向第二个节点

            // 执行交换操作
            first.next = second.next;
            second.next = first;

            // prev 前序指向第二个节点，第二个节点交换后反而位于前面
            prev.next = second;

            // 移动指针
            prev = first;       // 为的是下一次prev.next可以接上下两个元素交换后较前的元素
            head = first.next;

        }
        return dummy.next;
    }
}
