package wyz;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by tianxi on 4/10/17.
 */

/*
* 重建二叉树
* */
class Node {
    Node left = null;
    Node right = null;
    char value;
}
public class BinaryTreeBuilder {
    /**
     * 根据前序遍历和中序遍历重建二叉树子树
     * @param preOrder 前序遍历数组
     * @param start 子树起始位置
     * @param inOrder 中序遍历数组
     * @param end 中序遍历结束位置
     * @param length 子树节点树
     * @return 子树的根节点
     */
    public static Node buildTree(char[] preOrder, int start,
                                           char[] inOrder, int end, int length) {
        //参数验证
        if (preOrder == null || preOrder.length == 0 || inOrder == null
                || inOrder.length == 0 || length <= 0) {
            return null;
        }

        //建立子树根节点
        char value = preOrder[start];
         Node root = new Node();
        root.value = value;

        //递归终止条件：子树只有一个节点
        if (length == 1)
            return root;

        //分拆子树的左子树和右子树，找出中序遍历以根为分割的点i
        int i = 0;
        while (i < length) {
            if (value == inOrder[end - i]) {
                break;
            }
            i++;
        }

        //建立子树的左子树
        root.left = buildTree(preOrder, start + 1, inOrder, end - i - 1, length - 1 - i);
        //建立子树的右子树
        root.right = buildTree(preOrder, start + length - i, inOrder, end, i );

        return root;
    }

    //先序遍历,用递归
    public static void PreVisit(Node root){
        if(root !=null){
            System.out.printf(root.value+"  ");
            PreVisit(root.left);
            PreVisit(root.right);
        }
    }
    //中序遍历,用递归
    public static void InVisit(Node root){
        if(root !=null){
            InVisit(root.left);
            System.out.printf(root.value+"  ");
            InVisit(root.right);
        }
    }
    //后序遍历,用递归
    public static void AfterVisit(Node root){
        if(root !=null){
            AfterVisit(root.left);
            AfterVisit(root.right);
            System.out.printf(root.value+"  ");
        }
    }

    //非递归实现先序遍历
    /*
    * 1. 将二叉树根节点作为当前节点
    * 2. 若当前节点非空，则先访问该节点，并将该节点进栈，再将其左孩子作为当前节点，重复2，直到当前节点为空
    * 3. 若栈非空，则栈顶节点出栈，并将当前节点的右孩子作为当前节点
    * 4. 重复2,3，直到栈为空且当前节点为空为止
    * */
    public static void PreVisit_Stack(Node root){
        Stack<Node> stack = new Stack<Node>();

        Node p = root;
        while(p != null || !stack.empty()){
            while(p!=null){
                System.out.printf(p.value+"  ");
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                p = p.right;
            }
        }
    }

    //非递归中序遍历
    /*
    * 1. 将二叉树根节点作为当前节点
    * 2. 若当前节点非空，则该节点进栈并将其左孩子作为当前节点，重复2.直到当前节点为空
    * 3. 若栈非空，则将栈顶节点出栈并作为当前节点，接着访问当前节点，再将当前节点的右孩子作为当前节点
    * 4. 重复2,3，直到栈为空且当前节点为空为止
    * */
    public static void InVisit_Stack(Node root){
        Stack<Node> stack = new Stack<Node>();

        Node p = root;
        while(p != null || !stack.empty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                System.out.printf(p.value+"  ");
                p = p.right;
            }
        }
    }

    //非递归后序遍历
    /*
    * 直接用栈的方式写比较困难，为啥？？？？
    * */

    //求二叉树深度
    public static int getTreeDepth(Node root){
        if (root == null)
            return 0;
        else {
            int left = getTreeDepth(root.left);
            int right = getTreeDepth(root.right);
            return 1 + Math.max(left, right);
        }
    }
    // 获取最大宽度
    /*
    * 使用队列，层次遍历二叉树。在上一层遍历完成后，下一层的所有节点已经放到队列中，
    * 此时队列中的元素个数就是下一层的宽度。以此类推，依次遍历下一层即可求出二叉树的最大宽度。
    * */
    public static int getMaxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }

    //判断两棵二叉树是否相同
    /*
    * 包括左右子树相等或者左右互换
    * */
    public static boolean compareTree_1(Node root1, Node root2){
        if(root1==null && root2==null)
            return true;

        if((root1!=null &&root2==null) || (root1!=null && root2==null))
            return false;

        if(root1!=null && root2!=null){
            if(root1.value == root2.value){
                if(compareTree_1(root1.left,root2.left))
                    return compareTree_1(root1.right,root2.right);
                else if(compareTree_1(root1.right,root2.left))//如果左右孩子互换也不算做相等的话就把这个else if注释掉即可
                    return compareTree_1(root1.left,root2.right);
            }
        }

        return false;
    }
    public static void main(String[] args) {
        char[] preOrder = new char[] {'a', 'b', 'd', 'c', 'e', 'f'};
        char[] inOrder = new char[] {'d', 'b', 'a', 'e', 'c', 'f'};
        Node root = buildTree(preOrder, 0, inOrder, inOrder.length - 1, inOrder.length);

        char[] preOrder1 = new char[] {'a', 'b', 'd', 'c', 'f', 'e'};
        char[] inOrder1 = new char[] {'d', 'b', 'a', 'f', 'c', 'e'};
        Node root1 = buildTree(preOrder1, 0, inOrder1, inOrder1.length - 1, inOrder1.length);
        System.out.println("两棵树是否相同："+compareTree_1(root1,root));

        System.out.println("====================递归方式三种遍历=======================");

        PreVisit(root);
        System.out.println();

        InVisit(root);
        System.out.println();

        AfterVisit(root);
        System.out.println();

        System.out.println("====================非递归方式三种遍历=======================");
        //非递归方式先序遍历
        PreVisit_Stack(root);
        System.out.println();

        InVisit_Stack(root);
        System.out.println();

        System.out.println("二叉树深度为："+getTreeDepth(root));
        System.out.println("二叉树宽度为："+getMaxWidth(root));

    }
}
