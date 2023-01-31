import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] times) {
        
        double vel = 0;
        for (int t : times) 
            vel += 1D / t;
        double approx = n / vel;

        
        PriorityQueue<long[]> heap = new PriorityQueue<>(Comparator.comparingLong(a -> a[0] + a[1]));
        
        for (int t : times) {
            long cnt = (long) (approx / t);
            heap.offer(new long[]{t, cnt * t});
            n -= cnt;
        }

        long max = (long) approx;
        for (int i = 0; i < n; i++) {
            long[] a = heap.poll();
            a[1] += a[0];
            heap.offer(a);
            max = a[1];
        }

        return max;
    }
}