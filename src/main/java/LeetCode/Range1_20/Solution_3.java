package LeetCode.Range1_20;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Created by yzwang on 2019/4/13.
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution_3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aaabbbddc"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring2("abba"));
    }

    //自己实现的
    public static int lengthOfLongestSubstring(String s) {

        if(s == null)
            return 0;

        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new Hashtable<>();
        int length = 0;
        int max = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!map.containsKey(chars[i])){
                map.put(chars[i],i);
                length ++;
            }else{
                int index = map.get(chars[i]);
                for (int j = start; j <= index ; j++) {
                    map.remove(chars[j]);
                }
                start = index + 1;
                map.put(chars[i],i);
                length = i - index;
            }
            max = Math.max(max,length);
        }
        return max;
    }

    //优化的方法
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //再优化的方法
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new Hashtable<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static int lengthOfLongestSubstring4(String s) {
        Map<Character, Integer> map = new Hashtable<>();
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = map.get(s.charAt(i));
                map.put(s.charAt(i), i);
            }

            max = Math.max(max, i - start + 1);

        }

        return 0;
    }

}

