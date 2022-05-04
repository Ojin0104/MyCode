import java.io.*;
import java.util.ArrayList;

public class baek5376소수를분수로 {
    public static void main(String args[]) throws IOException {
        int N;
        double A;
        int start;
        int end;
        int len;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<N;i++){
            start=0;
            end=0;
            char[] num=br.readLine().toCharArray();
            for(int j=0;j<num.length;j++){

                if(num[j]=='('){
                    start=j;
                }

                else if(num[j]==')'){
                    end=j;
                }
            }
            if (start==0){//그대로써
                len=num.length-2;
                A=Double.parseDouble(String.valueOf(num));
                A*=(int)Math.pow(10,len);
                int son=(int)A;
                int mom=(int)Math.pow(10,len);
                int mod=gcd(son,mom);
                sb.append(son/mod+"/"+mom/mod+"\n");

            }else{//반복되는것이있을때

                ArrayList<Character> nums=new ArrayList<>();
                for(int j=0;j<start;j++){
                    nums.add(num[j]);
                }
                while(nums.size()<=13) {//6쨰까지만 반복해줌
                    for (int j = start + 1; j < end; j++) {
                        nums.add(num[j]);
                    }
                }
                char[] numss=new char[nums.size()];
                for(int j=0;j<nums.size();j++){
                    numss[j]=nums.get(j);
                }
                len=numss.length-2;
                A=Double.parseDouble(String.valueOf(numss));


                double n=3;
                while(true){
//System.out.println((int)n*A+1-n*A);

                if((int)(n*A)+1-n*A<0.0001){//그때의 n은 분모


                    break;
                }
                    n++;
                }
               int mom=(int)n;
                int son=(int)(n*A+1);
                sb.append(son+"/"+mom+"\n");
            }


        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
   static int gcd(int a,int b){
if(b==0)return a;
return(gcd(b,a%b));
    }
}
