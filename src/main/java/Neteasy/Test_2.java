package Neteasy;

import java.util.Scanner;


public class Test_2 {
    public static int curCount=0,curMax=Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()) {
            String s = sc.nextLine();
            count = 0;
            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '(') {
                    count++;
                }
            }
            curCount=0;
            curMax=Integer.MIN_VALUE;
            String cur = "";
            generateParentheses(count,count,cur,s);

            System.out.println(curCount);
        }
    }

    public static void generateParentheses(int left, int right, String cur,String origin)
    {
        if(left==0&&right==0)
        {
            if(!cur.equals(origin)) {
                int temInt = LCS(cur,origin);
                if(temInt > curMax) {
                    curMax = temInt;
                    curCount = 1;
                }
                else if(temInt == curMax) {
                    curCount++;
                }
            }

        }
        if(left>0)
        {
            generateParentheses(left-1,right,cur+"(",origin);
        }
        if(right>0&&left<right)
        {
            generateParentheses(left, right-1, cur+")",origin);
        }
    }

    public static int LCS(String str1, String str2) {
        int[][]dp=new int[str1.length()+1][str2.length()+1];
        for(int i=1;i<str1.length()+1;i++){
            for (int j=1;j<str2.length()+1; j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}