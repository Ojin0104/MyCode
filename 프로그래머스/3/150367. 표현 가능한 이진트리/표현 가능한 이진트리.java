import java.util.*;
import java.lang.Math;
class Solution {
    

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = canMakeBinaryTree(numbers[i]) ? 1 : 0;
        }
        
        return answer;
    }
    
    private boolean canMakeBinaryTree(long number) {
        // 1. 십진수를 이진수 문자열로 변환
        String binary = Long.toBinaryString(number);
        
        // 2. 포화 이진트리 크기로 맞추기 (2^h - 1 형태)
        int length = binary.length();
        int height = 0;
        int treeSize = 0;
        
        // 포화 이진트리 크기 찾기 (2^1-1=1, 2^2-1=3, 2^3-1=7, 2^4-1=15, ...)
        while (treeSize < length) {
            height++;
            treeSize = (1 << height) - 1; // 2^height - 1
        }
        
        // 3. 앞에 0을 채워서 포화 이진트리 크기로 만들기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < treeSize - length; i++) {
            sb.append('0');
        }
        sb.append(binary);
        binary = sb.toString();
        
        // 4. 유효한 이진트리인지 검증
        return isValidTree(binary, 0, binary.length() - 1);
    }
    
    /**
     * 재귀적으로 이진트리의 유효성 검증
     * 규칙: 부모 노드가 0(더미)이면, 자식 노드도 모두 0이어야 함
     */
    private boolean isValidTree(String binary, int start, int end) {
        if (start > end) {
            return true;
        }
        
        // 현재 서브트리의 루트는 중간 위치
        int mid = (start + end) / 2;
        char root = binary.charAt(mid);
        
        // 왼쪽 자식과 오른쪽 자식의 중간 위치 (각 서브트리의 루트)
        int leftChild = (start + mid - 1) / 2;
        int rightChild = (mid + 1 + end) / 2;
        
        // 부모가 0(더미 노드)인데 자식이 1이 있으면 안됨
        if (root == '0') {
            // 왼쪽 서브트리에 1이 있는지 확인
            if (start <= mid - 1 && hasOne(binary, start, mid - 1)) {
                return false;
            }
            // 오른쪽 서브트리에 1이 있는지 확인
            if (mid + 1 <= end && hasOne(binary, mid + 1, end)) {
                return false;
            }
        }
        
        // 왼쪽과 오른쪽 서브트리 재귀 검증
        return isValidTree(binary, start, mid - 1) && 
               isValidTree(binary, mid + 1, end);
    }
    
    /**
     * 주어진 범위에 1이 있는지 확인
     */
    private boolean hasOne(String binary, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (binary.charAt(i) == '1') {
                return true;
            }
        }
        return false;
    }
}