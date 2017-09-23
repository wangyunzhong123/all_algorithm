package Qunar;

import java.util.Scanner;

/**
 * Created by yzwang on 2017/9/20.
 */
public class Test_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rootValue = sc.nextInt();
        TreeNode root = new TreeNode(rootValue,null,null);

        sc.nextLine();
        while(sc.hasNext()){

            String line = sc.nextLine();
            int head = Integer.valueOf(line.split(":")[0]);
            String haha = line.split(":")[1];
            int a = Integer.valueOf(haha.split("\\|")[0]);
            int b = Integer.valueOf(haha.split("\\|")[1]);

            TreeNode node1 = searchRec(root,head);
            if(node1 == null){
                node1 = new TreeNode(head,null,null);
            }
            if(a != -1){
                TreeNode temp = searchRec(root,a);
                if(temp == null)
                    temp = new TreeNode(a,null,null);
                node1.left = temp;
            }

            if(b != -1){
                TreeNode temp = searchRec(root,b);
                if(temp == null)
                    temp = new TreeNode(b,null,null);
                node1.right = temp;
            }
        }

        boolean result = isBST(root);
        if(result)
            System.out.println(1);
        else
            System.out.println(0);

    }

    private static class TreeNode{

        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode a,TreeNode b){

            this.value = value;
            left = a;
            right = b;
        }
    }

    //找到指定value的节点，因为不确定是否是二叉查找树，所以改变下
    public static TreeNode searchRec(TreeNode root ,int val)
    {
        if(root == null)
            return root;
//        if(val<root.value)
//            return searchRec(root.left,val);
//        else if(val>root.value)
//            return searchRec(root.right,val);
//        else
//            return root;

        if(val != root.value){
            TreeNode haha = searchRec(root.left,val);
            if(haha == null)
                haha = searchRec(root.right,val);

            return haha;
        }else
            return root;
    }

    public static boolean isBST(TreeNode root)
    {
        int prev = Integer.MIN_VALUE;
        return isBST(root, prev);
    }

    /*该函数判断二叉树p是否是一棵二叉搜索树，且其结点值都大于prev*/
    public static boolean isBST(TreeNode p, int prev)
    {
        if (p == null) return true;
        if (isBST(p.left, prev)) { // 如果左子树是二叉搜索树，且结点值都大于prev
            if (p.value > prev) { //判断当前结点值是否大于prev，因为此时prev已经设置为已经中序遍历过的结点的最大值。
                prev = p.value;
                return isBST(p.right, prev); //若结点值大于prev，则设置prev为当前结点值，并判断右子树是否二叉搜索树且结点值都大于prev。
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }

}
