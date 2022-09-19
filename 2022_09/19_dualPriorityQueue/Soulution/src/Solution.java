import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // for operations
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(0)== 'I') {
                minHeap.add(Integer.parseInt(operations[i].substring(2)));
            }
            else if (operations[i] == "D 1") {

            }
            else if (operations[i] == "D -1") {
                
            }
        }

        return answer;
    }
}
