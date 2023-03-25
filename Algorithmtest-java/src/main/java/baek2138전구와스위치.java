import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2138전구와스위치 {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(br.readLine());

        String A=br.readLine();
        String B=br.readLine();

        char[] Ach=A.toCharArray();
        char[] Bch=B.toCharArray();

        //1.첫번쨰 스위치누른경우
        int min=Integer.MAX_VALUE;
        int count=1;
        if(Ach[0]=='0')
            Ach[0]='1';
        else
            Ach[0]='0';
        if(Ach[1]=='0')
            Ach[1]='1';
        else
            Ach[1]='0';

        for(int i=1;i<Ach.length;i++){
            if(Ach[i-1]!=Bch[i-1]){
                count++;
                if(Ach[i-1]=='0')
                    Ach[i-1]='1';
                else
                    Ach[i-1]='0';

                if(Ach[i]=='0')
                    Ach[i]='1';
                else
                    Ach[i]='0';

                if(i+1<n){
                    if(Ach[i+1]=='0')
                        Ach[i+1]='1';
                    else
                        Ach[i+1]='0';
                }
            }
        }
        if((new String(Ach)).equals(new String(Bch)))
            min=count;
        count=0;


        Ach=A.toCharArray();
        Bch=B.toCharArray();

        for(int i=1;i<Ach.length;i++){
            if(Ach[i-1]!=Bch[i-1]){
                count++;
                if(Ach[i-1]=='0')
                    Ach[i-1]='1';
                else
                    Ach[i-1]='0';
                if(Ach[i]=='0')
                    Ach[i]='1';
                else
                    Ach[i]='0';

                if(i+1<n){
                    if(Ach[i+1]=='0')
                        Ach[i+1]='1';
                    else
                        Ach[i+1]='0';

                }
            }

        }
        if((new String(Ach)).equals(new String(Bch)))
            min=Math.min(min,count);
        if(min==Integer.MAX_VALUE)System.out.println(-1);
        else
            System.out.print(min);
    }
}
