import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.*;

public class baek2304창고다각형 {
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ArrayList<chart> charts = new ArrayList<>();

        int n=Integer.parseInt(stringTokenizer.nextToken());
        int max=0;
        int index=0;
        for(int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x=Integer.parseInt(stringTokenizer.nextToken());
            int h=Integer.parseInt(stringTokenizer.nextToken());
            charts.add(new chart(x,h));
            if(h>max){
                max=h;
                index=x;
            }
        }
        Collections.sort(charts);
        int i=0;
        int nowh=0;
        int nowx=0;
        int answer=0;
        while(true){
            if(charts.get(i).x==index){
                answer+=Math.abs(charts.get(i).x-nowx)*nowh;
                break;
            }
            if(nowh<charts.get(i).h){
                answer+=Math.abs(charts.get(i).x-nowx)*nowh;
                nowx=charts.get(i).x;
                nowh=charts.get(i).h;

            }

            i++;
        }
        i=n-1;
        nowh=0;
        nowx=0;
        while(true){
            if(charts.get(i).x==index){
                answer+=Math.abs(charts.get(i).x-nowx)*nowh;
                break;
            }
            if(nowh<charts.get(i).h){
                answer+=Math.abs(charts.get(i).x-nowx)*nowh;
                nowx=charts.get(i).x;
                nowh=charts.get(i).h;

            }
            i--;
        }
        answer+=max;
        System.out.println(answer);

    }
    static class chart implements Comparable<chart>{
        int x;
        int h;

        chart(int x,int h){
            this.x=x;
            this.h=h;
        }

        @Override
        public int compareTo(chart charts) {
            return charts.x-this.x;
        }
    }
}
