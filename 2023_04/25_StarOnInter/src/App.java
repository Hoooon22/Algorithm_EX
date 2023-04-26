/*
 알고리즘 문제 : 프로그래머스 - 교점에 별 만들기
 실습 날짜 : 2023-04-25
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/87377
*/

import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> list = new LinkedList<>();
        
        // 교점 찾기
        for (int i = 0; i < line.length-1; i++) {
            for (int j = i+1; j < line.length; j++) {
                if (isInter(line[i], line[j])) {
                    double[] test = intersection(line[i], line[j]);
                    if (test[0] % 1 == 0.0 && test[1] % 1 == 0.0) {
                        long[] inter = {(long)test[0], (long)test[1]};
                        list.add(inter);
                        // System.out.printf("%d, %d\n", inter[0], inter[1]);
                    }
                }
            }
        }
        
        // list to arr
        int listSize = list.size();
        long[][] resultArr = list.toArray(new long[listSize][2]);
        
        // 맵 크기 설정 및 생성
        long[] min = {Long.MAX_VALUE, Long.MAX_VALUE};
        long[] max = {Long.MIN_VALUE, Long.MIN_VALUE};
        for(int i = 0; i < resultArr.length; i++) {
            // min max x,y
            if (resultArr[i][0] < min[0]) {
                min[0] = resultArr[i][0];
            }
            if (resultArr[i][1] < min[1]) {
                min[1] = resultArr[i][1];
            }
            if (resultArr[i][0] > max[0]) {
                max[0] = resultArr[i][0];
            }
            if (resultArr[i][1] > max[1]) {
                max[1] = resultArr[i][1];
            }
        }
        // System.out.printf("%d, %d, %d, %d\n", min[0], min[1], max[0], max[1]);

        // 맵 구현
        String[] answer = new String[(int)Math.abs((max[1] - min[1])+1)];
        for (int i = 0; i < answer.length; i++) {
            String str = ".".repeat((int)Math.abs((max[0] - min[0])+1));
            answer[i] = str;
            // System.out.println(str);
        }
        // 별 표시
        for (int i = 0; i < resultArr.length; i++) {
            String str = "";
            int x = (int)(resultArr[i][0] - min[0]);
            int y = Math.abs((int)(max[1] - min[1])) - (int)(resultArr[i][1] - min[1]);
            // System.out.printf("%d, %d\n", x,y);
            
            for (int j = 0; j < answer[y].length(); j++) {
                if (j == x) {
                    str += "*";
                }
                else {
                    str += answer[y].charAt(j);
                }
            }
            
            answer[y] = str;
            // System.out.println(answer[y]);
        }
        
        // 출력
        for (int i = 0; i < answer.length; i++) {
            // System.out.println(answer[i]);
        }

        return answer;
    }
    
    public static boolean isInter(int[] line1, int[] line2) {
        // AD - BC = 0인 경우 두 직선은 평행 또는 일치
        if ((line1[0] * line2[1] - line1[1] * line2[0]) == 0) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static double[] intersection(int[] line1, int[] line2) {
        double[] result = new double[2];
        
        result[0] = (double)((long)line1[1] * (long)line2[2] - (long)line1[2] * (long)line2[1]) / (double)((long)line1[0] * (long)line2[1] - (long)line1[1] * (long)line2[0]);
        result[1] = (double)((long)line1[2] * (long)line2[0] - (long)line1[0] * (long)line2[2]) / (double)((long)line1[0] * (long)line2[1] - (long)line1[1] * (long)line2[0]);
        
        return result;
    }
}