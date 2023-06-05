/*
 알고리즘 문제 : Softeer - 8단 변속기
 실습 날짜 : 2023-06-05
 문제 : https://softeer.ai/practice/info.do?idx=1&eid=408
*/

import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[8];

        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        arr[4] = sc.nextInt();
        arr[5] = sc.nextInt();
        arr[6] = sc.nextInt();
        arr[7] = sc.nextInt();

        if (arr[0] == 1) {
            int tmp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != tmp + 1) {
                    System.out.println("mixed");
                    return;
                }
                tmp++;
            }

            System.out.println("ascending");
            return;
        }
        else if (arr[0] == 8) {
            int tmp = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] != tmp - 1) {
                    System.out.println("mixed");
                    return;
                }
                tmp--;
            }

            System.out.println("descending");
            return;
        }
        else {
            System.out.println("mixed");
            return;
        }
    }
}