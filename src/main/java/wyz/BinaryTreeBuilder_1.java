package wyz;

/**
 * Created by tianxi on 4/10/17.
 */
class TreeNode {
    TreeNode left = null;
    TreeNode right = null;
    int value;
    public TreeNode(int a){
        value =a;
        left=null;
        right=null;
    }
}
public class BinaryTreeBuilder_1 {


    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}    
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {
        if(startPre>endPre||startIn>endIn)
            return null;

        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
            }

        return root;
    }

    //后序遍历,用递归
    public static void AfterVisit(TreeNode root){
        if(root !=null){
            AfterVisit(root.left);
            AfterVisit(root.right);
            System.out.printf(root.value+"  ");
        }
    }

    public static void main(String[] args){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstructBinaryTree(pre,in);
        AfterVisit(root);
    }
}
