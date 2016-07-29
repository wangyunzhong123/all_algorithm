package wyz;

import util.Data;

/**
 * Created by tianxi on 7/29/16.
 */

/*
* 插入排序，原址排序，稳定
* */
public class InsertSort {

    public void execute(int a[]){
        int i;
        int key;
        for(int j=1;j<a.length;j++){
            key = a[j];
            i=j-1;
            while(i>=0 && a[i]>key){
                a[i+1] = a[i];
                i=i-1;
            }
            a[i+1] = key;
        }
    }

    public void execute2(Data a[]){
        int i;
        Data key;
        for(int j=1;j<a.length;j++){
            key = a[j];
            i=j-1;
            while(i>=0 && a[i].value>=key.value){//改算法编程了不稳定，由于这一行后面的>=。。改为>变为稳定
                a[i+1] = a[i];
                i=i-1;
            }
            a[i+1] = key;
        }
    }
}
