import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 1. HashMap에  0~9 까지 문자열로 저장해둔다.
 * 2. Arrays.sort() 에 comparator를 Map을 사용하여 정렬해준다.
 */
public class Main {
    static HashMap<Integer, String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int start = Integer.parseInt(stringTokenizer.nextToken());
        int end = Integer.parseInt(stringTokenizer.nextToken());

        map = new HashMap<>();
        setMap(map);

        Integer[] nums = new Integer[end - start + 1];

        for (int num = start; num <= end; num++) {
            nums[num - start] = num;
        }

        Arrays.sort(nums, (a, b) -> {//nums인자인 a,b 를 비교하는 람다식
            String astr = toStr(a);
            String bstr = toStr(b);
            return astr.compareTo(bstr);//사전순으로 문자열 비교하는 함수
        });

        for (int index = 0; index < nums.length; index++) {
            sb.append(nums[index]);
            if ((index + 1) % 10 == 0) {
                sb.append("\n");
            } else {
                sb.append(" ");
            }
        }

        System.out.println(sb);
    }

    static String toStr(int a) {//숫자 한자릿수 아니면 두자릿수이므로
        if (a < 10) {//한자릿수일때는 문자열로바로반환
            return map.get(a);
        } else {//두자릿 수 일때는 첫재자리 다음 둘째자리 비교
            return map.get(a / 10) + " " + map.get(a % 10);
        }
    }

    static void setMap(HashMap<Integer, String> map) {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
    }
}
