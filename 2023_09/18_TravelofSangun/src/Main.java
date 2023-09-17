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

            // input & 인접 리스트
            int[][] planes = new int[M][2]; // edge

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                planes[i][0] = Integer.parseInt(st.nextToken());
                planes[i][1] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer>[] list = new ArrayList[M];
            
            for (int i = 0; i < M; i++) list[i] = new ArrayList<>();

            for(int[] plane : planes) {
                list[plane[0]].add(plane[1]);
                list[plane[1]].add(plane[0]);
            }

            // 
        }


    }
}
