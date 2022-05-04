package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14888연산자끼워넣기 {
    static int max=Integer.MIN_VALUE;
    static int min=Integer.MAX_VALUE;
    static int N;
    static int[] num;
    static int plus;
    static int minus;
    static int mult;
    static int div;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        num= new int[N];
        for(int i=0;i<N;i++){
            num[i]=Integer.parseInt(st.nextToken());

        }
        st=new StringTokenizer(br.readLine());
        plus=Integer.parseInt(st.nextToken());
        minus=Integer.parseInt(st.nextToken());
        mult=Integer.parseInt(st.nextToken());
        div=Integer.parseInt(st.nextToken());


        dfs(num[0],0,0,0,0);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int number,int p,int m,int x,int d){
        if(p==plus&&m==minus&&x==mult&&d==div){
          //  System.out.println(number);
            min=Math.min(number,min);
            max=Math.max(number,max);
        }

        int order=p+m+x+d+1;
        if(p<plus)
        dfs(number+num[order],p+1,m,x,d);

        if(m<minus)
            dfs(number-num[order],p,m+1,x,d);
        if(x<mult)
            dfs(number*num[order],p,m,x+1,d);
        if(d<div)
            dfs(number/num[order],p,m,x,d+1);

    }
}
