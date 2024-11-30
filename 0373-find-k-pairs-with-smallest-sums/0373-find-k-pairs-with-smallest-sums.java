class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer  =new ArrayList<>();
        int[] index = new int[nums1.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.sum-o2.sum);
      
            
        for(int idx = 0; idx< nums1.length; idx++){
            pq.add(new Node(nums1[idx]+nums2[0],idx));
        }

        for(int idx = 0 ;idx < k ; idx++){
            Node now = pq.poll();
            answer.add(List.of(nums1[now.idx],nums2[index[now.idx]]));
            index[now.idx]++;
            if(index[now.idx]==nums2.length)continue;
            pq.add(new Node(nums1[now.idx]+nums2[index[now.idx]],now.idx));

        }

        return answer;

    }

    static class Node{
        int sum;
        int idx;
        public Node(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
}