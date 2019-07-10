package Algorithm;

/**
 * Created by yzwang on 2019/4/13.
 *
 * 递归排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] a = {2,3,1,6,4,9,8,5,7,10};
        a = sort(a,0,a.length - 1);
        for (int item:a) {
            System.out.println(item);
        }
    }

    public static int[] sort(int[] a,int start,int end){
//        if(start < end){
//            int middle = (start + end) / 2;
//            sort(a,start,middle);
//            sort(a,middle + 1,end);
////            merge(a,start,middle,end);
//            System.out.println(a[middle]);
//        }
        if(start == end){
            return new int[]{a[start]};
        }
        int mid = (end + start) / 2;
        int[] l = sort(a, start, mid);
        int[] r = sort(a, mid + 1, end);

        return merge(l, r);
    }

    public static int[] merge(int[] l,int[] r){
        int[] result = new int[l.length + r.length];
        int p = 0;
        int lp = 0;
        int rp = 0;
        while (lp < l.length && rp < r.length) {
            result[p++] = l[lp] < r[rp] ? l[lp++] : r[rp++];
        }
        while (lp < l.length) {
            result[p++] = l[lp++];
        }
        while (rp < r.length) {
            result[p++] = r[rp++];
        }

        return result;
    }
}
