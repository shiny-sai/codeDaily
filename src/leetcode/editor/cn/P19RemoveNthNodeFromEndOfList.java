//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2871 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：删除链表的倒数第 N 个结点
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int len = 0; // 链表长度
        Map<Integer, ListNode> map = new HashMap(); // 遍历记录链表顺序
        // 遍历链表得到链表长度
        while (p != null) {
            map.put(len, p);
            len++;
            p = p.next;
        }
        ListNode del = map.get(len - n);
        ListNode prev = map.getOrDefault(len-n-1, null);
        ListNode post = map.getOrDefault(len-n+1, null);
        if (prev == null && post == null) {
            return null;
        } else if (prev != null) {
            prev.next = post;
            del.next = null;
        } else if (prev == null && post != null) {
            return post;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}