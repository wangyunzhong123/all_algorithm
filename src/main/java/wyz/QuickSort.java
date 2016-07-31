package wyz;

import util.Data;

/**
 * Created by tianxi on 7/31/16.
 */

/*
* 快排序，不稳定,原址排序
* */
public class QuickSort {

    public void execute(int a[],int p,int r){
        if(p<r){
            int q = partition(a,p,r);
            execute(a,p,q-1);
            execute(a,q+1,r);
        }
    }

    private int partition(int a[],int p,int r){
        int x = a[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++){
            if(a[j] <= x){
                i = i+1;
                //交换
                int temp = a[i];
                a[i] = a[j];
                a[j] =temp;
            }
        }
        //交换
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }

    //测试稳定性
    public void execute2(Data a[], int p, int r){
        if(p<r){
            int q = partition2(a,p,r);
            execute2(a,p,q-1);
            execute2(a,q+1,r);
        }
    }

    private int partition2(Data a[],int p,int r){
        Data x = a[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++){
            if(a[j].value <= x.value){
                i = i+1;
                //交换
                Data temp = a[i];
                a[i] = a[j];
                a[j] =temp;
            }
        }
        //交换
        Data temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;
        return i+1;
    }
}
