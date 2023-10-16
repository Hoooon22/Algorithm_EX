/*
 * Title : 기지국 설치
 * Link : https://school.programmers.co.kr/learn/courses/30/lessons/12979?language=java
 */

import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2*w+1;
        int empty_num;
        
        // 처음
        empty_num = stations[0] - w - 1; // ex) 9 - 2 - 1 = 6
        if (empty_num > 0) {
            answer += empty_num / range;
            if (empty_num % range != 0) 
                answer++;
        }
        
        // 중간
        for (int i = 1; i < stations.length; i++) {
            empty_num = (stations[i] - w) - (stations[i-1] + w) - 1; // ex) 10 - 5 -1
            if (empty_num > 0) {
                answer += empty_num / range;
                if (empty_num % range != 0) 
                    answer++;
            }
        }
        
        // 끝
        empty_num = n - (stations[stations.length - 1] + w);
        if (empty_num > 0) {
            answer += empty_num / range;
            if (empty_num % range != 0) 
                answer++;
        }
            
        return answer;
    }
}