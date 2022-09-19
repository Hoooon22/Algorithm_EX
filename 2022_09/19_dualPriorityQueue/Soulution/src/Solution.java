import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // for operations
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0)== 'I') {
                minHeap.add(Integer.parseInt(operations[i].substring(2)));
                maxHeap.add(Integer.parseInt(operations[i].substring(2)));
            }
            else if (!minHeap.isEmpty()) {
                if (operations[i] == "D 1") {
                    minHeap.remove();
                    maxHeap.remove(Integer.parseInt(operations[i].substring(operations[i].length()-1)));
                }
                else if (operations[i] == "D -1") {
                    maxHeap.remove();
                    minHeap.remove(Integer.parseInt(operations[i].substring(operations[i].length()-1)));
                }
            }
        }
        answer[0] = minHeap.poll();
        answer[1] = maxHeap.poll();

        return answer;
    }
}
