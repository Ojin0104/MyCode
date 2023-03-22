import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek20437문자열게임2 {

//1.K개 이상 포함한 문자 리스트에 넣어줌
    //2.이상포함한 문자들 이중배열로 만들어서 index까지 넣어줌
    //-> index로 각각 문자의 최단거리,최장거리  구해서 보관
       public static void main(String args[]) throws IOException {
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

           StringTokenizer st=new StringTokenizer(br.readLine());
           StringBuilder sb=new StringBuilder();
           int T=Integer.parseInt(st.nextToken());


           for(int i=0;i<T;i++){
               String str=br.readLine();
               int num=Integer.parseInt(br.readLine());
               int[] chars=new int[26];
               for(int j=0;j<str.length();j++){
                   chars[str.charAt(j)-'a']++;
               }
               int cannum=0;
               ArrayList<Integer> arr=new ArrayList<>();

               for(int j=0;j<26;j++){
                   if(chars[j]>=num) {
                       cannum++;
                      arr.add(j);
                   }
               }

               if(cannum==0){
                   sb.append(-1).append("\n");
                   continue;
               }

               ArrayList<Integer>[] numsarr=new ArrayList[cannum];
               for(int j=0;j<cannum;j++){
                   numsarr[j]=new ArrayList<>();
               }
               for(int k=0;k<str.length();k++){
                   for(int j=0;j<cannum;j++) {
                       if(str.charAt(k)=='a' + arr.get(j)){//
                           numsarr[j].add(k);
                       }
                   }
               }//리스트 배열에 넣어줌

               int min=Integer.MAX_VALUE;
               int max=0;
               int now=0;
               for(int j=0;j<numsarr.length;j++){//k개이상인 문자열들 검사
                    for(int k=0;k<numsarr[j].size()-num+1;k++){//해당 문자열들의 저장되어 있는 인덱스
                        now=numsarr[j].get(k+num-1)-numsarr[j].get(k)+1;
                        max=Math.max(now,max);
                        min=Math.min(now,min);

                    }
               }


               sb.append(min).append(" ").append(max).append("\n");



           }
           System.out.println(sb.toString());
       }
}

