/*
 * Title : 보디빌딩
 * Link : https://www.acmicpc.net/problem/27952
 */
import java.io.*;
import java.util.*;

public class Main {
    private static int N; // 보디빌딩 대회까지 남은 일수
    private static int X; // 루틴을 진행할 떄마다 빠지는 몸무게
    private static int[] A; // i번째 날 최종 몸무게의 하한
    private static int[] B; // i번째 날에 늘어나는 몸무게

    public static void main(String[] args) throws Exception {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int current_weight = 0;

        // input
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        B = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) 
            A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) 
            B[i] = Integer.parseInt(st.nextToken());
        
        // calculation
        for (int i = 0; i < N; i++) {
            current_weight += B[i];
            int routine = (current_weight - A[i]) / X;

            // if, he falls down
            if (current_weight < A[i]) {
                answer = -1;
                break;
            }

            // if, he can do routine
            if (routine > 0) {
                current_weight -= X * routine;
                answer += routine;
            }
        }
        
        System.out.println(answer);
    }
}