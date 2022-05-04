

import java.util.*;

public class daikstra {
   public static void main(String[] args){
       Scanner scanner=new Scanner(System.in);
       int T=scanner.nextInt();
       ArrayList<int[]> result=new ArrayList<>();
       for(int t=0;t<T;t++){
           int N=scanner.nextInt();//친구수
           int E=N-1;//간선수
           int shortest[][]=new int[N][N];

           Graph g=new Graph(N);

           for(int i=0;i<E;i++){
               g.input(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
           }
          //g.output();

           for(int j=0;j<N;j++){
               int shorts[]=new int[N];
                shorts=g.dijkstra(j);
                shortest[j]=shorts;
                System.out.println("shortse"+ j);
           }

           for(int i=0;i<N;i++){
               for(int j=0;j<N;j++){
                   System.out.print(shortest[i][j]+" ");
               }
               System.out.println(" ");
           }
            int min_load= Integer.MAX_VALUE;
           int place=1;
           for(int i=0;i<N;i++){
               int sum=0;
               for(int j=0;j<N;j++){
                   sum+=shortest[i][j];
               }
               if(sum<min_load){
                   min_load=sum;
               }else if(sum==min_load){
                   place++;
               }
           }
        int[] add={min_load,place};
           result.add(add);
       }
       for(int i=0;i<result.size();i++) {
           System.out.println("#" + (i + 1) + " " +result.get(i)[1]+" "+result.get(i)[0]);
       }
}}

class Graph{
    private int n;
    private int maps[][];

    public Graph(int n){
        this.n=n;
        maps=new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                maps[i][j]=Integer.MAX_VALUE;
            }
        }
    }

    class Node implements Comparable<Node>{
        private int weight;
        private int index;

        public Node(int weight,int index){
            this.weight=weight;
            this.index=index;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight,o.weight);
        }
    }
    public void input(int i,int j, int w){//인접행렬 양쪽다
        //System.out.println((i-1)+" "+(j-1));

        maps[i-1][j-1]=w;
        maps[j-1][i-1]=w;
        System.out.println((i-1)+" "+(j-1));
    }
    public void output(){
        System.out.println("output");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(maps[i][j]);
            }
            System.out.println("");
        }
    }
public int[] dijkstra(int v){
        PriorityQueue<Node> que=new PriorityQueue<>();
        int distance[]=new int[n];
        boolean[] check = new boolean[n];

        for(int i=0;i<n;i++){
            distance[i]=Integer.MAX_VALUE;
        }

        que.add(new Node(v,0));
        distance[v]=0;
        check[v]=true;

        //distance갱신
        for(int i=0;i<n;i++){
            if(!check[i]&& maps[v][i]!=Integer.MAX_VALUE){
                distance[i]=maps[v][i];
                que.add(new Node(maps[v][v],i));
            }
        }

        while(!que.isEmpty()){
           // System.out.println("몇번");
//            for(int i=0;i<check.length;i++){
//                if(check[i]==false){break;}
//                else{
//                    end=true;
//                }
//            }
//            if(end){
//                break;
//            }
            int min=Integer.MAX_VALUE;
            int min_index=-1;

            Node node=que.poll();
            min=node.weight;
            min_index=node.index;
//System.out.println("min"+min);
            check[min_index]=true;
            for(int i=0;i<n;i++){
                if(!check[i]&&maps[min_index][i]!=Integer.MAX_VALUE){
                    if(distance[min_index]+maps[min_index][i]<distance[i]){
                        distance[i]=distance[min_index]+maps[min_index][i];
                        que.add(new Node(distance[i],i));
                    }
                }

            }


        }

    int[] shors = Arrays.copyOf(distance, distance.length);
        System.out.println("dist"+distance[3]);
        return shors;
}

}