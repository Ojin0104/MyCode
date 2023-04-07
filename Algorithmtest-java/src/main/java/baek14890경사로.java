import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14890경사로 {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());
        int[][] map=new int[N][N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());

            }
        }
        int last=0;
        int answer=2*N;


        for(int i=0;i<N;i++){//가로

            boolean[] runway=new boolean[N];
            for(int j=0;j<N;j++){

                if(j==0){
                    last=map[i][j];
                }else if(Math.abs(last-map[i][j])>1){
                    answer-=1;
                    break;
                }else if(last-map[i][j]==1){//앞에께 한칸높음 ->뒤에 L길이만큼 깔수있어야함
                    runway[j]=true;
                    boolean flag=true;

                    for(int k=1;k<L;k++){//경사로놓기

                        if(j+k>=N){//경사로놓을수없음
                            answer-=1;
                            flag=false;
                            break;
                        }

                        if(map[i][j+k]!=map[i][j]){//높이가다름
                            answer-=1;
                            flag=false;
                            break;
                        }

                        runway[j+k]=true;//경사로놓기

                    }
                    if(!flag)break;

                }else if(map[i][j]-last==1){//뒤에꼐한칸높음 ->앞에L만큼 경사로

                    boolean flag=true;
                    for(int k=1;k<L+1;k++){
                        if(j-k<0){//경사로놓을수없음
                            answer-=1;
                            flag=false;
                            break;
                        }

                        if(runway[j-k]||map[i][j-k]!=map[i][j-1]){//이미깔려있음  높이가다름
                            answer-=1;
                            flag=false;
                            break;
                        }

                        runway[j-k]=true;

                    }
                    if(!flag)break;
                }
                last=map[i][j];


            }
        }

        for(int j=0;j<N;j++){//세로

            boolean[] runway=new boolean[N];
            for(int i=0;i<N;i++){

                if(i==0){
                    last=map[i][j];
                }else if(Math.abs(last-map[i][j])>1){
                    answer-=1;
                    break;
                }else if(last-map[i][j]==1){//앞에께 한칸높음 ->뒤에 L길이만큼 깔수있어야함
                    runway[i]=true;
                    boolean flag=true;

                    for(int k=1;k<L;k++){//경사로놓기

                        if(i+k>=N){//경사로놓을수없음
                            answer-=1;
                            flag=false;
                            break;
                        }

                        if(map[i+k][j]!=map[i][j]){//높이가다름
                            answer-=1;
                            flag=false;
                            break;
                        }

                        runway[i+k]=true;//경사로놓기

                    }
                    if(!flag)break;

                }else if(map[i][j]-last==1){//뒤에꼐한칸높음 ->앞에L만큼 경사로

                    boolean flag=true;
                    for(int k=1;k<L+1;k++){
                        if(i-k<0){//경사로놓을수없음
                            answer-=1;
                            flag=false;
                            break;
                        }

                        if(runway[i-k]||map[i-k][j]!=map[i-1][j]){//이미깔려있음  높이가다름
                            answer-=1;
                            flag=false;
                            break;
                        }

                        runway[i-k]=true;

                    }
                    if(!flag)break;
                }
                last=map[i][j];


            }
        }

        System.out.println(answer);

    }
}
