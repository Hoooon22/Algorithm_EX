/*
 알고리즘 문제 : 프로그래머스 - 미로 탈출 명령어
 실습 날짜 : 2023-05-26
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/150365
*/

/*
    일단 최소로 필요한 커맨드를 구한다. (예를 들어, 목적지가 왼쪽으로 두칸 있으면 ll)
*/

import java.util.*;

class Solution {
    public static class MinCommand {
        private int up;
        private int down;
        private int left;
        private int right;
        
        MinCommand (int x, int y) {
            if (y <= 0) {
                this.up = 0;
                this.down = -1 * y;
            }
            else{
                this.up = y;
                this.down = 0;
            }
            
            if (x <= 0) {
                this.left = 0;
                this.right = -1 * x;
            }
            else {
                this.left = x;
                this.right = 0;
            }
        }
        
        public char decrement_up () {
            if (this.up > 0) {
                this.up--;
                return 'u';
            }
            else {
                return 0;
            }
        }
        public char decrement_down () {
            if (this.down > 0) {
                this.down--;
                return 'd';
            }
            else {
                return 0;
            }
        }
        public char decrement_left () {
            if (this.left > 0) {
                this.left--;
                return 'l';
            }
            else {
                return 0;
            }
        }
        public char decrement_right () {
            if (this.right > 0) {
                this.right--;
                return 'r';
            }
            else {
                return 0;
            }
        }
        
        public boolean isEmpty() {
            if (this.up == 0 && this.down == 0 && this.left == 0 && this.right == 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        List<Character> re_ch = new ArrayList<>((int)(Math.abs(x-r) + Math.abs(y-c)));
        MinCommand mincommand = new MinCommand(x-r, y-c);
        
        // 나머지가 다르면 경로 없음
        if (k % 2 != (int)(Math.abs(x-r) + Math.abs(y-c)) % 2) {
            return "impossible";
        }
        
        // 최소 명령어 문자 추가 re_ch
        while (!mincommand.isEmpty()) {
            char tmp;
            tmp = mincommand.decrement_up();
            if (tmp != 0) {
                re_ch.add(tmp);
            }
            tmp = mincommand.decrement_down();
            if (tmp != 0) {
                re_ch.add(tmp);
            }
            tmp = mincommand.decrement_left();
            if (tmp != 0) {
                re_ch.add(tmp);
            }
            tmp = mincommand.decrement_right();
            if (tmp != 0) {
                re_ch.add(tmp);
            }
        }
        
        // 사전 순으로 
        
        
        return answer;
    }
}