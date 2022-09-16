import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] arr = new Integer[people.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = people[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i : arr) {
            deque.add(i);
        }
        while (!deque.isEmpty()) {
            int a = limit - deque.removeFirst();
            while (!deque.isEmpty() && deque.getLast() <= a) {
                a -= deque.removeLast();
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {40, 40, 40, 40, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}