import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baek2143 {
    static long T;
    static int n;
    static int m;


    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        T=Long.parseLong(br.readLine());
        n=Integer.parseInt(br.readLine());
        Long[] A=new Long[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        m=Integer.parseInt(br.readLine());
        Long[] B=new Long[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            B[i] = Long.parseLong(st.nextToken());
        }
        //입력부분
        ArrayList<Long> subA=new ArrayList<Long>();
        for(int i=0;i<n;i++){
            long sum=A[i];
            subA.add(sum);
            for(int j=i+1;j<n;j++){
                sum+=A[j];
                subA.add(sum);
              //  System.out.println(sum);
            }
        }

        Collections.sort(subA);

        ArrayList<Long> subB=new ArrayList<Long>();
        for(int i=0;i<m;i++){
            long sum=B[i];
            subB.add(sum);
            for(int j=i+1;j<m;j++){
                sum+=B[j];
                subB.add(sum);
            }
        }
        Collections.sort(subB,Collections.reverseOrder());
        //1.sub A sub B 각각 오름차순 내림차순으로 만들기
long currentA=0;
long currentB=0;
int asame=0;
int bsame=0;
        long count=0;
        //2.하나씩 이동하면서 subA+subB>T이면 ptB++ <T이면 ptA++ ==T이면 count++ (겹치는 수 있을때 경우 만들기)
        int ptrA=0;
        int ptrB=0;
        while(ptrA<subA.size()&&ptrB<subB.size()) {
          //  System.out.println(ptrA+" "+ptrB);
            if (subA.get(ptrA) + subB.get(ptrB) > T) {
                ptrB++;
            } else if (subA.get(ptrA) + subB.get(ptrB) == T) {

                asame=1;
                bsame=1;
                currentA=subA.get(ptrA++);
                while(true){
                    if(ptrA>=subA.size())break;
                    if(currentA==subA.get(ptrA)){
                       asame++;
                        ptrA++;
                    }else{
                        break;
                    }
                }
                currentB=subB.get(ptrB++);
                while(true){
                    if(ptrB>=subB.size())break;
                    if(currentB==subB.get(ptrB)){
                        bsame++;
                        ptrB++;
                    }else{
                        break;
                    }
                }
                count+=asame*bsame;
            } else {
                ptrA++;
            }

        }

        System.out.println(count);
    }
}
