import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bufferedReader.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        HashMap<String,Boolean> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(bufferedReader.readLine(),true);
        }
        ArrayList<String> answer=new ArrayList<>();
        for(int j=0;j<M;j++){
            String str=bufferedReader.readLine();
            if(map.containsKey(str)){
                answer.add(str);
            }
        }
        Collections.sort(answer);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(answer.size()+"\n");
        for(String s:answer){
            stringBuilder.append(s+"\n");
        }
        System.out.println(stringBuilder);
    }
}
