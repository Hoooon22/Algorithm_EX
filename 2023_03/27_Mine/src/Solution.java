/*
 알고리즘 문제 : 프로그래머스 - 광물 캐기
 실습 날짜 : 2023-03-28
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/150368
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] picks = {0, 1, 0};
        String[] minerals = {"stone", "stone", "stone", "stone", "stone"};

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Integer[] inter_5;

        // 0. 곡괭이 수 계산해서 inter_5 범위 나누기
        int pickSum = 0;
        int remainder;
        for (int pick : picks) {
            pickSum += pick;
        }
        if (pickSum*5 < minerals.length) {
            inter_5 = new Integer[pickSum];
            remainder = -1;
        }
        else {
            if (minerals.length % 5 == 0) 
                inter_5 = new Integer[minerals.length/5];
            else 
                inter_5 = new Integer[minerals.length/5 + 1];
            remainder = minerals.length%5;
        }

        // 1. 돌곡으로 계산
        int[] mineralsNum = new int[minerals.length];
        for (int i = 0; i < mineralsNum.length; i++) {
            if ("diamond".equals(minerals[i]))
                mineralsNum[i] = 25;
            else if ("iron".equals(minerals[i]))
                mineralsNum[i] = 5;
            else 
                mineralsNum[i] = 1;
        }

        // 2. 돌곡 피로도로 minerals를 5개씩 잘라서 저장
        System.out.println(inter_5.length + "\n");
        for (int i = 0; i < inter_5.length; i++) {
            int sum = 0;

            if (i == inter_5.length-1 && remainder > 0) {
                for (int j = i*5; j < mineralsNum.length; j++) {
                    sum += mineralsNum[j];
                }
            }
            else {
                for (int j = i*5; j < i*5+5; j++) {
                    sum += mineralsNum[j];
                }
            }
            inter_5[i] = sum;
        }

        // 3. mineralsNum이 높은 부분에 높은 곡괭이 부여
        Arrays.sort(inter_5, Collections.reverseOrder());

        for (int i = 0; i < inter_5.length; i++) {
            int inter = inter_5[i];
            int[] indexOfMinerals = new int[3];

            if (inter == 25 && remainder < 1) {
                indexOfMinerals[0] = 0;
                indexOfMinerals[1] = 5;
                indexOfMinerals[2] = 0;
            }
            else if (inter == 5 && remainder < 1) {
                indexOfMinerals[0] = 0;
                indexOfMinerals[1] = 0;
                indexOfMinerals[2] = 5;
            }
            else {
                indexOfMinerals[0] = inter / 25;
                indexOfMinerals[1] = (inter % 25) / 5;
                indexOfMinerals[2] = inter % 5;
            }

            
            System.out.println(indexOfMinerals[0]);
            System.out.println(indexOfMinerals[1]);
            System.out.println(indexOfMinerals[2]);

            if (picks[0] != 0) { // diamond pick
                answer += indexOfMinerals[0] + indexOfMinerals[1] + indexOfMinerals[2];
                picks[0]--;
            }
            else if (picks[1] != 0) { // iron pick
                answer += indexOfMinerals[0]*5 + indexOfMinerals[1] + indexOfMinerals[2];
                picks[1]--;
            }
            else { // stone pick
                answer += indexOfMinerals[0]*25 + indexOfMinerals[1]*5 + indexOfMinerals[2];
                picks[2]--;
            }
        }


        System.out.println();
        return answer;
    }
}