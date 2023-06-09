/*
 알고리즘 문제 : Softeer - 성적평가
 실습 날짜 : 2023-06-07
 문제 : https://softeer.ai/practice/formCodeEditor.do
*/

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int scores[][] = new int[3][n];
        int sum[] = new int[n];

        // init scores and calculate sum
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                scores[i][j] = sc.nextInt();
                sum[j] += scores[i][j];
            }
        }

        // rating
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                int rate = 1;
                for (int k = 0; k < n; k++) {
                    if (j != k && scores[i][j] < scores[i][k])
                        rate++;
                }
                System.out.printf("%d ", rate);
            }
            System.out.println();
        }

        // last sum rating
        for (int i = 0; i < n; i++) {
            int rate = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && sum[i] < sum[j])
                    rate++;
            }
            System.out.printf("%d ", rate);
        }
    }
}