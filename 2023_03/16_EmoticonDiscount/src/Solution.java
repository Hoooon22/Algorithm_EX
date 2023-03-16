/*
 알고리즘 문제 : 프로그래머스 - 무인도 여행
 실습 날짜 : 2023-03-16
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/150368
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        int min_discount = 40;
        int[] e_discount = new int[emoticons.length];

        // 1. find minimum discount rate
        for (int i = 0; i < users.length; i++) {
            if (users[i][0] < min_discount) {
                min_discount = users[i][0];
            }
        }
        for (int i = 0; i < e_discount.length; i++) {
            e_discount[i] = min_discount;
        }

        // 2. 이모지마다 할인률 적용해서 비교
        while (e_discount[e_discount.length-1] == 50) {
            int[] result = {0, 0};
            int[] users_exp = new int[users.length]; // user의 이모티콘 구매 비용
            int[] e_price = new int[emoticons.length]; // 이모지 가격
            
            // 이모지 할인률 적용
            for (int i = 0; i < emoticons.length; i++) {
                e_price[i] = (int)((double)emoticons[i] * (e_discount[i]/100));
            }

            // 이모티콘을 구매하거나, 이모티콘 플러스를 가입하거나
            for (int i = 0; i < users.length; i++) {
                users_exp[i] = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    
                }
            }
        }

        return answer;
    }
}
