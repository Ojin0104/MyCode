import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class baek1927 {
    static int N;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        //1.0인경우 배열에서 가장최소값 출력
        //2.자연수인 경우 배열에 등록
        //3.최소힙이므로 최소값이 루트노드가 되게
        //4.처음 입력시 마지막 노드로 넣고 그다음 정렬해줌
        MinHeap heap=new MinHeap();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                System.out.println(heap.delete());
            }else{
                heap.insert(num);
            }
        }

    }


    public static class MinHeap {
        int current;
        ArrayList<Integer> heap = new ArrayList<>();

        public MinHeap() {

            heap.add(0);

        }

        public void insert(int val) {
            heap.add(val);
            current = heap.size() - 1;
            int parent = current / 2;

            while (true) {
                if (parent == 0 || heap.get(parent) >= heap.get(current)) {
                    break;
                }
                int temp = heap.get(parent);
                heap.set(parent, heap.get(current));
                heap.set(current, temp);
                current = parent;
                parent = current / 2;
            }
        }

        public int delete() {
            if (heap.size() == 1) {
                return 0;
            }
            int top = heap.get(1);
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);

            int currentPos = 1;
            while (true) {
                int leftPos = currentPos * 2;
                int rightPos = currentPos * 2 + 1;

                if (leftPos >= heap.size()) {
                    break;
                }
                int maxValue = heap.get(leftPos);
                int maxPos = leftPos;

                //오른쪽ㅇ자식 있으면 비교후 작은애 확인
                if (rightPos < heap.size() && heap.get(rightPos) > maxValue) {
                    maxValue = heap.get(rightPos);
                    maxPos = rightPos;
                }
                if (heap.get(currentPos) < maxValue) {//자식이 더 크면 위치변경
                    int temp = heap.get(currentPos);
                    heap.set(currentPos, maxValue);
                    heap.set(maxPos, temp);
                    currentPos = maxPos;
                } else {
                    break;
                }
            }
            return top;
        }
    }
}
