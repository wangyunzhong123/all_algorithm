package LeetCode.Range1_20;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by yzwang on 2019/3/29.
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 https://leetcode-cn.com/problems/two-sum/
 */
public class Solution_1 {

    //还是想先排序，再两端查找
    //快排
    //可以用hash。不行，不能处理有重复数字的情况
    public static void main(String[] args) {

        int[] a = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(a,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int i=0;
        int j=0;

        Map<Integer,Integer> hash=new Hashtable<>();
        for(i=0;i<nums.length;i++) {
            if(hash.containsKey(target-nums[i]) ) {
                j=hash.get(target-nums[i]);
                break;
            }
            else hash.put(nums[i], i);
        }

        if(i<=j){
            int result[]={i,j};return result;
        }
        else {
            int result[]={j,i};return result;
        }
    }
}
