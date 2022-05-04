import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class war {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();

        ArrayList<int[]> result=new ArrayList<>();
        for(int i=0;i<T;i++){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            HashMap<Integer, ArrayList<Integer>> load=new HashMap<Integer,ArrayList<Integer>>();
            int a=0;
            int b=0;
            int znum=0;
            ArrayList<Integer>a_start=new ArrayList<>();
            ArrayList<Integer>b_start=new ArrayList<>();
            a_start.add(scanner.nextInt());
            b_start.add(scanner.nextInt());
            for(int j=0;j<m;j++){
                a=scanner.nextInt();
                b=scanner.nextInt();
                ArrayList<Integer> list=new ArrayList<Integer>();
                ArrayList<Integer> list2=new ArrayList<Integer>();
                if(load.containsKey(a)){
                    list=load.get(a);
                    list.add(b);
                }else{
                    list.add(b);
                }
                load.put(a,list);

                if(load.containsKey(b)){
                    list2=load.get(b);
                    list2.add(a);
                }else{
                    list2.add(a);
                }
                load.put(b,list2);
                /////길 바로바로 넣어줌
            }

           int[] acheck=new int[n+1];//0은 미점령 1은 점령 2는 대치거점-1은 상대점령
           int[] bcheck=new int[n+1];
           a=1;
           b=1;

           acheck[a_start.get(0)]=1;
           bcheck[a_start.get(0)]=-1;
            bcheck[b_start.get(0)]=1;
            acheck[b_start.get(0)]=-1;
           while(true){//2틀 후 상태ㅁㄴㅇㅁㄴㅇㅁㄴㅇㅁㄴㅇ
ArrayList<Integer> removebox=new ArrayList<>();
int turn=a_start.size();
               for(int k=0;k<turn;k++){
                   int point=a_start.get(k);
                   removebox.add(point);
                  for(int p=0;p<load.get(point).size();p++){//같은거두개
                      if(!a_start.contains(Integer.valueOf(load.get(point).get(p)))&&acheck[load.get(point).get(p)]==0){
                      a_start.add(load.get(point).get(p));
                     // System.out.println(k);
                     // System.out.println("asize"+load.get(point).get(p));
                      }
                  }
               }
               for(int k=0;k<removebox.size();k++){
                   a_start.remove(Integer.valueOf(removebox.get(k)));
                  // System.out.println("몇개"+a_start.size());
               }
               removebox.clear();
               turn= b_start.size();
               for(int k=0;k<turn;k++){
                   int point=b_start.get(k);
                   removebox.add(point);
                   for(int p=0;p<load.get(point).size();p++){//같은거두개
                       if(!b_start.contains(Integer.valueOf(load.get(point).get(p)))&&bcheck[load.get(point).get(p)]==0){
                           b_start.add(load.get(point).get(p));
                           //System.out.println(k);
                          // System.out.println("asize"+load.get(point).get(p));
                           }
                   }
               }
               for(int k=0;k<removebox.size();k++){
                   b_start.remove(Integer.valueOf(removebox.get(k)));
               }
               removebox.clear();
               //////a_start와 b_start그다음에 점령할 지역확인  위
              for(int k=0;k<a_start.size();k++){
              //    System.out.println(k);
                 if(b_start.contains(a_start.get(k))){//겹치는 값있으면
                     acheck[a_start.get(k)]=2;
                     bcheck[a_start.get(k)]=2;
                     znum++;
                    // System.out.println("z "+znum );
                 }else if(acheck[a_start.get(k)]==0){
                     a++;
                     acheck[a_start.get(k)]=1;
                     bcheck[a_start.get(k)]=-1;
                  //   System.out.println("a "+a);
                 }


              }
               for(int k=0;k<acheck.length;k++){
                   if(acheck[k]==2){
                       a_start.remove(Integer.valueOf(k));
                       b_start.remove(Integer.valueOf(k));
                   }
               }
             //  System.out.println("학인1");
               for(int k=0;k<b_start.size();k++){
                  if(bcheck[b_start.get(k)]==0){
                       b++;
                       acheck[b_start.get(k)]=-1;
                       bcheck[b_start.get(k)]=1;
                  //    System.out.println("b "+b );
                   }

               }
            //   System.out.println(a_start.size()); ///////////////////점령시 1 적점령시 -1 겹치면 2로 대치지역
               if(a_start.isEmpty()&&b_start.isEmpty())break;
           }
           int dest=n/2+1;
           int num=n-znum-a-b;//중립지역 수
            int pnum=0; //a가 이기기위해 필요한 점령수
           if(dest>a+num+znum){//이러면 남은거 다점령해도 B가이김
            pnum=-1;
           // System.out.println("약;");
           }else{
               pnum=dest-a;
               if(pnum<0)pnum=0;


           }

           //pnum음숨ㄴ 0
            int[] res={znum,pnum};
           result.add(res);
           // System.out.println("res"+res[0]+" "+res[1]);
            }
        for(int i=0;i<result.size();i++){
            System.out.println("#"+(i+1)+" "+result.get(i)[0]+" "+result.get(i)[1]);

        }
        }
    }

