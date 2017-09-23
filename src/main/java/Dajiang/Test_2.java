package Dajiang;
import java.util.*;
/**
 * Created by yzwang on 2017/9/3.
 */

public class Test_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int res = help(nums, k);
            System.out.println(res);
        }
        sc.close();
    }

    private static int help(int[] nums, int k) {
        if (k == 0 || nums.length == 0)
            return 0;
        int res = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                List<Integer> temp = new ArrayList<Integer>();
                boolean flag = true;
                for (int m = i; m <= j; m++) {
                    temp.add(nums[m]);
                    if (map.containsKey(nums[m]))
                        map.put(nums[m], map.get(nums[k])+1);
                    else
                        map.put(nums[m], 1);
                    if (map.get(nums[m]) > k) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    res++;
            }
        }
        return res;
    }
}