package wyz;

/**
 * Created by yzwang on 2017/9/15.
 */

/**
 * 字符串编辑距离
 给定一个源字符串和目标字符串，能够对源串进行如下操作：
 1.在给定位置上插入一个字符
 2.替换任意字符
 3.删除任意字符
 求通过以上操作使得源字符串和目标字符串一致的最小操作步数。
 简单描述一下解该题的思想，源字符串和目标字符串分别为str_a、str_b，二者的长度分别为la、lb，定义f[i,j]为子串str_a[0...i]和str_b[0...j]的最小编辑距离，简单分析可知求得的str_a[0...i]和str_b[0...j]的最小编辑距离有一下三种可能：
 （1）去掉str_a[0...i]的最后一个字符跟str_b[0...j]匹配，则f[i, j]的值等于f[i-1, j]+1；
 （2）去掉str_b[0...j]的最后一个字符跟str_a[0...i]匹配，则f[i, j]的值等于f[i, j-1]+1；
 （3）去掉str_a[0...i]和str_b[0...j]的最后一个字符，让二者匹配求得f[i-1, j-1]，计算f[i, j]时要考虑当前字符是否相等，如果str_a[i]==str_b[j]说明该字符不用编辑，所以f[i, j]的值等于f[i-1, j-1]，如果str_a[i]!=str_b[j]说明该字符需要编辑一次（任意修改str_a[i]或者str_b[j]即可），所以f[i, j]的值等于f[i-1, j-1]+1。
 因为题目要求的是最小的编辑距离，所以去上面上中情况中的最小值即可，因此可以得到递推公式：
 f[i, j] = Min ( f[i-1, j]+1,   f[i, j-1]+1,   f[i-1, j-1]+(str_a[i]==str_b[j] ? 0 : 1) )

 http://blog.csdn.net/han_xiaoyang/article/details/11969497

 */

/**
 * 矩阵标记法
 递推方法（也可称为矩阵标记法），通过分析可知可以将f[i, j]的计算在一个二维矩阵中进行，上面的递推式实际上可以看做是矩阵单元的计算递推式，只要把矩阵填满了，f[la-1, lb-1]的值就是要求得最小编辑距离。代码如下：

 */
public class EDI {

    public static int editDistance_iter(char[] strA,char[] strB){

        //递推版本 C[i,j]表示strA[i]...strA[size_A-1]与strB[j]...strB[size_B-1]的编辑距离
        int[][] c= new int[strA.length+1][];
        for (int i = 0; i < strA.length+1; i++) {
            c[i] = new int[strB.length+1];
        }

        int size_A = strA.length;
        int size_B = strB.length;

        for(int i=size_A;i>=0;i--){
            for(int j=size_B;j>=0;j--){
                if(i>size_A-1){
                    if(j>size_B-1)
                        c[i][j]=0;
                    else
                        c[i][j]=size_B-j;
                }else if(j>size_B-1){
                    if(i>size_A-1)
                        c[i][j]=0;
                    else
                        c[i][j]=size_A-i;
                }else if(strA[i]==strB[j])
                    c[i][j]=c[i+1][j+1];
                else
                    c[i][j]=Math.min(Math.min(c[i+1][j+1],c[i+1][j]),c[i][j+1])+1;
            }
        }
        int res = c[0][0];
        return res;
    }

    public static void main(String[] args) {

        String a = "abcdef";
        String b = "cbciefe";

        System.out.println(editDistance_iter(a.toCharArray(),b.toCharArray()));
    }
}
