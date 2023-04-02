import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek20920영단어괴로워 {
    static HashMap<String,Integer> map;
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        map=new HashMap();
        for(int i=0;i<N;i++){
            String str=br.readLine();
            if(str.length()<M)continue;
            if(map.containsKey(str))map.put(str,map.get(str)+1);
            else
                map.put(str,1);

        }
        PriorityQueue<Word> pq=new PriorityQueue<>();

        for(String key:map.keySet()){
            pq.add(new Word(key));
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        while(!pq.isEmpty()){
            bw.append(pq.poll().str+"\n");
        }
        bw.flush();
    }
    static class Word implements Comparable<Word>{
        String str;

        Word(String str){
            this.str=str;
        }
        @Override
        public int compareTo(Word o) {
            if(map.get(o.str)==map.get(this.str))
            {
                if(this.str.length()==o.str.length()){
                    return this.str.compareTo(o.str);
            }else{
            return o.str.length()-this.str.length();
        }
        }else{
                return map.get(o.str)-map.get(this.str);
            }
        }
    }
}
