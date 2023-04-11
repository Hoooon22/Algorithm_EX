/*
 알고리즘 문제 : 프로그래머스 - 인사고과
 실습 날짜 : 2023-04-11
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/152995
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int solution(int[][] scores) {
        int answer = 1; // 순위
        int wanho = scores[0][0] + scores[0][1]; // 완호
        Queue<Integer[]> queue = new LinkedList<>(); // 인센티브 조건을 만족한 사원만 추가하는 큐

        // 오름차순 정렬
        Arrays.sort(scores, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        // 인센티븐 조건 체크
        for (int i = 0; i < scores.length; i++) {
            int count = 0;
            int j;

            for (j = i+1; j < scores.length && count < 2; j++) {
                // 점수가 둘 다 낮으면
                if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1])
                    count++;
            }

            // 인센티브 조건을 만족한다면
            if (count < 2) {
                Integer[] list = Arrays.stream(scores[i]).boxed().toArray(Integer[]::new);
                queue.add(list);
            }
            else if (i == 0) { // 조건이 안되는 게 완호라면, -1
                return -1;
            }
        }

        // 점수의 합을 결정하고 sort
        Integer[] sum = new Integer[queue.size()];
        for (int i = 0; i < sum.length; i++) {
            Integer[] list = new Integer[2];
            list = queue.poll();
            sum[i] = list[0] + list[1];
            System.out.printf("%d %d\n",list[0], list[1]);
        }
        Arrays.sort(sum, Collections.reverseOrder());

        // 순위 결정
        for (int i = 0; i < sum.length; i++) {
            if (wanho == sum[i]) {
                break;
            }
            answer++;
        }

        return answer;
    }
}
