import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int min=Integer.MAX_VALUE;
        int str=0;
        int str2=0;
        for(int i=0;i<N-1;i++){
            int findNum=binSearch(arr[i],i+1,arr);
            if(Math.abs(arr[i]+findNum)<min){
                min=Math.abs(arr[i]+findNum);
                str=arr[i];
                str2=findNum;
            }

        }
        System.out.println(str+" "+str2);
    }

    static int binSearch(int num,int start,int[] arr){
        int point=start;
        int end=arr.length-1;
        int find=num*-1;
        while(start<=end){
            int mid=(start+end)/2;

            if(arr[mid]==find){
                return find;
            }else if(arr[mid]<find){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        if(start>arr.length-1)return arr[end];
        if(end<point)return arr[start];
        if(Math.abs(num+arr[start])<Math.abs(num+arr[end])){
            return arr[start];
        }else{
            return arr[end];
        }
    }
}
