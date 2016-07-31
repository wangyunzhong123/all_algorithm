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
    public void build_max_heap(int a[]){
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


    //应用，优先队列
    public void execute2(int a[]){
        build_max_heap(a);
    }
    //返回最大值
    public int heap_max(int a[]){
        System.out.println("返回的最大值是： "+a[0]);
        return a[0];
    }
    //删除并返回最大值
    public int heap_extract_max(int a[]){
        if(heap_size <0) {
            System.out.println("出错了，队列为空。。");
            return -1;
        }
        int max = a[0];
        a[0] = a[heap_size-1];
        heap_size = heap_size-1;
        max_heapify(a,0);
        System.out.println("删除并返回的最大值是： "+max);
        return max;
    }
    //增加一个元素的值
    public void heap_increase_key(int a[],int i,int key){
        if(key < a[i]){
            System.out.println("出错了，增加的值比原值小..");
            return;
        }

        a[i] = key;
        while (i>0 && a[parent(i)]<a[i]){
            //交换值
            int temp = a[i];
            a[i] = a[parent(i)];
            a[parent(i)] = temp;

            i = parent(i);
        }

    }
    //插入新值，是通过增加元素的值实现的
    public void heap_insert(int a[],int key){
        heap_size = heap_size+1;
        a[heap_size] = -100000;
        heap_increase_key(a,heap_size,key);
    }
}
