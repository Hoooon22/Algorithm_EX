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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // number of countries
            int M = Integer.parseInt(st.nextToken()); // number of planes

            for (int i = 0; i < M; i++) { 
                br.readLine(); // we don't need to process the plane information for this problem.
            }
            
            System.out.println(N-1); // the minimum number of planes Sanggeun needs to take is always N-1.
        }
    }
}
