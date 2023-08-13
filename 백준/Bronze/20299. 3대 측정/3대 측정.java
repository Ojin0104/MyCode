import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1.최소 점수 못넘을시 바로 continue;
 * 2.최소 및 몇균 넘을시 바로 sb추가
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder teamRatings = new StringBuilder(); //인원저장

        int teams = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] team = new int[3];
        int count = 0;

        for (int no = 0; no < teams; no++) {
            int teamSum = 0;
            boolean flag = true;
            st = new StringTokenizer(br.readLine());

            for (int index = 0; index < 3; index++) {
                team[index] = Integer.parseInt(st.nextToken());

                if (team[index] >= limit) {
                    teamSum += team[index];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag && teamSum >= total) {
                count++;
                addStr(teamRatings, team);
            }
        }
        System.out.println(count);
        System.out.println(teamRatings);
    }

    static void addStr(StringBuilder teamRatings, int[] team) {//가입가능 팀원 점수저장
        for (int rating : team) {
            teamRatings.append(rating + " ");
        }
    }
}
