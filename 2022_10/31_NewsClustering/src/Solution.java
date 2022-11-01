/*
 알고리즘 문제 : 프로그래머스 - [1차] 뉴스 클러스터링
 실습 날짜 : 2022-10-31
 문제 : https://school.programmers.co.kr/learn/courses/30/lessons/17677
*/
import java.util.Arrays;
import java.io.*;

public class Solution {

    public static int solution(String str1, String str2) {
        int answer = 0;
        int inter = 0; // 교집합
        int union = 0; // 합집합
        
        int anti_1 = 0;
        int anti_2 = 0;
        String[] arr_str1 = new String[str1.length()-1];
        String[] arr_str2 = new String[str2.length()-1];
        int[] count_str1 = new int[str1.length()-1];
        Arrays.fill(count_str1, 1);
        int[] count_str2 = new int[str2.length()-1];
        Arrays.fill(count_str2, 1);

        for (int i = 0; i < arr_str1.length; i++) {
            if (str1.substring(i, i+2).toUpperCase() != null && str1.substring(i, i+2).toUpperCase().matches("^[a-zA-Z]*$")) {
                arr_str1[i] = str1.substring(i, i+2).toUpperCase();
            }
            else {
                arr_str1[i] = "~~";
                anti_1++;
            }
        }
        for (int i = 0; i < arr_str2.length; i++) {
            if (str2.substring(i, i+2).toUpperCase() != null && str2.substring(i, i+2).toUpperCase().matches("^[a-zA-Z]*$")) {
                arr_str2[i] = str2.substring(i, i+2).toUpperCase();
            }
            else {
                arr_str2[i] = "~~";
                anti_2++;
            }
        }
        if (arr_str1[0] == "~~" && arr_str2[0] == "~~") {
            return 1 * 65536;
        }

        Arrays.sort(arr_str1);
        Arrays.sort(arr_str2);

        for (int i = 0; i < arr_str1.length; i++) {
            System.out.println(arr_str1[i]);
        }
        System.out.println("-----------");
        for (int i = 0; i < arr_str2.length; i++) {
            System.out.println(arr_str2[i]);
        }

        for (int i = 0; i < arr_str1.length-1-anti_1; i++) {
            int j = i;
            while (arr_str1[j].equals(arr_str1[i+1])) {
                count_str1[j]++;
                if (i+2 >= arr_str1.length-anti_1) {
                    break;
                }
                else {
                    i++;
                }
            }
        }
        for (int i = 0; i < arr_str2.length-1-anti_2; i++) {
            int j = i;
            while (arr_str2[j].equals(arr_str2[i+1])) {
                count_str2[j]++;

                if (i+2 >= arr_str2.length-anti_2) {
                    break;
                }
                else {
                    i++;
                }
            }
        }

        int a = 0, b=0;
        union = arr_str1.length-anti_1 + arr_str2.length-anti_2;
        while (a < arr_str1.length-anti_1 && b < arr_str2.length-anti_2) {
            if (arr_str1[a].equals(arr_str2[b])) {
                inter += Math.min(count_str1[a], count_str2[b]);
                union -= Math.min(count_str1[a], count_str2[b]);
                a += count_str1[a];
                b += count_str2[b];
            }
            else if (arr_str1[a].compareTo(arr_str2[b]) < 0){
                a++;
            }
            else if (arr_str1[a].compareTo(arr_str2[b]) > 0){
                b++;
            }
        }

        System.out.print("LL"+inter+",");
        System.out.println(union+"LL");
        if (inter ==0 && union == 0) {
            answer = 1 * 65536;
        }
        else if (union == 0) {
            answer = 1 * 65536;
        }
        else {
            answer = (int)(inter/(double)union * 65536);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
}
