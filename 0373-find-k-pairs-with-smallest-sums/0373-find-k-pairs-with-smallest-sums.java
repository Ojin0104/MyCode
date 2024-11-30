class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer  =new ArrayList<>();
        int[] index = new int[nums1.length];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> {

            if(o1.first+o1.second >o2.first + o2.second){
                return 1;
            }else if(o1.first+o1.second == o2.first+o2.second){
                if(o1.first>o2.first){
                    return 1;
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        });
        while(true){
            long before = Long.MAX_VALUE;
            for(int idx = 0; idx< nums1.length; idx++){
                int offset = index[idx];
                if(offset== nums2.length)continue;
                long now = nums1[idx] + nums2[offset];
                if(now<=before){
                    before = now;
                    pq.add(new Node(nums1[idx],nums2[offset]));
                    index[idx]++;
                }else{break;}
            }
            
                Node node = pq.poll();
                answer.add(List.of(node.first,node.second));
                if(answer.size()==k)return answer;
            

        }

    }

    static class Node{
        int first;
        int second;

        public Node(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}