import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek20055컨베이어벨트 {
    static int[] A;
    static int index=0;
    static int robot_index=0;
    static int N;
    static int K;
    static int count=0;

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        A=new int[2*N];
        for(int i=0;i<2*N;i++){
            A[i]=Integer.parseInt(st.nextToken());
            if(A[i]==0)
                count++;
        }

        boolean[] robot=new boolean[N];
        int answer=0;

        while(count< K){//index 는 올리는 위치 index+N은 내리는 위치
            answer++;

            if(index==0)
                index=2*N;
            if(robot_index==0)
                robot_index=N;
            index--;
            robot_index--;
            robot[(robot_index+N-1)%N]=false;

           // System.out.println(answer);
            for(int i=N-2;i>=0;i--){

                if(robot[(robot_index+i)%N]){
                    if(!robot[(robot_index+i+1)%N]&&A[(index+i+1)%(2*N)]>0)
                    {
                        robot[(robot_index+i+1)%N]=true;
                        robot[(robot_index+i)%N]=false;

                        A[(index+i+1)%(2*N)]--;

                        if(A[(index+i+1)%(2*N)]==0)
                            count++;

                        robot[(robot_index+N-1)%N]=false;

                    }
                }

            }

            if(A[index]>0){
                A[index]--;
                if(A[index]==0)
                    count++;

                robot[robot_index]=true;

            }


        }
        System.out.println(answer);


    }
}
