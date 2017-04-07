package wyz;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by tianxi on 4/7/17.
 */
public class TopologicalSort_DFS {

    private static boolean[] visited;
    private static char[] vexs ;
    private static int[][] edges;

    private static List result = new ArrayList();
    private static Stack<Integer> reversePost = new Stack<Integer>();
    public static void main(String[] args){
        vexs = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        edges = new int[][]{
                {0,0,0,0,0,0,1},
                {1,0,0,1,0,0,0},
                {0,0,0,0,0,1,1},
                {0,0,0,0,1,1,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}};

        /*
        * 下面这些求入度以及度为0的节点集合，是不需要的，直接用DFS再加一个栈就可以达到目的
        * */

//        //统计每个节点的入度
//        int[] ins = new int[vexs.length];
//        for (int i = 0; i < ins.length; i++) {
//            ins[i] = 0;
//        }
//        for (int i = 0; i < ins.length; i++) {
//            for (int j = 0; j < ins.length; j++) {
//                if(edges[i][j]==1){//存在边
//                    ins[j]++;
//                }
//            }
//        }
//        List<Integer> node = new ArrayList<Integer>();//入度为0的列表
//        for (int i = 0; i < ins.length; i++) {
////            System.out.printf(ins[i]+"  ");
//            if(ins[i] == 0)
//                node.add(i);
//        }

        visited = new boolean[vexs.length];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < vexs.length; i++) {
            if(!visited[i])
                visit(i);
        }
        print();//出栈操作
    }

    public static void visit(int v){
        visited[v] = true;

        for (int i=0;i<vexs.length;i++)
        {
            if (edges[v][i]==1 && !visited[i])
            {
                visit(i);
            }
        }

        // 在即将退出dfs方法的时候，将当前顶点添加到结果集中
        reversePost.push(v);
    }
    public static void print(){
        while(!reversePost.isEmpty()){
            int temp=reversePost.peek();
            reversePost.pop();
            System.out.printf(vexs[temp]+"  ");
        }
    }

}

