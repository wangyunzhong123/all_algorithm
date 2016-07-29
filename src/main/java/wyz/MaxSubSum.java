package wyz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianxi on 7/29/16.
 */

/*
* 最大子序列和，输入一组数据，有正有负，求最大和的连续序列。算法实现很简单，理解有点难度
* */
public class MaxSubSum {


    public void execute(int a[]){
        int maxSum =0,cureSum =0;

        List<Integer> index = new ArrayList<Integer>();
        for(int i=0;i<a.length;i++){
            cureSum +=a[i];
            if(cureSum>maxSum) {
                maxSum = cureSum;
                index.add(new Integer(i));
            }
            else if(cureSum<0){
                cureSum=0;
                index.clear();
            }
            else if(cureSum!=0){
                index.add(new Integer(i));
            }
        }
        System.out.println("最大和是："+maxSum);
        System.out.println("序列是：");
        for(int i=0;i<index.size();i++){
            System.out.print(a[index.get(i)]+"  ");
        }
    }
}
