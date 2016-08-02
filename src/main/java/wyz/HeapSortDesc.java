package wyz;

/**
 * Created by tianxi on 8/1/16.
 */

/*
*排序的结果是递减的
* 实现最小优先队列
 *  */
public class HeapSortDesc {

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
        int least;

        if(l < heap_size && a[l]<a[i])
            least =l;
        else least=i;

        if(r<heap_size && a[r] <a[least])
            least =r;

        if(least !=i){
            //交换
            int temp = a[i];
            a[i] = a[least];
            a[least] =temp;

            max_heapify(a,least);
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
    public int heap_min(int a[]){
        System.out.println("返回的最小值是： "+a[0]);
        return a[0];
    }
    //删除并返回最大值
    public int heap_extract_min(int a[]){
        if(heap_size <0) {
            System.out.println("出错了，队列为空。。");
            return -1;
        }
        int max = a[0];
        a[0] = a[heap_size-1];
        heap_size = heap_size-1;
        max_heapify(a,0);
        System.out.println("删除并返回的最小值是： "+max);
        return max;
    }
    //减小一个元素的值
    public void heap_decrease_key(int a[],int i,int key){
        if(key > a[i]){
            System.out.println("出错了，减小的值比原值大..");
            return;
        }

        a[i] = key;
        while (i>0 && a[parent(i)]>a[i]){
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
        heap_decrease_key(a,heap_size,key);
    }

}
