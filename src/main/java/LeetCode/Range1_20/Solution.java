package LeetCode.Range1_20;

import org.junit.Test;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = new int[]{10,9,2,5,3,7,101,18};
//        System.out.println(new Solution().lengthOfLIS(a));
        lIS(a);
        lIS(new int[]{7, 9, 6, 10, 7, 1, 3});
    }

    public int lengthOfLIS(int[] nums) {

        int start = 0;
        int max = 0;
        int nowlength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                nowlength = i - start;
            }else {
                start = i;
                nowlength = 0;
            }

            max = Math.max(max, nowlength);
        }
        return max;
    }

    // leetcode300
    public static int lIS(int[] num) {
        int[] f = new int[num.length + 1];
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (num[j] < num[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(f[i], max);
        }
        return max;
    }

    //leetcode45 从前往后
    @Test
    public void jump() {
        int[] nums = new int[]{2,3,1,1,4};
        int[] f = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] >= i - j) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(f[i]);

        }
    }

    // 从后往前  https://zhuanlan.zhihu.com/p/43006989
    @Test
    public void jump2() {
        int[] nums = new int[]{2,3,1,1,4};
        int len = nums.length - 1;
        int stepCount = 0;
        int right = 0;
        int left = 0;
        while (left < len) {
            int max = 0;
            for (int i = left; i <= left + nums[left]; i++) {
                max = Math.max(nums[i] + i, max);
            }
            left = max;
            stepCount ++;
        }
        System.out.println(stepCount);
    }

    // leetcode63
    @Test
    public void uniquePathsWithObstacles() {
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                System.out.print(obstacleGrid[i][j] + " ");
            }
            System.out.println();
        }

    }

    // leetcode62 m列 n行
    @Test
    public void uniquePaths() {
        int m = 7, n =3;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
