package FindWork;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 找工作
 * Created by yzwang on 2019/3/25.
 */
public class StringTest {

    public static void main(String[] args) {
        String a= "12";//final

        StringBuffer b = new StringBuffer();//线程安全的，用syc修饰方法。继承AbstractStringBuilder

        StringBuilder c = new StringBuilder();//线程不安全的

        LinkedList d = new LinkedList();

        Map<String,String> e = new Hashtable<>();


        Set dd = new HashSet();

        SortedMap f = new SortedMap() {
            @Override
            public Comparator comparator() {
                return null;
            }

            @Override
            public SortedMap subMap(Object fromKey, Object toKey) {
                return null;
            }

            @Override
            public SortedMap headMap(Object toKey) {
                return null;
            }

            @Override
            public SortedMap tailMap(Object fromKey) {
                return null;
            }

            @Override
            public Object firstKey() {
                return null;
            }

            @Override
            public Object lastKey() {
                return null;
            }

            @Override
            public Set keySet() {
                return null;
            }

            @Override
            public Collection values() {
                return null;
            }

            @Override
            public Set<Entry> entrySet() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Object get(Object key) {
                return null;
            }

            @Override
            public Object put(Object key, Object value) {
                return null;
            }

            @Override
            public Object remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map m) {

            }

            @Override
            public void clear() {

            }
        };

        TreeMap<String ,String> g = new TreeMap<>();

        ConcurrentHashMap h = new ConcurrentHashMap();

        Hashtable i = new Hashtable();




    }
}
