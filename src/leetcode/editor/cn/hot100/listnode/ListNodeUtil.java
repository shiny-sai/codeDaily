package leetcode.editor.cn.hot100.listnode;

/**
 * 链表工具类
 * @author caosai
 */
public class ListNodeUtil {

    /**
     * 使用数组初始化生成一条链表
     * @param nums 数组
     * @return 初始化后的链表
     */
    public ListNode createByArrays(int[] nums) {
        ListNode listNode = new ListNode(-1);
        ListNode curr = listNode;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return listNode.next;
    }

    /**
     * 打印链表
     * @param res 链表
     */
    public void printListNode(ListNode res) {
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
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
