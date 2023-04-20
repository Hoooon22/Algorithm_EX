/*
 알고리즘 문제 : 프로그래머스 - 요격 시스템
 실습 날짜 : 2023-04-19
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
*/

import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, new Comparator<int[]>() {
           @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1]; // 두번째 숫자 기준 오름차순
            }
        });
        
        // sorted array to List
        List<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < targets.length; i++) {
            list.add(targets[i]);
        }
        
        // calculate
        while (list.size() > 0) {
            int tmp_s = list.get(0)[0]; // s
            int tmp_e = list.get(0)[1]; // e
            System.out.print(list.get(0)[0] + ", ");
            System.out.print(list.get(0)[1] + "\n");
            list.remove(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[1] >= tmp_e) {
                    tmp_s = list.get(i)[0];
                    tmp_e = list.get(i)[1];
                    list.remove(i);
                    i = 0;
                }
            }
            System.out.println("..............");
            answer++;
        }
        
        return answer;
    }
}