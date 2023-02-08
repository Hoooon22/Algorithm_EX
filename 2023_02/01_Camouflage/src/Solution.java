/*
 알고리즘 문제 : 프로그래머스 - N으로 표현
 실습 날짜 : 2023-02-01
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42578
*/
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int solution(String[][] clothes) {
        int answer = 0;
        String kinds;

        // make hash
        String[][] clothes_sort = new String[clothes.length][2];
        for (int i = 0; i < clothes.length; i++) {
            clothes_sort[i][0] = clothes[i][1];
            clothes_sort[i][1] = clothes[i][0];
        }
        Arrays.sort(clothes_sort);

        // 1개, 2개, 3개, ... N개
        

        return answer;
    }
}
