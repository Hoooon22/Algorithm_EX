/*
 알고리즘 문제 : 프로그래머스 - 리코쳇 로봇
 실습 날짜 : 2023-03-29
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/169199
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int solution(String[] board) {
        int answer = 0;
        char[][] arr_board = new char[board.length+2][board[0].length()+2]; // array of board

        // board to array_board
        for (int i = 0; i < arr_board[0].length; i++) { // 1 row
            arr_board[0][i] = 'D';
        }
        for (int i = 0; i < arr_board.length; i++) { // 2 ~ last-1 row
            arr_board[i][0] = 'D';
            for (int j = 1; j < arr_board[0].length-1; j++) { // each row
                arr_board[i][j] = board[i].charAt(j);
            }
            arr_board[i][arr_board[0].length-1] = 'D';
        }
        for (int i = 0; i < arr_board[0].length; i++) { // last row
            arr_board[arr_board[0].length-1][i] = 'D';
        }

        return answer;
    }
}
