class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);

        for(int num: nums){
            pq.add(num);
        }

        int answer = 0;
        for(int times = 0 ;times<k ;times++){
            answer = pq.poll();
        }

        return answer;
    }
}