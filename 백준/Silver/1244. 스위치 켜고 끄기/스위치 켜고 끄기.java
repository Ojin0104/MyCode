import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=Integer.parseInt(br.readLine());
		int[] swich=new int[count];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int index=0;index<count;index++) {
			swich[index]=Integer.parseInt(st.nextToken());
		}
		
		int studentNum=Integer.parseInt(br.readLine());
		for(int student=0;student<studentNum;student++) {
			st=new StringTokenizer(br.readLine());
			int option=Integer.parseInt(st.nextToken());
			int click=Integer.parseInt(st.nextToken());
			
			clickSwich(swich,option,click);
			
		}
		StringBuilder sb=new StringBuilder();
		for(int index=0;index<swich.length;index++) {
			if((index+1)%20==0)
				sb.append(swich[index]+"\n");
			else 
				sb.append(swich[index]+" ");
			
		}
		System.out.println(sb);
	}
	static void clickSwich(int[] swich,int option,int click) {
		if(option==1) {//남학생의 경우
			manClick(swich,click);
		}else if(option==2) {//여학생의경우
			womanClick(swich,click);
		}
	}
	
	static void manClick(int[] swich,int click) {//배수를 곱해줌
		int addnum=click-1;
		while(addnum<swich.length) {
			swich[addnum]=swich[addnum]^1;
			addnum+=click;
		}
	}
	
	static void womanClick(int[] swich,int click) {//투포인터로 양쪽체크
		int right=click-1;
		int left=click-1;
		swich[click-1]=swich[click-1]^1;
		while(left>=0&&right<swich.length&&swich[left]==swich[right]) {
			swich[left]=swich[left]^1;
			swich[right]=swich[right]^1;
			left-=1;
			right+=1;
		}
	}
}
