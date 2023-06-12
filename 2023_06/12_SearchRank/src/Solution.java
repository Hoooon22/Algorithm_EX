/*
 알고리즘 문제 : 프로그래머스 - 순위 검색
 실습 날짜 : 2023-06-12
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
*/

import java.util.*;
import org.springframework.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int len = info.length;
        int[] answer = new int[query.length];
        
        MultiValueMap<String, Integer> mvMap = new LinkedMultiValueMap<String, Integer>();
        
        // to list
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(info[i]);
            StringBuilder stringBuilder = new StringBuilder();
            
            String tmp = st.nextToken();
            if (tmp.equals("cpp")) {
                stringBuilder.append('0');
            }
            else if (tmp.equals("java")) {
                stringBuilder.append('1');
            }
            else {
                stringBuilder.append('2');
            }
            if (st.nextToken().equals("backend")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            if (st.nextToken().equals("junior")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            if (st.nextToken().equals("chicken")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            int score = Integer.parseInt(st.nextToken());
                
            String str = stringBuilder.toString();
            
            mvMap.add(str, score);
        }
        
        // find
        for (int i = 0; i < query.length; i++) {
            int check = 0;
            
            StringTokenizer st = new StringTokenizer(query[i], " and ");
            StringBuilder stringBuilder = new StringBuilder();
            
            String tmp = st.nextToken();
            if (tmp.equals("cpp")) {
                stringBuilder.append('0');
            }
            else if (tmp.equals("java")) {
                stringBuilder.append('1');
            }
            else {
                stringBuilder.append('2');
            }
            if (st.nextToken().equals("backend")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            if (st.nextToken().equals("junior")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            if (st.nextToken().equals("chicken")) {
                stringBuilder.append('0');
            }
            else {
                stringBuilder.append('1');
            }
            int score = Integer.parseInt(st.nextToken());
            String str = stringBuilder.toString();
            
            List<Integer> list = mvMap.get(str);
            
            for (int data : list) {
                if (data > score) {
                    check++;
                }
            }
            answer[i] = check;
        }
        
        return answer;
    }
}