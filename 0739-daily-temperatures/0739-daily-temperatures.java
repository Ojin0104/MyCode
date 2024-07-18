class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        int now = 0;
        PriorityQueue<Status> pq = new PriorityQueue<>((o1,o2)->o1.num-o2.num);
        for(int idx = 0 ;idx<temperatures.length;idx++){
            int temperature= temperatures[idx];
            while(!pq.isEmpty()&&pq.peek().num<temperature){
                Status status = pq.poll();
                answer[status.idx] = idx-status.idx;
            }

            pq.add(new Status(idx,temperature));

        }

        return answer;
    }

    class Status{
        int idx;
        int num;

        public Status(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
}