package LeetCode;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Created by yzwang on 2019/4/18.
 *
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。

 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。

 示例1:

 输入: pattern = "abba", str = "dog cat cat dog"
 输出: true
 示例 2:

 输入:pattern = "abba", str = "dog cat cat fish"
 输出: false
 示例 3:

 输入: pattern = "aaaa", str = "dog cat cat dog"
 输出: false
 示例 4:

 输入: pattern = "abba", str = "dog dog dog dog"
 输出: false
 */
public class Solution_290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String,String> map = new Hashtable<>();
        Set<String> set = new HashSet<>();

        String[] strs = str.split(" ");

        if(strs.length != pattern.length())
            return false;

        for (int i = 0; i < strs.length; i++) {
            String temp = pattern.substring(i,i+1);
            if(map.containsKey(strs[i])){
                if(!temp.equals(map.get(strs[i]))){
                    return false;
                }
            }else {
                if(set.contains(temp)){
                    return false;
                }else {
                    map.put(strs[i],temp);
                    set.add(temp);
                }
            }
        }
        return true;
    }
}
