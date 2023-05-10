import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr=new ArrayList<>();
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr.add(new int[]{i+1,Integer.parseInt(st.nextToken())});
        }

        int[] result=new int[N];

        boomBallon(arr,result);

        arrToStr(result);
    }

    static void boomBallon(ArrayList<int[]> arr,int[] result){
        int now=0;
        for(int i=0;i<result.length;i++){
            int move=arr.get(now)[1];
            result[i]=arr.get(now)[0];
            arr.remove(now);
            if(arr.isEmpty())break;
            if(move>0){
                now=(now+move-1)%arr.size();
            }else{
                if(move+now>=0){
                    now=now+move;
                }else{
                while(now+move+arr.size()<0){
                    move+=arr.size();
                }
                now=arr.size()+now+move;
            }
            }
        }

    }

    static void arrToStr(int[] result){
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
