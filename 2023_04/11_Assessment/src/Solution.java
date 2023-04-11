/*
 알고리즘 문제 : 프로그래머스 - 인사고과
 실습 날짜 : 2023-04-11
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/152995
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[][] scores = {{100, 1}, {1010, 2}, {100, 1}};

        System.out.println(solution(scores));
    }

    public static int solution(int[][] scores) {
        int answer = 1; // 순위
        int[] arr_wanho = {scores[0][0], scores[0][1]};
        int sum_wanho = scores[0][0] + scores[0][1]; // 완호
        LinkedList<Integer[]> incentive_list = new LinkedList<>(); // 인센티브 조건을 만족한 사원만 추가하는 큐

        // 완호보다 합이 낮으면 그냥 out
        ArrayList<int[]> arrangeList = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (sum_wanho < scores[i][0] + scores[i][1]) {
                arrangeList.add(scores[i]);
            }
        }
        arrangeList.add(arr_wanho);
        int[][] arrange_score = arrangeList.toArray(new int[arrangeList.size()][2]);

        // 오름차순 정렬
        Arrays.sort(arrange_score, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));

        // 인센티븐 조건 체크
        for (int i = 0; i < arrange_score.length; i++) {
            Boolean isCheck = true;

            for (int j = i+1; j < arrange_score.length; j++) {
                // 점수가 둘 다 낮으면 out
                if (arrange_score[i][0] < arrange_score[j][0] && arrange_score[i][1] < arrange_score[j][1])
                {
                    isCheck = false;
                    break;
                }
            }

            // 인센티브 조건을 만족한다면
            if (isCheck) {
                Integer[] list = Arrays.stream(arrange_score[i]).boxed().toArray(Integer[]::new);
                incentive_list.add(list);
            }
            else if (arr_wanho[0] == arrange_score[i][0] && arr_wanho[1] == arrange_score[i][1]) { // 조건이 안되는 게 완호라면, -1
                return -1;
            }
        }

        // 점수의 합을 결정하고 내림차순 sort
        Integer[] sum = new Integer[incentive_list.size()];
        for (int i = 0; i < sum.length; i++) {
            sum[i] = incentive_list.get(i)[0] + incentive_list.get(i)[1];
            // System.out.printf("%d %d\n", incentive_list.get(i)[0], incentive_list.get(i)[1]);
        }
        Arrays.sort(sum, Collections.reverseOrder());

        // 순위 결정
        for (int i = 0; i < sum.length; i++) {
            if (sum_wanho == sum[i]) {
                break;
            }
            answer++;
        }

        return answer;
    }
}
