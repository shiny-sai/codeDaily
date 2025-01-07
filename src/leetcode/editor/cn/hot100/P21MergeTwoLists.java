package leetcode.editor.cn.hot100;

import leetcode.editor.cn.hot100.listnode.ListNode;
import leetcode.editor.cn.hot100.listnode.ListNodeUtil;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class P21MergeTwoLists {

    public static void main(String[] args) {

        ListNodeUtil listNodeUtil = new ListNodeUtil();
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};  // 1,3,4
        ListNode list1 = listNodeUtil.createByArrays(nums1);
        ListNode list2 = listNodeUtil.createByArrays(nums2);
        P21MergeTwoLists mergeTwoLists = new P21MergeTwoLists();
        ListNode res = mergeTwoLists.mergeTwoLists(list1, list2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    /**
     * 合并两个链表
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 声明一个头节点
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }

        // 如果有剩余的节点，直接连接
        current.next = (list1 != null) ? list1 : list2;

//        if (list1 == null) {
//            current.next = list2;
//        }
//
//        if (list2 == null) {
//            current.next = list1;
//        }

        return dummy.next;
    }
}
