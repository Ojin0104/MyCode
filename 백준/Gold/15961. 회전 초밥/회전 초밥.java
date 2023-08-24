import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. 벨트위초밥들을 rail 배열에 넣어준다. 3백만*4 1200만 약 11MB 
 * 2. 초밥종류 d개의 int형 배열을 만든다.(int[] chobab)
 * 3. rail배열의 0번에서 K(연속해서먹는 수)-1 에 포함된 초밥 갯수를 chobab배열에 저장 갯수를 포함하여(init)
 * 4. chobab배열에 c(쿠폰 초밥)이 존재하는지 체크 만약존재하지 않는다면 size+1이 해당 범위를 가져갔을떄 먹을 수 있는 초밥종류의 수이다.
 * 5. 오른쪽으로 한칸씩 밀면서 0번초밥 갯수 줄이고 K번쨰 초밥 갯수늘림 (경우에 따라 초밥 size를 업데이트)
 * 6. 3,4,5 를 N 끝까지 반복
 * 
 */
public class Main {
	static int c;
	static int k;
	static int N;
	static int size=0;//포함된 초밥종류의 수
	static int max =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int[] chobab = new int[d+1];
		int[] rail= new int[N];
		
		for(int index =0 ;index<N;index++) {
			rail[index]=Integer.parseInt(br.readLine());
		}
		
		init(rail,chobab);//0~k-1번까지 초밥의 종류를기록하고 포함된 종류의 수를 알아낸다.
		
		findMax(rail,chobab);
		
		System.out.println(max);
	}
	static void checkCoupon(int[] chobab,int size) {
		if(chobab[c]==0) {//쿠폰초밥 포함안됐을시 +1
			max=Math.max(max, size+1);
		}else {
			max=Math.max(max, size);
		}
	}
	static void init(int[] rail, int[] chobab) {
		for(int index=0;index<k;index++) {
			int now = rail[index];
			chobab[now]++;
			if(chobab[now]==1)size++;
		}
		
		checkCoupon(chobab,size);
	}
	
	static void findMax(int[] rail,int[] chobab) {
		
		
		for(int start=0;start<N-1;start++) {
			int del = rail[start];
			int add = rail[(start+k)%N];
			
			//앞에초밥 제외시키기
			chobab[del]--;
			if(chobab[del]==0) {
				size--;
			}
			
			chobab[add]++;
			if(chobab[add]==1) {
				size++;
			}
			
			
			checkCoupon(chobab,size);
		}
	}

}
