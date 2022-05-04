import java.util.ArrayList;
import java.util.Scanner;

public class campingclub {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<T;i++){
            int N=scanner.nextInt();
            int[] load=new int[N];
            scanner.nextLine();
            int dest=0;
            String loadstr=scanner.nextLine();
            String[] loadspl=loadstr.split(" ");//for문쓸때 전에 값 초기화되는지?
            //System.out.println(loadspl.length);
            for(int j=0;j<N;j++){
                load[j]=Integer.parseInt(loadspl[j]);
                if(load[j]==3)dest=j;

            }
            //System.out.println("dest"+dest);
            ////////////////값 받아주기 완료
            int find_sleep=0;
            boolean find;
            int location=0; //캠핑카위치
            int r_time=6;//휴식시간
            int s_time=13;//자야하느시간-2 휴식 최소 두번은 해야하기때문에
            int time=0;//총이동시간
int pre_location=0;
int pre_time=0;
            int position;//계산되고있는 위치
            while(location<dest){
find=false;
                    for(int k=0;k<13;k++){
                        pre_location=location;
                        pre_time=time;

                        find_sleep=0;
                        position=location+s_time-k;
                        if(position>dest)continue;
                        if(load[position]==3){
                            find_sleep=position;
                            while(find_sleep!=location){
                                for(int g=0;g<6;g++){//캠핑장 찾으면 캠핑장가는길찾기

                                position=pre_location+r_time-g;//6시간에서 줄이면서 계산
//System.out.println("find"+find_sleep);
//System.out.println("pos"+position);

                                    if(position>find_sleep)continue;
                                if(position==find_sleep){//자야하는 캠핑장위치면 자기
                                    location=position;
                                    pre_time+=r_time-g;
                                    time=pre_time;
                                    find=true;
                                   // find_sleep=-1;

                                    break;
                                }


                                if(load[position]==2){
                                    //바로휴식
                                    pre_time+=r_time-g+1;//휴식시간 포함
                                    pre_location=position;

                                    break;
                                }
                               if(g==5)find_sleep=-2;
                            }

                            if(find_sleep==-2)break;
                            }
                      }//System.out.println(k);
                        if(find)break;//캠핑장찾으면 k처음부터
                        if(k==12)find_sleep=-2;

                    }


                if(find_sleep==-2){//잠못자면 -1
                    result.add(-1);

                    break;
                }
            }//목적지도착하면 자연종료
            if(find_sleep==-2)continue;
            result.add(time);

        }
        for(int i=0;i<result.size();i++){
            System.out.println("#"+(i+1)+" "+result.get(i));
        }
    }
}
