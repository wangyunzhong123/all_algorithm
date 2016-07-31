package wyz;

/**
 * Created by tianxi on 7/31/16.
 */

/*
* 两个字符串的最大公共子序列。自底向上
* */
public class LCSLength {

    int b[][];
    int c[][];

    public void execute(char x[],char y[]){
        int m =x.length;
        int n = y.length;
        b = new int[m][n];
        c = new int[m][n];

        for(int i=1;i<m;i++)
            c[i][0] = 0;
        for(int j=0;j<n;j++)
            c[0][j] = 0;

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                if(x[i] == y[j]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = 0;
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] =1;
                }
                else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = 2;
                }
            }
    }

    public int LCS_length(int i,int j){
        return c[i][j];
    }
    //打印结果
    public void print_LCS(char x[],int i,int j){
        if(i==0 || j==0)
            return;
        if(b[i][j] ==0){
            print_LCS(x,i-1,j-1);
            System.out.print(x[i]);
        }
        else if(b[i][j] ==1)
            print_LCS(x,i-1,j);
        else
            print_LCS(x,i,j-1);
    }
}
