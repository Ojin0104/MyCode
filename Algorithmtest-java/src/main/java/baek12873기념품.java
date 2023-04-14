import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek12873기념품 {

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N;
        N = Integer.parseInt(bufferedReader.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i=1;i<N+1 ;i++){
            arrayList.add(i);
        }
        int num=0;
        int index=-1;
        while(arrayList.size()>1) {
            num++;
            int size=arrayList.size();
            index=(index+(num*num)%size*(num%size))%size;
            //System.out.println(index);
            arrayList.remove(index);
            index-=1;
            if(index==-1)index=arrayList.size()-1;
        }
        System.out.println(arrayList.get(0));
    }
}
