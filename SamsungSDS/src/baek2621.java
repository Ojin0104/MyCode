import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2621 {
    static boolean flush=true;
    static boolean straight=true;
    static int samenum=0;
    static int same=1;
    static String[] color=new String[5];
    static int[] num=new int[5];
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        for(int i=0;i<5;i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            color[i]=stringTokenizer.nextToken();

            if(!color[0].equals(color[i]))flush=false;

            num[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int[] a=new int[10];
        int high=isCheck();
        int secondnum=-1;
        int checknum=-1;
        for(int i=0;i<5;i++){
            if(num[i]!=samenum){
                a[num[i]]++;
                if(a[num[i]]==2){
                    secondnum=num[i];
                    break;
                }
            }
        }
System.out.println("숫자동일" +same);
        System.out.println("해당숫자" +samenum);
        System.out.println("다른 두개있다면 숫자" +secondnum);
        System.out.println("가장큰숫자" +high);
System.out.println(straight);

        int score=0;
        if(straight&&flush){
            score=900+high;
        }else if(same==4){
            score=800+samenum;
        }else if(same==3&&secondnum!=-1){
            score=700+samenum*10+secondnum;
        }else if(flush){
            score=600+high;
        }else if(straight){
            score=500+high;
        }else if(same==3){
            score=400+samenum;
        }else if(same==2&&secondnum!=-1){
            if(samenum>=secondnum){
                score=300+samenum*10+secondnum;
            }else{
                score=300+secondnum*10+samenum;
            }
        }else if(same==2){
            score=200+samenum;
        }else{
            score=100+high;
        }

        System.out.println(score);
    }

    public static int isCheck() {
        int[] check=new int[5];
         for(int i=0;i<5;i++){
             check[i]=num[i];
         }
        int sn=1;
        Arrays.sort(check);

        for(int i=0;i<4;i++){
          //  System.out.println(check[i]);
            if(check[i+1]==check[i]){
                straight=false;
                sn++;
            }else if(check[i+1]!=check[i]+1){
                straight=false;
                if(same<sn) {
                    same = sn;
                    samenum=check[i];
                }
                sn=1;
            }else{
                if(same<sn) {
                    same = sn;
                    samenum=check[i];
                }
                sn=1;
            }
        }
        if(same<sn){
            same=sn;
            samenum=check[4];
        }

        return check[4];
    }
}
