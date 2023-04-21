/*
 알고리즘 문제 : 프로그래머스 - 두 큐 합 같게 만들기
 실습 날짜 : 2023-04-21
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/118667
*/

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        long sum = 0; // q1 - q2
        
        // sum
        for (int i = 0; i < queue1.length; i++) {
            sum += queue1[i] - queue2[i];
        }
        if (Math.abs(sum) % 2 != 0) { // sum이 홀수라면
            return -1;
        }
        
        // queue to q
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        
        // 
        while (sum != 0) {
            if (answer >= 2*(queue1.length + queue2.length)) {
                return -1;
            }
            else {
                if (sum > 0) { // q1 > q2
                    int tmp = q1.poll();
                    sum -= tmp*2;
                    q2.add(tmp);
                }
                else { // q1 < q2
                    int tmp = q2.poll();
                    sum += tmp*2;
                    q1.add(tmp);
                }
                answer++;    
            }
        }
        
        
        return answer;
    }
}