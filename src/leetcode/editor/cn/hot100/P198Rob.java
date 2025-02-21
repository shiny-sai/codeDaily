package leetcode.editor.cn.hot100;

import java.util.Scanner;

/**
 * Author: 曹赛
 * Date: 2025/2/21
 * Description:
 */
public class P198Rob {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        P198Rob rob = new P198Rob();
        while (in.hasNextLine()) {
            String[] str = in.nextLine().split(" ");
            int[] nums = new int[str.length];
            int count = 0;
            for (String s : str) {
                nums[count++] = Integer.parseInt(s);
            }
            int res = rob.rob(nums);
            System.out.println(res);
        }
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else if (i == 1) {
                dp[i] = Math.max(nums[i], nums[i-1]);
            } else {
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
            }
        }

        int maxNum = -1;
        for (int i : dp) {
            maxNum = Math.max(i, maxNum);
        }

        return maxNum;
    }

}
