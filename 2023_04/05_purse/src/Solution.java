/*
 알고리즘 문제 : 프로그래머스 - 연속 펄스 부분 수열의 합
 실습 날짜 : 2023-04-05
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/161988
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public long solution(int[] sequence) {
        long answer = 0;

        

        return answer;
    }

    // 연속 부분 수열에 유리한 펄스 수열의 합을 출력
    public static long sumOfPurse(int[] seq) {
        long result1 = 0;
        long result2 = 0;

        // 1, -1, ...
        int purse = 1;
        for (int i = 0; i < seq.length; i++) {
            result1 += seq[i] * purse;
            purse *= -1;
        }

        // -1, 1, ...
        purse = -1;
        for (int i = 0; i < seq.length; i++) {
            result2 += seq[i] * purse;
            purse *= -1;
        }

        return Math.max(result1, result2);
    }
}
