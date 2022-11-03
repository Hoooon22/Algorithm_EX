/*
 알고리즘 문제 : 프로그래머스 - 등산코스 정하기
 실습 날짜 : 2022-11-03
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/118669
*/
import java.util.*;

public class Solution {
    public static int getSmallDistance(int[] distance, boolean[] visited) {
        int min = 1000000;
        int index = 0;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int[][] graph, int start, boolean[] visited, int[] distance, List<Integer> root) {
        for (int i = 0; i < graph.length; i++) {
            distance[i] = graph[start][i];
        }
        visited[start] = true;
        for (int i = 0; i < graph.length - 2; i++) {
            int current = getSmallDistance(distance, visited);
            visited[current] = true;
            for (int j = 0; j < distance.length; j++) {
                if(!visited[j]) {
                    if(distance[current] + graph[current][j] < distance[j]) {
                        distance[j] = distance[current] + graph[current][j]; 
                    }
                }
            }
        }

    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        boolean[] visited = new boolean[n];
        int[][] graph = new int[n][n];
        int[] distance = new int[n];
        List<Integer> root = new ArrayList<>();
        int start = 0;
        int[] end = new int[2];
        
        Arrays.fill(visited, false);
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 10000000);
        }
        for (int i = 0; i < n; i++) {
            graph[paths[i][0]][paths[i][1]] = paths[i][2];
        }

        // route
        end[1] = 10000000;
        for (int i = 0; i < gates.length; i++) {
            dijkstra(graph, gates[i], visited, distance, root);
            for (int j = 0; j < summits.length; j++) {
                if (distance[summits[j]] < end[2]) {
                    start = gates[i];
                    end[0] = summits[j];
                    end[1] = distance[summits[j]];
                }
            }
        }
        answer[0] = end[0];
        // instance
        int index = end[0];
        while (true) {
            if(start == index)
                break;
            
        }

        
        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
