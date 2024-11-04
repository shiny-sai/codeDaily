package leetcode.editor.cn.test.doublepointer;

import java.util.Arrays;

public class P26RemoveDuplicates {

    // Test
    public static void main(String[] args) {

        P26RemoveDuplicates rd = new P26RemoveDuplicates();
        int[] nums = new int[]{1,2,2,3,3,4,4,4,5,6,6};
        int len = rd.removeDuplicates(nums);
        System.out.println(len);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 移除有序数组中的重复元素，使得每个元素只留一个，并返回数组长度
     * @param nums 数组
     * @return 数组长度
     */
    public int removeDuplicates(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != nums[slowIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
        }
        return slowIndex + 1;
    }
}
