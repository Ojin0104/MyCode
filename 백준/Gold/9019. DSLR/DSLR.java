import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static boolean[] visited;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int times = 1; times <= T; times++) {
      visited = new boolean[10000];
      StringTokenizer st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      int target = Integer.parseInt(st.nextToken());

      bfs(num, target);
    }
    System.out.println(sb);

  }

  static void bfs(int num, int target) {
    ArrayDeque<DSLR> que = new ArrayDeque<>();
    que.add(new DSLR("", num));

    while (!que.isEmpty()) {
      DSLR now = que.poll();

      if (now.num == target) {
        sb.append(now.command + "\n");
        return;
      }

      if (visited[now.num])
        continue;

      visited[now.num] = true;
      int next = D(now.num);
      if (!visited[next]) {
        que.add(new DSLR(now.command + "D", next));
      }

      next = S(now.num);
      if (!visited[next]) {
        que.add(new DSLR(now.command + "S", next));
      }

      next = L(now.num);
      if (!visited[next]) {
        que.add(new DSLR(now.command + "L", next));
      }

      next = R(now.num);
      if (!visited[next]) {
        que.add(new DSLR(now.command + "R", next));
      }

    }
  }

  static int D(int num) {
    num *= 2;
    return num > 9999 ? num % 10000 : num;
  }

  static int S(int num) {
    num--;
    if (num < 0) {
      return 9999;
    }
    return num;
  }

  static int L(int num) {
    int temp = num / 1000;
    num = (num * 10) % 10000 + temp;
    return num;
  }

  static int R(int num) {
    int temp = num % 10;
    num /= 10;
    num += temp * 1000;

    return num;
  }

  static class DSLR {
    String command;
    int num;

    public DSLR(String command, int num) {
      this.command = command;
      this.num = num;
    }
  }
}
