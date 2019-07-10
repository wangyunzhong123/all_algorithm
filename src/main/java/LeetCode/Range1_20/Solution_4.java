package LeetCode.Range1_20;

/**
 * Created by yzwang on 2019/4/13.
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

 你可以假设 nums1 和 nums2 不会同时为空。

 示例 1:

 nums1 = [1, 3]
 nums2 = [2]

 则中位数是 2.0
 示例 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 则中位数是 (2 + 3)/2 = 2.5

 1,4,5
 2,3

 3


 1,4,6
 7,8,9

 6.5

 未完成

 */
public class Solution_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0)
            return get(nums2);
        if(nums2 == null || nums2.length == 0)
            return get(nums1);

        return 0;
    }

    public double get(int[] a){
        if(a == null || a.length == 0)
            return -1;

        if(a.length % 2 == 0){//偶数个
            int middle = a.length / 2;
            return (a[middle - 1] + a[middle]) / 2;
        }else {//奇数个
            int middle = a.length / 2;
            return a[middle];
        }
    }
}
