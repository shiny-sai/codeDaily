package leetcode.editor.cn.hot100.listnode;

/**
 * 链表工具类
 * @author caosai
 */
public class ListNodeUtil {

    /**
     * 删除链表节点值为val的所有节点
     * @param head 头节点
     * @param val 整数
     * @return 新的头节点
     */
    public ListNode removeElements(ListNode head, int val) {
        // 设置一个虚拟头节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 再定义一个指针，用于遍历链表
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }



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
