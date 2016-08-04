package wyz;

/**
 * Created by tianxi on 8/3/16.
 */

/*
* 单源最短路径。
* 解决一半情况下的单源最短路径，边的权重可以为负，有向。
* 如果存在负环，返回false，否则返回最短路径和权重。
* 可以解决查分约束系统
* */
import java.io.*;
import java.util.*;

public class BellmanFord  {

    LinkedList<Edge> edges;
    int distances[];
    //int path[];
    int numberOfVertices;
    int edge;
    int source;
    final static int INFINITY=999;

    //prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
    int prev[];
    private static class Edge  {
        int u,v,w;
        public Edge(int u, int v, int w)     {
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }

    BellmanFord () throws IOException {

        InputResult BellmanFordInput = readInput("BellmanFordinput.txt");

        source = BellmanFordInput.sourceVertex;
        numberOfVertices = BellmanFordInput.numberOfVertice;

        int[][] inputGraph = BellmanFordInput.adjacencyMatrix;
        edges = new LinkedList<Edge>();
        for(int i=0; i<numberOfVertices; i++) {
            for(int j =0; j< numberOfVertices; j++) {
                if(inputGraph[i][j] != 0)
                    edges.add(new Edge(i, j, inputGraph[i][j]));
            }
        }
        edge = edges.size();
        distances = new int[numberOfVertices];

        prev = new int[numberOfVertices];
        for(int i=0;i<numberOfVertices;i++)
            prev[i] = 0;
    }

    int[] relax() { //the relax operation
        int i, j;
        for(i=0;i<numberOfVertices;++i) {
            distances[i]=INFINITY;
        }
        distances[source] = 0;

        //前驱节点
        prev = new int[numberOfVertices];

        for (i = 0; i < numberOfVertices - 1; ++i) {
            for (j = 0; j < edge; ++j) {                             //calculate the shortest path
                if (distances[edges.get(j).u] + edges.get(j).w < distances[edges.get(j).v]) {
                    distances[edges.get(j).v] = distances[edges.get(j).u] + edges.get(j).w;
                    //更新前驱节点
                    prev[edges.get(j).v] = edges.get(j).u;
                }
            }
        }
        return prev;
    }

    boolean NoCycle() {
        int j;
        for (j = 0; j < edge; ++j)
            if (distances[edges.get(j).u] + edges.get(j).w < distances[edges.get(j).v])
                return false;
        return true;
    }



    /* The following method is going read the BellmanFordinput.txt as input and returns an object that contains
        1) total number of vertices, 2)  source vertex and 3) the adjacency matrix  */
    private static InputResult readInput(String txtfile) throws IOException{
//        String pathname=txtfile;
//        File filename=new File(pathname);
//        InputStreamReader reader = new InputStreamReader( new FileInputStream(filename));
//        BufferedReader br = new BufferedReader(reader);
//        StringBuffer buffer = new StringBuffer();
//        String line = br.readLine();
//        while(line!=null){
//            buffer.append(" "+line);
//            line = br.readLine();
//        }
//        String temp[]=buffer.toString().replaceFirst(" ", "").split("\\s+");
//        InputResult inputResult= new InputResult();
//        inputResult.numberOfVertice=Integer.parseInt(temp[0]);
//        inputResult.sourceVertex=Integer.parseInt(temp[1]);

        InputResult inputResult= new InputResult();
        inputResult.numberOfVertice=5;
        inputResult.sourceVertex=0;

        inputResult.adjacencyMatrix=new int[inputResult.numberOfVertice][inputResult.numberOfVertice];
        int a[][] = {
                {0,6,INFINITY,7,INFINITY},
                {INFINITY,0,5,8,-4},
                {INFINITY,-2,0,INFINITY,INFINITY},
                {INFINITY,INFINITY,-3,0,9},
                {2,INFINITY,7,INFINITY,0}};
        for(int i=0; i<inputResult.numberOfVertice; i++) { //line
            for(int j=0; j<inputResult.numberOfVertice; j++){ //column
                inputResult.adjacencyMatrix[ i ] [ j ] = a[i][j];
            }
        }
        return inputResult;
    }

    //This inner auxiliary class is for storing the BellmanFordinput.txt input result
    private static class InputResult{
        int numberOfVertice;
        int sourceVertex;
        int[][] adjacencyMatrix;
    }

    //打印出Dijkstra的最短路径
    public void print_shortest(int vex,int n,int prev[]){
        for(int i=0;i<n;i++){
            System.out.print(vex+"  ");
            printt(vex,i,prev);
            System.out.println();
        }
    }
    private void printt(int vex,int index,int prev[]){
        if(prev[index] != 0) {
            printt(vex, prev[index], prev);
        }
        System.out.print(index+"  ");
    }



    public static void main(String args[]) throws IOException   {
        BellmanFord  bellmanFord = new BellmanFord ();
        int prev[] = bellmanFord.relax();
        if(bellmanFord.NoCycle()) {
            System.out.println("Start from the source vertex: " + bellmanFord.source + " to " + "destination vertex: i");
            for(int i=0;i<bellmanFord.numberOfVertices;i++)
                if(bellmanFord.distances[i]!=INFINITY){
                    System.out.println(bellmanFord.source+" ==> "+ i +",  shortest distance: " +bellmanFord.distances[i]);
                }
                else
                    System.out.println(bellmanFord.source+" ==> "+ i +",  shortest distance: INIFINITY" );
        }
        else {
            System.out.println(" There is a negative edge cycle ");
        }

        for(int i=0;i<prev.length;i++)
            System.out.print(prev[i]+"  ");
        System.out.println();
        System.out.println("各个最短路径是： ");
        //可根据prev来打印出最短路径
        bellmanFord.print_shortest(0,prev.length,prev);
    }
}