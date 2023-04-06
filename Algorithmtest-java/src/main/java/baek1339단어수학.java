import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baek1339단어수학 {
    static int nextnum=9;
    static int[] alpnum;
    static int N;
    static int max;
    static ArrayList<Integer> check;
    static String[] words;

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        words=new String[N];
        max=0;
        int maxindex=0;
        for(int i=0;i<N;i++){
            words[i]=br.readLine();
            if(max<words[i].length()){
                maxindex=i;
                max=words[i].length();
            }
        }
        check=new ArrayList<>();//해당 문자열 길이 만족하는 지 체크
        //check.add(maxindex);

        alpnum=new int[26];
        Arrays.fill(alpnum,-1);

        for(int i=max;i>0;i--){//제일 앞에 애부터
            for(int j=0;j<N;j++){
                if(check.indexOf(j)!=-1)continue;
                //System.out.println(j);
               // System.out.println(check.get(0)+" "+check.indexOf(j));
                if(words[j].length()>=max)check.add(j);


            }


            Point[] count=new Point[26];
            for(int k=0;k<26;k++){
                count[k]=new Point(k,0);
            }
            ArrayList<Integer> arr=new ArrayList<>();
            Order(count,i,arr);



        }
        int answer=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<words[i].length();j++){
                answer+=alpnum[words[i].charAt(j)-'A']*Math.pow(10,words[i].length()-j-1);
            }
        }
//        for(int i=0;i<26;i++){
//            System.out.println(alpnum[i]);
//        }
        System.out.println(answer);

    }
    static void Order(Point[] count,int firstCh,ArrayList<Integer> answer){

        char ch;
        if(firstCh==0){
            for(int now:check){
                ch=words[now].charAt(words[now].length()-firstCh);
                if(alpnum[ch-'A']==-1){
                    answer.add(ch-'A');
                }
            }
        }
        int ansnum=0;
        for(int now:check){
            ch=words[now].charAt(words[now].length()-firstCh);
            //System.out.println(now);
            if(alpnum[ch-'A']==-1){
                count[ch-'A'].count++;
            }else{
                ansnum++;
            }

             }
        Arrays.sort(count);
        for(Point now:count){

            System.out.println(now.ch+" "+now.count+" " +now.same);
            if(!now.same&&answer.indexOf(now.ch)!=-1){
                answer.add(now.ch);
                ansnum++;
            }
        }
        if(ansnum==check.size()){
            for(Integer ans:answer){
                alpnum[ans]=nextnum;
                nextnum--;
            }
        }else{
            Point[] nextcount=new Point[26];
            for(int k=0;k<26;k++){
                //System.out.println(count[k]);
                nextcount[k]=new Point(k,0);
            }
            Order(nextcount,firstCh-1,answer);
        }

    }

    static class Point implements Comparable<Point>{
        int ch;
        int count;
        boolean same;
        Point(int ch,int conut){
            this.ch=ch;
            this.count=conut;
            this.same=false;
        }


        @Override
        public int compareTo(Point o) {
            if(this.count==o.count){
                this.same=true;
                o.same=true;
            }
            return o.count-this.count;
        }
    }
}
