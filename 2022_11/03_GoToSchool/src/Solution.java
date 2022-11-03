/*
 알고리즘 문제 : 프로그래머스 - 등굣길
 실습 날짜 : 2022-11-03
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/42898
*/
import java.util.*;

public class Solution {

    public static boolean isPuddles(int[][] puddles, int x, int y) {
        for (int i = 0; i < puddles.length; i++) {
            if (puddles[i][0]-1 == x && puddles[i][1]-1 == y) {
                return true;
            }
        }
        return false;
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] route_count = new int[m][n];
        for (int i = 0; i < route_count.length; i++) { // init
            Arrays.fill(route_count[i], 0);
        }
        
        // side -> school
        for (int i = 1; i < m; i++) {
            if (isPuddles(puddles, i, 0)) {
                break;
            }
            else {
                route_count[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (isPuddles(puddles, 0, i)) {
                break;
            }
            else {
                route_count[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (!isPuddles(puddles, i, j))
                    route_count[i][j] = (route_count[i-1][j] + route_count[i][j-1]) % 1000000007;
            }
        }

        answer = route_count[m-1][n-1] % 1000000007;
        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
