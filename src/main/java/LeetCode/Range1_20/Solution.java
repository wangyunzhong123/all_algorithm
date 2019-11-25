package LeetCode.Range1_20;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.*;

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
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[][] dp = new int[n+1][m+1];
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                flag = true;
            }else
                dp[i][0] = 1;

            if (flag) {
                dp[i][0] = 0;
            }
        }
        flag = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                flag = true;
            } else
                dp[0][i] = 1;
            if (flag) {
                dp[0][i] = 0;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        System.out.println(dp[n-1][m-1]);

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

    // 数塔问题 https://blog.csdn.net/theonegis/article/details/45801201 自底向上
    @Test
    public void numberTower() {
        int[][] data = new int[][]{{9},{12,15},{10,6,8},{2,18,9,5},{19,7,10,4,16}};
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }

        // 初始化
        int n = data.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = data[n-1][i];
        }

        for (int i = n-2; i >=0 ; i--) {
            for (int j = 0; j <= i ; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + data[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
    // leetcode120 和数塔问题高度相似
    @Test
    public void minimumTotal() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(ImmutableList.of(2));
        triangle.add(ImmutableList.of(3,4));
        triangle.add(ImmutableList.of(6,5,7));
        triangle.add(ImmutableList.of(4,1,8,3));

    }
}
