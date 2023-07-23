import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    /**
     * 아스키코드 이용해 52x52matrix 생성
     * 플로이드사용해 boolean 값 true
     * map[start][end];
     *
     *
     * @param args
     */
    static boolean[][] floyd=new boolean[52][52];
    static int count=0;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader( System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=changetoIndex(st.nextToken().charAt(0));
            st.nextToken();
            int end=changetoIndex(st.nextToken().charAt(0));
            floyd[start][end]=true;
        }

        goFloyd();
        System.out.println(count);
        System.out.print(sb);
    }
    static void goFloyd(){

        for(int mid=0;mid<52;mid++){
            for(int start=0;start<52;start++){
                for(int end=0;end<52;end++){
                    if(floyd[start][mid]&&floyd[mid][end])
                        floyd[start][end]=true;
                }
            }
        }
        for(int i=0;i<52;i++){
            for(int j=0;j<52;j++){
                if(i==j)continue;
                if(floyd[i][j]) {

                    count++;
                    sb.append(changetoChar(i) + " => " + changetoChar(j) + "\n");
                }
            }
        }

    }
    static int changetoIndex(Character c){
        if(Character.isUpperCase(c)){
            return c-'A';
        }else{
            return c-'a'+26;
        }
    }

    static char changetoChar(int i){

        if(i<26){
            return (char)('A'+i);
        }else{
            return (char)('a'+i-26);
        }
    }
}
