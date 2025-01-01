package leetcode.editor.cn.hot100;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class P49Trap {
    public static void main(String[] args) {

        P49Trap trap = new P49Trap();
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int res = trap.trap(height);
        System.out.println(res);
    }

    /**
     * （双指针）计算能接多少雨水
     * @param height 数组
     * @return 接多少雨水
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left <= right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if (height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            } else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}
