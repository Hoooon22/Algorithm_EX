/*
 알고리즘 문제 : 프로그래머스 - 연속 펄스 부분 수열의 합
 실습 날짜 : 2023-04-05
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/161988
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int arr[] = {2, 3, -6, 1, 3, -1, 2, 4};
        System.out.println(solution(arr));
    }

    public static long solution(int[] sequence) {
        long answer = 0;

        for (int i = 0; i < sequence.length; i++) {
            for (int j = i+1; j < sequence.length-i; j++) {
                int[] arr = Arrays.copyOfRange(sequence, i, j);
                answer = Math.max(answer, sumOfPurse(arr));
            }
        }

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
