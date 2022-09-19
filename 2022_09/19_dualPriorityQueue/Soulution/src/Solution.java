import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // for operations
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0)== 'I') {
                minHeap.add(Integer.parseInt(operations[i].substring(2)));
                maxHeap.add(Integer.parseInt(operations[i].substring(2)));
            }
            else if (!minHeap.isEmpty()) {
                if (operations[i].equals("D -1")) {
                    minHeap.remove();
                    maxHeap.remove(maxHeap.size()-1);
                }
                else if (operations[i].equals("D 1")) {
                    maxHeap.remove();
                    minHeap.remove(minHeap.size()-1);
                }
            }
        }
        if (!minHeap.isEmpty()) {
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }
}
