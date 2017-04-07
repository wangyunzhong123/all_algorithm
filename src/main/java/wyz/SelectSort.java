package wyz;

/**
 * Created by tianxi on 4/6/17.
 */
public class SelectSort {

    public static void main(String[] args){
        int[] a = new int[30];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(1+Math.random()*(100-1+1));//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
            System.out.printf(a[i]+"  ");
        }
        System.out.println();
        selection_sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.printf(a[i]+"  ");
        }

        System.out.println();
        System.out.println("=============topK============================");

        int[] b= new int[30];
        for (int i = 0; i < b.length; i++) {
            b[i] = (int)(1+Math.random()*(100-1+1));//(数据类型)(最小值+Math.random()*(最大值-最小值+1))
            System.out.printf(b[i]+"  ");
        }
        System.out.println();

        int k =10;
        selection_sort_topK(b,k);
        for (int i = 0; i < k; i++) {
            System.out.printf(b[i]+"  ");
        }
        System.out.println();
        selection_sort(b);
        for (int i = 0; i < b.length; i++) {
            System.out.printf(b[i]+"  ");
        }
    }

    static void selection_sort(int[] unsorted)
    {
        for (int i = 0; i < unsorted.length; i++)
        {
            int min = unsorted[i], min_index = i;
            for (int j = i; j < unsorted.length; j++)
            {
                if (unsorted[j] < min)
                {
                    min = unsorted[j];
                    min_index = j;
                }
            }
            if (min_index != i)
            {
                int temp = unsorted[i];
                unsorted[i] = unsorted[min_index];
                unsorted[min_index] = temp;
            }
        }
    }


    //修改一下，用于查找数组最小的前k个数
    static void selection_sort_topK(int[] unsorted,int k)
    {
        for (int i = 0; i < k; i++)
        {
            int min = unsorted[i], min_index = i;
            for (int j = i; j < unsorted.length; j++)
            {
                if (unsorted[j] < min)
                {
                    min = unsorted[j];
                    min_index = j;
                }
            }
            if (min_index != i)
            {
                int temp = unsorted[i];
                unsorted[i] = unsorted[min_index];
                unsorted[min_index] = temp;
            }
        }
    }
}
