package Algorithm;

/**
 * Created by yzwang on 2019/4/13.
 *
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {12,3,5,9,1,3,5,7,0,9,1};
//        System.out.println(partition(a,0,a.length - 1));

        quickSort(a,0,a.length - 1);
        for (int i: a) {
            System.out.println(i);
        }
    }

    public static void quickSort(int a[],int start,int end){
        if(start < end){
            int partition = partition(a,start,end);
            quickSort(a,start,partition -1);
            quickSort(a,partition + 1, end);
        }

    }

    public static int partition(int[] a,int start,int end){
        int temp = a[end];

        int index = start - 1;
        for (int i = start; i < end ; i++) {
            if(a[i] < temp){
                index ++;
                if(index != i){
                    //交换
                    int te = a[index];
                    a[index] = a[i];
                    a[i] = te;
                }
            }
        }
        index ++;
        int te = a[index];
        a[index] = a[end];
        a[end] = te;

        return index;
    }
}
