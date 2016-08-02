package wyz;

/**
 * Created by tianxi on 8/1/16.
 */

/*
* 最先生成树，Kruskal实现.贪心策略，从小到大遍历所有的表，不构成环路的边加入生成树里面
* 无向，权重非负
*kruskal算法的基本思想：
1.首先将G的n个顶点看成n个孤立的连通分支（n个孤立点）并将所有的边按权从小大排序。
2.按照边权值递增顺序，如果加入边后存在圈则这条边不加，直到形成连通图
对2的解释：如果加入边的两个端点位于不同的连通支，那么这条边可以顺利加入而不会形成圈

* 无向联通带权图
* */
import java.util.ArrayList;
import java.util.Scanner;
/*
 * 最小生成树kruskal算法：首先将每个顶点作为一棵森林，升序比较该顶点的邻接边，
 * 每次取最小权值的邻接边，将该邻接边连接的顶点与原先顶点构成一棵树，接着寻找
 * 下一个顶点，继续按照邻接边权值升序进行比较，取权值最小的构成树...
 *
 * 该类用一个Edge类构成一个邻接边的信息，包括邻接边的起始顶点与结束顶点，权值。
 * 用类Edge创建对象，录入对象信息，按照对象的权值进行比较，符合条件的对象加入
 * 到链表中，最终按照链表顺序输出最小生成树。
 */
public class MSTKruskal {
    /**
     * @author 刘雁冰
     * @date 2015-02-13 20:23
     */

 /*
  * Max:定义顶点数组的最大值
  * edge:链表edge，存储构造的Edge对象
  * target:链表trget,存储最终得到结果的Edge对象
  * parent:存储顶点信息的数组
  * n:顶点数
  */
    int Max=100;
    ArrayList<Edge>edge=new ArrayList<Edge>();
    ArrayList<Edge>target=new ArrayList<Edge>();
    int[] parent=new int[Max];
    Float TheMax=Float.MAX_VALUE;
    int n;

    public void init(){
        /**
         * p:起始顶点
         * q:结束顶点
         * w:边的权值
         * n:顶点个数
         */
        Scanner scan =new Scanner(System.in);
        int p,q;
        double w;
        System.out.println("请输入结点的个数:");
        n=scan.nextInt();
        System.out.println("按照'A B C'的格式输入边与边的信息,ABC分别代表边的起始顶点，结束顶点，权值(输入-1 -1 -1结束输入):");
        while(true){
            p=scan.nextInt();
            q=scan.nextInt();
            w=scan.nextDouble();
            if(p<0||q<0||w<0)break;
            Edge e=new Edge();
            e.start=p;
            e.end=q;
            e.weight=w;
            edge.add(e);
        }
        for(int i=1;i<=n;++i){          //初始化边的信息数组
            parent[i]=i;
        }
    }

    /*
     * 对象合并，将上一对象的结束边作为下一对象的起始边
     */
    public void union(int j,int k){
        for(int i=1;i<=n;++i){
            if(parent[i]==k)
                parent[i]=j;//注意理解该算法的巧妙之处。更新每棵树有相同的标志，利于105行的jj==kk的判断是否该边构成了环。
        }
    }

    public void kruskal(){
        int i=0;                 //顶点
        while(i<n-1&&edge.size()>0){       //如果只有一条边或者没有边跳出
            double min=Double.MAX_VALUE;
            Edge temp=null;
            for(int j=0;j<edge.size();++j){      //遍历图形
                Edge tt=edge.get(j);
                if(tt.weight<min){           //若两个顶点有权值，即相连
                    min=tt.weight;
                    temp=tt;
                }
            }

            //构造一棵树
            int jj=parent[temp.start];
            int kk=parent[temp.end];


            if(jj!=kk){
                ++i;                 //以end作为下一条边的start,寻找下一条边
                target.add(temp);           //将找到的边放入目标集合中
                union(jj,kk);
            }
            edge.remove(temp);           //将临时边删除
        }
        System.out.println("最小生成树的路径是:");
        for(int k=0;k<target.size();++k){     //输出最小生成树
            Edge e=target.get(k);
            System.out.println(e.start+"-->"+e.end);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MSTKruskal kr=new  MSTKruskal();
        kr.init();
        kr.kruskal();
    }
}
/*
 * start:起始顶点
 * end:结束顶点
 * weight:权值
 */
class Edge{
    public int start;
    public int end;
    public double weight;
}
