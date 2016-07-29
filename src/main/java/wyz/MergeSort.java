package wyz;

import util.Data;

/**
 * Created by tianxi on 7/29/16.
 */

/*
* 分治算法，归并排序的实现。稳定，非原址排序
*
* */
public class MergeSort {

    //正常对数组的排序
    public void execute(int a[],int p,int r){
        if(p < r){
            int q = new Double(Math.floor((p+r)/2)).intValue();//向下取整，Math.ceil()向上取整
            execute(a,p,q);
            execute(a,q+1,r);
            merge(a,p,q,r);
        }
    }
    private void merge(int a[],int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        int L[] = new int[n1+1];
        int R[] = new int[n2+1];

        for(int i=0;i<n1;i++){
            L[i] = a[p+i];
        }

        for(int j=0;j<n2;j++){
            R[j] = a[q+j+1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i=0,j=0;

        for(int k=p;k<=r;k++){
            if(L[i]<=R[j]) {
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
        }
    }

    //为证明是原址排序，
    public void execute2(Data a[], int p, int r){
        if(p < r){
            int q = new Double(Math.floor((p+r)/2)).intValue();//向下取整，Math.ceil()向上取整
            execute2(a,p,q);
            execute2(a,q+1,r);
            merge2(a,p,q,r);
        }
    }
    private void merge2(Data a[],int p,int q,int r){
        int n1 = q-p+1;
        int n2 = r-q;
        Data L[] = new Data[n1+1];
        Data R[] = new Data[n2+1];

        for(int i=0;i<n1;i++){
            L[i] = a[p+i];
        }

        for(int j=0;j<n2;j++){
            R[j] = a[q+j+1];
        }

        L[n1] = new Data();
        L[n1].value = Integer.MAX_VALUE;
        L[n1].index = String.valueOf(Integer.MAX_VALUE);
        R[n2] = new Data();
        R[n2].value = Integer.MAX_VALUE;
        R[n2].index = String.valueOf(Integer.MAX_VALUE);

        int i=0,j=0;

        for(int k=p;k<=r;k++){
            if(L[i].value<=R[j].value) { //改算法的稳定，取决于这一行的<=
                a[k] = L[i];
                i++;
            }
            else{
                a[k] = R[j];
                j++;
            }
        }
    }
}
