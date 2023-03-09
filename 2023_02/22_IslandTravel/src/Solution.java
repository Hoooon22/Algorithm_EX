/*
 알고리즘 문제 : 프로그래머스 - 무인도 여행
 실습 날짜 : 2023-02-22
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/154540
*/
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(String[] maps) {

        ArrayList<Integer> list = new ArrayList<>(); // 결과를 넣어줄 ArrayList
        int[][] island_map = new int[maps.length+2][maps[0].length()+2]; // 매개변수인 maps를 이차원으로
        boolean[][] visited = new boolean[maps.length+2][maps[0].length()+2]; // 방문

        // 1. maps -> island_map
        for (int i = 0; i < maps.length+2; i++) {
            for (int j = 0; j < maps[0].length()+2; j++) {
                if (i == 0 || i == maps.length+1 || j == 0 || j == maps[0].length()+1) {
                    island_map[i][j] = -1;
                }
                else if (maps[i-1].charAt(j-1) == 'X') { // X면
                    island_map[i][j] = -1;
                }
                else { // 아니면
                    island_map[i][j] = Character.getNumericValue(maps[i-1].charAt(j-1));
                }
                visited[i][j] = false;
            }
        }

        // 2. sum of island
        for (int i = 1; i < maps.length+1; i++) {
            for (int j = 1; j < maps[0].length()+1; j++) {
                if (island_map[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    list.add(island_map[i][j] + sum(island_map, visited, i, j));
                }
            }
        }

        // result
        int[] answer;

        if (list.isEmpty()) {
            answer = new int[1];
            answer[0] = -1;
        }
        else {
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }

    public int sum(int[][] island_map, boolean[][] visited, int a, int b) {
        
        int num = 0;
        // up, down, left, right
        if (island_map[a-1][b] > 0 && !visited[a-1][b]) {
            visited[a-1][b] = true;
            num += island_map[a-1][b] + sum(island_map, visited, a-1, b);
        }
        if (island_map[a+1][b] > 0 && !visited[a+1][b]) {
            visited[a+1][b] = true;
            num += island_map[a+1][b] + sum(island_map, visited, a+1, b);
        }
        if (island_map[a][b-1] > 0 && !visited[a][b-1]) {
            visited[a][b-1] = true;
            num += island_map[a][b-1] + sum(island_map, visited, a, b-1);
        }
        if (island_map[a][b+1] > 0 && !visited[a][b+1]) {
            visited[a][b+1] = true;
            num += island_map[a][b+1] + sum(island_map, visited, a, b+1);
        }

        return num;
    }
}
