package wyz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianxi on 8/2/16.
 */

/*
* 斐波那契堆，抽取和删除操作时间复杂度是lgn，其余均为常数时间
* 用在这两个操作相比其他操作较少的场景下。但算法编程过于复杂，导致其更多的是作为研究
* */

    /*
    此版本有问题，有错误，还没调通
    * */
public class FibonHeap<T extends Comparable<T>> {

    private int keyNum;

    private FibonNode<T> min;

    /*
     * 保存当前指针
     */
    private FibonNode<T> current;

    /*
     * 保存各个度对应的节点,如度为1的节点对应的节点
     */
    private Map<Integer, FibonNode<T>> degreeNodes;

    public FibonHeap(T key) {
        min = new FibonNode<T>(key);
        keyNum += 1;
        min.left = min;
        min.right = min;
    }

    /*
    * 返回最小值
    * */
    public T MiniMun(){
        System.out.println("最小值是： "+min.key);
        return min.key;
    }
    /*
     * 插入值
     */
    public void insert(T key) {
        FibonNode<T> node = new FibonNode<T>(key);
        insert(node);
    }


    /*
     * 删除最小值
     */
    public void deleteMin() {
        degreeNodes = new HashMap<Integer, FibonNode<T>>();
        removeMinNode();
        consolidate();

    }

    /*
     * 删除节点
     */
    public void deleteNode(FibonNode<T> node){
        T everSmall = min.key;
        decrease(node, everSmall);
        deleteMin();
    }

    /*
     * 合并堆
     */
    public FibonHeap<T> union(FibonHeap<T> heapA, FibonHeap<T> heapB){
        FibonNode<T> minA = heapA.min;
        FibonNode<T> minB = heapB.min;
        minA.right = minB;
        minA.right.left = minB.right;
        minB.left = minA;
        minB.right.left = minA.right;
        FibonNode<T> min = minA;
        if(minB.key.compareTo(min.key) < 0){
            min = minB;
        }
        heapA.min = min;
        heapA.keyNum += heapB.keyNum;
        return heapA;
    }

    private void insert(FibonNode<T> node) {
        //插入就是直接更新左右节点就可以了
        min.left.right = node;
        node.left = min.left;
        node.right = min;
        min.left = node;
        T minKey = min.key;
        if (node.key.compareTo(minKey) < 0) {
            min = node;
        }
        keyNum += 1;
    }

    /*
     * 把最小节点从堆中删除
     */
    private void removeMinNode() {
        if(min == null)
            return;
        FibonNode<T> left = min.left;
        if (left == min) {
            //说明只剩最后一个节点了，也就是最小节点自己
            if (min.child != null) {
                FibonNode<T> temp =min.child;
//                while()
//                min = min.child;//这里不是null，应该是孩子节点中最小节点，笔者没有写完而已,埋下错误隐患;
                // 先随意选个节点作为最小节点，在随后环节会更新的
                addChToR(min);
                min = min.child;
            }else
                min =null;
            //将min每一个儿子和儿子的兄弟加入根链表中
//            while(min.child != null){
//                FibonNode<T> child = min.child;
//
//            }
        } else {
            deleteInList(min);
            addChToR(min);
            min = left;    //    先随意选个节点作为最小节点，在随后环节会更新的
        }
        keyNum--;
    }


    /*
     * 把根节点合并使其所有节点的度不相等
     */
    private void consolidate() {
        current = min;
        do {
            current = putDegreeNodes(current);
            if (current.key.compareTo(min.key) < 0) {
                min = current;
            }
            current = current.right;
        } while (current != min && current.left != current);
    }

    /*
     *
     */
    private FibonNode<T> putDegreeNodes(FibonNode<T> node) {
        int nodeDegree = node.degree;
        //从map中找节点对应的度是否存在，存在说明有相同度的节点了，需要合并
        FibonNode<T> nodeInMap = degreeNodes.get(nodeDegree);
        if (nodeInMap == null) {
            degreeNodes.put(nodeDegree, node);
        } else {
            if (node.key.compareTo(nodeInMap.key) < 0) {
                deleteInList(nodeInMap);
                nodeInMap.left = nodeInMap;
                nodeInMap.right = nodeInMap;
                node = fibLink(node, nodeInMap);
                nodeInMap = node;
            } else {
                deleteInList(node);
                node.left = node;
                node.right = node;
                nodeInMap = fibLink(nodeInMap, node);

                node = nodeInMap;
            }
            degreeNodes.put(nodeDegree, null);
            node = putDegreeNodes(node);
        }
        return node;
    }

    /*
    * 合并，后者为前者的孩子节点
    * */
    private FibonNode<T> fibLink(FibonNode<T> parent, FibonNode<T> child) {
        if (parent.child == null) {
            parent.child = child;

        } else {
            parent.child = insertCyle(parent.child, child);
        }
        child.parent = parent;
        parent.degree += 1;
        return parent;
    }

    /*
     * 从所在链中删除
     */
    private void deleteInList(FibonNode<T> node) {
        FibonNode<T> left = node.left;
        FibonNode<T> right = node.right;
        left.right = right;
        right.left = left;
    }

    /*
     * 插入到链中，将后者作为前者的兄弟
     */
    private FibonNode<T> insertCyle(FibonNode<T> target, FibonNode<T> node) {
        FibonNode<T> left = target.left;
        left.right = node;
        node.left = target;
        node.right = target;
        target.left = node;
        return target;
    }

    /*
     * 把孩子节点添加到根链表中
     */
    private void addChToR(FibonNode<T> node) {
        FibonNode<T> aChild = node.child;
        if (aChild == null) {
            return;
        }
        do {
            //孩子节点循环插入根
            FibonNode<T> right = aChild.right;
            min.right = insertCyle(min.right, aChild);
            aChild = right;

        } while (aChild != node.child);
    }

    /*
    * 减小key
    * */
    public void decrease(FibonNode<T> target, T key){
        FibonNode<T> parent = target.parent;
        if(target.key.compareTo(key) < 0){//是 < ,表示要减小元素的原值要大于等于新值才能继续下面的操作
            System.out.println("只能减少key值");
            return;
        }
        if(parent == null){
            //如果修改节点是根节点，直接修改
            target.key = key;
            if(key.compareTo(min.key) <= 0){
                //更新最小节点
                min = target;
            }
            return;
        }
        if(parent.key.compareTo(key) < 0){
            //如果值修改稿后不违反最小堆，直接修改即可
            target.key = key;
            return;
        }
        cutAndMeld(target);
        parent = cascadingCut(parent);
    }

    /*
     * 删除节点，并合并到根中
     */
    private void cutAndMeld(FibonNode<T> target){
        target.parent = null;
        target.mark = false;
        insert(target);
    }

    /*
     * 级联删除，使其符合斐波那契堆性质
     */
    private FibonNode<T> cascadingCut(FibonNode<T> parent){
        if(null == parent){
            return null;
        }
        parent.degree--;
        if(parent.mark == false){
            parent.mark = true;
        }else{
            cutAndMeld(parent);
            parent = cascadingCut(parent);
        }
        return parent;
    }
}
class FibonNode<T extends Comparable<T>> {

    public T key;

    public FibonNode<T> child;

    public FibonNode<T> left;

    public FibonNode<T> right;

    public boolean mark;

    public FibonNode<T> parent;

    public int degree;

    public FibonNode(T key){
        this.degree = 0;
        this.key = key;
        this.parent = null;
        this.child = null;
        this.left = null;
        this.right = null;
        this.mark = false;
    }
}
