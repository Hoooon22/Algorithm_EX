/*
 알고리즘 문제 : 프로그래머스 - 표현 가능한 이진트리
 실습 날짜 : 2023-03-09
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/150367
*/

import java.util.*;

public class Solution {

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static class BinaryTree {
        Node head;
        int size;

        public BinaryTree() {
            head = null;
            size = 0;
        }

        public void push(Node nd) {
            if (size == 0) {
                Node node = nd;
                head = node;
            }
            else {
                Node node = head;
                Queue<Node> q = new LinkedList<Node>();
                q.add(node);

                while (!q.isEmpty()) {
                    Node temp = q.poll();

                    if (temp.left == null) {
                        temp.left = nd;
                        break;
                    }
                    else {
                        q.add(temp.left);
                    }

                    if (temp.right == null) {
                        temp.right = nd;
                        break;
                    }
                    else {
                        q.add(temp.right);
                    }
                }
            }
            size++;
        }
    }

    // main

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }

    public static int[] solution(long[] numbers) {
        int[] answer = {};
        String[] str_n = new String[numbers.length];

        // 1. binary to decimal
        for (int i = 0; i < str_n.length; i++) {
            str_n[i] = Long.toBinaryString(numbers[i]);
            str_n[i] = perfect_binary_tree(str_n[i]);
        }
        
        for (int i = 0; i < str_n.length; i++) {
            BinaryTree bt = new BinaryTree();

            int k = 0;
            while (bt.size < str_n[i].length()) {
                ArrayList<String> list = new ArrayList<>();
                for (int j = 0; j < Math.pow(2, k); j++) {
                    
                }
            }
            
        }

        return answer;
    }

    public static String perfect_binary_tree(String str) {
        int tmp = str.length();
        String perfect_str = str;

        // 0 몇개 추가할 것인지
        int i = 0;
        while (true) {
            if (tmp <= 0) {
                break;
            }
            else {
                tmp -= (int)Math.pow(2, i);
                i++;
            }
        }

        tmp *= -1; // 양수 전환
        for (int j = 0; j < tmp; j++) {
            perfect_str = "0" + perfect_str;
        }

        return perfect_str;
    }
}
