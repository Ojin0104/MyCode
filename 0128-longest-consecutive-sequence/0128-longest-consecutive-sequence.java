import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxStreak = 0;

        for (int num : set) {
            // num이 연속된 시퀀스의 시작점인 경우만 처리
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // 연속된 숫자를 계속 찾아서 시퀀스 길이를 계산
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                maxStreak = Math.max(maxStreak, currentStreak);
            }
        }

        return maxStreak;
    }
}