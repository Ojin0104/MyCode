import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int M;
    static boolean[] check;
    static StringBuilder stringBuilder= new StringBuilder();
    static TreeSet<Integer> set =new TreeSet<>();
    static boolean[] era = new boolean[10001];
    public static void main(String[] args) throws IOException {
        //수의 합이 소수 M마리
        //N개의 소중 M개를 골라 합이 소수가 될 확률 백트래킹??

        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N =Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        int[] weight = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0;i<N;i++){
            weight[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        
        makePrime(era);
        dfs(weight,0,0,0);
        for(Integer num : set){
            stringBuilder.append(num+" ");
        }
        if(set.size()==0){
            System.out.println(-1);
        }else{
            System.out.println(stringBuilder);
        }
    }

    static void dfs(int [] weight,int count, int index,int sum){
        if(count==M){
            
            if(!era[sum]) {
                set.add(sum);
            }
            return;
            }
        if(index>=weight.length)return;

        dfs(weight,count+1,index+1,sum+weight[index]);
        dfs(weight,count,index+1,sum);
    }


    static void makePrime(boolean[] era){
        era[0]=true;
        era[1]=true;
        for(int i=2;i<=Math.sqrt(10000);i++){
            if(era[i])continue;
            int index=i+i;
            while(index<era.length){
                era[index]=true;
                index+=i;
            }
        }
    }
}
