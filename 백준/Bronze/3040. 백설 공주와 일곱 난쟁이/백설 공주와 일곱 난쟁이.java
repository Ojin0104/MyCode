import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 영진
 *1. 총합을구하고
 *2. 총합-100이 되는 두 난쟁이를 구함 걔네 뺴고다출력
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] smallMan= new int[9];
		int sum =0;
		for(int index=0;index<9;index++) {
			smallMan[index]= Integer.parseInt(br.readLine());
			sum+=smallMan[index];
		}
		
		sum-=100;
		//sum에 해당하는 두 친구를 찾기
		for(int first =0;first<8;first++) {
			int hat = smallMan[first];
			for(int second= first+1;second<9;second++) {
				if(hat+smallMan[second]==sum) {
					//두명찾음
					writeMan(sb,first,second,smallMan);
				}
			}
		}
		
		System.out.println(sb);
		
	}
	
	//진짜난쟁이작성
	static void writeMan(StringBuilder sb, int first,int second,int[] smallMan) {
		for(int index=0;index<9;index++) {
			if(index!=first&&index!=second) {
				sb.append(smallMan[index]+"\n");
			}
		}
	}
}
