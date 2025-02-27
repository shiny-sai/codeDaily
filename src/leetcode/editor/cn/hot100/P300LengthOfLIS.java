package leetcode.editor.cn.hot100;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P300LengthOfLIS {
    public static void main(String[] args) {
        P300LengthOfLIS len = new P300LengthOfLIS();
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String[] str = in.nextLine().split(",");
            int[] nums = new int[str.length];
            int count = 0;
            for (String s : str) {
                nums[count++] = Integer.parseInt(s);
            }
            int res = len.lengthOfLIS(nums);
            System.out.println(res);
        }
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

}
