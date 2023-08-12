import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        for(int  test_case =1;test_case<=10;test_case++){
            int size = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st =new StringTokenizer(br.readLine());

            for(int i=0;i<size;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            int query = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int i=0;i<query;i++){
                char q = st.nextToken().charAt(0);

                if(q=='I'){
                    int index = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());//삽입될 원소갯수
                    LinkedList<Integer> nums = new LinkedList<>();//임시 연결리스트에 여러값을 삽입하고 한번에 연결리스트에 삽입한다.

                    for(int j = 0;j<count;j++){
                        nums.add(Integer.parseInt(st.nextToken()));
                    }
                    list.addAll(index,nums);

                }else if(q=='D'){
                    int index = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());//삽입될 원소갯수

                    for(int times=0;times<count;times++){
                        list.remove(index);//해당인덱스의 원소를 count번 지워준다.
                    }

                }else if(q=='A'){
                    int count = Integer.parseInt(st.nextToken());//삽입될 원소갯수
                    LinkedList<Integer> nums = new LinkedList<>();

                    for(int j = 0;j<count;j++){
                        nums.add(Integer.parseInt(st.nextToken()));
                    }
                    list.addAll(nums);
                }
            }
            sb.append("#"+test_case+" ");
            for(int i=0;i<10;i++){//1~10번쨰 까지있는 리스트값을 출력
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
