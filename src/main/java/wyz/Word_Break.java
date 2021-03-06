package wyz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by tianxi on 4/11/17.
 */

/*
* Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
* */
public class Word_Break {

    /*
    * 通常方法，O(n^2)
    * */
    public static boolean wordBreakHelper(String s, Set<String> dict, int start){
        if(start == s.length())
            return true;

        for(String a: dict){
            int len = a.length();
            int end = start+len;

            //end index should be <= string length
            if(end > s.length())
                continue;

            if(s.substring(start, start+len).equals(a))
                if(wordBreakHelper(s, dict, start+len))
                    return true;
        }

        return false;
    }

    /*
    * 动态规划方法
    * Define an array t[] such that t[i]==true => 0-(i-1) can be segmented using dictionary
    *  Initial state t[0] == true
    *  Time: O(string length * dict size).
    * */
    public static boolean wordBreak_DP(String s,Set<String> dict){

        boolean[] t = new boolean[s.length()+1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for(int i=0; i<s.length(); i++){
            //should continue from match position
            if(!t[i])
                continue;

            for(String a: dict){
                int len = a.length();
                int end = i + len;
                if(end > s.length())
                    continue;

                if(t[end]) continue;

                if(s.substring(i, end).equals(a)){
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    /*
    * 3. Java Solution 3 - Simple and Efficient
    In Solution 2, if the size of the dictionary is very large, the time is bad.
    Instead we can solve the problem in O(n^2) time (n is the length of the string).
    * */
    public static boolean wordBreak_simple(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];

        Arrays.fill(pos, -1);

        pos[0]=0;

        for(int i=0; i<s.length(); i++){
            if(pos[i]!=-1){
                for(int j=i+1; j<=s.length(); j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[s.length()]!=-1;
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("leet");
        dict.add("lee");
        dict.add("code");

        String s = "leetcodelee";
        System.out.println(wordBreakHelper(s,dict,0));
        System.out.println(wordBreak_DP(s,dict));

        Set<String> set = new TreeSet<String>();
        set.add("abc");
        set.add("xyz");
        set.add("rst");
    }

}
