
class Solution {
    public int candy(int[] ratings) {
        //ratings낮은 순서 대로 candy를 줄것 

        Status[] priorityArr = new Status[ratings.length];
        int[] candy = new int[ratings.length];
        for(int idx = 0 ;idx<ratings.length;idx++){
            priorityArr[idx] = new Status(idx,ratings[idx]);
        }
        Arrays.sort(priorityArr,(o1,o2)-> o1.rating - o2.rating);

        for(int idx= 0; idx<ratings.length;idx++){
            int now = priorityArr[idx].idx;
            int rating = priorityArr[idx].rating;
            //now기준 좌우 확인 

            //왼쪽
            if(now!=0){
                if(ratings[now-1]<rating){
                    candy[now] = Math.max(candy[now],candy[now-1]+1);
                }
            }
            //오른쪽
            if(now!=ratings.length-1){
                 if(ratings[now+1]<rating){
                    candy[now] = Math.max(candy[now],candy[now+1]+1);
                }

            }

            if(candy[now]==0)candy[now]=1;
        }
        int answer = 0;
        for(int idx = 0 ;idx <ratings.length;idx++){
            answer+=candy[idx];
        }

        return answer;

    }

    class Status{
        int idx;
        int rating;

        public Status(int idx, int rating){
            this.idx = idx;
            this.rating = rating;
        }
    }
}