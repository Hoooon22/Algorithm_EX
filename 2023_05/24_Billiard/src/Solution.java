/*
 알고리즘 문제 : 프로그래머스 - 당구 연습
 실습 날짜 : 2023-05-24
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/169198
*/

import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        // loop balls
        int i = 0;
        for (int[] ball: balls) {
            int destX = 0, destY = 0; // 대칭되는 목적지 좌표
            double checkX = Math.abs((startX + ball[0]) - m);
            double checkY = Math.abs((startY + ball[1]) - n);
            
            // 목적지 좌표 설정
            // X
            int length_line = Integer.MAX_VALUE;
            if (startY != ball[1]) {
                length_line = calLine(startX, startY, -1 * ball[0], ball[1]);
            }
            
            int tmp_line = calLine(startX, startY, ball[0] + (m-ball[0]) * 2, ball[1]);
            if (length_line > tmp_line && startY != ball[1]) {
                length_line = tmp_line;
            }
            // Y
            tmp_line = calLine(startX, startY, ball[0], -1 * ball[1]);
            if (length_line > tmp_line && startX != ball[0]) {
                length_line = tmp_line;
            }
            tmp_line = calLine(startX, startY, ball[0], ball[1] + (n-ball[1]) * 2);
            if (length_line > tmp_line && startX != ball[0]) {
                length_line = tmp_line;
            }
            
            answer[i] = length_line;
            i++;
        }
        
        return answer;
    }
    
    public static int calLine(int startX, int startY, int destX, int destY) {
        return (int)(Math.pow(startX - destX, 2) + Math.pow(startY - destY, 2));
    }
}