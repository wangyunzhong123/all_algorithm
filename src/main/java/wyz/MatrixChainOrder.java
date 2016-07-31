package wyz;

/**
 * Created by tianxi on 7/31/16.
 */

/*
* 矩阵链乘，动态规划，自底向上表格法的实现
* */
public class MatrixChainOrder {

    int m[][];
    int s[][];

    public void execute(int p[]){
        int n = p.length-1;
        m = new int[n+1][n+1];
        s = new int[n][n+1];

        for(int i=0;i<n+1;i++)
            m[i][i] = 0;
        for(int l = 2;l<n+1;l++)
            for(int i=1;i<n-l+2;i++){
                int j = i+l-1;
                m[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int q = m[i][k] + m[k+1][j] +p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        m[i][j] =q;
                        s[i][j] = k;
                    }
                }
            }
    }

    //打印最优解
    public void print_optimal_parens(int i,int j){
        if(i==j)
            System.out.print("A"+i);
        else{
            System.out.print("(");
            print_optimal_parens(i,s[i][j]);
            print_optimal_parens(s[i][j]+1,j);
            System.out.print(")");
        }
    }
}
