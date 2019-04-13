package LeetCode;

/**
 * Created by yzwang on 2019/4/13.
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution_53 {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMax(a));
        System.out.println(getMax2(a));
    }

    //wrong
    public static int getMax(int[] a){
        if(a == null || a.length == 0)
            return 0;

        int max = a[0];
        for (int i = 1; i < a.length; i++) {
//            if(max < 0){
//                if(a[i] > 0){
//                    max = a[i];
//                    continue;
//                }
//            }
            if(max > 0)
                max = Math.max(max,a[i] + max);
            else
                max = Math.max(max,a[i]);
        }

        return max;
    }

    //
    public static int getMax2(int[] nums){
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
    }
}
