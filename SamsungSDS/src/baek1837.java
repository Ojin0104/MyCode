import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek1837 {

    static int K;
    static int num=0;
    static char[] P;
    static List<Integer> prime=new ArrayList<>();

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());

        //K까지의소수 구하기
        boolean[] isnotprime = new boolean[K + 1];
        isnotprime[1] = true;
        for (int i = 2; i < K + 1; i++) {

            if (isnotprime[i] == false) {
                prime.add(i);
               // System.out.println("p" + i);
                for (int j = 2 * i; j < K + 1; j += i) {
                    isnotprime[j] = true;
                    // System.out.println(j);
                }
            }


        }
        for (int primes : prime) {
            if(primes>=K){
                break;
            }
         //   System.out.println(primes);
            if (ismod(primes)) {
                num = primes;
                break;
            }
            //if P%q==0-> BAD,num=i; break;


        }
        if (num == 0) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD "+num);
        }
    }

    static boolean ismod(int b){
        int r=0;
       for(int i=0;i<P.length;i++){
           r=(r*10+(P[i]-'0'))%b;
       }
       if(r==0)return true;
       return false;
    }
    }



