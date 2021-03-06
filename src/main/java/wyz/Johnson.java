package wyz;

/**
 * Created by tianxi on 8/4/16.
 */

/*
* 用于系数图额johnson算法，对于稀疏图来说，该算法要优于重复平方法和Floyd算法
*
* */
import java.util.*;
public class Johnson{
    static final int MAX = 20;  //最大点数
    static int[][] g;
    static int[] h = new int[MAX];
    //	static LinkedList<Elem> S = new LinkedList<Elem>();
    static PriorityQueue<Elem> Q = new PriorityQueue<Elem>(); //Q = V-S
    static ArrayList<Elem> nodes = new ArrayList<Elem>();
    static int[][] D;

    static int ver;  //节点数
    static int edge; //边数
    static final int BELLMAN_FORD = 1;
    static final int DIJKSTRA = 2;
    /************全局数据结构****************/
    static class Elem implements Comparable<Elem>
    {
        public int s; //节点编号
        public int d;  //与源节点距离
        public Elem(int s,int d){
            this.s = s;
            this.d = d;
        }
        public int compareTo(Elem e){return d - e.d;}
    }
    /***********以下是Johnson算法实现*******************/
    static void johnson(){

        int s = ver; //新添加一个节点
        int[][] g_new = new int[ver+1][ver+1];
        for(int u = 0;u < g_new.length;u++){
            for(int v = 0;v < g_new.length;v++){
                if(v == g.length){g_new[u][v] = Integer.MAX_VALUE;continue;}
                if(u == g.length){g_new[u][v] = 0; continue;}
                g_new[u][v] = g[u][v];
            }
        }

        if(bellman_ford(g_new,s) == false) {System.out.println("circle exist");return;}

        for(Elem e:nodes) h[e.s] = e.d;
        System.out.println("h[v]: from 0 to n");
        for(int i = 0;i<g.length;i++) System.out.print(h[i]+" "+'\t');
        System.out.println();
        for(int u = 0;u < ver;u++){
            for(int v = 0;v < ver;v++){
                if(g[u][v] == Integer.MAX_VALUE) continue;
                g[u][v] = g[u][v] + h[u]-h[v];
            }
        }
        System.out.println("G' :");
        initD(g);
        print(g);
        for(int u = 0;u < ver;u++){
            dijkstra(g,u);
            for(int v = 0;v < ver;v++){
                if(nodes.get(v).d == Integer.MAX_VALUE) continue;
                D[u][v] = nodes.get(v).d + h[v] - h[u];
            }
        }

        System.out.println("D[i][j]: shortest path from i to j");
        print(D);

    }

    /***初始化函数：可用于Bellman-Ford与Dijkstra的初始化*******/
    static void init(int[][] g,int source,int mode){
        nodes.clear();
        for(int i=0; i < g.length;i++){
            //初始S为空，Q为全部节点
            Elem e = new Elem(i,Integer.MAX_VALUE);
            nodes.add(e);
            if(i == source && mode == DIJKSTRA) Q.add(e);
        }
        nodes.get(source).d = 0;
    }
    static void initD(int[][] g){
        for(int i = 0;i < g.length;i++)
            for(int j = 0;j < g.length;j++){
                D[i][j] = g[i][j];
            }
    }
    /*********以下是Bellman-Ford实现***********/
    static boolean bellman_ford(int[][] g,int source){
        init(g,source,BELLMAN_FORD);
        int s=0,e=0,w=0;
        for(int i=0;i < g.length-1;i++){
            //对所有的边进行松弛操作
            for(int u = 0;u < g.length;u++){
                for(int v = 0;v < g.length;v++){
                    if(g[u][v] == Integer.MAX_VALUE||nodes.get(u).d == Integer.MAX_VALUE) continue;
                    nodes.get(v).d = Math.min(nodes.get(v).d, nodes.get(u).d + g[u][v]);
                }
            }
        }
        //遍历每条边
        for(int u = 0;u < g.length;u++){
            for(int v = 0;v < g.length;v++){
                if(g[u][v] == Integer.MAX_VALUE||nodes.get(u).d == Integer.MAX_VALUE) continue;
                if(nodes.get(v).d > nodes.get(u).d + g[u][v]) return false;
            }
        }
        return true;
    }
    /************以下是Dijkstra实现*************/

    static void dijkstra(int[][] g,int source){
        init(g,source,DIJKSTRA);
        while(Q.size() > 0){
            Elem u = Q.poll();
//		    S.add(u);
            for(int v = 0;v < g.length;v++){
                if(g[u.s][v] != Integer.MAX_VALUE && nodes.get(v).d > u.d + g[u.s][v]){
                    Elem nv = nodes.get(v);
                    //下面删除后添加是为了使PriorityQueue能够重新调整
                    Q.remove(nv);
                    nv.d = u.d + g[u.s][v];
                    Q.offer(nv);
                }
            }
        }
    }
    /**************用于获取输入数据，初始化图G的***************/
    static void input(){
        Scanner cin = new Scanner(System.in);
        System.out.println("请输入 点数 边数");
        ver = cin.nextInt();
        edge = cin.nextInt();
        g  = new int[ver][ver];
        D = new int[ver+1][ver+1];
        int s,e,w;
        for(int i = 0;i < ver;i++){
            for(int j = 0;j < ver;j++) {g[i][j] = Integer.MAX_VALUE;}
        }
        System.out.println("起点 终点 权值");
        for(int i=0;i<edge;i++){
            s = cin.nextInt();
            e = cin.nextInt();
            w = cin.nextInt();
            g[s][e] = w;
        }
    }
    /************打印前驱矩阵**************/
    static void print(int[][] g){
        for(int u = 0;u < ver;u++){
            for(int v = 0;v < ver;v++){
                if(g[u][v] == Integer.MAX_VALUE){System.out.print("inf\t"); continue;}
                System.out.print(g[u][v]+""+'\t');
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        input();
        johnson();
    }

}
