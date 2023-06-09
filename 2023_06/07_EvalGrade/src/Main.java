/*
 알고리즘 문제 : Softeer - 성적평가
 실습 날짜 : 2023-06-07
 문제 : https://softeer.ai/practice/formCodeEditor.do
*/

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int scores[][] = new int[3][n];

        // init scores
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j] = sc.nextInt();
            }
        }

        // rating
        for (int i = 0; i < 3; i++) {
            Integer sort_arr[] = new Integer[n];
            for (int j = 0; j < n; j++) {
                sort_arr[j] = scores[i][j];
            }
            Arrays.sort(sort_arr, Collections.reverseOrder());

            for (int j = 0; j < n; j++) {
                int rate = 1;
                for (int num : sort_arr) {
                    if (scores[i][j] == num) {
                        System.out.printf("%d ", rate);
                        break;
                    }
                    else {
                        rate++;
                    }
                }
            }
            System.out.println();
        }
        
        // last sum
        int sum[] = new int[n];
        Integer sort_sum[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            sum[i] = scores[0][i] + scores[1][i] + scores[2][i];
            sort_sum[i] = sum[i];
        }

        Arrays.sort(sort_sum, Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int rate = 1;
            for (int num : sort_sum) {
                if (sum[i] == num) {
                    System.out.printf("%d ", rate);
                    break;
                }
                else {
                    rate++;
                }
            }
        }
    }
}