package wyz;

import java.util.Stack;

/**
 * Created by yzwang on 2017/9/24.
 */
public class BTreeInOrderNoRecursion {

    static class Node{

        public int value;
        public Node left;
        public Node right;

        public int flag = 0;//1,访问一次后设为1，用作后序访问

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {


        Node node_1 = new Node(1,null,null);
        Node node_3 = new Node(3,null,null);

        Node node_5 = new Node(5,null,null);
        Node node_7 = new Node(7,null,null);

        Node node_2 = new Node(2,node_1,node_3);

        Node node_6 = new Node(6,node_5,node_7);

        Node root = new Node(4,node_2,node_6);

        InOrderNotRecursion(root);

        System.out.println("---------------------前序遍历-------------------");
        preOrderNotRecursion(root);

        System.out.println("---------------------后序遍历-------------------");
        afterOrderNotRecursion(root);

    }


    /**
     * 用非递归的方式中序遍历二叉树。面试的时候没整出来，基本算法能力真的很差，锻炼一下
     *
     */

    public static void InOrderNotRecursion(Node root){

        Stack<Node> st = new Stack();

        if(root !=null){

            st.push(root);

            Node temp = root.left;
            while(temp != null){
                st.push(temp);
                temp = temp.left;
            }
        }

        while(!st.empty()){
            Node temp = st.peek();

            System.out.println(temp.value);
            st.pop();

            if(temp.right == null){//没有右子树


            }else {
                st.push(temp.right);
                Node t1 = temp.right.left;
                while (t1 !=null){
                    st.push(t1);
                    t1 = t1.left;
                }

            }
        }
    }

    /**
     * 前序遍历非递归
     * @param root
     */
    public static void preOrderNotRecursion(Node root){

        Stack<Node> st = new Stack<Node>();

        if(root != null)
            st.push(root);

        while(!st.empty()){
            Node temp = st.peek();
            System.out.println(temp.value);
            st.pop();

            if(temp.right != null)
                st.push(temp.right);

            if(temp.left !=null)
                st.push(temp.left);
        }
    }

    /**
     * 后序遍历，非递归
     * @param root
     */
    public static void afterOrderNotRecursion(Node root){

        Stack<Node> st = new Stack();

        if(root !=null){

            st.push(root);

            Node temp = root.left;
            while(temp != null){
                st.push(temp);
                temp = temp.left;
            }
        }

        while(!st.empty()){

            Node temp = st.peek();
            if(temp.right ==null){
                System.out.println(temp.value);
                st.pop();
            }else {//有右孩子
                if(temp.flag ==0){
                    temp.flag =1;
                    Node t1 = temp.right;
                    while (t1 != null) {
                        st.push(t1);
                        t1 = t1.left;
                    }
                }
                else {
                    System.out.println(temp.value);
                    st.pop();
                }

            }
        }
    }
}
