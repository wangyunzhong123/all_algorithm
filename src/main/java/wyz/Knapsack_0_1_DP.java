package wyz;

/**
 * Created by tianxi on 7/31/16.
 */

/*
* 0,1背包问题，只能用动态规划求解，而不能用贪心
* */
public class Knapsack_0_1_DP {

    int c[][];
    public void execute(int v[],int w[],int n,int W){
        c = new int[n][W+1];

        for(int i=0;i<W+1;i++)
            c[0][i] = 0;
        for(int i =1;i<n;i++){
            c[i][0] = 0;
            for(int j=1;j<=W;j++){
                if(w[i] <= j){
                    if(v[i]+c[i-1][j-w[i]]>c[i-1][j]) {
                        c[i][j] = v[i] + c[i - 1][j - w[i]];
//                        System.out.print(i+"  ");
                    }
                    else
                        c[i][j] = c[i-1][j];
                }
                else
                    c[i][j] = c[i-1][j];
            }
        }
    }

    //打印结果
    public void print_result(int n,int W){
        System.out.println("最大价值是： "+c[n][W]);
    }

    //怎么把选择哪些物品列出来

}
