import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class baek4195친구네트워크 {

    static int[] parent;
    static int[] count;

    public static void main(String args[]) throws IOException {
        //1.hash사용해서 사람이름 번호로 저장함
        //2.parent(arraylist)를 사용해 왼쪽에있는 친구 부모로 설정
        //3.해당 부모와 연관되어있는 친구들 표시해줌
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T=Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){

            HashMap<String,Integer> map=new HashMap<>();
            int num=0;
            int N=Integer.parseInt(br.readLine());
            parent=new int[2*N];
            count=new int[2*N];
            for(int j=0;j<N;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());

                String A=st.nextToken();
                String B=st.nextToken();

                if(!map.containsKey(A)){
                    map.put(A,num);
                    parent[num]=num;
                    count[num]=1;
                    num++;
                }
                if(!map.containsKey(B)){
                    map.put(B,num);
                    parent[num]=num;
                    count[num]=1;
                    num++;
                }
                union(map.get(A),map.get(B));

                int now=find(map.get(A));

                bw.append(count[now]+"\n");

            }

        }
        bw.flush();
    }

    static int find(int num){
        if(parent[num]==num){
            return num;
        }
        return parent[num]=find(parent[num]);
    }

    static void union(int A, int B){
        A=find(A);
        B=find(B);

        if(A==B)return;

        if(A>B){
            parent[A]=B;
            count[B]+=count[A];
        }else{
            parent[B]=A;
            count[A]+=count[B];
        }

    }
}

