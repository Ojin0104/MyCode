import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(bufferedReader.readLine());
        String start_str=st.nextToken();
        String end_str=st.nextToken();
        String final_str=st.nextToken();

        int start=makeTime(start_str);
        int end=makeTime(end_str);
        int last=makeTime(final_str);
        HashMap<String,Boolean> map = new HashMap<>();
        int count=0;
        while(bufferedReader.ready()){
            String str=bufferedReader.readLine();
            String[] strs=str.split(" ");
            int now=makeTime(strs[0]);
            if(now<=start){
                map.put(strs[1],true);
            }else if(now>=end&&now<=last) {
                if (map.containsKey(strs[1])) {
                    count++;
                    map.remove(strs[1]);
                }
            }

        }
        System.out.println(count);

    }
    static int makeTime(String str){
        String times[]=str.split(":");
        return Integer.parseInt(times[0])*60+Integer.parseInt(times[1]);
    }
}
