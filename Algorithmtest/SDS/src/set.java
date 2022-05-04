import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class set {

    public static void main(String[] args) {
        ArrayList<int[]> comb=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        int[] result=new int[T];
        ArrayList<Integer[]> sets=new ArrayList<>();
        ArrayList<String> cards=new ArrayList<>();
        for(int i=0; i<T;i++){
            sets.clear();
            cards.clear();

            int N=scanner.nextInt();
            scanner.nextLine();
            for(int j=0;j<N;j++){
                cards.add(scanner.nextLine());
            }

            //세트판별 다 다르거나 같으면 true
            for(int a=0;a<N-2;a++){
                for(int b=a+1;b<N-1;b++){
                    for(int c=b+1;c<N;c++){

                    if(check(cards.get(a),cards.get(b),cards.get(c))){
                        Integer[] goods={a,b,c};//위치만 기억
                        sets.add(goods);

                    }


                    }
                }}









            result[i]=1;
        }
        for(int i=0;i<result.length;i++)
            System.out.println("#"+(i+1)+" "+result[i]);

    }


    public static boolean check(String a, String b, String c){
        for(int i=0;i<4;i++){

            if(b.charAt(i)==a.charAt(i)&&c.charAt(i)==a.charAt(i)){//모두같을때
                //세트합격 4번모두 합격하면 그 배열은 세트이다.
            }else if(b.charAt(i)!=a.charAt(i)&&c.charAt(i)!=a.charAt(i)&&c.charAt(i)!=b.charAt(i)){

            }
            else{
                return false;
            }
        }return true;//4번모두 if문거치면 true return
    }
}
