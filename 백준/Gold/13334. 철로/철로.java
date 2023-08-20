import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 철로를 우선순위큐로 받는다 앞에기준으로
 * 뒤에기준우선순위큐 하나더 만들어 현재 선분에 포함되는지 확인한다.
 */
public class Main {
    static int answer =0;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        PriorityQueue<Line> lines = new PriorityQueue<Line>((l1,l2)->l1.end-l2.end);
        PriorityQueue<Line> inLine= new PriorityQueue<Line>((l1,l2)->l1.start-l2.start);

        for(int i=0; i<n;i++){
            StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine());
            int start =Integer.parseInt(stringTokenizer.nextToken());
            int end =Integer.parseInt(stringTokenizer.nextToken());
            if(end<start){
                int temp= start;
                start=end;
                end=temp;
            }
            lines.add(new Line(start,end));


        }
        int D = Integer.parseInt(bufferedReader.readLine());

        findMax(lines,inLine,D);

        System.out.println(answer);
    }
    static void findMax(PriorityQueue<Line>lines,PriorityQueue<Line>inLine,int D){
        Line now = lines.poll();
        inLine.add(now);
        int now_end= now.end;
        int canStart = now.end -D;
        while(!lines.isEmpty()){

            now= lines.poll();
            if(now.end-now.start>D)continue;

            if(now.end>now_end){
                now_end=now.end;
                canStart = now_end-D;
            }
            inLine.add(now);

            while(!inLine.isEmpty()&&inLine.peek().start<canStart){
                inLine.poll();
            }

            answer= Math.max(answer,inLine.size());
        }


    }

    static class Line{
        int start;
        int end;

        public Line(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
}
