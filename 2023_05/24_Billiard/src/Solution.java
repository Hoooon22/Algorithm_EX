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
            if (startX == ball[0]) {
                destX = (startX*2 <= m) ? -1 * ball[0] : ball[0] + (m-ball[0]) * 2;
                destY = ball[1];
            }
            else if (startY == ball[1]) {
                destX = ball[0];
                destY = (startY*2 <= n) ? -1 * ball[1] : ball[1] + (n-ball[1]) * 2;
            }
            // 3, 4
            else if (checkX >= checkY) {
                destX = (startX*2 <= m) ? -1 * ball[0] : ball[0] + (m-ball[0]) * 2;
                destY = ball[1];
            } 
            else if (checkX <= checkY) {
                destX = (startX*2 <= m) ? -1 * ball[0] : ball[0] + (m-ball[0]) * 2;
                destY = ball[1];
            } 
            
            System.out.printf("%d, %d\n", destX, destY);
            answer[i] = (int)(Math.pow(startX - destX, 2) + Math.pow(startY - destY, 2));
            i++;
        }
        
        return answer;
    }
}