package shortesttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek1922 {
    static int N;
    static int M;
    static int a;
    static int b;
    static int c;
    static int[] parent;
    static int result;
    static PriorityQueue<network> pq=new PriorityQueue<network>(new Comparator<network>() {
        @Override
        public int compare(network o1, network o2) {
            if(o1.g>o2.g)return 1;
            else if(o1.g<o2.g) return -1;
            else return 0;
        }
    });
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        StringTokenizer st ;
        parent=new int[N+1];
        for(int i=1;i<N+1;i++){
            parent[i]=i;  //부모 정점 본인으로 설정해놓기
        }
        for(int i=0; i<M;i++){
            st =new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            pq.add(new network(a,b,c));
        }
        //우선순위큐에 넣기완료
        while(!pq.isEmpty()){
            network net;
            net=pq.poll();
          //  System.out.println(net.g);
            if(find(net.s)!=find(net.t)){//부모가같으면 -> 사이클이다
                union(net.s,net.t);//부모맞춰주고
                result+=net.g;//더해줌
             //   System.out.println("g "+net.g);
            }

        }
System.out.println(result);
    }


    static class network{
        int s;
        int t;
        int g;
        network(int n,int e,int g){
            this.s=n;
            this.t=e;
            this.g=g;
        }

    }
    static int find(int n){
        if(n==parent[n])return n;//부모 노드라면 리턴
        parent[n]=find(parent[n]);//하나씩거슬러서 찾아냄 위에 if문 터질때까지 돌고 터지면 그값계속드어옴

        return parent[n];
    }
    static void union(int a,int b){
            parent[find(a)]=b;
    }


}
