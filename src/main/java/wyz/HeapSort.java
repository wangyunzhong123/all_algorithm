package wyz;

/**
 * Created by tianxi on 7/29/16.
 */

/*
* 堆排序，分为建堆，然后迭代维护最大堆的性质
* 不稳定，原址排序
* */
public class HeapSort {

    int heap_size;//保存堆的大小

    public void execute(int a[]){
        build_max_heap(a);
        for(int i=a.length-1;i>=1;i--){
            //交换
            int temp = a[0];
            a[0] = a[i];
            a[i] =temp;
            heap_size = heap_size-1;
            max_heapify(a,0);
        }
    }

    //维护堆的性质
    private void max_heapify(int a[],int i){
        int l = left(i);
        int r = right(i);
        int largest;

        if(l < heap_size && a[l]>a[i])
            largest =l;
        else largest=i;

        if(r<heap_size && a[r] >a[largest])
            largest =r;

        if(largest !=i){
            //交换
            int temp = a[i];
            a[i] = a[largest];
            a[largest] =temp;

            max_heapify(a,largest);
        }

    }

    //建堆
    private void build_max_heap(int a[]){
        heap_size = a.length;
        for(int i=new Double(Math.floor((a.length-1)/2)).intValue();i>=0;i--){
            max_heapify(a,i);
        }
    }



    //获取左孩子
    private int left(int i){
        return i*2 +1;
    }
    //获取右孩子
    private int right(int i){
        return i*2+2;
    }
    //获取父节点
    private int parent(int i){
        return new Double(Math.floor((i-1)/2)).intValue();
    }
}
