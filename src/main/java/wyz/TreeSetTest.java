package wyz;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by tianxi on 4/13/17.
 */
public class TreeSetTest {

    public static void main(String[] args){

    /*
    * (01) TreeSet是有序的Set集合，因此支持add、remove、get等方法。
    (02) 和NavigableSet一样，TreeSet的导航方法大致可以区分为两类，一类时提供元素项的导航方法，返回某个元素；另一类时提供集合的导航方法，返回某个集合。
    lower、floor、ceiling 和 higher 分别返回小于、小于等于、大于等于、大于给定元素的元素，如果不存在这样的元素，则返回 null。
    * */


        TreeSet set = new TreeSet();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("eee");
        set.add("ddd");
        set.add("ccc");


        // 顺序遍历TreeSet
        ascIteratorThroughIterator(set) ;
        // 逆序遍历TreeSet
        descIteratorThroughIterator(set);
        // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
        foreachTreeSet(set);


        testTreeSetAPIs();


    }

    // 顺序遍历TreeSet
    public static void ascIteratorThroughIterator(TreeSet set) {
        System.out.print("\n ---- Ascend Iterator ----\n");
        for(Iterator iter = set.iterator(); iter.hasNext(); ) {
            System.out.printf("asc : %s\n", iter.next());
        }
    }

    // 逆序遍历TreeSet
    public static void descIteratorThroughIterator(TreeSet set) {
        System.out.printf("\n ---- Descend Iterator ----\n");
        for(Iterator iter = set.descendingIterator(); iter.hasNext(); )
            System.out.printf("desc : %s\n", (String)iter.next());
    }

    // 通过for-each遍历TreeSet。不推荐！此方法需要先将Set转换为数组
    private static void foreachTreeSet(TreeSet set) {
        System.out.printf("\n ---- For-each ----\n");
        String[] arr = (String[])set.toArray(new String[0]);
        for (String str:arr)
            System.out.printf("for each : %s\n", str);
    }

    // 测试TreeSet的api
    public static void testTreeSetAPIs() {
        String val;

        // 新建TreeSet
        TreeSet tSet = new TreeSet();
        // 将元素添加到TreeSet中
        tSet.add("aaa");
        // Set中不允许重复元素，所以只会保存一个“aaa”
        tSet.add("aaa");
        tSet.add("bbb");
        tSet.add("eee");
        tSet.add("ddd");
        tSet.add("ccc");
        System.out.println("TreeSet:"+tSet);

        // 打印TreeSet的实际大小
        System.out.printf("size : %d\n", tSet.size());

        // 导航方法
        // floor(小于、等于)
        System.out.printf("floor bbb: %s\n", tSet.floor("bbb"));
        // lower(小于)
        System.out.printf("lower bbb: %s\n", tSet.lower("bbb"));
        // ceiling(大于、等于)
        System.out.printf("ceiling bbb: %s\n", tSet.ceiling("bbb"));
        System.out.printf("ceiling eee: %s\n", tSet.ceiling("eee"));
        // ceiling(大于)
        System.out.printf("higher bbb: %s\n", tSet.higher("bbb"));
        // subSet()
        System.out.printf("subSet(aaa, true, ccc, true): %s\n", tSet.subSet("aaa", true, "ccc", true));
        System.out.printf("subSet(aaa, true, ccc, false): %s\n", tSet.subSet("aaa", true, "ccc", false));
        System.out.printf("subSet(aaa, false, ccc, true): %s\n", tSet.subSet("aaa", false, "ccc", true));
        System.out.printf("subSet(aaa, false, ccc, false): %s\n", tSet.subSet("aaa", false, "ccc", false));
        // headSet()
        System.out.printf("headSet(ccc, true): %s\n", tSet.headSet("ccc", true));
        System.out.printf("headSet(ccc, false): %s\n", tSet.headSet("ccc", false));
        // tailSet()
        System.out.printf("tailSet(ccc, true): %s\n", tSet.tailSet("ccc", true));
        System.out.printf("tailSet(ccc, false): %s\n", tSet.tailSet("ccc", false));


        // 删除“ccc”
        tSet.remove("ccc");
        // 将Set转换为数组
        String[] arr = (String[])tSet.toArray(new String[0]);
        for (String str:arr)
            System.out.printf("for each : %s\n", str);

        // 打印TreeSet
        System.out.printf("TreeSet:%s\n", tSet);

        // 遍历TreeSet
        for(Iterator iter = tSet.iterator(); iter.hasNext(); ) {
            System.out.printf("iter : %s\n", iter.next());
        }

        // 删除并返回第一个元素
        val = (String)tSet.pollFirst();
        System.out.printf("pollFirst=%s, set=%s\n", val, tSet);

        // 删除并返回最后一个元素
        val = (String)tSet.pollLast();
        System.out.printf("pollLast=%s, set=%s\n", val, tSet);

        // 清空HashSet
        tSet.clear();

        // 输出HashSet是否为空
        System.out.printf("%s\n", tSet.isEmpty()?"set is empty":"set is not empty");
    }



}
