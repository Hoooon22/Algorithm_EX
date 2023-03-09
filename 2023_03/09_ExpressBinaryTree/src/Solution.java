/*
 알고리즘 문제 : 프로그래머스 - 표현 가능한 이진트리
 실습 날짜 : 2023-03-09
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/150367
*/

import java.util.*;

public class Solution {
    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public int[] solution(long[] numbers) {
        int[] answer = {};
        String[] str_n = new String[numbers.length];

        // 1. binary to decimal
        for (int i = 0; i < str_n.length; i++) {
            str_n[i] = Long.toBinaryString(numbers[i]);
        }

        return answer;
    }
}
