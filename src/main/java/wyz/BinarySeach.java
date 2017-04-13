package wyz;

/**
 * Created by tianxi on 4/13/17.
 */
public class BinarySeach {

    /*
        bin_search 二分查找元素x的下标，如无 return -1
        low,high 分别为待查元素的区间的 上下界(包含边界).
        x为待查元素.
        注意 low <= high
    */
    public static int bin_search_1(int a[], int low, int high, int x)
    {
        if(null == a || low > high)
            return -1;

        int mid;
        while(low<=high)//注意是<=，若是<会找不到边界值情况
        {
            mid = low + ((high-low)>>1);
            if(x<a[mid])
                high = mid-1;
            else if(x>a[mid])
                low = mid +1;
            else
                return mid;
        }
        return -1;
    }

    /*
    * 对于问题2，二分查找返回x(可能有重复)第一次出现的下标，如无return  -1。
    我们只需找到x重复出现情况下的第一次出现的下标。则我们只需用a[mid]和元素x进行比较，当a[mid]<x时
    此时待查元素肯定在待查区间的右半部分 显然此时 不包括 mid 所以有 low = mid+1, 若a[mid]>=x时, 因为我
    们查找的是x第一次出现的位置,我们不关心x最后出现的位置,所以此时high下标为mid,直到 low == high 终止
    循环，并且比较a[low]是否为x,若是则 找到。
    总的思路是：
    把有序序列分成2个序列:[first,mid][mid+1,last) 当 a[mid]<x 时 使用 使用序列[mid + 1,last)
    当 a[mid]>=x 时 使用序列[first,mid]。
    * */
    /*
        binS_first二分查找返回x(可能有重复)第一次出现的下标，如无return -1
        low,high 分别为待查元素的区间的 上下界(包含边界).
        //分成2个序列:[first,mid][mid+1,last)
          x为待查元素.注意 循环结束条件，low == high
    */
    public static int binS_first(int a[], int low, int high, int x)
    {
        if(null == a || low > high)return -1;
        int mid;
        while(low<high)
        {
            mid=low+((high-low)>>1);//计算中点
            if(a[mid]<x)// <x ,调整起点或者终点
                low=mid+1;
            else // >=x
                high=mid;
        }
        if(a[low] == x)
            return low;
        return -1;
    }

    /*
    * 对于问题3，二分查找返回x(可能有重复)最后一次出现的下标，如无return  -1
    其实和问题2的思路差不多。
    只是在 while中我们假定 low+1 < high,否则在只有两个或者一个元素时 我们只需在while循环之外判断即可。
    接下来的while 情况和问题2等价。我们现在关心的是 x(可能有重复)最后一次出现的下标，所以现在我们不关心他
    第一次出现下标的位置, 当 a[mid]<=x 时 low = mid, 否则 a[mid] >x 此时 high = mid -1. 代码如下：
    * */
    /*
    binS_last二分查找返回x(可能有重复)最后一次出现的下标,如无return -1
    low,high 分别为待查元素的区间的 上下界(包含边界).
    x为待查元素.
    注意 循环结束条件，low+1 == high
    */
    public static int binS_last(int a[], int low, int high, int x)
    {
        if(null == a || low > high)
            return -1;
        int mid;
        while(low+1<high)//**
        {
            mid=low+((high-low)>>1);
            if(a[mid]<=x)  // <=x
                low = mid;
            else  // >x
                high=mid-1;
        }
        if(a[high] == x)//先判断high
            return high;
        else if(a[low] == x)
            return low;
        return -1;
    }

    /*
    * 在轮转后的有序数组上应用二分查找法
    之前我们说过二分法是要应用在有序的数组上，如果是无序的，那么比较和二分就没有意义了。
    不过还有一种特殊的数组上也同样可以应用，那就是“轮转后的有序数组（Rotated Sorted Array）”。
    它是有序数组，取期中某一个数为轴，将其之前的所有数都轮转到数组的末尾所得。
    比如{7, 11, 13, 17, 2, 3, 5}就是一个轮转后的有序数组。非严格意义上讲，有序数组也属于轮转后的有序数组——我们取首元素作为轴进行轮转。
    下边就是二分查找法在轮转后的有序数组上的实现（假设数组中不存在相同的元素）
    * */
    public static int SearchInRotatedSortedArray(int array[], int low, int high, int target)
    {
        while(low <= high)
        {
            int mid = (low + high) / 2;
            if (target < array[mid])
                if (array[mid] < array[high])//the higher part is sorted
                    high = mid - 1; //the target would only be in lower part
                else //the lower part is sorted
                    if(target < array[low])//the target is less than all elements in low part
                        low = mid + 1;
                    else
                        high = mid - 1;

            else if(array[mid] < target)
                if (array[low] < array[mid])// the lower part is sorted
                    low = mid + 1; //the target would only be in higher part
                else //the higher part is sorted
                    if (array[high] < target)//the target is larger than all elements in higher part
                        high = mid - 1;
                    else
                        low = mid + 1;
            else //if(array[mid] == target)
                return mid;
        }

        return -1;
    }


    public static void main(String[] args){
        int[] a = {1,2,3,3,3,3,3,3,4,5,6,7,8,9};

        System.out.println(bin_search_1(a,0,a.length-1,3));
        System.out.println(binS_first(a,0,a.length-1,3));
        System.out.println(binS_last(a,0,a.length-1,3));

        int[] b = {8,9,10,11,12,0,1,2,3,4,5,6,7};
        System.out.println(SearchInRotatedSortedArray(b,0,b.length-1,12));
    }
}
