import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        long[] primes = {2L,3L,5L};
        PriorityQueue<Long> pq = new PriorityQueue<>();

        pq.add(1L);
        set.add(1L);
        
        long now = 1;
        int size =1;
        while(size<=n){
            now = pq.poll();
            size++;
            for(long prime:primes){
                long num = now * prime;
                if(set.contains(num))continue;
                pq.add(num);
                set.add(num);
            }
        }
        return (int)now;
    }
}