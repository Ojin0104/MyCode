import java.io.*;
import java.util.StringTokenizer;

public class baek1072게임 {
   static long X;
   static long Y;
   static long per;
   static long end;
   static long start=0;
    public static void main(String args[]) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        Y=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        per=X*100/Y;
        end =Y;//X랑 Y바꿔서풀어버림
        if(per>=99){
            bw.write("-1");
        }else {
           // System.out.println(per);

                long a = sort(start, end);//
                bw.write(String.valueOf(a));
            }

        bw.close();
        br.close();
    }

    static long sort(long s,long e){
        long mid=(s+e)/2;
      //  System.out.println(mid);
        if(s>=e){
            return mid;
        }
        else if ((mid+X)*100/(mid+Y)>=per+1){

            return sort(s,mid);
        }else{
            return sort(mid+1,e);
        }

    }
}
