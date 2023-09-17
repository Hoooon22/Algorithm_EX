/*
 * Title : 상근이의 여행
 * Link : https://www.acmicpc.net/problem/9372
 */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // input
        int tc = Integer.parseInt(br.readLine());

        // each TestCase
        for (int t = 0; t < tc; t++) {
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // input
            int[][] plane = new int[M][M];

            for (int i = 0; i < M; i++) { // init
                for (int j = 0; j < M; j++) {
                    plane[i][j] = 0;
                }
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                plane[x][y] = 1;
                plane[y][x] = 1;
            }

            // cal
            
        }


    }
}
