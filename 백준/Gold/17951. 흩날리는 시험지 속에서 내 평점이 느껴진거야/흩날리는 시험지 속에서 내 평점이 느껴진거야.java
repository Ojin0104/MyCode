import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] problems = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            problems[i] = Integer.parseInt(st.nextToken());
        }

        // end = 20*100000;
        int answer= binSearch(problems,K);
        System.out.println(answer);
    }

    static int binSearch(int[] problems,int K){
        int left = 0;
        int right= 20*problems.length;
        while(left<=right){
            int mid =(left+right)/2;

            if(canPoint(mid,problems,K)){//해당점수로 K 그룹 나누기 가능
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return right;
    }

    static boolean canPoint(int target, int[] problems, int K){
        int count = 0;
        int score = 0;
        for(int idx = 0;idx<problems.length;idx++) {
            score += problems[idx];
            if (score >= target) {
                count++;
                score=0;
                if(count>=K)return true;
            }
        }

        return false;

        }
    }



