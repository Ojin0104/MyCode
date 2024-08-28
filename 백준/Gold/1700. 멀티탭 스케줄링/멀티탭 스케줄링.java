import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] order = new int[K];
        for (int i = 0; i < K; i++) {
            order[i] = sc.nextInt();
        }

        ArrayList<Integer> multitap = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < K; i++) {
            if (!multitap.contains(order[i])) {
                if (multitap.size() < N) {
                    multitap.add(order[i]);
                } else {
                    int max = -1;
                    int index = -1;
                    for (int j = 0; j < multitap.size(); j++) {
                        int lastUse = 0;
                        for (int k = i + 1; k < K; k++) {
                            if (multitap.get(j) == order[k]) {
                                break;
                            }
                            lastUse++;
                        }
                        if (lastUse > max) {
                            max = lastUse;
                            index = j;
                        }
                    }
                    multitap.remove(index);
                    multitap.add(order[i]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}