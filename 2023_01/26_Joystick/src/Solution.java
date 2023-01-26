/*
 알고리즘 문제 : 프로그래머스 - 네트워크
 실습 날짜 : 2023-01-26
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("ABBBBBBAAAAAAABA"));
    }

    public static int solution(String name) {
        int answer = 0;
        boolean visited[] = new boolean[name.length()];
        int index = 0;

        // init
        for (int i = 0; i < visited.length; i++) {
            if (name.charAt(i) == 'A') {
                visited[i] = true;
            }
            else {
                visited[i] = false;
            }
        }

        // first word
        answer += countAlpha(name.charAt(0));
        visited[0] = true;

        // move -> countAlpha
        while(!isDone(visited)) {
            // move (left or right)
            int move = moveSide(visited, index);
            if (index + move >= visited.length) {
                index = index + move - visited.length;
            }
            else if (index + move < 0) {
                index = visited.length + index + move;
            }
            else {
                index += move;
            }
            answer += Math.abs(move);

            // countAlpha
            answer += countAlpha(name.charAt(index));
            visited[index] = true;
        }
        

        return answer;
    }

    public static int countAlpha(char alpha) {
        // abcdefghijklmn/opqrstuvwxyz
        int count = 0;
        if (alpha < 'O') {
            count = (int)(alpha - 'A');
        }
        else {
            count = (int)('Z' - alpha) + 1;
        }

        return count;
    }

    public static boolean isDone(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true; 
    }

    public static int moveSide(boolean[] visited, int index) {
        int right = 0, left = 0;
        int tmp = index;
        int move = 0;

        // right
        while (true) {
            tmp += 1;
            right++;
            if (tmp >= visited.length) {
                tmp = 0;
            }

            if (!visited[tmp]) {
                break;
            }
        }
        // left
        tmp = index;
        while (true) {
            tmp -= 1;
            left++;
            if (tmp < 0) {
                tmp = visited.length-1;
            }

            if (!visited[tmp]) {
                break;
            }
        }

        move = (right > left) ? (-1 * left) : right;
        return move;
    }
}
