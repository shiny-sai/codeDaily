package leetcode.editor.cn.test.doublepointer;

public class P27RemoveElement {
    //Test
    public static void main(String[] args) {
        P27RemoveElement re = new P27RemoveElement();
        int len = re.removeElement(new int[]{1,2,3,3,4}, 3);
        System.out.println(len);
    }

    /**
     * 移除数组中目标元素val，并返回最终数组长度
     * @param nums 数组
     * @param val 目标值
     * @return 数组长度
     */
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
                // 这里上一步运行完，slowIndex比fastIndex先加一
            }
        }
        return slowIndex;
    }
}
